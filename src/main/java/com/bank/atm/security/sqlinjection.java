package com.bank.atm.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.regex.Pattern;

public class sqlinjection {

    private static final Pattern KEYWORD_PATTERN = Pattern.compile(
            "\\b(UNION|SELECT|DROP|INSERT|DELETE|UPDATE|OR|AND|EXEC)\\b",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern SUSPICIOUS_CHARS_PATTERN = Pattern.compile("('|\";|;|--|/\\*|\\#)");
    // Yukarıdaki pattern tek tek riskli karakter/işaretleri tespit eder.

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Boolean sqlinjectiontester(String inputJsonValue) {
        if (inputJsonValue == null || inputJsonValue.trim().isEmpty()) {
            return false;
        }

        try {
            JsonNode root = MAPPER.readTree(inputJsonValue);
            StringBuilder collected = new StringBuilder();
            collectTextNodes(root, collected);
            String text = collected.toString();

            if (SUSPICIOUS_CHARS_PATTERN.matcher(text).find()) {
                return true;
            }
            if (KEYWORD_PATTERN.matcher(text).find()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            // Eğer input JSON değilse fallback: ham string üzerinde güvenlik kontrolleri
            String fallback = inputJsonValue;
            if (SUSPICIOUS_CHARS_PATTERN.matcher(fallback).find()) {
                return true;
            }
            if (KEYWORD_PATTERN.matcher(fallback).find()) {
                return true;
            }
            return false;
        }
    }

    private static void collectTextNodes(JsonNode node, StringBuilder out) {
        if (node.isObject()) {
            node.fieldNames().forEachRemaining(field -> collectTextNodes(node.get(field), out));
        } else if (node.isArray()) {
            node.forEach(element -> collectTextNodes(element, out));
        } else if (node.isValueNode()) {
            out.append(node.asText()).append(" ");
        }
    }
}
// yapay zekadan aldım proje bıttıgınde ekleyecegım.
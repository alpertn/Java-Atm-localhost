package com.bank.atm.security;

import java.util.regex.Pattern;

public class sqlinjectiontester {

    private static final Pattern kelimePattern = Pattern.compile(
            "(select|union|insert|update|delete|drop|or|and)",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern supheliKarakterler = Pattern.compile(
            "('|;|--|/\\*|\\*/|#)");

    private static final Pattern tautology = Pattern.compile(
            "or\\s*1\\s*=\\s*1|1\\s*=\\s*1", Pattern.CASE_INSENSITIVE);

    private static final String[] imzalar = new String[] {
            "select", "union", "insert", "delete", "drop", "or1=1", "and1=1"
    };

    public static boolean isSqlInjection(String girdi) {
        if (girdi == null) return false;
        String s = girdi.toLowerCase();
        s = s.replaceAll("\\s+", " ");

        if (supheliKarakterler.matcher(s).find()) return true;
        if (tautology.matcher(s).find()) return true;
        if (kelimePattern.matcher(s).find()) return true;

        String kompakt = s.replaceAll("[^a-z0-9]", "");
        for (String imza : imzalar) {
            if (kompakt.contains(imza)) return true;
        }

        return false;
    }


}

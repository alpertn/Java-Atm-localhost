//package com.bank.atm.api;
//
//import jakarta.validation.Valid;
//import com.bank.atm.dto.testdto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/test")
//public class testip {
//
//    private static final Logger log = LoggerFactory.getLogger(testip.class);
//
//    private String getClientIp(HttpServletRequest request) {
//        // Proxy başlıklarını kontrol et
//        String xfHeader = request.getHeader("X-Forwarded-For");
//        String ip;
//        if (xfHeader != null && !xfHeader.isEmpty() && !"unknown".equalsIgnoreCase(xfHeader)) {
//            ip = xfHeader.split(",")[0].trim();
//        } else {
//            ip = request.getRemoteAddr();
//        }
//
//        // IPv6'yı IPv4'e çevir
//        try {
//            InetAddress inetAddress = InetAddress.getByName(ip);
//            if (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) {
//                return "127.0.0.1";
//            }
//            if (inetAddress instanceof java.net.Inet6Address) {
//                // Eğer IPv6 adresi varsa, IPv4'e dönüştürülmüş hali varsa al
//                InetAddress ipv4 = InetAddress.getByAddress(inetAddress.getAddress());
//                return ipv4.getHostAddress();
//            }
//        } catch (UnknownHostException e) {
//            log.warn("IP çözümleme hatası: {}", e.getMessage());
//        }
//
//        return ip;
//    }
//
//    @PostMapping("/ip")
//    public ResponseEntity<?> request(
//            @Valid @RequestBody testdto gelenistek,
//            BindingResult bindingResult,
//            HttpServletRequest request
//    ) {
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().build();
//        } else {
//            String clientIp = getClientIp(request);
//            log.info("İstek IP adresi: {}", clientIp);
//            return ResponseEntity.ok(Map.of("ip", clientIp));
//        }
//    }
//}
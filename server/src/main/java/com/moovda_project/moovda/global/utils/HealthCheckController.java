package com.moovda_project.moovda.global.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
@RestController
@RequestMapping("/aws")
public class HealthCheckController {
    @GetMapping("/test")
    public ResponseEntity<String> healthCheck() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String hostname = ip.getHostName();
            String ipAddress = ip.getHostAddress();

            String response = "EC2 Hostname: " + hostname + "\nEC2 IP Address: " + ipAddress;
            return ResponseEntity.ok(response);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting hostname and IP address.");
        }
    }
}

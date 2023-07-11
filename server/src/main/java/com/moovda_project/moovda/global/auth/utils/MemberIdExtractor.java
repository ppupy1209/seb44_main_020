package com.moovda_project.moovda.global.auth.utils;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashMap;

public class MemberIdExtractor {
    public static Long extractMemberId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HashMap<String, Object> principal = (HashMap<String, Object>) authentication.getPrincipal();
        return Long.valueOf((Integer) principal.get("memberId"));
    }
}







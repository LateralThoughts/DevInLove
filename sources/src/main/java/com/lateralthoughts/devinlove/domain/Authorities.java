package com.lateralthoughts.devinlove.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Authorities implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}

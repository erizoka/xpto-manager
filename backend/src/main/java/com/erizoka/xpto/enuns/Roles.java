package com.erizoka.xpto.enuns;

public enum Roles {

	ADMIN("admin"),
    USER("user"),
    CLIENT("client");

    private final String role;

    Roles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

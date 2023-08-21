package com.numanstc.domain;

public enum Separator {
    COMMA(","),
    SEMICOLON(";"),
    TAB("\t");
    private final String text;

    Separator(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

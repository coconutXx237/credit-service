package com.klimkin.msconveyor.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Position {
    WORKER,
    MID_MANAGER,
    TOP_MANAGER,
    OWNER;

    @JsonCreator
    public static Position getPosition(String s) {
        for (Position e : Position.values()) {
            if (e.toString().equalsIgnoreCase(s)){
                return e;
            }
        }
        throw new IllegalArgumentException(s + " is not a Gender");
    }
}
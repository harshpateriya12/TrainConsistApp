package com.model;

public class GoodsBogie {

    private String bogieType;
    private String cargo;

    public GoodsBogie(String bogieType, String cargo) {
        this.bogieType = bogieType;
        this.cargo = cargo;
    }

    public String getBogieType() {
        return bogieType;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Type: " + bogieType + " | Cargo: " + cargo;
    }
}
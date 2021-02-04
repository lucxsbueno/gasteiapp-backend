package com.goldencode.gasteiapp.domain;

import java.util.Objects;

public enum Option {

    SPENT(1, "Gasto"),
    GAIN(2, "Ganho");

    private int cod;
    private String name;

    Option(int cod, String name){
        this.cod = cod;
        this.name = name;
    }

    public static Option toEnum(Integer cod){
        if (cod == null) {
            return null;
        }
        for (Option x : Option.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

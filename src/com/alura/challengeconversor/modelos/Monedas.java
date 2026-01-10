package com.alura.challengeconversor.modelos;

public enum Monedas {
    MXN("Peso mexicano"),
    ARS("Peso argentino"),
    USD ("Dólar"),
    BRL ("Real brasileño"),
    COP ("Peso colombiano"),
    BOB ("Boliviano"),
    CLP ("Peso chileno");

    private final String descripcion;

    Monedas (String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

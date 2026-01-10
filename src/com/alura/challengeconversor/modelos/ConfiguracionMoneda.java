package com.alura.challengeconversor.modelos;

public record ConfiguracionMoneda(int id, Monedas base, Monedas objetivo) {
    public String obtenerLineaMenu() {
        return id + ")" + base.getDescripcion() + "-->" + objetivo.getDescripcion();
    }
}

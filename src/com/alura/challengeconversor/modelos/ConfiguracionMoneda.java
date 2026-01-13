package com.alura.challengeconversor.modelos;

public record ConfiguracionMoneda(int id, Monedas base, Monedas objetivo) {
    public String obtenerLineaMenu() {
        return id + ") " + base.getDescripcion() + "-->" + objetivo.getDescripcion();
    }
}
/*
Clase usada para crear nuestro modelo de conjunto de datos necesarios para establecer los tipos de conversiones que
se pueden realizar e inclusión de método para imprimir la línea que indica al usuario la converión especifica a
seleccionar
 */
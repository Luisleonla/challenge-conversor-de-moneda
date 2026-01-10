package com.alura.challengeconversor.modelos;

public record SolicitudConversion(String monedaBase,
                                  String monedaObjetivo,
                                  double montoAConvertir) {
}

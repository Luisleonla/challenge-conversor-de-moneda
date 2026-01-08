package com.alura.challengeconversor.modelos;

public record SolicitudConversion(String result,
                                  String time_last_update_utc,
                                  String time_next_update_utc,
                                  String base_code,
                                  String target_code,
                                  Double conversion_rate,
                                  Double conversion_result) {
}

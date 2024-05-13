package com.convertidorDivisas.models;

public record ChangeGson(String base_code,
                         String target_code,
                         double conversion_rate,
                         double conversion_result) {
}

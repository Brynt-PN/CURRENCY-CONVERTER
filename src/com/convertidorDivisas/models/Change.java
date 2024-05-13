package com.convertidorDivisas.models;

public class Change {
    private double amountOrigin;
    private String divisaOrigin;
    private String divisaDestin;
    private double tasaCambio;
    private double amountResult;


    public Change(ChangeGson changeGson, double amount) {
        this.amountOrigin = amount;
        this.divisaOrigin = changeGson.base_code();
        this.divisaDestin = changeGson.target_code();
        this.tasaCambio = changeGson.conversion_rate();
        this.amountResult = changeGson.conversion_result();
    }

    @Override
    public String toString() {
        String message = "El valor de " + this.amountOrigin +
                " [" + this.divisaOrigin + "] equivale a -> " +
                this.amountResult + " [" + this.divisaDestin + "]"+
                " el tipo de cambio es -> "+this.tasaCambio;
        return message;
    }
}

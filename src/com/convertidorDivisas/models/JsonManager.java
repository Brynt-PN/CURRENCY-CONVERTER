package com.convertidorDivisas.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonManager {

    private Gson manager = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public Change instanceJson(String response, double amount) {
        Change change = new Change(manager.fromJson(response, ChangeGson.class),amount);
        return change;
    }

    public JsonObject instanceJsonObjet(String pathFile) throws FileNotFoundException {
        JsonObject jsonObject = manager.fromJson(new FileReader(pathFile), JsonObject.class);
        return jsonObject;
    }
}

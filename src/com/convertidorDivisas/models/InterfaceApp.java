package com.convertidorDivisas.models;

import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class InterfaceApp {
    private JsonManager jsonManager = new JsonManager();
    private String dataBasePath = "C:\\Users\\bpn70\\Documentos\\CURSOS\\ORACLE\\Challenge\\convertidorDivisas\\src\\com\\convertidorDivisas\\database\\CurrenciesCode.json";
    private JsonObject dataBase = jsonManager.instanceJsonObjet(this.dataBasePath);
    private Scanner scanner = new Scanner(System.in);


    //FUNTION_____________________________________________________________________
    public InterfaceApp() throws FileNotFoundException {
    }

    public void showJsonFile() {
        System.out.println("***********************Estas son las monedas disponibles y su código*****************************");
        int size = dataBase.size();
        for (int key = 1 ;key <= size; key++) {
            if (key <= size - 5){
                System.out.println(key+" -> "+dataBase
                        .get(String.valueOf(key)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+1)+" -> "+dataBase
                        .get(String.valueOf(key+1)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+2)+" -> "+dataBase
                        .get(String.valueOf(key+2)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+3)+" -> "+dataBase
                        .get(String.valueOf(key+3)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+4)+" -> "+dataBase
                        .get(String.valueOf(key+4)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+5)+" -> "+dataBase
                        .get(String.valueOf(key+5)).getAsJsonArray().get(0).getAsString());
                key = key+5;
            }else {
                System.out.println(key+" -> "+dataBase
                        .get(String.valueOf(key)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+1)+" -> "+dataBase
                        .get(String.valueOf(key+1)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+2)+" -> "+dataBase
                        .get(String.valueOf(key+2)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+3)+" -> "+dataBase
                        .get(String.valueOf(key+3)).getAsJsonArray().get(0).getAsString()+" "+
                        "  |  "+
                        (key+4)+" -> "+dataBase
                        .get(String.valueOf(key+4)).getAsJsonArray().get(0).getAsString());
                key = key+4;
            }

        }
    }

    public int captureDiviceOrigin() {
        System.out.println("****************************Ingresa la Divisa de Origen**********************************");
        return scanner.nextInt();
    }

    public int captureDiviceDestin() {
        System.out.println("****************************Ingresa la Divisa de Destino*********************************");
        return scanner.nextInt();
    }

    public double captureAmount() {
        System.out.println("**********************************Ingresa el monto***************************************");
        return scanner.nextDouble();
    }

    public JsonObject getDataBase() {
        return dataBase;
    }
}

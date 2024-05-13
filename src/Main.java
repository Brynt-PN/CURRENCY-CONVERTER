import com.convertidorDivisas.models.InterfaceApp;
import com.convertidorDivisas.models.RequestHttp;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("*********************************Bienvenido**********************************************");
        InterfaceApp interfaceApp = new InterfaceApp();
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        do {
            interfaceApp.showJsonFile();
            String origin = interfaceApp.getDataBase()
                    .get(String.valueOf(interfaceApp.captureDiviceOrigin()))
                    .getAsJsonArray().get(0).getAsString();
            double amount = interfaceApp.captureAmount();
            String destin = interfaceApp.getDataBase()
                    .get(String.valueOf(interfaceApp.captureDiviceDestin()))
                    .getAsJsonArray().get(0).getAsString();
            RequestHttp requestHttp = new RequestHttp();
            requestHttp.executeRequest(origin,destin,amount);
            System.out.println("""
                    **********************************Deseas continuar**************************************
                    1 -> SI
                    2 -> NO""");
            opt = scanner.nextInt();
            while (opt != 1 && opt !=2)          {
                System.out.println("""
                    ****************************Opcion invalida ingresa una nueva***************************
                    1 -> SI
                    2 -> NO""");
                opt = scanner.nextInt();
            }
        }while (opt == 1);

    }
}
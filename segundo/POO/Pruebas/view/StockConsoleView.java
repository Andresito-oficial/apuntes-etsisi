package view;

import model.Stock;

import java.util.Scanner;

public class StockConsoleView {

    privatefinal Scanner scanner = new Scanner(System.in);

    publicString askSymbol() {
        System.out.print("Introduce el símbolo de la acción: ");
        returnscanner.nextLine();
    }

    publicvoid show(Stock stock) {
        System.out.println("\n=== Información de la acción ===");
        System.out.println("Compañía : " + stock.getCompanyName());
        System.out.println("Símbolo  : "+ stock.getSymbol());
        System.out.println("Precio   : "+ stock.getPrice());
        System.out.println("Cambio   : " + stock.getChange() + "%");
    }

    publicvoid showError(String msg) {
        System.out.println("\nERROR: " + msg);
    }
}

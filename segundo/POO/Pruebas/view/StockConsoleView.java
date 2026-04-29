package view;

import model.Stock;

import java.util.Scanner;

public class StockConsoleView {

    private final Scanner scanner = new Scanner(System.in);

    public String askSymbol() {
        System.out.print("Introduce el símbolo de la acción: ");
        return scanner.nextLine();
    }

    public void show(Stock stock) {
        System.out.println("\n=== Información de la acción ===");
        System.out.println("Compañía : " + stock.getCompanyName());
        System.out.println("Símbolo  : "+ stock.getSymbol());
        System.out.println("Precio   : "+ stock.getPrice());
        System.out.println("Cambio   : " + stock.getChange() + "%");
    }

    public void showError(String msg) {
        System.out.println("\nERROR: " + msg);
    }
}

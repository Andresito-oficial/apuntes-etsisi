package controller;

import model.Stock;
import model.StockRepository;
import view.StockConsoleView;

public class StockController {

    privatefinal StockRepository repo;
    privatefinal StockConsoleView view;

    publicStockController(StockRepository repo, StockConsoleView view) {
        this.repo = repo;
        this.view = view;
    }

    publicvoid start() {
        String symbol = view.askSymbol();   
        searchStock(symbol);
    }

    privatevoid searchStock(String symbol) {
        Stock stock = repo.findBySymbol(symbol);

        if(stock != null) {
            view.show(stock);
        } else {
            view.showError("No existe ninguna acción con símbolo '" + symbol + "'.");
        }
    }
}

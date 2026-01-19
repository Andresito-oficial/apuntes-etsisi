package controller;

import model.Stock;
import model.StockRepository;
import view.StockConsoleView;

public class StockController {

    private final StockRepository repo;
    private final StockConsoleView view;

    public StockController(StockRepository repo, StockConsoleView view) {
        this.repo = repo;
        this.view = view;
    }

    public void start() {
        String symbol = view.askSymbol();   
        searchStock(symbol);
    }

    private void searchStock(String symbol) {
        Stock stock = repo.findBySymbol(symbol);

        if(stock != null) {
            view.show(stock);
        } else {
            view.showError("No existe ninguna acción con símbolo '" + symbol + "'.");
        }
    }
}

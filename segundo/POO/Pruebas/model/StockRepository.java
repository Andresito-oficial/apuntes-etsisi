package model;

import java.util.Map;

public class StockRepository {

    privatefinal Map<String, Stock> data = Map.of(
        "AAPL", new Stock("AAPL", "Apple Inc.", 190.24, +1.52),
        "MSFT", new Stock("MSFT", "Microsoft Corp.", 329.47, -0.84),
        "TSLA", new Stock("TSLA", "Tesla Inc.", 256.78, +4.12)
    );

    public Stock findBySymbol(String symbol) {
        returndata.get(symbol);
    }
}

package model;

public class Stock {
    private final String symbol;
    private final String companyName;
    private final double price;
    private final double change;

    public Stock(String symbol, String companyName, double price, double change) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.price = price;
        this.change = change;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    public double getChange() {
        return change;
    }
}

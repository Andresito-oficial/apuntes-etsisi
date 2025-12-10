package model;

public class Stock {
    privatefinal String symbol;
    privatefinal String companyName;
    privatefinal double price;
    privatefinal double change;

    public Stock(String symbol, String companyName, double price, double change) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.price = price;
        this.change = change;
    }

    publicString getSymbol() {
        return symbol;
    }

    publicString getCompanyName() {
        returncompanyName;
    }

    publicdouble getPrice() {
        return price;
    }

    publicdouble getChange() {
        return change;
    }
}

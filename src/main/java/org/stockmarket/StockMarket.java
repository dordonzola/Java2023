package org.stockmarket;

import org.stockmarket.model.Stock;
import org.stockmarket.model.StockType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class StockMarket {
    private final List<Stock> stocks;

    public StockMarket() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    // TODO zaimplementuj metodę, która zwraca opisy wszystkich akcje danego typu, razem z opisem, np.
    //  "AAPL - Technology and innovation sector - $150.0",
    //  "MSFT - Technology and innovation sector - $200.0",
    //  ...
    public List<String> listStocksByType(StockType type) {
        List<String> result=new ArrayList<>();
        result.add(type.getName());
        result.add(" - ");
        result.add(type.getDescription());

        return result;
    }

    public void updateStockPrice(String symbol, double newPrice) {
        for (Stock stock : stocks) {
            if (Objects.equals(stock.getSymbol(), symbol)) {
                stock.setPrice(newPrice);
            }
        }
    }

    // TODO zaimplentuj metodę, która zwraca daną akcję.
    //  Użyj optional na wypadek, gdyby nie było akcji o danym symbolu.
    public Optional<Stock> getStock(String symbol) {
        for (Stock stock : stocks) {
            if (Objects.equals(stock.getSymbol(), symbol)) {
                return Optional.of(stock);
            }
        }
        return Optional.empty();
    }

    // TODO zaimplentuj metodę, która zwraca wszystkie akcje
    public List<Stock> getStocks() {
        return stocks;
    }
}

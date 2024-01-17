package org.stockmarket;

import org.stockmarket.model.Stock;
import org.stockmarket.model.StockType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StockMarket {
    private final List<Stock> stocks;

    public StockMarket() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public List<String> listStocksByType(StockType type) {
        List<String> result=new ArrayList<>();
        String stockData="";
        for (Stock stock : stocks) {
            if (stock.getType()==type)
            {
                stockData+=stock.getSymbol();
                stockData+=" - ";
                stockData+=stock.getTypeDescription();
                stockData+=" - ";
                stockData+=stock.getPrice();
                result.add(stockData);
                stockData="";

            }
        }
        return result;
    }

    public void updateStockPrice(String symbol, double newPrice) {
        for (Stock stock : stocks) {
            if (Objects.equals(stock.getSymbol(), symbol)) {
                stock.setPrice(newPrice);
            }
        }
    }


    public Optional<Stock> getStock(String symbol) {
        for (Stock stock : stocks) {
            if (Objects.equals(stock.getSymbol(), symbol)) {
                return Optional.of(stock);
            }
        }
        return Optional.empty();
    }


    public List<Stock> getStocks() {
        return stocks;
    }
}

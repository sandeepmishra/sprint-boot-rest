package org.springboot.starter.rxjava;

import org.springboot.starter.rxjava.stockservice.StockServiceImpl;
import rx.Observable;
import rx.functions.Action1;
import yahoofinance.Stock;

public class ReactiveStockReader {

    public static void main(String[] args) {
        Observable<Stock> getStock = new ReactiveStockReader().getStock("GOOG");

        getStock.subscribe(ReactiveStockReader::callBackGetStock,
                ReactiveStockReader::getStockError,
                ReactiveStockReader::completeCallBack);
    }

    private static void completeCallBack() {
        System.out.println("Completed successfully.");
    }

    private static void getStockError(Throwable throwable) {
        System.out.println(throwable);
    }

    private static Action1<? super Stock> callBackGetStock(Stock stock) {
        System.out.println(String.format("Quotes %s, Price %s, Day's High %s, Days's Low %s",
                stock.getSymbol(),
                stock.getQuote().getPrice(),
                stock.getQuote().getDayHigh(),
                stock.getQuote().getDayLow()));
        stock.getQuote();
        return null;
    }


    Observable<Stock> getStock(String stockName){
        return new StockServiceImpl().getStock(stockName);
    }
}

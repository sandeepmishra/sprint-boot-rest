package org.springboot.starter.rxjava.stockservice;

import rx.Observable;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

public class StockServiceImpl {

    public Observable<Stock> getStock(String stockName){

        //Observable.create();
        return Observable.create(subscriber -> {
            if(!subscriber.isUnsubscribed()){

                Stock stock = null;

                try {
                    stock = YahooFinance.get(stockName);
                    subscriber.onNext(stock);
                } catch (IOException e) {
                    //System.out.println(e);
                    subscriber.onError(e);
                }
            }
            subscriber.onCompleted();
        });

    }
}

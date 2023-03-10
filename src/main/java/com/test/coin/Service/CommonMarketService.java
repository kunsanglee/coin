package com.test.coin.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommonMarketService {

//    private final List<MarketService> marketServiceList;
//
//    public double getPrice(String market, String coin) {
//        for (MarketService marketService : marketServiceList) {
//            if (marketService.getClass().getSimpleName()
//                    .startsWith(market)) { // substring(0, market.length())
//                return marketService.getCoinCurrentPrice(coin);
//            }
//        }
//        return 0.00;
//    }

    private final Map<String, MarketService> marketServices;

    public double getPrice(String market, String coin) {
        MarketService marketService = getMarketService(marketServices, market);

        return marketService.getCoinCurrentPrice(coin);
    }

    public List<String> getCommonCoin(String fromMarket, String toMarket) {
        // 마켓 서비스 가져오기
        MarketService fromMarketService = getMarketService(marketServices, fromMarket);
        MarketService toMarketService = getMarketService(marketServices, toMarket);

        // 각 마켓의 거래가능한 코인 불러오기
        List<String> fromMarketCoins = fromMarketService.getCoins();
        List<String> toMarketCoins = toMarketService.getCoins();

        // 공통의 것 찾기
        List<String> result = new ArrayList<>();
        for (String eachCoin : fromMarketCoins) {
            if (toMarketCoins.contains(eachCoin)) {
                result.add(eachCoin);
            }
        }
        return result;
    }

    public static MarketService getMarketService(Map<String, MarketService> marketServices, String market) {
        for (String key : marketServices.keySet()) {
            if (key.startsWith(market.toLowerCase())) {
                return marketServices.get(key);
            }
        }
        return null;
    }
}

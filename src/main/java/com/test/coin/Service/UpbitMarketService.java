package com.test.coin.Service;

import com.test.coin.DTO.CoinBuyDTO;
import com.test.coin.DTO.CoinSellDTO;
import com.test.coin.Feign.UpbitFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UpbitMarketService implements MarketService{

    private final UpbitFeignClient upbitFeignClient;

    @Override
    public double getCoinCurrentPrice(String coin) {
        return upbitFeignClient.getCoinPrice("KRW-" + coin.toUpperCase())
                .get(0).getTrade_price();
    }

    @Override
    public CoinBuyDTO calculateBuy(List<String> commonCoins, double amount) {
        return null;
    }

    @Override
    public CoinSellDTO calculateSell(List<String> commonCoins, double amount) {
        return null;
    }

    @Override
    public List<String> getCoins() {
        List<String> result = new ArrayList<>();
        // api활용하여 가져온다.
        upbitFeignClient.getMarketCode().forEach(k -> {
            if (k.getMarket().startsWith("KRW")) {
                String coin = k.getMarket().substring(4).toUpperCase();
                result.add(coin);
            }
        });
        return result;
    }
}
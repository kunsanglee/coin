package com.test.coin.Service;

import com.test.coin.DTO.CoinBuyDTO;
import com.test.coin.DTO.CoinSellDTO;
import com.test.coin.Feign.BithumbFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BithumbMarketService implements MarketService{

    private final BithumbFeignClient bithumbFeignClient;
    @Override
    public double getCoinCurrentPrice(String coin) {
        return bithumbFeignClient.getCoinPrice(coin.toUpperCase()+"_KRW").getData().getClosing_price();
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
        bithumbFeignClient.getAssetStatus().getData().forEach((k,v) -> {
            if (v.getDeposit_status() == 1 && v.getWithdrawal_status() == 1) {
                result.add(k.toUpperCase());
            }
        });
        return result;
    }

}

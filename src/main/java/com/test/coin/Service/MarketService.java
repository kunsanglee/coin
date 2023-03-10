package com.test.coin.Service;

import com.test.coin.DTO.CoinBuyDTO;
import com.test.coin.DTO.CoinSellDTO;

import java.util.List;

public interface MarketService {

    double getCoinCurrentPrice(String coin);

    CoinBuyDTO calculateBuy(List<String> commonCoins, double amount);

    CoinSellDTO calculateSell(List<String> commonCoins, double amount);

    List<String> getCoins();

}

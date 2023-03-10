package com.test.coin.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class CoinBuyDTO {
    private Map<String, Double> amounts;
    private Map<String, Map<Double, Double>> orderBooks;
}

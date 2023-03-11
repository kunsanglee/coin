package com.test.coin.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommonMarketServiceTest {

    @Mock
    private BithumbMarketService bithumbMarketService;
    @Mock
    private UpbitMarketService upbitMarketService;

    private CommonMarketService commonMarketService;

    @BeforeEach
    void setUp() {
        commonMarketService = new CommonMarketService(
                Map.of("bithumbMarketService", bithumbMarketService,
                        "upbitMarketService", upbitMarketService)
        );
    }

    @Test
    void getPriceTest() {
        // given : 어떤 상황이 주어질 때
        double testAmount = 123.456;
        String testcoin = "ABC";

        when(bithumbMarketService.getCoinCurrentPrice(testcoin)).thenReturn(testAmount);
        when(upbitMarketService.getCoinCurrentPrice(testcoin)).thenReturn(testAmount);

        // when : 어떤 것을 실행할지


        // then : 어떤 결과가 나와야할지
        assertEquals(testAmount, commonMarketService.getPrice("bithumb", testcoin));
        assertEquals(testAmount, commonMarketService.getPrice("upbit", testcoin));

    }


    @Test
    void getMarketServiceTest() {

        // given
        Map<String, MarketService> marketService = new HashMap<>();
        marketService.put("bithumbMarketService", bithumbMarketService);
        marketService.put("upbitMarketService", upbitMarketService);

        // when & then
        assertEquals(bithumbMarketService, CommonMarketService.getMarketService(marketService, "bithumb"));
        assertEquals(bithumbMarketService, CommonMarketService.getMarketService(marketService, "Bithumb"));
        assertEquals(bithumbMarketService, CommonMarketService.getMarketService(marketService, "BITHUMB"));
        assertEquals(bithumbMarketService, CommonMarketService.getMarketService(marketService, "bithumB"));
        assertEquals(upbitMarketService, CommonMarketService.getMarketService(marketService, "upbit"));
        assertEquals(upbitMarketService, CommonMarketService.getMarketService(marketService, "Upbit"));
        assertEquals(upbitMarketService, CommonMarketService.getMarketService(marketService, "UPBIT"));
        assertEquals(upbitMarketService, CommonMarketService.getMarketService(marketService, "upbiT"));
    }
}
//package com.test.coin.Controller;
//
//import com.test.coin.Service.TransferCalculateService;
//import com.test.coin.View.TransferCalculateResponseView;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//public class TransferCalculateController {
//
//    private final TransferCalculateService transferCalculateService;
//
//    @GetMapping("/transfer-calculate")
//    public TransferCalculateResponseView getPrice(
//            @RequestParam String fromMarket,
//            @RequestParam String toMarket,
//            @RequestParam double amount
//    ) {
//        return TransferCalculateResponseView.of(
//                transferCalculateService.calculate(fromMarket, toMarket, amount)
//        );
//    }
//
//}

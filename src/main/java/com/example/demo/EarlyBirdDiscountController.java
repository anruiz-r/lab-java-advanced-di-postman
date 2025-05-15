package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/discount")
@RequiredArgsConstructor
public class EarlyBirdDiscountController {
    private final EarlyBirdDiscountService earlyBirdDiscountService;


    @GetMapping
    public String getDiscount(@RequestParam String eventDate, @RequestParam String bookingDate){
        LocalDate event = LocalDate.parse(eventDate);
        LocalDate booking = LocalDate.parse(bookingDate);
        double discount = earlyBirdDiscountService.getDiscount(event, booking);

        if (discount > 0) {
            return earlyBirdDiscountService.getDiscountMessage(discount);
        }
        return "Sorry, no discount available";
    }
}
package com.example.demo;

import java.time.LocalDate;

public class EarlyBirdDiscountService {
    public String getDiscountMessage(double discount) {
        return "You have a discount of " + (discount * 100) + "% on your booking!";
    }

    public double getDiscount(LocalDate eventDate, LocalDate bookingDate) {
        if (eventDate.isAfter(bookingDate) && eventDate.isBefore(bookingDate.plusDays(30))) {
            return 0.15;
        } else {
            return 0.0;
        }
    }
}

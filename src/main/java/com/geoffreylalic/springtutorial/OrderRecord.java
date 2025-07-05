package com.geoffreylalic.springtutorial;

public record OrderRecord(
        String custumerName,
        String productName,
        int quantity
) {
}

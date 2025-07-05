package com.geoffreylalic.springtutorial;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    // to remap properties with JsonProperty
    @JsonProperty("c-name")
    private String custumerName;

    @JsonProperty("p-name")
    private String productName;

    @JsonProperty("q")
    private int quantity;


    public String getCustumerName() {
        return custumerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCustumerName(String custumerName) {
        this.custumerName = custumerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "custumerName='" + custumerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}


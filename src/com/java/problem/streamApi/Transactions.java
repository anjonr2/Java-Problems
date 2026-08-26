package com.java.problem.streamApi;

public class Transactions {
    private String category;
    private int amount;

    public Transactions(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}

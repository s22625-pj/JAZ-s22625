package com.example.jazs22625.model;

import java.util.List;

public class Rates {
    private List<Rate> rates;

    public Rates() {
    }

    public Rates(List<Rate> rates) {
        this.rates = rates;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}

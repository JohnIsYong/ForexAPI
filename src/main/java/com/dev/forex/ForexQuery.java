package com.dev.forex;

import jakarta.persistence.*;

@Entity
@Table(name="forex_query")
public class ForexQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="query_number")
    private int queryNumber;

    @Column(name="input_currency")
    private String inputCurrency;

    @Column(name="output_currency")
    private String outputCurrency;

    @Column(name="exchange_rate")
    private Double exchangeRate;

    @Column(name="query_date")
    private String dateQueried;

    @Column(name="query_time")
    private String timeQueried;

    public ForexQuery(){
    }

    public ForexQuery(String inputCurrency, String outputCurrency, Double exchangeRate, String dateQueried, String timeQueried) {
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        this.exchangeRate = exchangeRate;
        this.dateQueried = dateQueried;
        this.timeQueried = timeQueried;
    }

    public int getQueryNumber() {
        return queryNumber;
    }

    public void setQueryNumber(int queryNumber) {
        this.queryNumber = queryNumber;
    }

    public String getInputCurrency() {
        return inputCurrency;
    }

    public void setInputCurrency(String inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    public String getOutputCurrency() {
        return outputCurrency;
    }

    public void setOutputCurrency(String outputCurrency) {
        this.outputCurrency = outputCurrency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getDateQueried() {
        return dateQueried;
    }

    public void setDateQueried(String dateQueried) {
        this.dateQueried = dateQueried;
    }

    public String getTimeQueried() {
        return timeQueried;
    }

    public void setTimeQueried(String timeQueried) {
        this.timeQueried = timeQueried;
    }

    @Override
    public String toString() {
        return "ForexQuery{" +
                "queryNumber=" + queryNumber +
                ", inputCurrency='" + inputCurrency + '\'' +
                ", outputCurrency='" + outputCurrency + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", dateQueried='" + dateQueried + '\'' +
                ", timeQueried='" + timeQueried + '\'' +
                '}';
    }
}

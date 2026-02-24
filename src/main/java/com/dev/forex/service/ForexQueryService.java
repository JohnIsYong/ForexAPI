package com.dev.forex.service;

import com.dev.forex.ForexQuery;

import java.util.List;

public interface ForexQueryService {
    public List<ForexQuery> listAll();

    public List<ForexQuery> findByInputCurrency(String currency);

    public ForexQuery addQuery(ForexQuery forexQuery);

    public ForexQuery findByQueryNumber(int queryNumber);

    public ForexQuery deleteByQueryNumber(int queryNumber);

    public Integer deleteByInputCurrency(String currency);
}

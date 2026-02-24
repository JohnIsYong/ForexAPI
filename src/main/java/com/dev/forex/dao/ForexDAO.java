package com.dev.forex.dao;

import com.dev.forex.ForexQuery;

import java.util.List;

public interface ForexDAO {
    public List<ForexQuery> listAll();

    public List<ForexQuery> findByInputCurrency(String currency);

//    public boolean hasQueried(Map<String, String> partialQuery);
    public ForexQuery addQuery(ForexQuery forexQuery);

    public ForexQuery findByQueryNumber(int queryNumber);

    public ForexQuery deleteByQueryNumber(int queryNumber);

    public Integer deleteByInputCurrency(String currency);
}

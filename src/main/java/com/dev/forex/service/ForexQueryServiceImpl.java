package com.dev.forex.service;

import com.dev.forex.ForexQuery;
import com.dev.forex.dao.ForexDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ForexQueryServiceImpl implements ForexQueryService{

    private ForexDAO forexDAO;

    @Autowired
    public ForexQueryServiceImpl(ForexDAO forexDAO){
        this.forexDAO = forexDAO;
    }

    @Override
    public List<ForexQuery> listAll(){
        return forexDAO.listAll();
    }

    @Override
    public List<ForexQuery> findByInputCurrency(String currency){
        return forexDAO.findByInputCurrency(currency);
    }

    @Override
    @Transactional
    public ForexQuery addQuery(ForexQuery forexQuery) {
        return forexDAO.addQuery(forexQuery);
    }

    @Override
    public ForexQuery findByQueryNumber(int queryNumber){
        return forexDAO.findByQueryNumber(queryNumber);
    }

    @Override
    @Transactional
    public ForexQuery deleteByQueryNumber(int queryNumber){
        return forexDAO.deleteByQueryNumber(queryNumber);
    }

    @Override
    @Transactional
    public Integer deleteByInputCurrency(String currency){
        return forexDAO.deleteByInputCurrency(currency);
    }
}

package com.dev.forex.dao;

import com.dev.forex.ForexQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ForexDAOImpl implements ForexDAO{

    private EntityManager entityManager;

    @Autowired
    public ForexDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<ForexQuery> listAll(){
        TypedQuery<ForexQuery> query = entityManager.createQuery("from ForexQuery", ForexQuery.class);
        List<ForexQuery> queries = query.getResultList();
        return queries;
    }

    @Override
    public List<ForexQuery> findByInputCurrency(String currency){
        TypedQuery<ForexQuery> query = entityManager.createQuery("select c from ForexQuery c where c.inputCurrency = :value1", ForexQuery.class).setParameter("value1", currency);
        List<ForexQuery> queries = query.getResultList();
        return queries;
    }

    @Override
    public ForexQuery addQuery(ForexQuery forexQuery) {
        return entityManager.merge(forexQuery);
    }

    @Override
    public ForexQuery findByQueryNumber(int queryNumber){

        return entityManager.find(ForexQuery.class, queryNumber);
    }

    @Override
    public ForexQuery deleteByQueryNumber(int queryNumber){
        ForexQuery removed = entityManager.find(ForexQuery.class, queryNumber);
        entityManager.remove(removed);
        return removed;
    }

    @Override
    public Integer deleteByInputCurrency(String currency){
        jakarta.persistence.Query query = entityManager.createQuery("delete from ForexQuery f where f.inputCurrency = :currency").setParameter("currency", currency);
        return query.executeUpdate();
    }
}

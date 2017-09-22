package com.iqmsoft.jaas.jsf.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import com.iqmsoft.jaas.jsf.domain.Company;

import java.util.List;

@ManagedBean
@SessionScoped
public class PersistenceAwareManagedBean {

    @ManagedProperty("#{entityManagerFactoryBean.entityManager}")
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Company> getAllCompanies() {
        System.out.println("MY ENTITY MANAGER IS: "+entityManager);
        return entityManager.createQuery("select c FROM Company c").getResultList();
    }

}
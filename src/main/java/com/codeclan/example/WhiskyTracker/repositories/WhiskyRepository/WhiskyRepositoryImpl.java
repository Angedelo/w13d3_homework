package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {


//    TODO: get all whiskys for a particular year

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findAllWhiskeysForYear(int year){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr  = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

//    TODO: get all whiskies from a particular region

    @Transactional
    public List<Whisky> findAllWhiskeysFromRegion(String region){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

//    TODO: get all the whisky from a particular distillery that's a specific age (if any)


}

package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {


//    TODO: get all whiskeys for a particular year

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findAllWhiskeysForYear(int year){

    }
}

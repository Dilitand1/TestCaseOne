package ru.litvinov.javapool.model.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class DaoImpl implements Dao {

    @Autowired
    SessionFactory sessionFactory;

    public List getAllStudents(){
        List list = sessionFactory.getCurrentSession().createQuery("FROM Students").list();
        return list;
    }
}

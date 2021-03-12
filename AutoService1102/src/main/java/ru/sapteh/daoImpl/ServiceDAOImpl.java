package ru.sapteh.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Client;
import ru.sapteh.model.Service;

import java.util.List;

public class ServiceDAOImpl implements DAO<Service, Integer> {
    private final SessionFactory factory;

    public ServiceDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public void create(Service service) {
       try (Session session = factory.openSession()){
           session.beginTransaction();
           session.save(service);
           session.getTransaction().commit();
       }
    }

    public void update(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(service);
            session.getTransaction().commit();
        }
    }

    public void delete(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(service);
            session.getTransaction().commit();
        }
    }

    public Service read(Integer id) {
        try (Session session = factory.openSession()) {
            return session.get(Service.class, id);
        }
    }

    public List<Service> findByAll() {
        try (Session session = factory.openSession()){
            Query<Service> query = session.createQuery("FROM Service");
            return query.list();
        }
    }
}

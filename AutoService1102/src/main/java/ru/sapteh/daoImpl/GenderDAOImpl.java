package ru.sapteh.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.ClientService;
import ru.sapteh.model.Gender;

import java.util.List;

public class GenderDAOImpl implements DAO<Gender, Integer> {
    private final SessionFactory factory;

    public GenderDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public Gender read(Integer id) {
        try (Session session = factory.openSession()) {
            return session.get(Gender.class, id);
        }
    }

    @Override
    public List<Gender> findByAll() {
        try (Session session = factory.openSession()){
            Query<Gender> query = session.createQuery("FROM Gender");
            return query.list();
        }
    }
}

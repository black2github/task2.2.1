package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findUserByCar(String carModel, int carSeries) {
        User user = null;
        try {
            TypedQuery<User> query3 = sessionFactory.getCurrentSession()
                .createQuery("select u from User u where u.car.model = :model and u.car.series = :series")
                .setParameter("model", carModel).
                setParameter("series", carSeries);
            user = query3.getSingleResult();
        } catch (NoResultException ignore) {
        }
        return user;
    }
}

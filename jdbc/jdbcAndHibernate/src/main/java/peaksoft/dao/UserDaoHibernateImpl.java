package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao ,AutoCloseable{

    private final EntityManagerFactory entityManagerFactory=Util.getSession();


    @Override
    public void createUsersTable() {
//        Util.getSession();
//        User user=new User();
//        EntityManager entityManager= entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.createQuery(user.getName());
//        entityManager.createQuery(user.getLastName());
//        entityManager.createQuery(user.getAge().toString());
//        entityManager.getTransaction().commit();
//        entityManager.close();
    }

    @Override
    public void dropUsersTable() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("");
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user=new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void removeUserById(long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User id1 = entityManager.createQuery("select u from User u where u.id=:id", User.class).
                setParameter("id", id).getSingleResult();
        entityManager.remove(id1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> userList = entityManager.createQuery("from User ", User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from User ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();

    }
}

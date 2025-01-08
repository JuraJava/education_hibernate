package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson_10 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Class.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Car car = session.get(Car.class, 1);
//            session.delete(car);
//          Так мы удаляем когда нам требуется один объект
            session.createQuery("delete Car where color = 'Black' ").executeUpdate();
//          Так мы удаляем, когда нам требуется удалить несколько объектов

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

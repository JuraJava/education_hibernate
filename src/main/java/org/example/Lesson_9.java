package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson_9 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Car car = session.get(Car.class, 1);
//            car.setName("Honda");
//            session.createQuery("update Car set price = 170000 where year = 2022").executeUpdate();
// Если в конце строки кода метод  executeUpdate() не добавить, то запрос
// выполнится, но данные не поменяются
            session.createQuery("update Car set price = 210000 where color = 'Black'").executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

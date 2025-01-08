package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Lesson_7 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            List<Car> carList = session.createQuery("from Car").getResultList();
//            List<Car> carList = session.createQuery("from Car where year = 2020").getResultList();
//            List<Car> carList = session.createQuery("from Car where year = 2022 and name = 'BMW'").getResultList();
            List<Car> carList = session.createQuery("from Car where speed > 225").getResultList();
//  Здесь запросом выбираются данные не из БД из таблицы cars, а именно из класса Car
            for (Car car : carList) {
                System.out.println(car);
            }
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

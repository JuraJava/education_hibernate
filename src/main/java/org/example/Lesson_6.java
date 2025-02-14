package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson_6 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Car.class)
//  Эту строку можно не писать, т.к. информацию об этом
//  мы указали в hibernate.cfg.xml
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Car car1 = session.get(Car.class, 4);
            System.out.println(car1);
            // после того как мы получили данные об объекте из БД мы с помощью
            // сеттера можем их переустановить в другое значение
            car1.setSpeed(240.0);
            car1.setName("Mercedes");
            car1.setPrice(200_000);
            car1.setColor("Black");
            car1.setYear(2020);
            System.out.println(car1);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

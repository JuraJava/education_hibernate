package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
//        Car car1 = new Car("Mercedes", 2023, "Red", 150_000, 240.0);
//        Car car2 = new Car("AUDI", 2022, "Black", 75_000, 225.0);
        Car car3 = new Car("Mazda", 2021, "Blue", 50_000, 200.0);
// Добавляем в таблицу первый, потом верхнюю строку закомментируем, затем второй и т.д.

        SessionFactory factory = new Configuration()
// Здесь выбираем Configuration() именно для hibernate
                .configure("hibernate.cfg.xml")
// Так как указан файл "hibernate.cfg.xml", то именно на основе данных,
// имеющихся в нём (логин, пароль, url) и будет происходить подключение к БД
                .addAnnotatedClass(Car.class)
// Здесь мы указываем тот класс, который помечен аннотацией @Entity
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
//        После написания этого обязательно желательно запустить наше
//        приложение и после этого печатаем код дальше

            session.beginTransaction();
//        session.save(car1);
//        session.save(car2);
            session.save(car3);
// Добавляем в таблицу первый, потом верхнюю строку закомментируем, затем второй и т.д.
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
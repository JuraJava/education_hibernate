package one_to_one;

import one_to_one.entity.Car;
import one_to_one.entity.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Engine.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//      Lesson 13

//            Car car1 = new Car("Volvo", 2020, "Black", 2000, 135.7);
//            Engine engine1 = new Engine(500, 2000);
//            car1.setCarEngine(engine1);

//            Car car1 = new Car("BMW", 2022, "White", 3000, 248.0);
//            Engine engine1 = new Engine(450, 1750);
//            car1.setCarEngine(engine1);

//            session.save(car1);

//      Lesson 14
//            Получение данных из таблицы. Способ 1
//            Car car1 = session.get(Car.class, 2);
//            Engine engine = session.get(Engine.class, 1);
//            System.out.println(engine);

//            Получение данных из таблицы. Способ 2
//            List<Car> cars = session.createQuery("from Car where name = 'Volvo'").getResultList();
//            System.out.println(cars);

//            Удаление данных из таблицы.
            Car car2 = session.get(Car.class, 2);
            session.delete(car2);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

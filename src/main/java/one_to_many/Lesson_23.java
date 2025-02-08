package one_to_many;

import one_to_many.entity.Car;
import one_to_many.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Lesson_23 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Owner owner = session.get(Owner.class, 3);
//            System.out.println(owner);
//            System.out.println(owner.getCars());

// Можно и по другому получить эти данные

//            Car car = session.get(Car.class, 4);
//            System.out.println(car);
//            System.out.println(car.getOwner());

//            List<Car> cars = session.createQuery("from Car where speed > 112 and id = 4").getResultList();
//            System.out.println(cars);

//            for (Car car : cars) {
//                System.out.println(car);
//            }

// Эти верхние три строки кода можно написать и по другому:
//            for (var c : cars) {
//                System.out.println(c);
//            }

//  Lesson 24   ************************************************

//            Car car1 = session.get(Car.class, 1);
//            session.delete(car1);

            Owner owner = session.get(Owner.class, 1);
            session.delete(owner);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

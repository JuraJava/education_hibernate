package one_to_one;

import one_to_one.entity.Car;
import one_to_one.entity.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Engine.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Car car1 = new Car("AUDI", 1995, "Yellow", 600, 200);
//            Engine engine1 = new Engine(333, 3333);
//
//            car1.setCarEngine(engine1);
//            engine1.setCar(car1);
//
//            session.save(engine1);

//  Lesson 17

            Engine engine = session.get(Engine.class, 3);

            engine.getCar().setCarEngine(null);
            // Это мы делаем чтобы разорвать связь между автомобилем (Car) и двигателем (Engine)
            // чтобы потом удалить, а если бы в классе Engine cascade был бы = CascadeType.ALL
            // то этого делать бы не пришлось

            session.delete(engine);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

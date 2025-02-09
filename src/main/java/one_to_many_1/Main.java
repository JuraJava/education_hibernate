package one_to_many_1;

import jakarta.persistence.CascadeType;
import one_to_many_1.entity.Car;
import one_to_many_1.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Owner owner = new Owner("Katia", 23);
//            Car car1 = new Car("Fiat", 150);
//            Car car2 = new Car("Siat", 160);
//            owner.addCarToOwner(car1);
//            owner.addCarToOwner(car2);
//            session.save(owner);
////    Так можно добавлять данные в таблицы

//            Car car = session.get(Car.class, 13);
//            session.delete(car);
////    Так мы удалили один автомобиль по id и владелец при этом не удалился

            Owner owner = session.get(Owner.class, 6);
            session.delete(owner);
//  Так мы удалили владельца Елена и т.к. cascade = CascadeType.ALL то удалились и её автомобили

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

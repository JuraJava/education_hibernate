package many_to_many;

import many_to_many.entity.Passenger;
import many_to_many.entity.Taxi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
                .addAnnotatedClass(Taxi.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//  Lesson 31  Добавление данных в БД

//            Taxi taxi1 = new Taxi();
//            taxi1.setName("Mazda");
//            Passenger passenger1 = new Passenger("Vasia", 32);
//            Passenger passenger2 = new Passenger("Olia", 23);
//            Passenger passenger3 = new Passenger("Kolia", 45);
//            taxi1.addPassengerToTaxi(passenger1);
//            taxi1.addPassengerToTaxi(passenger2);
//            taxi1.addPassengerToTaxi(passenger3);
//            session.save(taxi1);
//            Taxi taxi2 = new Taxi("BMW");
//            taxi2.addPassengerToTaxi(passenger2);
//            taxi2.addPassengerToTaxi(passenger3);
//            session.save(taxi2);

//  Lesson 32  Получение данных из БД

//            Taxi taxi1 = session.get(Taxi.class, 1);
//            System.out.println(taxi1);
//            System.out.println(taxi1.getPassengerList());

//            Passenger passenger1 = session.get(Passenger.class, 4);
//            System.out.println(passenger1);
//            System.out.println(passenger1.getTaxiList());

//  Lesson 33

//            Taxi taxi3 = new Taxi();
//            taxi3.setName("AUDI");
//            Passenger passenger3 = session.get(Passenger.class, 3);
//            Passenger passenger4 = session.get(Passenger.class, 4);
//
//            taxi3.addPassengerToTaxi(passenger3);
//            taxi3.addPassengerToTaxi(passenger4);
//            session.save(taxi3);

//  Lesson 33  Удаление данных из БД

//            Passenger passenger3 = session.get(Passenger.class, 3);
//            session.delete(passenger3);

//  Lesson 34 Добавление данных

            Taxi taxi1 = new Taxi("Mazda");
            Taxi taxi2 = new Taxi("Ford");
            Taxi taxi3 = new Taxi("BMW");

            session.save(taxi1);
            session.save(taxi2);
            session.save(taxi3);

            Passenger passenger1 = new Passenger("Vasia", 32);
            Passenger passenger2 = new Passenger("Olia", 23);
            Passenger passenger3 = new Passenger("Kolia", 45);
            Passenger passenger4 = new Passenger("Tania", 45);
            Passenger passenger5 = new Passenger("Serg", 45);

            session.save(passenger1);
            session.save(passenger2);
            session.save(passenger3);
            session.save(passenger4);
            session.save(passenger5);

// Такой вариант добавления не оптимальный

            taxi1.addPassengerToTaxi(passenger1);
            taxi1.addPassengerToTaxi(passenger2);
            taxi1.addPassengerToTaxi(passenger3);

            taxi2.addPassengerToTaxi(passenger2);
            taxi2.addPassengerToTaxi(passenger3);
            taxi2.addPassengerToTaxi(passenger4);

            taxi3.addPassengerToTaxi(passenger3);
            taxi3.addPassengerToTaxi(passenger4);
            taxi3.addPassengerToTaxi(passenger5);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

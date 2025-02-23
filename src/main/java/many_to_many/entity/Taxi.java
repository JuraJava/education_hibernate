package many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "taxi")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

// @ManyToMany(cascade = CascadeType.ALL)
// Если мы установим cascade = CascadeType.ALL, то при удалении данных с какой-нибудь
// таблицы, будут удаляться все данные из связанных таблиц,
// для ManyToMany  CascadeType.ALL лучше не устанавливать
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH })
    @JoinTable(name = "pass_taxi",
            joinColumns = @JoinColumn(name = "taxi_id"),
            inverseJoinColumns = @JoinColumn(name = "pass_id"))
    private List<Passenger> passengerList;

    public Taxi() {
    }

    public Taxi(String name) {
        this.name = name;
    }

    public void addPassengerToTaxi(Passenger passenger) {
        if(passengerList == null) {
            passengerList = new ArrayList<Passenger>();
        }
        passengerList.add(passenger);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

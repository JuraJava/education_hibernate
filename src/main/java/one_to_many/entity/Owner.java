package one_to_many.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
//    @Column(name = "car_id")
//    private int car_id;

    public Owner() {
    }

    public Owner(String name, int age, int car_id) {
        this.name = name;
        this.age = age;
//        this.car_id = car_id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public int getCar_id() {
//        return car_id;
//    }
//
//    public void setCar_id(int car_id) {
//        this.car_id = car_id;
//    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
//                ", car_id=" + car_id +
                '}';
    }
}

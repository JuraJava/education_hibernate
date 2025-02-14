package one_to_one.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "engine")
// После написания этой строки если "engine" будет подчёркнуто красным
// жмём Alt+Enter, далее Assign Data Sources, далее выбираем education_db@localhost
public class Engine {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private int id;

   @Column(name = "horse_power")
   private int horsePower;

   @Column(name = "volume")
   private int volume;

//   @OneToOne(mappedBy = "carEngine", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "carEngine", cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
   private Car car;
   // Это поле мы добавили позднее чтобы показать двунаправленную связь


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Engine() {
    }

    public Engine(int horsePower, int volume) {
        this.horsePower = horsePower;
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", horsePower=" + horsePower +
                ", volume=" + volume +
                '}';
    }
}

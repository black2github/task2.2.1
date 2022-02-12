package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    String model;
    int series;
    /*
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    User user;

     */

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    /*
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car{id=").append(id).append(", model=").append(model).append(", series=").append(series);
        return sb.toString();
    }
}

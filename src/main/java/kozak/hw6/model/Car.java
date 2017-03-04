package kozak.hw6.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Олексій on 01.03.2017.
 */
@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "model")
    private String model;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "car_service", joinColumns = {
            @JoinColumn(name = "car_id",updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "service_id",
                    nullable = false, updatable = false)})
    private Set<ServiceStation> services = new HashSet();
    @Column(name = "engine_id")
    private Integer engineId;
    @Column(name = "price")
    private Long price;
    @Column(name = "date")
    private String date;
    @Column(name = "creator")
    private String creator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<ServiceStation> getServices() {
        return services;
    }

    public void setServices(Set<ServiceStation> services) {
        this.services = services;
    }

    public Integer getEngineId() {
        return engineId;
    }

    public void setEngineId(Integer engineId) {
        this.engineId = engineId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", services=" + services +
                ", engineId=" + engineId +
                ", price=" + price +
                ", date=" + date +
                ", creator='" + creator + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!id.equals(car.id)) return false;
        if (!model.equals(car.model)) return false;
        if (services != null ? !services.equals(car.services) : car.services != null) return false;
        if (!engineId.equals(car.engineId)) return false;
        if (!price.equals(car.price)) return false;
        if (!date.equals(car.date)) return false;
        return creator.equals(car.creator);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + (services != null ? services.hashCode() : 0);
        result = 31 * result + engineId.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + creator.hashCode();
        return result;
    }
}

package kozak.hw6.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Олексій on 01.03.2017.
 */
@Entity
@Table(name = "service_stations")
public class ServiceStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private Long service_id;
    @Column(name = "address")
    private String address;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "services",cascade=CascadeType.ALL)
    private Set<Car> cars = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "serviceStation")
    private Set<Mechanic> mechanics = new HashSet<>();

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(Set<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    @Override
    public String toString() {
        return "ServiceStation{" +
                "service_id=" + service_id +
                ", address='" + address + '\'' +
                ", cars=" + cars +
                ", mechanics=" + mechanics +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceStation that = (ServiceStation) o;

        if (!service_id.equals(that.service_id)) return false;
        if (!address.equals(that.address)) return false;
        if (cars != null ? !cars.equals(that.cars) : that.cars != null) return false;
        return mechanics != null ? mechanics.equals(that.mechanics) : that.mechanics == null;
    }

    @Override
    public int hashCode() {
        int result = service_id.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
//        result = 31 * result + (mechanics != null ? mechanics.hashCode() : 0);
        return result;
    }
}

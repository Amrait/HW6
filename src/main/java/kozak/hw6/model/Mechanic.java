package kozak.hw6.model;

import javax.persistence.*;

/**
 * Created by Олексій on 01.03.2017.
 */
@Entity
@Table(name = "mechanic")
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mechanic_id")
    private Long mechanicId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id",nullable = false)
    private ServiceStation serviceStation;

    public Long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ServiceStation getServiceStation() {
        return serviceStation;
    }

    public void setServiceStation(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "mechanicId=" + mechanicId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", serviceStationId=" + serviceStation.getService_id() +
                ", serviceAddress=" + serviceStation.getAddress() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mechanic mechanic = (Mechanic) o;

        if (!mechanicId.equals(mechanic.mechanicId)) return false;
        if (!name.equals(mechanic.name)) return false;
        if (!surname.equals(mechanic.surname)) return false;
        return serviceStation != null ? serviceStation.equals(mechanic.serviceStation) : mechanic.serviceStation == null;
    }

    @Override
    public int hashCode() {
        int result = mechanicId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (serviceStation != null ? serviceStation.hashCode() : 0);
        return result;
    }
}

package tractebel.exercice.model;

import javax.persistence.*;

/**
 * Created by Dell on 28/09/2017.
 */
@Entity
@Table(name="team1_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade =  CascadeType.ALL)
    private Payment payment;

    @Column(name = "serial_number")
    private String serial_number;

    @OneToOne(cascade =  CascadeType.ALL)
    private Order favorite;

    public Order getFavorite() {
        return favorite;
    }

    public void setFavorite(Order favorite) {
        this.favorite = favorite;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }
}

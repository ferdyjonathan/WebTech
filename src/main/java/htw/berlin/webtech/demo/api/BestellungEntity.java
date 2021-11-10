package htw.berlin.webtech.demo.api;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity(name = "bestellung")
public class BestellungEntity {

    @Column
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Nullable
    private String name;

    @Column
    @Nullable
    private String paket;

    @Column
    @Nullable
    private String payment;

    @Column
    @Nullable
    private String status;

    @Column
    @Nullable
    private double totalprice;

    public BestellungEntity( String name, String paket, String payment, String status, double totalprice) {
        this.name = name;
        this.paket = paket;
        this.payment = payment;
        this.status = status;
        this.totalprice = totalprice;
    }

    protected BestellungEntity() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
}

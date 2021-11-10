package htw.berlin.webtech.demo.api;

public class Bestellung {

    private int id;
    private String name;
    private String paket;
    private String payment;
    private String status;
    private double totalprice;

    public Bestellung(int id, String name, String paket, String payment, String status, double totalprice){
        this.id = id;
        this.name = name;
        this.paket = paket;
        this.payment= payment;
        this.status = status;
        this.totalprice =  totalprice;
    }

    public Bestellung() {
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
package htw.berlin.webtech.demo.api;

import javax.validation.constraints.Size;

public class BestellungManipulationRequest {

    @Size(min = 3, message = "Please provide name with 3 characters or more.")
    private String name;

    private String paket;
    private Boolean payment;
    private String status;
    private double totalprice;

    public BestellungManipulationRequest(String name, String paket, Boolean payment, String status, double totalprice) {
        this.name = name;
        this.paket = paket;
        this.payment = payment;
        this.status = status;
        this.totalprice = totalprice;
    }

    public BestellungManipulationRequest() {}

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

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
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

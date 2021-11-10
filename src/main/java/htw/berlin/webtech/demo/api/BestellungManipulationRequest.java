package htw.berlin.webtech.demo.api;

public class BestellungManipulationRequest {

    private String name;
    private String paket;
    private String payment;
    private String status;
    private double totalprice;

    public BestellungManipulationRequest(String name, String paket, String payment, String status, double totalprice) {
        this.name = name;
        this.paket = paket;
        this.payment = payment;
        this.status = status;
        this.totalprice = totalprice;
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

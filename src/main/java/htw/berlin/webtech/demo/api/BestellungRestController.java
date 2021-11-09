//package htw.berlin.webtech.demo.api;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class BestellungRestController {
//
//    private List<Bestellung> bestellungs;
//
//    public BestellungRestController(){
//     bestellungs = new ArrayList<>();
//     bestellungs.add(new Bestellung(1,"Mutter","paket1","bezahlt","Process",2.5));
//     bestellungs.add(new Bestellung(5,"Mike","paket2","bezahlt","Pending",5.5));
//    }
//
//    @GetMapping(path = "/api/v1/orders")
//    public List<Bestellung> fetchBestellungs(){
//        return bestellungs;
//    }
//}

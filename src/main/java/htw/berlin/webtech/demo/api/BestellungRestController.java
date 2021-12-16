package htw.berlin.webtech.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BestellungRestController {

    private final BestellungServiceImp bestellungServiceImp;

    public BestellungRestController(BestellungServiceImp bestellungServiceImp) {
        this.bestellungServiceImp = bestellungServiceImp;
    }

    @GetMapping(path = "/api/bestellungs")
    public ResponseEntity<List<Bestellung>> fetchBestellungs(){
        return ResponseEntity.ok(bestellungServiceImp.findall());
    }

    @GetMapping(path = "/api/bestellungs/{id}")
    public ResponseEntity<Bestellung> fetchBestellungById(@PathVariable Integer id){
        var bestellung = bestellungServiceImp.findById(id);
        return bestellung != null? ResponseEntity.ok(bestellung) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/bestellungs")
    public ResponseEntity<Void> createBestellung(@RequestBody BestellungManipulationRequest request) throws URISyntaxException {
        var bestellung= bestellungServiceImp.create(request);
        URI uri = new URI("/api/bestellung/" + bestellung.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/bestellungs/{id}")
    public ResponseEntity<Bestellung> updateBestellung(@PathVariable Integer id, @RequestBody BestellungManipulationRequest request){
        var bestellung = bestellungServiceImp.update(id, request);
        return bestellung != null? ResponseEntity.ok(bestellung) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/bestellungs/{id}")
    public ResponseEntity<Void> deleteBestellung(@PathVariable Integer id){
        boolean succesful = bestellungServiceImp.deleteById(id);
        return succesful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/homepage")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "homepage";
    }

}

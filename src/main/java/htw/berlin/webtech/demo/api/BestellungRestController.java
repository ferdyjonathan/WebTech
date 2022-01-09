package htw.berlin.webtech.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Void> createBestellung(@Valid @RequestBody BestellungManipulationRequest request) throws URISyntaxException {
        var valid = validate(request);
        if(valid){
            var bestellung= bestellungServiceImp.create(request);
            URI uri = new URI("/api/bestellungs/" + bestellung.getId());
            return ResponseEntity.created(uri).build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }
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

    private boolean validate(BestellungManipulationRequest request){
        return request.getName() != null
                && !request.getName().isBlank()
                && request.getPaket() != null
                && request.getTotalprice() != 0
                && !request.getPaket().isBlank()
                && request.getStatus() != null
                && !request.getStatus().isBlank();
    }
}

package htw.berlin.webtech.demo.api;

import org.springframework.stereotype.Service;

@Service
public class BestellungServiceImp implements BestellungService{

    private final BestellungRepository bestellungRepository;

    public BestellungServiceImp(BestellungRepository bestellungRepository) {
        this.bestellungRepository = bestellungRepository;
    }

    public Bestellung save(Bestellung bestellung) {
        return bestellungRepository.save(bestellung);
    }

    public void deleteById(int id) {

        bestellungRepository.deleteById(id);
    }
}

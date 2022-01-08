package htw.berlin.webtech.demo.service;

import htw.berlin.webtech.demo.api.Bestellung;
import htw.berlin.webtech.demo.persistence.BestellungEntity;
import org.springframework.stereotype.Service;

@Service
public class BestellungTransformer {

    public Bestellung transformEntity(BestellungEntity bestellungEntity){
        return new Bestellung(
                bestellungEntity.getId(),
                bestellungEntity.getName(),
                bestellungEntity.getPaket(),
                bestellungEntity.getPayment(),
                bestellungEntity.getStatus(),
                bestellungEntity.getTotalprice()
        );
    }
}

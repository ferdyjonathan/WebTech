package htw.berlin.webtech.demo.api;

import htw.berlin.webtech.demo.persistence.BestellungEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BestellungServiceImp implements BestellungService {

    private final BestellungRepository bestellungRepository;

    public BestellungServiceImp(BestellungRepository bestellungRepository) {
        this.bestellungRepository = bestellungRepository;
    }

    public List<Bestellung> findall() {
        List<BestellungEntity> bestellungs = bestellungRepository.findAll();
        return bestellungs.stream().
                map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Bestellung findById(Integer id){
        var bestellungEntity = bestellungRepository.findById(id);
        return bestellungEntity.map(this::transformEntity).orElse(null);
    }

    public Bestellung create(BestellungManipulationRequest request){
        var bestellungEntity = new BestellungEntity(request.getName(),request.getPaket(),request.getPayment(), request.getStatus(), request.getTotalprice());
        bestellungEntity = bestellungRepository.save(bestellungEntity);
        return transformEntity(bestellungEntity);
    }

    private Bestellung transformEntity(BestellungEntity bestellungEntity){
        return new Bestellung(
                bestellungEntity.getId(),
                bestellungEntity.getName(),
                bestellungEntity.getPaket(),
                bestellungEntity.getPayment(),
                bestellungEntity.getStatus(),
                bestellungEntity.getTotalprice()
        );
    }

    public Bestellung update(int id, BestellungManipulationRequest request){
      var bestellungEntityOptional = bestellungRepository.findById(id);
      if(bestellungEntityOptional.isEmpty()){
          return null;
      }

      var bestellungEntity = bestellungEntityOptional.get();
      bestellungEntity.setName(request.getName());
      bestellungEntity.setPaket(request.getPaket());
      bestellungEntity.setPayment(request.getPayment());
      bestellungEntity.setStatus(request.getStatus());
      bestellungEntity.setTotalprice(request.getTotalprice());
      bestellungEntity = bestellungRepository.save(bestellungEntity);

    return transformEntity(bestellungEntity);
    }

    public boolean deleteById(int id) {
        if(!bestellungRepository.existsById(id)){
            return false;
        }

        bestellungRepository.deleteById(id);
        return true;
    }
}

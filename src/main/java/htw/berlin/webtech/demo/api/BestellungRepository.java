package htw.berlin.webtech.demo.api;

import htw.berlin.webtech.demo.persistence.BestellungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestellungRepository extends JpaRepository<BestellungEntity, Integer> {

    List<BestellungEntity> findAllById(Integer id);

}

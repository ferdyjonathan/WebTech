package htw.berlin.webtech.demo.api;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BestellungRepository extends JpaRepository<BestellungEntity, Integer> {

    List<BestellungEntity> findAllById(Integer id);

}

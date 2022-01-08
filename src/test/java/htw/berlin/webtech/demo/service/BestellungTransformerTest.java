package htw.berlin.webtech.demo.service;

import htw.berlin.webtech.demo.persistence.BestellungEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

class BestellungTransformerTest implements WithAssertions {

    private final BestellungTransformer underTest = new BestellungTransformer();

    @Test
    @DisplayName("Should transform BestellungEntity to Bestellung")
    void should_transform_bestellung_entity_to_bestellung(){
       //given
       var bestellungEntity = Mockito.mock(BestellungEntity.class);
       doReturn(111).when(bestellungEntity).getId();
       doReturn("Michael").when(bestellungEntity).getName();
       doReturn("Special Service").when(bestellungEntity).getPaket();
       doReturn(true).when(bestellungEntity).getPayment();
       doReturn("New").when(bestellungEntity).getStatus();
       doReturn(2.0).when(bestellungEntity).getTotalprice();

        // when
        var result = underTest.transformEntity(bestellungEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getName()).isEqualTo("Michael");
        assertThat(result.getPaket()).isEqualTo("Special Service");
        assertThat(result.isPayment()).isEqualTo(true);
        assertThat(result.getStatus()).isEqualTo("New");
        assertThat(result.getTotalprice()).isEqualTo(2.0);
    }

}

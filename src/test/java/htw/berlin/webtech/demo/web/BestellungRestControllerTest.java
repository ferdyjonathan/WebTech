package htw.berlin.webtech.demo.web;

import htw.berlin.webtech.demo.api.Bestellung;
import htw.berlin.webtech.demo.api.BestellungRestController;
import htw.berlin.webtech.demo.api.BestellungServiceImp;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@WebMvcTest(BestellungRestController.class)
class BestellungRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BestellungServiceImp bestellungservice;

    @Test
    @DisplayName("should return found order from order service")
    void should_return_found_Order_from_Order_service() throws Exception {

        //given
        var bestellungs = List.of(
                new Bestellung(1,"Michael","Special Service",true,"new",9.5),
                new Bestellung(2,"Rowen","One day Service",true,"new",15.6)
        );
        doReturn(bestellungs).when(bestellungservice).findall();

        mockMvc.perform(get("/api/bestellungs"))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Michael"))
                .andExpect(jsonPath("$[0].paket").value("Special Service"))
                .andExpect(jsonPath("$[0].payment").value(true))
                .andExpect(jsonPath("$[0].status").value("new"))
                .andExpect(jsonPath("$[0].totalprice").value(9.5))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Rowen"))
                .andExpect(jsonPath("$[1].paket").value("One day Service"))
                .andExpect(jsonPath("$[1].payment").value(true))
                .andExpect(jsonPath("$[1].status").value("new"))
                .andExpect(jsonPath("$[1].totalprice").value(15.6));
    }

    @Test
    @DisplayName("should return 404 if Order is not found")
    void should_return_404_if_Order_is_not_found() throws Exception {
        // given
        doReturn(null).when(bestellungservice).findById(anyInt());

        // when
        mockMvc.perform(get("/api/bestellungs/150"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a Order")
    void should_return_201_http_status_and_location_header_when_creating_a_order() throws Exception {
        //given
        String orderToCreateAsJson = "{\"name\": \"Michael\", \"paket\": \"Special Service\", \"payment\": true, \"status\": \"new\", \"totalprice\": 9.5}";
        var dummyorder = new Bestellung(123, null, null, false, null, 0.0);
        doReturn(dummyorder).when(bestellungservice).create(any());

        //when
        mockMvc.perform(
                post("/api/bestellungs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderToCreateAsJson)
                )
                //then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/bestellungs/" + dummyorder.getId()))));
    }

    @Test
    @DisplayName("should validate create order request")
    void should_validate_create_order_request() throws Exception {
        // given
        String orderToCreateAsJson = "{\"name\": \"M\", \"paket\": \"Special Service\", \"payment\": true, \"status\": \"new\", \"totalprice\": 9.5}";

        // when
        mockMvc.perform(
                        post("/api/bestellungs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(orderToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}

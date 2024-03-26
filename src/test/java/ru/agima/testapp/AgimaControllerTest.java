package ru.agima.testapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.agima.testapp.agima.model.DeleteResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AgimaControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    void delete() {
        ResponseEntity<DeleteResponse> resp = template.exchange("/?threshold=15.03.2024", HttpMethod.DELETE, HttpEntity.EMPTY, DeleteResponse.class);
        Assertions.assertEquals(HttpStatus.OK, resp.getStatusCode());
        Assertions.assertNotNull(resp.getBody());
        Assertions.assertEquals(0, resp.getBody().getCount());
    }

}

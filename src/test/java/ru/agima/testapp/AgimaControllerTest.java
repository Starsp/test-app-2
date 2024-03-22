package ru.agima.testapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AgimaControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    void delete() {
        ResponseEntity<String> resp = template.exchange("/", HttpMethod.DELETE, HttpEntity.EMPTY, String.class);
    }
}

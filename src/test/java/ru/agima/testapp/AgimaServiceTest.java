package ru.agima.testapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.agima.testapp.agima.service.AgimaService;

import java.time.LocalDate;

@SpringBootTest
class AgimaServiceTest {

    @Autowired
    private AgimaService agimaService;

    @Test
    void deleteTest() {
        agimaService.delete(LocalDate.now());
    }

}

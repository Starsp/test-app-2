package ru.agima.testapp;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.agima.testapp.agima.domain.repository.AgimaRepository;
import ru.agima.testapp.agima.service.AgimaService;

import java.time.LocalDate;

@SpringBootTest
class AgimaServiceTest {

    @Autowired
    private AgimaService agimaService;
    @Autowired
    private AgimaRepository agimaRepository;


    @Test
    void deleteTest() {
        agimaService.delete(LocalDate.now().minusDays(2));
        Assertions.assertEquals(2L, agimaRepository.count());
        Assertions.assertTrue(CollectionUtils.isNotEmpty(agimaRepository.findAll()));
    }

}

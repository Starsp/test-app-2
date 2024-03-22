package ru.agima.testapp.agima.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agima.testapp.agima.service.AgimaService;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class AgimaController {

    private final AgimaService agimaService;

    @DeleteMapping
    public void delete(Instant instant) {
        agimaService.delete(instant);
    }

}

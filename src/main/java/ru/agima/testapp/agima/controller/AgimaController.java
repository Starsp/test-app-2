package ru.agima.testapp.agima.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.agima.testapp.agima.domain.entity.Agima;
import ru.agima.testapp.agima.domain.repository.AgimaRepository;
import ru.agima.testapp.agima.model.DeleteResponse;
import ru.agima.testapp.agima.service.AgimaService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class AgimaController {

    private final AgimaService agimaService;
    private final AgimaRepository agimaRepository;

    @DeleteMapping
    @Operation(summary = "Удаление записей старше порогового значения", description = "Формат даты dd.MM.yyyy")
    public DeleteResponse delete(@RequestParam(name = "threshold") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate threshold) {
        return agimaService.delete(threshold);
    }

    @GetMapping
    @Operation(summary = "Удаление записей старше порогового значения", description = "Формат даты dd.MM.yyyy")
    public void get() {
        Agima agima = new Agima();
        agima.setId(124124124L);
        agima.setCreateDate(LocalDateTime.now());
        agimaRepository.save(agima);
    }

}

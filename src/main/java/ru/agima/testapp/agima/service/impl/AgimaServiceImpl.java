package ru.agima.testapp.agima.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.agima.testapp.agima.domain.entity.Agima;
import ru.agima.testapp.agima.domain.repository.AgimaRepository;
import ru.agima.testapp.agima.model.DeleteResponse;
import ru.agima.testapp.agima.service.AgimaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class AgimaServiceImpl implements AgimaService {

    private final AgimaRepository repository;

    @Async
    @Override
    public CompletableFuture<DeleteResponse> delete(@NotNull LocalDate threshold) {
        LocalDateTime thresholdDateTime = threshold.atStartOfDay();
        return CompletableFuture.completedFuture(new DeleteResponse(repository.deleteByThreshold(thresholdDateTime)));
    }

    @Override
    public Long create() {
        Agima agima = new Agima();
        agima.setCreateDate(LocalDateTime.now());
        return repository.save(agima).getId();
    }

}

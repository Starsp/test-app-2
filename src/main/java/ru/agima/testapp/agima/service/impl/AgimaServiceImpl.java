package ru.agima.testapp.agima.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
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

    @Lazy
    @Autowired
    private AgimaService agimaService;
    private final AgimaRepository repository;

    @Override
    public DeleteResponse delete(@NotNull LocalDate threshold) {
        LocalDateTime thresholdDateTime = threshold.atStartOfDay();
//        Long count = repository.countAgimaByCreateDateIsBefore(thresholdDateTime);
        CompletableFuture.runAsync(() -> agimaService.delete(thresholdDateTime, 0L));
        return new DeleteResponse(0L);
    }

    @Async
    public void delete(LocalDateTime threshold, Long count) {
        while (count >= 0) {
            final long cnt = count - 100000;
            count = cnt;
            agimaService.deletePart(threshold, cnt);
        }
        agimaService.deletePart(threshold, count % 100000);
    }

    @Override
    @Async
    public void deletePart(LocalDateTime threshold, Long count) {
        repository.delete(threshold, count);
    }

}

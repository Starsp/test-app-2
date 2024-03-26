package ru.agima.testapp.agima.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agima.testapp.agima.domain.repository.AgimaRepository;
import ru.agima.testapp.agima.model.DeleteResponse;
import ru.agima.testapp.agima.service.AgimaService;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class AgimaServiceImpl implements AgimaService {


    private final AgimaRepository repository;

    @Override
    @Transactional
    public DeleteResponse delete(@NotNull LocalDate threshold) {
        return new DeleteResponse(repository.deleteByThreshold(threshold.atStartOfDay()));
    }

}

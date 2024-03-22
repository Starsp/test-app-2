package ru.agima.testapp.agima.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.agima.testapp.agima.domain.repository.AgimaRepository;
import ru.agima.testapp.agima.service.AgimaService;

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class AgimaServiceImpl implements AgimaService {


    private final AgimaRepository repository;

    @Override
    public void delete(Instant threshold) {
        repository.deleteByThreshold(threshold);
    }

}

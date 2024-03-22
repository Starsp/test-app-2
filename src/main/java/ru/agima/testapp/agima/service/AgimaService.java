package ru.agima.testapp.agima.service;

import java.time.Instant;

public interface AgimaService {

    /**
     * @param threshold
     * @apiNote Delete rows with date older than threshold
     */
    void delete(Instant threshold);

}

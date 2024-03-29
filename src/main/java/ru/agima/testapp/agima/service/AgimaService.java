package ru.agima.testapp.agima.service;

import ru.agima.testapp.agima.model.DeleteResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AgimaService {

    /**
     * @param threshold
     * @return count the number of deleted rows
     * @apiNote Delete rows with date older than threshold
     */
    DeleteResponse delete(LocalDate threshold);

    void delete(LocalDateTime threshold, Long count);

    void deletePart(LocalDateTime threshold, Long count);
}

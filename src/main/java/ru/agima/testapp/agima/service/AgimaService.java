package ru.agima.testapp.agima.service;

import ru.agima.testapp.agima.model.DeleteResponse;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

public interface AgimaService {

    /**
     * @param threshold
     * @return count the number of deleted rows
     * @apiNote Delete rows with date older than threshold
     */
    CompletableFuture<DeleteResponse> delete(LocalDate threshold);

    Long create();

}

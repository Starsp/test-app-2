package ru.agima.testapp.agima.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.agima.testapp.agima.domain.entity.Agima;

import java.time.Instant;

@Repository
public interface AgimaRepository extends JpaRepository<Agima, Long> {

    @Modifying
    @Query("DELETE Agima where createDate < :threshold")
    Integer deleteByThreshold(Instant threshold);

}
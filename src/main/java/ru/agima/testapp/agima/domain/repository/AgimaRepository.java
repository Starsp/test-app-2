package ru.agima.testapp.agima.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agima.testapp.agima.domain.entity.Agima;

import java.time.LocalDateTime;

@Repository
public interface AgimaRepository extends JpaRepository<Agima, Long> {

    @Modifying
    @Transactional
    @Query("DELETE Agima where createDate < :threshold")
    Integer deleteByThreshold(LocalDateTime threshold);

}

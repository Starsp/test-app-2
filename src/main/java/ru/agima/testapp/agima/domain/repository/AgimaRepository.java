package ru.agima.testapp.agima.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.agima.testapp.agima.domain.entity.Agima;

import java.time.LocalDateTime;

@Repository
public interface AgimaRepository extends JpaRepository<Agima, Long> {

    @Modifying
    @Query("DELETE Agima where createDate < :threshold")
    Integer deleteByThreshold(LocalDateTime threshold);

    Long countAgimaByCreateDateIsBefore(LocalDateTime threshold);

    @Modifying
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Query(nativeQuery = true, value =
            """
                    DELETE
                    FROM agima
                    WHERE id IN (select id from agima WHERE create_date <= ?1 FETCH NEXT ?2 ROWS ONLY)
                    """)
    Integer delete(LocalDateTime threshold, Long count);
}

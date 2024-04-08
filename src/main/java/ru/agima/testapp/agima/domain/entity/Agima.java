package ru.agima.testapp.agima.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "AGIMA")
public class Agima {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_AGIMA")
    @SequenceGenerator(name = "SEQ_AGIMA", sequenceName = "SEQ_AGIMA", allocationSize = 1)
    private Long id;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate;

}

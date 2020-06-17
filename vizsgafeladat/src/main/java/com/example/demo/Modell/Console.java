package com.example.demo.Modell;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "console")
public class Console {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "console_generator")
    @SequenceGenerator(name = "console_generator", sequenceName = "console_seq")
    private Long consoleID;

    @Column(name = "consoleName", nullable = false)
    @Size(min = 1, max = 50)
    private String consoleName;

    @Column(name = "portable", nullable = false)
    private boolean portable;

    @Column(name = "consolePrice", nullable = false)
    private int consolePrice;
}

package com.gitclientes.clientes.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(name = "date_register")
    private LocalDate dateRegiser;

    @PrePersist
    public void prePersist(){
        setDateRegiser(LocalDate.now());
    }

}

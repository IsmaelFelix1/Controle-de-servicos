package com.gitclientes.clientes.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "O campo nome é obrigatório.")
    private String name;

    @Column(nullable = false, length = 11)
    @NotNull(message = "O campo CPF é obrigatório.")
    @CPF(message = "CPF está inválido.")

    private String cpf;
    @Column(name = "date_register")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegiser;

    @PrePersist
    public void prePersist(){
        setDateRegiser(LocalDate.now());
    }

}

package com.gitclientes.clientes.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandarError implements Serializable {
    private static final long serialVersionUID= 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}

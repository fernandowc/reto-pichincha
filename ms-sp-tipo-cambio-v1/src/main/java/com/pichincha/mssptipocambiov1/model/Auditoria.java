package com.pichincha.mssptipocambiov1.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "auditoria")
@ToString
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long idTipoCambio;
    @Column
    private String fechaHora;
    @Column
    private String tipoOperaracion;
    @Column
    private String idUsuario;
    @Column
    private String tipoCambioAnterior;
    @Column
    private String tipoCambioActual;

}

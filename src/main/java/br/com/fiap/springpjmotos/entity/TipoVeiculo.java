package br.com.fiap.springpjmotos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_TIPOVEICULO")
public class TipoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_TIPOVEICULO")
    @SequenceGenerator(name = "SQ_TIPOVEICULO",
            sequenceName = "SQ_TIPOVEICULO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_TIPOVEICULO")
    private Long id;

    @Column(name = "NM_TIPOVEICULO")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "VEICULO", referencedColumnName = "ID_VEICULO",
            foreignKey = @ForeignKey(name = "FK_TIPO_VEICULO_VEICULO"))
    private Veiculo tipo;

}


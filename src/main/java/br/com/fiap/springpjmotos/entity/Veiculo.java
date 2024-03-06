package br.com.fiap.springpjmotos.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_Veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_VEICULOS")
    @SequenceGenerator(name = "SQ_VEICULOS",
            sequenceName = "SQ_VEICULOS",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_VEICULO")
    private Long id;

    @Column(name = "NM_VEICULO")
    private String nome;

    @Column(name = "COR")
    private String cor;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "CILINDRADAS")
    private Short cilindradas;
}

package br.com.fiap.springpjmotos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
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

    @Column(name = "PRECO")
    private Double preco;

    @ManyToMany(fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "TB_ACESSORIO_VEICULO",
            joinColumns = {
                    @JoinColumn(name = "ACESSORIO",
                    referencedColumnName = "ID_ACESSORIO",
                    foreignKey = @ForeignKey(name ="FK_VEICULO_ACESSORIO")
            )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                    name = "VEICULO",
                    referencedColumnName = "ID_VEICULO",
                    foreignKey = @ForeignKey(name = "FK_VEICULOS_ACESSORIO")
                    )
            }
    )
    private Set<Veiculo> acessorios = new LinkedHashSet<>();




}



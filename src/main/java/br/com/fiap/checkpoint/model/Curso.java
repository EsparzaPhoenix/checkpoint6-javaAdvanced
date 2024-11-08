package br.com.fiap.checkpoint.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "CP_JV_CURSO")
@Getter
@Setter
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue
    @Column(name = "id_curso")
    private int id;

    @Column(name = "nm_curso")
    private String nome;

    @Column(name = "ds_curso")
    private String descricao;

    @Column(name = "nr_carga_horaria")
    private int cargaHoraria;

    @Column(name = "dt_inicio")
    private Date dataInicio;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Matricula> matriculas;
}

package br.com.fiap.checkpoint.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "CP_JV_MATRICULA")
@Getter
@Setter
@NoArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue
    @Column(name = "id_matricula")
    private int id;

    @Column(name = "dt_matricula")
    private Date dataMatricula;

    @Column(name = "ds_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    public Matricula(Date dataMatricula, String status, Usuario usuario, Curso curso) {
        this.dataMatricula = dataMatricula;
        this.status = status;
        this.usuario = usuario;
        this.curso = curso;
    }
}

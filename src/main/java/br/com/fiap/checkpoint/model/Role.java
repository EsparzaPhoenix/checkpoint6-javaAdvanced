package br.com.fiap.checkpoint.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity @Table(name = "CP_JV_ROLE")
@Getter @Setter
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id_role")
    private Long id;

    @Column(name = "nm_role", nullable = false, unique = true)
    private String name;

    @Column(name = "ds_label", nullable = false)
    private String label;

}
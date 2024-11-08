package br.com.fiap.checkpoint.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "CP_JV_USUARIO")
@Getter @Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "ds_username", nullable = false, unique = true)
    private String username;

    @Column(name="ds_password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CP_JV_USUARIO_ROLE", joinColumns = @JoinColumn(name="id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Matricula> matriculas;

    public Usuario(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}

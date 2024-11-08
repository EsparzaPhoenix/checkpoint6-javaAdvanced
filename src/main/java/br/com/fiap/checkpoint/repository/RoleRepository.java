package br.com.fiap.checkpoint.repository;

import br.com.fiap.checkpoint.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}

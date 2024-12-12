package EjercicioPractico2_EliasViquez.demo.dao;

import EjercicioPractico2_EliasViquez.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrEmail(String username, String email);

    boolean existsByUsernameOrEmail(String username, String email);
}


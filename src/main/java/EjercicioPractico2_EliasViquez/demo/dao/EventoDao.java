package EjercicioPractico2_EliasViquez.demo.dao;

import EjercicioPractico2_EliasViquez.demo.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoDao extends JpaRepository <Evento,Long> {
    
}
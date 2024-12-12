package EjercicioPractico2_EliasViquez.demo.dao;

import EjercicioPractico2_EliasViquez.demo.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository <Reserva,Long> {
    
}
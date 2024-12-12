package EjercicioPractico2_EliasViquez.demo.service;

import EjercicioPractico2_EliasViquez.demo.domain.Reserva;
import java.util.List;

public interface ReservaService {
    
    // Se obtiene un listado de products en un List
    public List<Reserva> getReservas(boolean activos);
    
    // Get a Category, based on the ID of a category
    public Reserva getReserva(Reserva product);

    // Insert a new category if the category ID is empty
    // Update a category if the category ID is NOT empty
    public void save(Reserva product);

    // Delete the category that has the ID passed as a parameter
    public void delete(Reserva product);
 
}
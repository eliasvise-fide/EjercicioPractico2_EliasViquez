package EjercicioPractico2_EliasViquez.demo.service;

import EjercicioPractico2_EliasViquez.demo.domain.Evento;
import java.util.List;

public interface EventoService {
    
    // Se obtiene un listado de categorias en un List
    public List<Evento> getEventos(boolean activos);
    
    // Get a Category, based on the ID of a category
    public Evento getEvento(Evento categoria);

    // Insert a new category if the category ID is empty
    // Update a category if the category ID is NOT empty
    public void save(Evento categoria);

    // Delete the category that has the ID passed as a parameter
    public void delete(Evento categoria);
 
}
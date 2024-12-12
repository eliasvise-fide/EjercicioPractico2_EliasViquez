package EjercicioPractico2_EliasViquez.demo.service.impl;

import EjercicioPractico2_EliasViquez.demo.domain.Evento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import EjercicioPractico2_EliasViquez.demo.dao.EventoDao;
import EjercicioPractico2_EliasViquez.demo.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoDao eventoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> getEventos(boolean activos) {
        var lista = eventoDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Evento getEvento(Evento evento) {
        return eventoDao.findById(evento.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Evento evento) {
        eventoDao.save(evento);
    }

    @Override
    @Transactional
    public void delete(Evento evento) {
        eventoDao.delete(evento);
    }
}

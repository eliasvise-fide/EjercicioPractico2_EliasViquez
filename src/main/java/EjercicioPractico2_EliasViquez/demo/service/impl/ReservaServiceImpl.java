package EjercicioPractico2_EliasViquez.demo.service.impl;

import EjercicioPractico2_EliasViquez.demo.domain.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import EjercicioPractico2_EliasViquez.demo.dao.ReservaDao;
import EjercicioPractico2_EliasViquez.demo.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservas(boolean activos) {
        var lista = productDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva getReserva(Reserva product) {
        return productDao.findById(product.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reserva product) {
        productDao.save(product);
    }

    @Override
    @Transactional
    public void delete(Reserva product) {
        productDao.delete(product);
    }
}

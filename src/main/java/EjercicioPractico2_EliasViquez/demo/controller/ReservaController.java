package EjercicioPractico2_EliasViquez.demo.controller;

import org.springframework.ui.Model;
import EjercicioPractico2_EliasViquez.demo.domain.Reserva;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import EjercicioPractico2_EliasViquez.demo.service.ReservaService;

@Controller
@Slf4j
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var reservas = reservaService.getReservas(false);
        for (Reserva prod : reservas) {
            System.out.println("ID: " + prod.getId()
                    + ", Evento Id: " + prod.getEvento_id());
        }
        model.addAttribute("reservas", reservas);
        model.addAttribute("totalReservas", reservas.size());
        return "/reserva/listado";
    }

    @GetMapping("/nuevo")
    public String reservaNuevo(Reserva reserva) {
        return "/reserva/modifica";
    }

    @PostMapping("/guardar")
    public String reservaGuardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String reservaEliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{id}")
    public String reservaModificar(Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);
        model.addAttribute("reserva", reserva);
        return "/reserva/modifica";
    }
}

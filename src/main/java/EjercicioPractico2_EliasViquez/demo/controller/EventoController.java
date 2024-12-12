package EjercicioPractico2_EliasViquez.demo.controller;

import org.springframework.ui.Model;
import EjercicioPractico2_EliasViquez.demo.domain.Evento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import EjercicioPractico2_EliasViquez.demo.service.EventoService;

@Controller
@Slf4j
@RequestMapping("/Evento")
public class EventoController {

    @Autowired
    private EventoService EventoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        System.out.println("inicio() method called");
        var Eventos = EventoService.getEventos(false);
        log.info("Categories fetched: {}", Eventos);
        for (Evento Evento : Eventos) {
            System.out.println("ID: " + Evento.getId()
                    + ", Nombre: " + Evento.getNombre()
                    + ", Description: " + Evento.getDescripcion()
                    + ", Tipo: " + Evento.getTipo()
                    + ", Fecha Inicio: " + Evento.getFecha_inicio()
                    + ", Fecha Fin: " + Evento.getFecha_fin()
                    + ", Fecha Inicio: " + Evento.getCapacidad()
                    );
        }
        model.addAttribute("Eventos", Eventos);
        model.addAttribute("totalEventos", Eventos.size());
        return "/Evento/listado";
    }

    @GetMapping("/nuevo")
    public String EventoNuevo(Evento Evento) {
        return "/Evento/modifica";
    }

    @PostMapping("/guardar")
    public String EventoGuardar(Evento Evento) {
        EventoService.save(Evento);
        return "redirect:/Evento/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String EventoEliminar(Evento Evento) {
        EventoService.delete(Evento);
        return "redirect:/Evento/listado";
    }

    @GetMapping("/modificar/{id}")
    public String EventoModificar(Evento Evento, Model model) {
        Evento = EventoService.getEvento(Evento);
        model.addAttribute("Evento", Evento);
        return "/Evento/modifica";
    }

}

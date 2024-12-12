package EjercicioPractico2_EliasViquez.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
    @Table(name="reservas")
public class Reserva implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    private int usuario_id;
    private int evento_id;
    private double price;
    private Date fecha_reserva;
    

    public Reserva() {
    }

    public Reserva(Long id, int usuario_id, int evento_id, double price, Date fecha_reserva) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.evento_id = evento_id;
        this.price = price;
        this.fecha_reserva = fecha_reserva;
    }

    
}
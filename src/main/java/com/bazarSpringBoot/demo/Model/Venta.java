package com.bazarSpringBoot.demo.Model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Britos
 */
@Getter @Setter
@Entity
public class Venta {
      @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    @OneToMany
    private List<Producto> listaProductos;
    @OneToOne
    private Cliente unCliente;

}

package com.bazarSpringBoot.demo.Model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @ManyToMany
    private List<Producto> listaProductos;
    
    @JoinTable(
            name = "venta_producto", 
            joinColumns = @JoinColumn (name = "codigo_venta", nullable = false),
            inverseJoinColumns = @JoinColumn (name = "codigo_producto", nullable = false)
        )
    
    @OneToOne
    private Cliente unCliente;

    
    
    public Venta() {
    }
    
    
    

}

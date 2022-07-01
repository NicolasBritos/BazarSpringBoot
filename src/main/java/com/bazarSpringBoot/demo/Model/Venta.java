package com.bazarSpringBoot.demo.Model;

import java.io.Serializable;
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
public class Venta implements Serializable {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta = LocalDate.now();
    private Double total = 0.0;
    @ManyToMany
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn (name = "codigo_venta", nullable = false),
            inverseJoinColumns = @JoinColumn (name = "codigo_producto", nullable = false)
    )
    private List<Producto> listaProductos;
    
    @OneToOne
    @JoinColumn (name= "unCliente_id", referencedColumnName="id_cliente")
    private Cliente unCliente;
    
    public Venta() {
    }

    public Venta(Long codigo_venta, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
    
    
    
    
}

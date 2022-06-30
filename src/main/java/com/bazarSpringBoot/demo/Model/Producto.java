package com.bazarSpringBoot.demo.Model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;




/**
 *
 * @author Britos
 */
@Getter @Setter
@Entity
public class Producto implements Serializable {
    @Id
     
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;

    public Producto() {
    }
    
    

}

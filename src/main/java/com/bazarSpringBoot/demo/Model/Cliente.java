package com.bazarSpringBoot.demo.Model;

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
public class Cliente {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;
    private Boolean borrado= false;
    private String descripcion_estado = "Cliente activo";
    
    public Cliente() {
    }
    
    public Cliente(Long id_cliente, String nombre, String apellido, String dni, Boolean borrado, String descripcion_estado) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.borrado = borrado;
        this.descripcion_estado= descripcion_estado;
    }
    
    
    
    
}

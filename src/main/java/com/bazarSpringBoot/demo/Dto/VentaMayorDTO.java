package com.bazarSpringBoot.demo.Dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Britos
 */
@Getter @Setter
public class VentaMayorDTO implements Serializable{
    private Long codigo_venta;
    private Double cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;
    private Double monto;
    
    public VentaMayorDTO(Long codigo_venta, Double cantidad_productos, String nombre_cliente, String apellido_cliente, Double monto) {
        this.codigo_venta = codigo_venta;
        this.cantidad_productos = cantidad_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.monto = monto;
        
    }
    
    public VentaMayorDTO() {
    }
    
    
    
    
    
    
}

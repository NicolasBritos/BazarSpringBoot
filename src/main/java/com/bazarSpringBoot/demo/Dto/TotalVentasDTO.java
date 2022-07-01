package com.bazarSpringBoot.demo.Dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Britos
 */
@Getter @Setter
public class TotalVentasDTO implements Serializable{
    
    private LocalDate fecha;
    private Double montoTotal = 0.0;
    private int cantidadVentas = 0;
    
    public TotalVentasDTO() {
    }
    
    public TotalVentasDTO(LocalDate fecha, Double montoTotal, int cantidadVentas) {
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.cantidadVentas = cantidadVentas;
    }
    
    
}

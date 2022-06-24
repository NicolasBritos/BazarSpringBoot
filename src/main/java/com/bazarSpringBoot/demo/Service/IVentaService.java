package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Model.Cliente;
import com.bazarSpringBoot.demo.Model.Producto;
import com.bazarSpringBoot.demo.Model.Venta;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Britos
 */
public interface IVentaService {
         
    public List <Venta> getVentas();
    
    public void saveVenta (Venta venta);
    
    public void deleteVenta (Long id);
    
    public Venta findVenta (Long id);
    
    public void editVenta (Long codigo_venta, Long nuevoCodigo, LocalDate nuevaFecha, Double nuevoTotal, List<Producto> nuevaListaProductos, Cliente nuevoCliente);
    
}

    



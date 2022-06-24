package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Model.Cliente;
import com.bazarSpringBoot.demo.Model.Producto;
import com.bazarSpringBoot.demo.Model.Venta;
import com.bazarSpringBoot.demo.Repository.VentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Britos
 */
@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> getVentas() {
        
        List <Venta> ventas = ventaRepository.findAll();
        
        return ventas;        
        
    }

    @Override
    public void saveVenta(Venta venta) {
        
        ventaRepository.save(venta);
        
    }

    @Override
    public void deleteVenta(Long id) {
        
        ventaRepository.deleteById(id);
        
    }

    @Override
    public Venta findVenta(Long id) {
    
    Venta venta = ventaRepository.findById(id).orElse(null);
    
    return venta;
        
    }

    @Override
    public void editVenta(Long codigo_venta, Long nuevoCodigo, LocalDate nuevaFecha, Double nuevoTotal, List<Producto> nuevaListaProductos, Cliente nuevoCliente) {
      Venta venta =  this.findVenta(codigo_venta);
       venta.setCodigo_venta(nuevoCodigo);
       venta.setFecha_venta(nuevaFecha);
       venta.setTotal(nuevoTotal);
       venta.setListaProductos(nuevaListaProductos);
       venta.setUnCliente(nuevoCliente);
       
       this.saveVenta(venta);
        
        
        
    }
    
    
    
    
}

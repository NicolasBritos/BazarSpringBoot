package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Dto.TotalVentasDTO;
import com.bazarSpringBoot.demo.Dto.VentaMayorDTO;
import com.bazarSpringBoot.demo.Model.Cliente;
import com.bazarSpringBoot.demo.Model.Producto;
import com.bazarSpringBoot.demo.Model.Venta;
import com.bazarSpringBoot.demo.Repository.VentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
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
    
    @Autowired
    private IProductoService productoService;
    
    @Override
    public List<Venta> getVentas() {
        
        List <Venta> ventas = ventaRepository.findAll();
        
        return ventas;
    }
    
    @Override
    public void saveVenta(Venta venta) {
        venta.setTotal(0.0);
        for ( Producto prod : venta.getListaProductos()){                                     /*recorre la lista (que es un string del JSON) para calcular el total.*/
            Producto aux  = productoService.findProducto(prod.getCodigo_producto());      /*Obtiene cada producto mediante los ids del List invocando a productService.*/
            venta.setTotal(venta.getTotal() + aux.getCosto());                               /*Setea el total sumando el costo de cada producto. */
        }
        /* Fin cálculo del total de la venta. */
        
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
    public void editVenta(Long codigo_venta, Long nuevoCodigo, LocalDate nuevaFecha, List<Producto> nuevaListaProductos, Cliente nuevoCliente) {
        Venta venta =  this.findVenta(codigo_venta);
        if (nuevoCodigo != null){
            venta.setCodigo_venta(nuevoCodigo);
        }
        if (nuevaFecha != null){
            venta.setFecha_venta(nuevaFecha);
        }
         if (nuevaListaProductos != null ){
            venta.setListaProductos(nuevaListaProductos);
        }
        if (nuevoCliente != null){
            venta.setUnCliente(nuevoCliente);
        }
        
        this.saveVenta(venta);
        
        
        
    }
    
    @Override
    public List<Producto> productosVenta(Long id) {
        Venta venta = this.findVenta(id);
        List <Producto> lista = venta.getListaProductos();
        return lista;
    }
    
    @Override
    public TotalVentasDTO ventasDiarias(String fecha) {
        List <Venta> ventas = this.getVentas();
        LocalDate fechaParseada;
        TotalVentasDTO totalVentas = new TotalVentasDTO();                    /*Instancia un objeto DTO.*/
        fechaParseada = LocalDate.parse(fecha);                                        /*Convierte el String Fecha en LocalDate.*/
        totalVentas.setFecha(fechaParseada);                                             /*Setea la fecha en el DTO.*/
        for (Venta venta : ventas){
            if (venta.getFecha_venta().isEqual(fechaParseada)){
                totalVentas.setMontoTotal(totalVentas.getMontoTotal() + venta.getTotal());                    /*Suma los montos de las ventas realizadas que coinciden con la fecha.*/
                totalVentas.setCantidadVentas(totalVentas.getCantidadVentas() + 1);                            /* Suma la cantidad de ventas realizadas en la fecha.*/
            }
            
        }
        return totalVentas;
        
    }
    
    @Override
    public VentaMayorDTO ventaMayor() {
        Venta aux = new Venta();
        VentaMayorDTO ventaMayorDTO = new VentaMayorDTO();
        List<Venta> ventas = this.getVentas();
        Double total = ventas.get(0).getTotal();       /*se obtiene el total de la primer venta de la lista */
        for (Venta venta : ventas) {
            if (venta.getTotal() >= total) {
                total = venta.getTotal();                      /*Si el total de alguna venta es mayor, se reemplaza en la variable.*/
                aux = venta;                                       /*Tambien se almacena el objeto de la venta a la que pertenece el total mayor.*/
            }
        }
        ventaMayorDTO.setCodigo_venta(aux.getCodigo_venta());
        ventaMayorDTO.setMonto(aux.getTotal());
        total = cantidadProductos(aux);                 /*Se utiliza el método cantidadProductos para recorrer la lista de productos y realizar el conteo*/
        ventaMayorDTO.setCantidad_productos(total);
        ventaMayorDTO.setApellido_cliente(aux.getUnCliente().getApellido());
        ventaMayorDTO.setNombre_cliente(aux.getUnCliente().getNombre());
        
        
        return ventaMayorDTO;
        
    }
    
    
    public Double cantidadProductos(Venta venta){
        List <Producto>  listaProductos = venta.getListaProductos();
        Double cantidad = 0.0;
        for (Producto listaProducto : listaProductos) {
            cantidad= cantidad + 1;
        }
        return cantidad;
    }

    @Override
    public void agregarUnProducto(Long id, Producto unProducto) {
        
        Venta venta = this.findVenta(id);                                                           /*Método que añade a la lista de productos de la venta obtenida por id un producto y hace el update mediante saveVenta*/
        List <Producto> listaProductos = venta.getListaProductos();
        listaProductos.add(unProducto);
        venta.setListaProductos(listaProductos);
        this.saveVenta(venta);
                
    }
    
    
    
    
    
    
}

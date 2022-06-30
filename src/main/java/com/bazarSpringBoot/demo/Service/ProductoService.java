package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Model.Producto;
import com.bazarSpringBoot.demo.Model.Venta;
import com.bazarSpringBoot.demo.Repository.ProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Britos
 */
@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    public List<Producto> getProductos() {
        
        List <Producto> productos = productoRepository.findAll();
        
        return productos;
    }

    @Override
    public void saveProducto(Producto producto) {
    
        productoRepository.save(producto);
        
    }

    @Override
    public void deleteProducto(Long id) {
       
    productoRepository.deleteById(id);
    
        
    }

    @Override
    public Producto findProducto(Long id) {
    
    Producto producto = productoRepository.findById(id).orElse(null);
    
    return producto;
    
    }

    @Override
    public void editProducto(Long codigo_producto, Long nuevoCodigo, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double nuevaCantidad) {
        Producto producto = this.findProducto(codigo_producto);
        if (nuevoCodigo != null){
        producto.setCodigo_producto(nuevoCodigo);                  // Se controla que los parámetros no estén vacíos para seterlos, de lo contrario, se mantienen.
        }
        if (nuevoNombre != null){
        producto.setNombre(nuevoNombre);
        }
        if (nuevaMarca != null){
        producto.setMarca(nuevaMarca);
        }
        if (nuevoCosto != null){
        producto.setCosto(nuevoCosto);
        }
        if (nuevaCantidad != null){
        producto.setCantidad_disponible(nuevaCantidad);
        }                     
        this.saveProducto(producto);
    }
    
    

    @Override
    public List<Producto> getLowStock() {
        List<Producto> lista = this.getProductos();
        List<Producto> low = new ArrayList();
        for (Producto prod : lista){
        if (prod.getCantidad_disponible() < 5){
          low.add(prod);                                           // Arma una nueva lista con los productos que tengan menos de 5 unidades.
          }
           
        }       
               return low;
}
    
    

}

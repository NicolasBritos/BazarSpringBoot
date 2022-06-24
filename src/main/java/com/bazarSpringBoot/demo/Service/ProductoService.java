package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Model.Producto;
import com.bazarSpringBoot.demo.Repository.ProductoRepository;
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
        producto.setCodigo_producto(nuevoCodigo);
        producto.setNombre(nuevoNombre);
        producto.setMarca(nuevaMarca);
        producto.setCosto(nuevoCosto);
        producto.setCantidad_disponible(nuevaCantidad);
                     
        this.saveProducto(producto);
    }
}

package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Model.Producto;
import java.util.List;

/**
 *
 * @author Britos
 */
public interface IProductoService {
    
      
    public List <Producto> getProductos();
    
    public void saveProducto (Producto producto);
    
    public void deleteProducto (Long id);
    
    public Producto findProducto (Long id);
    
    public void editProducto ( Long codigo_producto, Long nuevoCodigo, String nuevoNombre, String nuevaMarca, Double nuevoCosto,  Double nuevaCantidad, Boolean borrado);
    
    public List <Producto> getLowStock ();

}

    


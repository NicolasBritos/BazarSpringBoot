package com.bazarSpringBoot.demo.Controller;

import com.bazarSpringBoot.demo.Model.Producto;
import com.bazarSpringBoot.demo.Service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Britos
 */

@RestController
@RequestMapping ("/producto")
public class ProductoController {
    
    
        @Autowired
    private IProductoService iProducto;

    @PostMapping("/crear")
    public String createProducto(@RequestBody Producto producto) {

        iProducto.saveProducto(producto);

        return "Producto creado correctamente";

    }

    @GetMapping("/listar")
    public List<Producto> listProducto() {

        return iProducto.getProductos();

    }

    @GetMapping("/buscar")
    public Producto findProducto(@RequestParam Long codigo_producto) {

        return iProducto.findProducto(codigo_producto);

    }

    @DeleteMapping("/eliminar")
    public String deleteProducto(Long codigo_producto) {

        iProducto.deleteProducto(codigo_producto);
        
        return "Producto eliminado correctamente";

    }

    @PutMapping("editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
            @RequestParam(required = false) Long nuevoCodigo,
            @RequestParam(required = false) String nuevoNombre,
            @RequestParam(required = false) String nuevaMarca,
            @RequestParam(required = false) Double nuevoCosto,
            @RequestParam(required = false) Boolean nuevoBorrado,
            @RequestParam(required = false) Double nuevaCantidad)
    {

         iProducto.editProducto(codigo_producto, nuevoCodigo, nuevoNombre,nuevaMarca, nuevoCosto, nuevaCantidad, nuevoBorrado);

        Producto producto = iProducto.findProducto(codigo_producto);

        return producto;
    }
    
    
    @GetMapping ("/listar-bajo-stock")
     public List <Producto> listarBajoStock(){
       
       return iProducto.getLowStock();
        
    }
     
    
}

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
    public Producto findProducto(Long codigo_producto) {

        return iProducto.findProducto(codigo_producto);

    }

    @DeleteMapping("/eliminar")
    public String deleteProducto(Long codigo_producto) {

        iProducto.deleteProducto(codigo_producto);

        return "Producto eliminado correctamente";

    }

    @PutMapping("/editar/{codigo_producto_original}")
    public Producto editProducto(@PathVariable Long codigo_producto_original,
            @RequestParam(required = false, name = "nuevo_codigo_producto") Long nuevoCodigo,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
             @RequestParam(required = false, name = "marca") String nuevaMarca,
               @RequestParam(required = false, name = "costo") Double nuevoCosto,
            @RequestParam(required = false, name = "cantidad") Double nuevaCantidad)
    {

         iProducto.editProducto(codigo_producto_original, nuevoCodigo, nuevoNombre,nuevaMarca, nuevoCosto, nuevaCantidad);

        Producto producto = iProducto.findProducto(codigo_producto_original);

        return producto;
    }
    
}

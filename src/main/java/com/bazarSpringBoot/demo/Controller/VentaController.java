package com.bazarSpringBoot.demo.Controller;

import com.bazarSpringBoot.demo.Dto.TotalVentasDTO;
import com.bazarSpringBoot.demo.Dto.VentaMayorDTO;
import com.bazarSpringBoot.demo.Model.Cliente;
import com.bazarSpringBoot.demo.Model.Producto;
import com.bazarSpringBoot.demo.Model.Venta;
import com.bazarSpringBoot.demo.Service.IVentaService;
import java.time.LocalDate;
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
@RequestMapping ("/venta")
public class VentaController {
    
            @Autowired
    private IVentaService iVenta;

    @PostMapping("/crear")
    public String createVenta(@RequestBody Venta venta) {
      
        iVenta.saveVenta(venta);
                
        return "Venta creado correctamente";

    }

    @GetMapping("/listar")
    public List<Venta> listVenta() {

        return iVenta.getVentas();

    }

    @GetMapping("/buscar")
    public Venta findVenta(@RequestParam Long codigo_venta) {

        return iVenta.findVenta(codigo_venta);

    }

    @DeleteMapping("/eliminar")
    public String deleteVenta(Long codigo_venta) {

        iVenta.deleteVenta(codigo_venta);

        return "Venta eliminado correctamente";

    }

    @PutMapping("/editar/{codigo_venta_original}")
    public Venta editVenta(@PathVariable Long codigo_venta_original,
            @RequestParam(required = false) Long nuevoCodigo,
            @RequestParam(required = false) LocalDate nuevaFecha,
            @RequestParam(required = false) Double nuevoTotal,
            @RequestParam(required = false) List<Producto>  nuevaLista,
            @RequestParam(required = false) Cliente nuevoCliente)
    {

         iVenta.editVenta(codigo_venta_original, nuevoCodigo, nuevaFecha, nuevoTotal, nuevaLista, nuevoCliente);

        Venta venta = iVenta.findVenta(codigo_venta_original);

        return venta;
    }
    
    @GetMapping ("/productos-venta")
    public List <Producto> productosVenta (@RequestParam Long codigo_venta){
        
        return iVenta.productosVenta(codigo_venta);
                
    }
    
   
    @GetMapping ("/ventas-diarias")
    public TotalVentasDTO ventasDiarias (@RequestParam String fecha){
                       
        return iVenta.ventasDiarias(fecha);
        
    }
    
    
    @GetMapping ("/venta-mayor")
    
    public VentaMayorDTO ventaMayor (){
        
        return iVenta.ventaMayor();
        
    }
    
    
    
    
}

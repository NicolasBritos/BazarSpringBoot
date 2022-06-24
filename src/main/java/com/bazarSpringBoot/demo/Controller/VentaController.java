package com.bazarSpringBoot.demo.Controller;

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
    public Venta findVenta(Long codigo_venta) {

        return iVenta.findVenta(codigo_venta);

    }

    @DeleteMapping("/eliminar")
    public String deleteVenta(Long codigo_venta) {

        iVenta.deleteVenta(codigo_venta);

        return "Venta eliminado correctamente";

    }

    @PutMapping("/editar/{codigo_venta_original}")
    public Venta editVenta(@PathVariable Long codigo_venta_original,
            @RequestParam(required = false, name = "nuevo_codigo_venta") Long nuevoCodigo,
            @RequestParam(required = false, name = "fecha") LocalDate nuevaFecha,
            @RequestParam(required = false, name = "total") Double nuevoTotal,
            @RequestParam(required = false, name = "lista") List<Producto>  nuevaLista,
            @RequestParam(required = false, name = "cliente") Cliente nuevoCliente)
    {

         iVenta.editVenta(codigo_venta_original, nuevoCodigo, nuevaFecha, nuevoTotal, nuevaLista, nuevoCliente);

        Venta venta = iVenta.findVenta(codigo_venta_original);

        return venta;
    }
    
    
    
}

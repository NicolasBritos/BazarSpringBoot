package com.bazarSpringBoot.demo.Controller;

import com.bazarSpringBoot.demo.Model.Cliente;
import com.bazarSpringBoot.demo.Service.IClienteService;
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

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService iCliente;

    @PostMapping("/crear")
    public String createCliente(@RequestBody Cliente cliente) {

        iCliente.saveCliente(cliente);

        return "Cliente creado correctamente";

    }

    @GetMapping("/listar")
    public List<Cliente> listCliente() {

        return iCliente.getClientes();

    }

    @GetMapping("/buscar")
    public Cliente findCliente(Long id) {

        return iCliente.findCliente(id);

    }

    @DeleteMapping("/eliminar")
    public String deleteCliente(Long id) {

        iCliente.deleteCliente(id);

        return "Cliente eliminado correctamente";

    }

    @PutMapping("/editar/{id_original}")
    public Cliente editCliente(@PathVariable Long id_original,
            @RequestParam(required = false, name = "nuevo_id") Long nuevoId,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "dni") String nuevoDni) {

         iCliente.editCliente(id_original, nuevoId, nuevoNombre, nuevoApellido, nuevoDni);

        Cliente cliente = iCliente.findCliente(id_original);

        return cliente;
    }

}

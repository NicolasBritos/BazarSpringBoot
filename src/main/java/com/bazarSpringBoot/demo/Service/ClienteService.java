package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Model.Cliente;
import com.bazarSpringBoot.demo.Repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Britos
 */
@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public List<Cliente> getClientes() {
        
     List <Cliente> clientes = clienteRepository.findAll();
        List <Cliente> aux = new ArrayList();
        for ( Cliente cli : clientes){                                                 /*Utiliza una lista auxiliar para seleccionar  solo los productos que no fueron eliminados*/
            if (cli.getBorrado() == false){
                aux.add(cli);
            }
        }
        
        return aux;     
      
    }

    @Override
    public void saveCliente(Cliente cliente) {
        
        clienteRepository.save(cliente);
        
          }

    @Override
    public void deleteCliente(Long id) {
        
   Cliente cliente = this.findCliente(id);
    cliente.setBorrado(Boolean.TRUE);
    cliente.setDescripcion_estado("Cliente inactivo/eliminado");
      this.saveCliente(cliente);
                         
    }

    @Override
    public Cliente findCliente(Long id) {
      Cliente cliente = clienteRepository.findById(id).orElse(null);
                   
        return cliente;
        
    }
    
    @Override
    public void editCliente(Long id_cliente, Long nuevoId, String nuevoNombre, String nuevoApellido, String nuevoDni, Boolean nuevoBorrado) {
        
        Cliente cliente =  this.findCliente(id_cliente);
        if (nuevoId != null){                                        // Se controla que los parámetros no sean null para setearlos, de lo contrario se mantiene.
            cliente.setId_cliente(nuevoId);
        }
        if (nuevoApellido != null){
            cliente.setApellido(nuevoApellido);
        }
        if (nuevoNombre != null){
            cliente.setNombre(nuevoNombre);
        }
        if (nuevoDni != null){
            cliente.setDni(nuevoDni);
        }
        if (nuevoBorrado!=null){
            cliente.setBorrado(nuevoBorrado);
        }
        if (nuevoBorrado == false){
            cliente.setDescripcion_estado("Cliente activo");
        }else if (nuevoBorrado == true){
            cliente.setDescripcion_estado("Cliente inactivo/eliminado");
        }
          
        this.saveCliente(cliente);
    }
    
    @Override
    public List<Cliente> getClientesBorrados() {
        
        List <Cliente> clientes = clienteRepository.findAll();
        List <Cliente> aux = new ArrayList();
        for ( Cliente cli : clientes){                                                 /*Utiliza una lista auxiliar para seleccionar  solo los productos eliminados*/
            if (cli.getBorrado() == true){
                aux.add(cli);
            }
        }
        
        return aux;
        
        
    }
    
    
}
    


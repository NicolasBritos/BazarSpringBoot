package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Model.Cliente;
import com.bazarSpringBoot.demo.Model.Venta;
import com.bazarSpringBoot.demo.Repository.ClienteRepository;
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
    
    @Autowired
    private IVentaService iVentaService;

    @Override
    public List<Cliente> getClientes() {
        
        List<Cliente>  listaClientes = clienteRepository.findAll();
        return listaClientes;       
      
    }

    @Override
    public void saveCliente(Cliente cliente) {
        
        clienteRepository.save(cliente);
        
          }

    @Override
    public void deleteCliente(Long id) {
        
   Cliente cliente = this.findCliente(id);
    cliente.setBorrado(Boolean.TRUE);
      this.saveCliente(cliente);
       
        /*
        List <Venta> ventas = iVentaService.getVentas();
        for ( Venta venta : ventas){
            if (venta.getUnCliente().getId_cliente() == id){                                  //Recorre las Ventas y elimina la correspondiente al Cliente.
                iVentaService.deleteVenta(venta.getCodigo_venta());       
            }
        }
      clienteRepository.deleteById(id);
              */
             
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
       this.saveCliente(cliente);
    }
    
}

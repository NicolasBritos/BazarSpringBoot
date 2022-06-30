package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Model.Cliente;
import java.util.List;

/**
 *
 * @author Britos
 */
public interface IClienteService {
    
    public List <Cliente> getClientes();
    
    public void saveCliente (Cliente cliente);
    
    public void deleteCliente (Long id);
    
    public Cliente findCliente (Long id);
    
   public void editCliente (Long id_cliente, Long nuevoId, String nuevoNombre, String nuevoApellido, String nuevoDni, Boolean borrado);
    
    
}

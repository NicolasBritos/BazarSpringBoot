package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Repository.ClienteRepository;
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
}

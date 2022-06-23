package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Britos
 */
@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private VentaRepository ventaRepository;
    
}

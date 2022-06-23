package com.bazarSpringBoot.demo.Service;

import com.bazarSpringBoot.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Britos
 */
@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
}

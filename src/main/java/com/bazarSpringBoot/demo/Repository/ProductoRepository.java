package com.bazarSpringBoot.demo.Repository;

import com.bazarSpringBoot.demo.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Britos
 */
@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {
    
}

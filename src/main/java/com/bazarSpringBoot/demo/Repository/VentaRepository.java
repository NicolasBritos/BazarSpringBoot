package com.bazarSpringBoot.demo.Repository;

import com.bazarSpringBoot.demo.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Britos
 */
@Repository
public interface VentaRepository extends JpaRepository <Venta, Long> {
    
}

package com.bazarSpringBoot.demo.Repository;

import com.bazarSpringBoot.demo.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Britos
 */
@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
    
}

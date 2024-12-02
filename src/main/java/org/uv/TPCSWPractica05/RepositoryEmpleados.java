
package org.uv.TPCSWPractica05;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryEmpleados extends JpaRepository<Empleado, Long> {
    
}
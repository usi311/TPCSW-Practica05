/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.TPCSWPractica05;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author roberto
 */
@RestController
@RequestMapping("/api/empleados")
public class ControllerEmpleados {
    
    @Autowired
    private RepositoryEmpleados repositoryEmpleados;
    
    @GetMapping()
    public List<Empleado> list() {
        return repositoryEmpleados.findAll();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Optional<Empleado> res = repositoryEmpleados.findById(Long.valueOf(id));
        return res.get();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> put(@PathVariable String id, @RequestBody Empleado input) {
          Optional<Empleado> res = repositoryEmpleados.findById(Long.valueOf(id));
        if (res.isPresent()) {
            Empleado empleadoExistente = res.get();
            empleadoExistente.setNombre(input.getNombre());
            empleadoExistente.setTelefono(input.getTelefono());
            empleadoExistente.setDireccion(input.getDireccion());
            empleadoExistente.setDepto(input.getDepto());
            Empleado updatedEmpleado = repositoryEmpleados.save(empleadoExistente);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
        Empleado empRes = repositoryEmpleados.save(empleado);
        return new ResponseEntity<Empleado>(empRes,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Empleado> res = repositoryEmpleados.findById(Long.valueOf(id));
        if (res.isPresent()) {
            repositoryEmpleados.deleteById(Long.valueOf(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
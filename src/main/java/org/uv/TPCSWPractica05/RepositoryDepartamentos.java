/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package org.uv.TPCSWPractica05;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryDepartamentos extends JpaRepository<Departamento, Long> {
    
}
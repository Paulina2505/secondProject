/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.secondProject.repository;
import modelo.secondProject.builder.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Paulina
 */

@Repository
public interface DirRepository extends JpaRepository <Constructor, Long>{

    public Constructor save(Constructor directorio);
    
}

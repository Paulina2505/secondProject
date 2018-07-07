/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.secondProject.controller;

import modelo.secondProject.exception.ResourceNotFoundException;
import modelo.secondProject.builder.Constructor;
import modelo.secondProject.repository.DirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controlador {
    
    @Autowired
    DirRepository conRepository;
    DirRepository corRepository;
    DirRepository telRepository;
    
    // Get All Contacts
    @GetMapping("/contacto")
    public List<Constructor> getAllCon() {
        return conRepository.findAll();
    }
    
    // Get All Mails
    @GetMapping("/correo")
    public List<Constructor> getAllCor() {
        return corRepository.findAll();
    }

    // Get All Phones
    @GetMapping("/telefono")
    public List<Constructor> getAllTel() {
        return telRepository.findAll();
    }
    
    // Create a new Contact
    @PostMapping("/contact")
    public Constructor createCon(@Valid @RequestBody Constructor contacto) {
        return conRepository.save(contacto);
    }
    
    // Create a new Mail
    @PostMapping("/correo")
    public Constructor createCor(@Valid @RequestBody Constructor correo) {
        return corRepository.save(correo);
    }

    // Create a new Phone
    @PostMapping("/telefono")
    public Constructor createTel(@Valid @RequestBody Constructor telefono) {
        return telRepository.save(telefono);
    }
    
    // Get a Single Contact
    @GetMapping("/contacto/{cve_con}")
    public Constructor getConById(@PathVariable(value = "cve_con") Long conCve_con) {
        return conRepository.findById(conCve_con)
            .orElseThrow(() -> new ResourceNotFoundException("Dir", "contacto", conCve_con));
    }
    
    // Get a Single Mail
    @GetMapping("/correo/{cve_cor}")
    public Constructor getCorById(@PathVariable(value = "cve_cor") Long corCve_cor) {
        return corRepository.findById(corCve_cor)
            .orElseThrow(() -> new ResourceNotFoundException("Dir", "correo", corCve_cor));
    }

    // Get a Single Phone
    @GetMapping("/telefono/{cve_tel}")
    public Constructor getTelById(@PathVariable(value = "cve_tel") Long telCve_tel) {
        return telRepository.findById(telCve_tel)
            .orElseThrow(() -> new ResourceNotFoundException("Dir", "telefono", telCve_tel));
    }

    // Update a Contact
    @PutMapping("/contacto/{cve_con}")
    public Constructor updateContacto(@PathVariable(value = "cve_con") Long conCve_con,
                                        @Valid @RequestBody Constructor contactoDetails) {

        Constructor contacto = conRepository.findById(conCve_con)
            .orElseThrow(() -> new ResourceNotFoundException("Dir", "cve_con", conCve_con));

        contacto.setNom_con(contactoDetails.getNom_con());
        contacto.setAp_con(contactoDetails.getAp_con());
        contacto.setAm_con(contactoDetails.getAm_con());
        contacto.setFechanac_con(contactoDetails.getFechanac_con());

        Constructor updatedContacto = conRepository.save(contacto);
        return updatedContacto;
}

    // Update a Mail
    @PutMapping("/correo/{cve_cor}")
    public Constructor updateCorreo(@PathVariable(value = "cve_cor") Long corCve_cor,
                                        @Valid @RequestBody Constructor correoDetails) {

        Constructor correo = corRepository.findById(corCve_cor)
            .orElseThrow(() -> new ResourceNotFoundException("Dir", "corCve_cor", corCve_cor));

        correo.setNom_cor(correoDetails.getNom_cor());
        correo.setTip_cor(correoDetails.getTip_cor());
        correo.setCve_con(correoDetails.getCve_con());

        Constructor updatedCorreo = corRepository.save(correo);
        return updatedCorreo;
}
    // Update a Phone
    @PutMapping("/telefono/{cve_tel}")
    public Constructor updateTelefono(@PathVariable(value = "cve_tel") Long telCve_tel,
                                        @Valid @RequestBody Constructor telefonoDetails) {

        Constructor telefono = telRepository.findById(telCve_tel)
            .orElseThrow(() -> new ResourceNotFoundException("Dir", "telCve_tel", telCve_tel));

        telefono.setNom_tel(telefonoDetails.getNom_tel());
        telefono.setTip_tel(telefonoDetails.getTip_tel());
        telefono.setCve_tel(telefonoDetails.getCve_tel());

        Constructor updatedTelefono = telRepository.save(telefono);
        return updatedTelefono;
}
    // Delete a Contact
    @DeleteMapping("/contacto/{cve_con}")
    public ResponseEntity<?> deleteContacto(@PathVariable(value = "cve_con") Long conCve_con) {
        Constructor contacto = conRepository.findById(conCve_con)
            .orElseThrow(() -> new ResourceNotFoundException("contacto", "cve_con", conCve_con));

        conRepository.delete(contacto);

        return ResponseEntity.ok().build();
    }
    
    // Delete a Mail
    @DeleteMapping("/correo/{cve_cor}")
    public ResponseEntity<?> deleteCorreo(@PathVariable(value = "cve_cor") Long corCve_cor) {
        Constructor correo = corRepository.findById(corCve_cor)
            .orElseThrow(() -> new ResourceNotFoundException("correo", "cve_cor", corCve_cor));

        corRepository.delete(correo);

        return ResponseEntity.ok().build();
    }
    // Delete a Phone
    @DeleteMapping("/telefono/{cve_tel}")
    public ResponseEntity<?> deleteTelefono(@PathVariable(value = "cve_tel") Long telCve_tel) {
        Constructor telefono = telRepository.findById(telCve_tel)
            .orElseThrow(() -> new ResourceNotFoundException("telefono", "cve_tel", telCve_tel));

        telRepository.delete(telefono);

        return ResponseEntity.ok().build();
    }
}

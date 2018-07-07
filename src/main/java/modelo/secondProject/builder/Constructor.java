/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.secondProject.builder;

/**
 *
 * @author Paulina
 */
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "contacto")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updateAt"},
        allowGetters = true)    


public class Constructor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cve_con;
    
    @NotBlank
    private String nom_con;
    
    @NotBlank
    private String ap_con;
    
    @NotBlank
    private String am_con;
    
    @NotBlank
    private String fechanac_con;
    
    @NotBlank
    private Long cve_cor;
    
    @NotBlank
    private String nom_cor;
    
    @NotBlank
    private String tip_cor;
    
    @NotBlank
    private Long cve_tel;
    
    @NotBlank
    private String nom_tel;
    
    @NotBlank
    private String tip_tel;
    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date updatedAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCve_con() {
        return cve_con;
    }

    public String getNom_con() {
        return nom_con;
    }

    public String getAp_con() {
        return ap_con;
    }

    public String getAm_con() {
        return am_con;
    }

    public String getFechanac_con() {
        return fechanac_con;
    }

    public Long getCve_cor() {
        return cve_cor;
    }

    public String getNom_cor() {
        return nom_cor;
    }

    public String getTip_cor() {
        return tip_cor;
    }
    
    public Long getCve_tel() {
        return cve_cor;
    }

    public String getNom_tel() {
        return nom_tel;
    }
    
    public String getTip_tel() {
        return tip_tel;
    }
    
    public void setCve_con(Long cve_con) {
        this.cve_con = cve_con;
    }

    public void setNom_con(String nom_con) {
        this.nom_con = nom_con;
    }

    public void setAp_con(String ap_con) {
        this.ap_con = ap_con;
    }

    public void setAm_con(String am_con) {
        this.am_con = am_con;
    }

    public void setFechanac_con(String fechanac_con) {
        this.fechanac_con = fechanac_con;
    }

    public void setCve_cor(Long cve_cor) {
        this.cve_cor = cve_cor;
    }

    public void setNom_cor(String nom_cor) {
        this.nom_cor = nom_cor;
    }

    public void setTip_cor(String tip_cor) {
        this.tip_cor = tip_cor;
    }

    public void setCve_tel(Long cve_tel) {
        this.cve_tel = cve_tel;
    }

    public void setNom_tel(String nom_tel) {
        this.nom_tel = nom_tel;
    }
    
    public void setTip_tel(String tip_tel) {
        this.tip_tel = tip_tel;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_servidor.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "CANDIDATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findByCanCedula", query = "SELECT c FROM Candidato c WHERE c.canCedula = :canCedula")
    , @NamedQuery(name = "Candidato.findByCanNombre", query = "SELECT c FROM Candidato c WHERE c.canNombre = :canNombre")
    , @NamedQuery(name = "Candidato.findByCanFechaNacimiento", query = "SELECT c FROM Candidato c WHERE c.canFechaNacimiento = :canFechaNacimiento")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAN_CEDULA")
    private String canCedula;
    @Size(max = 30)
    @Column(name = "CAN_NOMBRE")
    private String canNombre;
    @Column(name = "CAN_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date canFechaNacimiento;

    public Candidato() {
    }

    public Candidato(String canCedula) {
        this.canCedula = canCedula;
    }

    public String getCanCedula() {
        return canCedula;
    }

    public void setCanCedula(String canCedula) {
        this.canCedula = canCedula;
    }

    public String getCanNombre() {
        return canNombre;
    }

    public void setCanNombre(String canNombre) {
        this.canNombre = canNombre;
    }

    public Date getCanFechaNacimiento() {
        return canFechaNacimiento;
    }

    public void setCanFechaNacimiento(Date canFechaNacimiento) {
        this.canFechaNacimiento = canFechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canCedula != null ? canCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.canCedula == null && other.canCedula != null) || (this.canCedula != null && !this.canCedula.equals(other.canCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_servidor.entidades.Candidato[ canCedula=" + canCedula + " ]";
    }
    
}

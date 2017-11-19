/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_jersey.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "CABECERAEVALUACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cabeceraevaluacion.findAll", query = "SELECT c FROM Cabeceraevaluacion c")
    , @NamedQuery(name = "Cabeceraevaluacion.findByCabCodigo", query = "SELECT c FROM Cabeceraevaluacion c WHERE c.cabCodigo = :cabCodigo")
    , @NamedQuery(name = "Cabeceraevaluacion.findByCanCedula", query = "SELECT c FROM Cabeceraevaluacion c WHERE c.canCedula = :canCedula")
    , @NamedQuery(name = "Cabeceraevaluacion.findByCabFecha", query = "SELECT c FROM Cabeceraevaluacion c WHERE c.cabFecha = :cabFecha")})
public class Cabeceraevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CAB_CODIGO")
    private BigDecimal cabCodigo;
    @Column(name = "CAN_CEDULA")
    private String canCedula;
    @Column(name = "CAB_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cabFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabCodigo")
    private Collection<Detalleevaluacion> detalleevaluacionCollection;

    public Cabeceraevaluacion() {
    }

    public Cabeceraevaluacion(BigDecimal cabCodigo) {
        this.cabCodigo = cabCodigo;
    }

    public BigDecimal getCabCodigo() {
        return cabCodigo;
    }

    public void setCabCodigo(BigDecimal cabCodigo) {
        this.cabCodigo = cabCodigo;
    }

    public String getCanCedula() {
        return canCedula;
    }

    public void setCanCedula(String canCedula) {
        this.canCedula = canCedula;
    }

    public Date getCabFecha() {
        return cabFecha;
    }

    public void setCabFecha(Date cabFecha) {
        this.cabFecha = cabFecha;
    }

    @XmlTransient
    public Collection<Detalleevaluacion> getDetalleevaluacionCollection() {
        return detalleevaluacionCollection;
    }

    public void setDetalleevaluacionCollection(Collection<Detalleevaluacion> detalleevaluacionCollection) {
        this.detalleevaluacionCollection = detalleevaluacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabCodigo != null ? cabCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabeceraevaluacion)) {
            return false;
        }
        Cabeceraevaluacion other = (Cabeceraevaluacion) object;
        if ((this.cabCodigo == null && other.cabCodigo != null) || (this.cabCodigo != null && !this.cabCodigo.equals(other.cabCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_jersey.entidades.Cabeceraevaluacion[ cabCodigo=" + cabCodigo + " ]";
    }
    
}

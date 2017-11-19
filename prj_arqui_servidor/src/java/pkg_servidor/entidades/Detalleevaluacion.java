/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_servidor.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "DETALLEEVALUACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleevaluacion.findAll", query = "SELECT d FROM Detalleevaluacion d")
    , @NamedQuery(name = "Detalleevaluacion.findByDetCodigo", query = "SELECT d FROM Detalleevaluacion d WHERE d.detCodigo = :detCodigo")
    , @NamedQuery(name = "Detalleevaluacion.findByDetCalificacion", query = "SELECT d FROM Detalleevaluacion d WHERE d.detCalificacion = :detCalificacion")})
public class Detalleevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_CODIGO")
    private BigDecimal detCodigo;
    @Column(name = "DET_CALIFICACION")
    private BigInteger detCalificacion;
    @JoinColumn(name = "CAB_CODIGO", referencedColumnName = "CAB_CODIGO")
    @ManyToOne(optional = false)
    private Cabeceraevaluacion cabCodigo;
    @JoinColumn(name = "PAR_CODIGO", referencedColumnName = "PAR_CODIGO")
    @ManyToOne
    private Parametroevaluacion parCodigo;

    public Detalleevaluacion() {
    }

    public Detalleevaluacion(BigDecimal detCodigo) {
        this.detCodigo = detCodigo;
    }

    public BigDecimal getDetCodigo() {
        return detCodigo;
    }

    public void setDetCodigo(BigDecimal detCodigo) {
        this.detCodigo = detCodigo;
    }

    public BigInteger getDetCalificacion() {
        return detCalificacion;
    }

    public void setDetCalificacion(BigInteger detCalificacion) {
        this.detCalificacion = detCalificacion;
    }

    public Cabeceraevaluacion getCabCodigo() {
        return cabCodigo;
    }

    public void setCabCodigo(Cabeceraevaluacion cabCodigo) {
        this.cabCodigo = cabCodigo;
    }

    public Parametroevaluacion getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Parametroevaluacion parCodigo) {
        this.parCodigo = parCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detCodigo != null ? detCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleevaluacion)) {
            return false;
        }
        Detalleevaluacion other = (Detalleevaluacion) object;
        if ((this.detCodigo == null && other.detCodigo != null) || (this.detCodigo != null && !this.detCodigo.equals(other.detCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_servidor.entidades.Detalleevaluacion[ detCodigo=" + detCodigo + " ]";
    }
    
}

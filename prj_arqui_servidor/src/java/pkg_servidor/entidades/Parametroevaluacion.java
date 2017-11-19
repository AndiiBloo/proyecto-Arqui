/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_servidor.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "PARAMETROEVALUACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametroevaluacion.findAll", query = "SELECT p FROM Parametroevaluacion p")
    , @NamedQuery(name = "Parametroevaluacion.findByParCodigo", query = "SELECT p FROM Parametroevaluacion p WHERE p.parCodigo = :parCodigo")
    , @NamedQuery(name = "Parametroevaluacion.findByParNombre", query = "SELECT p FROM Parametroevaluacion p WHERE p.parNombre = :parNombre")
    , @NamedQuery(name = "Parametroevaluacion.findByParPuntajeMaximo", query = "SELECT p FROM Parametroevaluacion p WHERE p.parPuntajeMaximo = :parPuntajeMaximo")})
public class Parametroevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_CODIGO")
    private BigDecimal parCodigo;
    @Size(max = 30)
    @Column(name = "PAR_NOMBRE")
    private String parNombre;
    @Column(name = "PAR_PUNTAJE_MAXIMO")
    private BigInteger parPuntajeMaximo;
    @OneToMany(mappedBy = "parCodigo")
    private Collection<Detalleevaluacion> detalleevaluacionCollection;

    public Parametroevaluacion() {
    }

    public Parametroevaluacion(BigDecimal parCodigo) {
        this.parCodigo = parCodigo;
    }

    public BigDecimal getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(BigDecimal parCodigo) {
        this.parCodigo = parCodigo;
    }

    public String getParNombre() {
        return parNombre;
    }

    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
    }

    public BigInteger getParPuntajeMaximo() {
        return parPuntajeMaximo;
    }

    public void setParPuntajeMaximo(BigInteger parPuntajeMaximo) {
        this.parPuntajeMaximo = parPuntajeMaximo;
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
        hash += (parCodigo != null ? parCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametroevaluacion)) {
            return false;
        }
        Parametroevaluacion other = (Parametroevaluacion) object;
        if ((this.parCodigo == null && other.parCodigo != null) || (this.parCodigo != null && !this.parCodigo.equals(other.parCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_servidor.entidades.Parametroevaluacion[ parCodigo=" + parCodigo + " ]";
    }
    
}

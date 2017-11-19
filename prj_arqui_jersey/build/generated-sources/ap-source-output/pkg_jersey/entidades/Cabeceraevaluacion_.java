package pkg_jersey.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pkg_jersey.entidades.Detalleevaluacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-18T18:24:55")
@StaticMetamodel(Cabeceraevaluacion.class)
public class Cabeceraevaluacion_ { 

    public static volatile SingularAttribute<Cabeceraevaluacion, String> canCedula;
    public static volatile SingularAttribute<Cabeceraevaluacion, BigDecimal> cabCodigo;
    public static volatile CollectionAttribute<Cabeceraevaluacion, Detalleevaluacion> detalleevaluacionCollection;
    public static volatile SingularAttribute<Cabeceraevaluacion, Date> cabFecha;

}
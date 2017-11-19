package pkg_jersey.entidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pkg_jersey.entidades.Cabeceraevaluacion;
import pkg_jersey.entidades.Parametroevaluacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-18T18:24:55")
@StaticMetamodel(Detalleevaluacion.class)
public class Detalleevaluacion_ { 

    public static volatile SingularAttribute<Detalleevaluacion, Parametroevaluacion> parCodigo;
    public static volatile SingularAttribute<Detalleevaluacion, Cabeceraevaluacion> cabCodigo;
    public static volatile SingularAttribute<Detalleevaluacion, BigInteger> detCalificacion;
    public static volatile SingularAttribute<Detalleevaluacion, BigDecimal> detCodigo;

}
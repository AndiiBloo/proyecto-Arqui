package pkg_jersey.entidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pkg_jersey.entidades.Detalleevaluacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-18T18:24:55")
@StaticMetamodel(Parametroevaluacion.class)
public class Parametroevaluacion_ { 

    public static volatile SingularAttribute<Parametroevaluacion, BigDecimal> parCodigo;
    public static volatile SingularAttribute<Parametroevaluacion, String> parNombre;
    public static volatile CollectionAttribute<Parametroevaluacion, Detalleevaluacion> detalleevaluacionCollection;
    public static volatile SingularAttribute<Parametroevaluacion, BigInteger> parPuntajeMaximo;

}
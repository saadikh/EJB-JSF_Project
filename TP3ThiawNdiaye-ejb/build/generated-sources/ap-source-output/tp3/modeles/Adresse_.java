package tp3.modeles;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp3.modeles.OperationBancaire;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T23:47:35")
@StaticMetamodel(Adresse.class)
public class Adresse_ { 

    public static volatile SingularAttribute<Adresse, String> voie;
    public static volatile SingularAttribute<Adresse, String> ville;
    public static volatile CollectionAttribute<Adresse, OperationBancaire> operations;
    public static volatile SingularAttribute<Adresse, Integer> numeroVoie;
    public static volatile SingularAttribute<Adresse, Long> id;

}
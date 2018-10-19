package tp3.modeles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp3.modeles.Agence;
import tp3.modeles.Personne;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-19T11:58:22")
@StaticMetamodel(CompteBancaire.class)
public class CompteBancaire_ { 

    public static volatile SingularAttribute<CompteBancaire, Agence> agence;
    public static volatile SingularAttribute<CompteBancaire, Personne> proprietaire;
    public static volatile SingularAttribute<CompteBancaire, Integer> soldeCompte;
    public static volatile SingularAttribute<CompteBancaire, Date> dateOuverture;
    public static volatile SingularAttribute<CompteBancaire, Long> id;

}
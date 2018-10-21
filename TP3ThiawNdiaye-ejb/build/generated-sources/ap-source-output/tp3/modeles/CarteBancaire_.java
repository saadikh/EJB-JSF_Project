package tp3.modeles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp3.modeles.Agence;
import tp3.modeles.Personne;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-21T08:30:57")
@StaticMetamodel(CarteBancaire.class)
public class CarteBancaire_ { 

    public static volatile SingularAttribute<CarteBancaire, Agence> agence;
    public static volatile SingularAttribute<CarteBancaire, Date> dateCreation;
    public static volatile SingularAttribute<CarteBancaire, Personne> proprietaire;
    public static volatile SingularAttribute<CarteBancaire, Date> dateExpiration;
    public static volatile SingularAttribute<CarteBancaire, Long> id;

}
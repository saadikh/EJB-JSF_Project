package tp3.modeles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp3.modeles.Banque;
import tp3.modeles.Personne;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-24T15:38:27")
@StaticMetamodel(CarteBancaire.class)
public class CarteBancaire_ { 

    public static volatile SingularAttribute<CarteBancaire, Personne> proprietaire;
    public static volatile SingularAttribute<CarteBancaire, Integer> numeroCarte;
    public static volatile SingularAttribute<CarteBancaire, Date> dateExpiration;
    public static volatile SingularAttribute<CarteBancaire, Banque> banque;
    public static volatile SingularAttribute<CarteBancaire, Long> id;

}
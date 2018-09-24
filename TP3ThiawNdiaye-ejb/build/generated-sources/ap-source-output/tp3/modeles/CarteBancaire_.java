package tp3.modeles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-24T13:46:57")
@StaticMetamodel(CarteBancaire.class)
public class CarteBancaire_ { 

    public static volatile SingularAttribute<CarteBancaire, Integer> numeroCarte;
    public static volatile SingularAttribute<CarteBancaire, String> nomBanque;
    public static volatile SingularAttribute<CarteBancaire, Date> dateExpiration;
    public static volatile SingularAttribute<CarteBancaire, Long> id;
    public static volatile SingularAttribute<CarteBancaire, String> nomProprietaire;
    public static volatile SingularAttribute<CarteBancaire, String> prenomProprietaire;

}
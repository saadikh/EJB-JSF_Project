package tp3.modeles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp3.modeles.Adresse;
import tp3.modeles.Personne;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-24T10:03:09")
@StaticMetamodel(CompteBancaire.class)
public class CompteBancaire_ { 

    public static volatile SingularAttribute<CompteBancaire, Adresse> adresseBanque;
    public static volatile SingularAttribute<CompteBancaire, Adresse> adresseProprietaire;
    public static volatile SingularAttribute<CompteBancaire, Personne> proprietaire;
    public static volatile SingularAttribute<CompteBancaire, Integer> soldeCompte;
    public static volatile SingularAttribute<CompteBancaire, Date> dateOuverture;
    public static volatile SingularAttribute<CompteBancaire, Personne> banque;
    public static volatile SingularAttribute<CompteBancaire, Integer> numCompte;
    public static volatile SingularAttribute<CompteBancaire, Long> id;

}
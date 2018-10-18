package tp3.modeles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp3.modeles.Adresse;
import tp3.modeles.CompteBancaire;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-18T21:10:31")
@StaticMetamodel(Personne.class)
public class Personne_ { 

    public static volatile SingularAttribute<Personne, String> profession;
    public static volatile SingularAttribute<Personne, String> motDePasse;
    public static volatile SingularAttribute<Personne, Date> dateNaissance;
    public static volatile SingularAttribute<Personne, Adresse> adresse;
    public static volatile ListAttribute<Personne, CompteBancaire> compteBancaires;
    public static volatile SingularAttribute<Personne, Long> id;
    public static volatile SingularAttribute<Personne, String> login;
    public static volatile SingularAttribute<Personne, String> nom;
    public static volatile SingularAttribute<Personne, String> prenom;

}
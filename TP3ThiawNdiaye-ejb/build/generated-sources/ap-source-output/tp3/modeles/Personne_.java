package tp3.modeles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tp3.modeles.Adresse;
import tp3.modeles.CompteBancaire;
import tp3.modeles.OperationBancaire;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T23:47:35")
@StaticMetamodel(Personne.class)
public class Personne_ { 

    public static volatile SingularAttribute<Personne, String> password;
    public static volatile CollectionAttribute<Personne, OperationBancaire> operations;
    public static volatile SingularAttribute<Personne, Date> dateNaissance;
    public static volatile SingularAttribute<Personne, Adresse> adresse;
    public static volatile ListAttribute<Personne, CompteBancaire> compteBancaires;
    public static volatile SingularAttribute<Personne, Long> id;
    public static volatile SingularAttribute<Personne, String> nom;
    public static volatile SingularAttribute<Personne, String> prenom;
    public static volatile SingularAttribute<Personne, String> statut;

}
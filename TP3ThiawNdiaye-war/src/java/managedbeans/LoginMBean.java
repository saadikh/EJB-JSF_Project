/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.gestionnaires.GestionnairePersonne;
import tp3.gestionnaires.LoginManager;
import tp3.modeles.CompteBancaire;
import tp3.modeles.Login;

@Named(value = "loginMBean")
@SessionScoped
public class LoginMBean implements Serializable {

    @EJB
    private LoginManager loginManager;

    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }

    public void creerAdmin() {
        loginManager.creerUser("admin", "admin");
    }

    public String connexion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        //si l'admin de l'application
        if (name.equals("admin") && password.equals("admin")) {
            session.setAttribute(name, name);
            return "admin?faces-redirect=true";
        }
        //si le conseiller principal ou admin au niveau banque
        if (name.equals("conseiller") && password.equals("root")) {
            session.setAttribute(name, name);
            return "printComptes?faces-redirect=true";

        }
        //verication du password au niveau bd pour tout client ou autre conseiller
        boolean result = loginManager.getValidation(password);

        if (result) {

            if (name.equals("client")) {
                session.setAttribute(name, name);
                return "user?faces-redirect=true";

            }

            if (name.equals("conseiller")) {
                return "printComptes?faces-redirect=true";

            }
        }

        //si erreur identification, on detruit aussi la session
        session.invalidate();
        return "login?faces-redirect=true";

    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "login?faces-redirect=true";
    }

    public String deleteByPwd(String pwd) {
        loginManager.deleteByPwd(pwd);
        return "admin?faces-redirect=true";
    }

    public List<Login> getUsers() {
        return loginManager.getAllUsers();
    }

    public List<CompteBancaire> getComptesUsers() {
        return gestionnaireCompteBancaire.getComptesByPwd(password);
    }

    /**
     * Creates a new instance of LoginMBean
     */
    public LoginMBean() {
    }

}

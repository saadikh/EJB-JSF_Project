/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import tp3.gestionnaires.LoginManager;

@Named(value = "loginMBean")
@SessionScoped
public class LoginMBean implements Serializable {

    @EJB
    private LoginManager loginManager;

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
        if (name.equals("admin") && password.equals("admin")) {
            return "admin?faces-redirect=true";
        }
        //verication du password
        boolean result = loginManager.getValidation(password);

        
        if (result) {

            if (name.equals("client")) {
                return "user?faces-redirect=true";

            }
            
            if (name.equals("conseiller")) {
                return "printComptes?faces-redirect=true";

            }
        }
        
        //si erreur identification 
        return "login";

    }

    /*validate login
    public String validateUsernamePassword() {
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "admin";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }*/
    /**
     * Creates a new instance of LoginMBean
     */
    public LoginMBean() {
    }

}

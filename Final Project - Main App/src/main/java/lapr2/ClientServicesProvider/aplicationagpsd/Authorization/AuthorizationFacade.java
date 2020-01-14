/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Authorization;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.UsersRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model.UserSession;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.User;

/**
 *
 * @author Tiago Dias(1180939)
 * @author Tiago Ribeiro(1181444)
 * @author Bernardo Carvalho(1170691)
 * 
 */
public class AuthorizationFacade {

    private static UserSession session = null;
    private static final UsersRecord users = new UsersRecord();

    public void registUserWithRole(String strEmail, String strPassword, String strRole) {
        User utlz = this.users.newUser(strEmail, strPassword, strRole);
        this.users.addUser(utlz);
    }

    public boolean UserExists(String strEmail) {
        return this.users.hasUser(strEmail);
    }

    public UserSession doLogin(String strEmail, String strPwd) {
        User utlz = this.users.findUser(strEmail);
        if (utlz != null) {
            if (utlz.hasPassword(strPwd)) {
                this.session = new UserSession(utlz);
            }
        }
        return getSessaoAtual();
    }

    public static UserSession getSessaoAtual() {
        return AuthorizationFacade.session;
    }

    public void doLogout() {
        if (this.session != null) {
            this.session.doLogout();
        }
        this.session = null;
    }
    
}

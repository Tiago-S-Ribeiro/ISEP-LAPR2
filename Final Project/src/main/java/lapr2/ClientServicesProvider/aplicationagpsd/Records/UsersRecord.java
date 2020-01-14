package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Model.User;

import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;

/**
 *
 * @author Tiago Dias(1180939)
 * @author Tiago Ribeiro(1181444)
 * @author Bernardo Carvalho(1170691)
 */
public class UsersRecord {

    private List<User> lstUsers = new ArrayList<User>();
    
    public UsersRecord(){
        this.lstUsers = new ArrayList<User>();
    }
    
    public List<User> getUserList(){
        return lstUsers;
    }
    
    public void setUsersList(ArrayList<User> usersList){
       lstUsers = usersList; 
    }

    public User newUser(String strEmail, String strPassword, String strRole) {
        return new User(strEmail, strPassword, strRole);
    }

    public void addUser(User utlz) {
        if (hasUser(utlz)) {
            throw new IllegalArgumentException("User Already Exists");
        }
        Company.getUserRecord().getUserList().add(utlz);
    }

    public void removeUser(User utlz) {
        if (!hasUser(utlz)) {
            throw new IllegalArgumentException("User does not exist");
        }
        Company.getUserRecord().getUserList().remove(utlz);
    }

    public User findUser(String strEmail) {
        for (User utlz : Company.getUserRecord().getUserList()) {
            if (utlz.hasEmail(strEmail)) {
                return utlz;
            }
        }
        return null;
    }

    public boolean hasUser(String strEmail) {
        User utlz = findUser(strEmail);
        if (utlz != null) {
            return Company.getUserRecord().getUserList().contains(utlz);
        }
        return false;
    }

    public boolean hasUser(User utlz) {
        return Company.getUserRecord().getUserList().contains(utlz);
    }
}

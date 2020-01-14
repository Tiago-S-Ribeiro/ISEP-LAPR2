package lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model;

import lapr2.ClientServicesProvider.aplicationagpsd.Model.User;


/**
 *
 * @author Tiago Dias(1180939)
 * @author Tiago Ribeiro(1181444)
 * @author Bernardo Carvalho(1170691)
 */
public class UserSession
{
    private User user= null;
    
    public UserSession(User user)
    {
        if (user == null)
            throw new IllegalArgumentException("Argumento não pode ser nulo.");
        this.user = user;
    }
    
    public void doLogout()
    {
        this.user = null;
    }
    
    public boolean isLoggedIn()
    {
        return this.user != null;
    }
    
    public boolean isLoggedInWithPart(String strRole)
    {
        if (isLoggedIn())
        {
            return this.user.getRole().equalsIgnoreCase(strRole);
        }
        return false;
    }
    
    public String getUserEmail()
    {
        if (isLoggedIn())
            return this.user.getEmail();
        return null;
    }
    
    public User getUserBySession(){
        return this.user;
    }

    @Override
    public String toString() {
        return "UserSession{" + "user=" + user.toString() + '}';
    }
    
    

}

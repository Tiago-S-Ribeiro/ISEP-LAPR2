//package lapr2.ClientServicesProvider.aplicationagpsd.Records;
//
//import java.util.ArrayList;
//import java.util.List;
//import lapr2.ClientServicesProvider.aplicationagpsd.Model.User;
//import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Tiago Ribeiro (1181444)
// */
//public class UsersRecordTest {
//    
//    public UsersRecordTest() {
//    }
//    
//    /**
//     * Test of getAddressList method, of class Client.
//     */
//    @Test
//    public void testgetUserList() {
//        System.out.println("getAddressList");
//        UsersRecord instance = new UsersRecord();
//        List<User> expResult = new ArrayList<User>();
//        List<User> result = instance.getUserList();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of newUser method, of class UsersRecord.
//     */
//    @Test
//    public void testNewUser() {
//        System.out.println("newUser");
//        String strEmail = "emailTeste";
//        String strPassword = "passTeste";
//        String strRole = "PART";
//        UsersRecord instance = new UsersRecord();
//        User expResult = new User(strEmail,strPassword,strRole);
//        User result = instance.newUser(strEmail, strPassword, strRole);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of addUser method, of class UsersRecord.
//     */
//    @Test
//    public void testAddUser() {
//        System.out.println("addUser");
//        User utlz = new User("email","pass","role");
//        UsersRecord instance = new UsersRecord();
//        instance.addUser(utlz);
//        assertEquals(utlz, instance.getUserList().get(0));
//    }
//
//    /**
//     * Test of removeUser method, of class UsersRecord.
//     */
//    @Test
//    public void testRemoveUser() {
//        System.out.println("removeUser");
//        User utlz = new User("mail","pass","role");
//        User utlz2 = new User("mail2","pass2","role2");
//        User utlz3 = new User("mail3","pass3","role3");
//        UsersRecord instance = new UsersRecord();
//        instance.addUser(utlz);
//        instance.addUser(utlz2);
//        instance.addUser(utlz3);
//        instance.removeUser(utlz2);
//        assertEquals(utlz3, instance.getUserList().get(1));
//    }
//
//    /**
//     * Test of findUser method, of class UsersRecord.
//     */
//    @Test
//    public void testFindUser() {
//        System.out.println("findUser");
//        String strEmail = "mail";
//        UsersRecord instance = new UsersRecord();
//        User expResult = new User("mail","pass","role");
//        instance.addUser(expResult);
//        User result = instance.findUser(strEmail);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of hasUser method, of class UsersRecord.
//     */
//    @Test
//    public void testHasUser_String() {
//        System.out.println("hasUser");
//        String strEmail = "emailTest";
//        UsersRecord instance = new UsersRecord();
//        instance.addUser(new User("email","pass","role"));
//        boolean expResult = false;
//        boolean result = instance.hasUser(strEmail);
//        assertEquals(expResult, result);
//    }
//    
//    /**
//     * Test of hasUser method, of class UsersRecord.
//     */
//    @Test
//    public void testHasUser_String2() {
//        System.out.println("hasUser");
//        String strEmail = "emailTest";
//        UsersRecord instance = new UsersRecord();
//        instance.addUser(new User("emailTest","pass","role"));
//        boolean expResult = true;
//        boolean result = instance.hasUser(strEmail);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of hasUser method, of class UsersRecord.
//     */
//    @Test
//    public void testHasUser_User() {
//        System.out.println("hasUser");
//        User utz = new User("email","pass","ROLE");
//        UsersRecord instance = new UsersRecord();
//        boolean expResult = false;
//        boolean result = instance.hasUser(utz);
//        assertEquals(expResult, result);
//    }
//    
//    /**
//     * Test of hasUser method, of class UsersRecord.
//     */
//    @Test
//    public void testHasUser_User2() {
//        System.out.println("hasUser");
//        User utz = new User("email","pass","ROLE");
//        UsersRecord instance = new UsersRecord();
//        instance.addUser(utz);
//        boolean expResult = true;
//        boolean result = instance.hasUser(utz);
//        assertEquals(expResult, result);
//    }
//}


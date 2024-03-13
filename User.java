/**************************
 * 
 * User.java is the class name
 
 **************************/

package assignment1;//package name
public class User {//class name
  //declaring variables
    private int userID;
    private String name;
    private String contactInformation;
   

    // Constructor
    public User(int userID, String name, String contactInformation) {
        this.userID = userID;
        this.name = name;
        this.contactInformation = contactInformation;
       
    }

    // Getter methods
    public int getUserID() {//getter for user id
        return userID;
    }

    public String getName() {//getter for name
        return name;
    }

    public String getContactInformation() {//getter for contact information
        return contactInformation;
    }

  
}
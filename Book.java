/************************
 * 
 * Book.java is the class name
 * 
 *************************/

package assignment1;//package name
public class Book  {//class name
  //declaring variables
 private int bookID;
 private String title;
 private String author;
 private boolean availabilityStatus;
 private String genre;
 
// parametrized constructor
 public Book(int bookID,String title,String author,boolean availabilityStatus,String genre){
this.bookID = bookID;
this.title = title;
this.author = author;
this.availabilityStatus = availabilityStatus;
this.genre = genre;


   } 
   



   public int getbookid(){//getter for book id
    return bookID;
}
public String gettitle(){//getter for title
    return title;
}
public String getauthor(){//getter for author
    return author;
}
public boolean getavailabilityStatus(){//getter for availability status
    return availabilityStatus;
}
public String getgenre(){//getter for genre
    return genre;
}
public void setAvailability(boolean availability) {//setter for availability status
    availabilityStatus = availability;
}

}


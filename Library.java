/***************
 * 
 * Library.java is the class name
 * 
 * ****************/
 
package assignment1;//package name
import java.util.ArrayList;//importing arraylist
import java.util.List;//importing list
import java.util.Scanner;//importing scanner

public class Library  {//class name
  //declaring variables
   Scanner sc = new Scanner (System.in);
   ArrayList<Book> books = new ArrayList<Book>();//arraylist of books
   ArrayList<User> users = new ArrayList<User>();//arraylist of users
   private ArrayList<Book> borrowedBooks = new ArrayList<Book>();//arraylist of borrowed books
   public Library() {//constructor
    this.books = new ArrayList<>();
    this.users = new ArrayList<>();
    this.borrowedBooks = new ArrayList<>();
}
public ArrayList<Book> getBorrowedBooks() {//getter
    return borrowedBooks;
}
public void borrowBook(Book book) {//borrow book method
    borrowedBooks.add(book);
}

public void returnBook(Book book) {//return book method
    borrowedBooks.remove(book);
}

public boolean hasBorrowedBook(Book book) {//checking if the book is borrowed or not
    return borrowedBooks.contains(book);
}

public List<Book> getBooks() {//getter for books
    return books;
}
public List<User> getUsers(){//getter for users
    return users;
}
    public  void bookAdder(Book b){//adding book to the arraylist
     books.add(b);
    }


    public void userAdder(User u){//adding user to the arraylist
       users.add(u); 
    }


    public Book getBookByID(int bookID){//getting book by id
        for(Book b : books){//for each loop
       if(b.getbookid() == bookID){//if the book id is equal to the book id
        return b;
       }
        }return null;
    }


    public User getUserByID(int userID){//getting user by id
        for (User u : users) {//for each loop
            if (u.getUserID() == userID) {//if the user id is equal to the user id
                return u;
            }
        }
        return null;
    }



    public void displayBooks() {//displaying books
        System.out.println("Books in the library:");
        for (Book book : books) {//for each loop
            // Display book details
            System.out.println("ID: " + book.getbookid() + ", Title: " + book.gettitle()
                    + ", Author: " + book.getauthor() + ", Genre: " + book.getgenre()
                    + ", Availability: " + (book.getavailabilityStatus() ? "Available" : "Not Available"));
        }
    }



    public void displayUsers() {//displaying users
        try {
            System.out.println("Users in the library:");
            for (User user : users) {//for each loop
                // Display user details
                System.out.println("ID: " + user.getUserID() + ", Name: " + user.getName()
                        + ", Contact Info: " + user.getContactInformation());
            }

        } catch (Exception e) {
           e.printStackTrace();
        }
      
    }


    
public void  bookSearcher(String title , String author,ArrayList<Book> books ){//searching book by title or author
try {
    System.out.println("what do you want to search with title or author :");//asking the user to search by title or author
    String answer = sc.nextLine();
    

    switch (answer.toLowerCase()) {//switch case
      
        case "title"://if the user wants to search by title
         for(Book b : books){
            String bookTitle = b.gettitle();//getting the title of the book
            bookTitle.toLowerCase();//converting to lower case
            if(bookTitle.equals(title)){//if the title is equal to the title
                System.out.println("ID: " + b.getbookid() + ", Title: " + b.gettitle()
                + ", Author: " + b.getauthor() + ", Genre: " + b.getgenre()
                + ", Availability: " + (b.getavailabilityStatus() ? "Available" : "Not Available"));
            }
            
             }
             break;

        case "author"://if the user wants to search by author
             for(Book b : books){//for each loop
                String bookAuthor = b.getauthor();//getting the author of the book
                bookAuthor.toLowerCase();//converting to lower case
                if(bookAuthor.equals(author)){//if the author is equal to the author
                    System.out.println("ID: " + b.getbookid() + ", Title: " + b.gettitle()
                    + ", Author: " + b.getauthor() + ", Genre: " + b.getgenre()
                    + ", Availability: " + (b.getavailabilityStatus() ? "Available" : "Not Available"));
                }
               
                 }
                 break;
               
            default://if the user enters invalid input
            System.out.println("Invalid input");
            break;
 } 
}
catch (Exception e) {//catching the exception
    e.printStackTrace();
    
}
 }

public void bookSearcherbyID(int userID , ArrayList<User> users ){//searching book by id
        try {
            for(User u : users){//for each loop
                if(u.getUserID() == userID){//if the user id is equal to the user id
                  List<Book> borrowedBooks = getBorrowedBooks();//getting the borrowed books
                  if (!borrowedBooks.isEmpty()) {//if the borrowed books is not empty
                    // Assuming you want to return the first borrowed book
                    // return borrowedBooks.get(0);
                    for(Book b : borrowedBooks){//for each loop
                        // Display book details
                        System.out.println("ID: " + b.getbookid() + ", Title: " + b.gettitle()
                        + ", Author: " + b.getauthor() + ", Genre: " + b.getgenre()
                        + ", Availability: " + (b.getavailabilityStatus() ? "Available" : "Not Available"));
                    }
                    
                }
                else {//if the borrowed books is empty
                    System.out.println("User with ID " + userID + " has not borrowed any books.");
                    
                }
            }
        }
               } catch (Exception e) {
            e.printStackTrace();
            
        }
        
         
    }

}


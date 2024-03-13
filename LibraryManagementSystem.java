/*******************
 * 
 * LibraryManagementSystem.java is the class name
 * 
 ********************/

package assignment1;//Package declaration
import java.util.Scanner;//Importing the scanner class
import java.io.*;//Importing the input output package


public class LibraryManagementSystem {//LibraryManagementSystem class

public static void main(String []args){//Main method

        String booksFilePath = "C:\\Book.txt.txt";//Path of the book file
        String usersFilePath = "C:\\User.txt.txt";//Path of the user file
      
        Library library = new Library();//Creating an object of library class
        Scanner sc = new Scanner(System.in);//Creating an object of scanner class

       designer();//Calling the designer method to print the design
       System.out.println("                                                   Welcome to the Library Management System");//Printing the welcome message
       designer();
       System.out.println(""); 
       loadBooksFromFile(booksFilePath, library);//Loading books from the file
       loadUsersFromFile(usersFilePath, library);//Loading users from the file
    
    int choice;//Declaring a variable choice
    try {
        do {
            
              menu();//Calling the menu method to display the menu
                choice = sc.nextInt();
                 sc.nextLine(); // Consume the newline character
    
                switch (choice) {//Switch case to perform the operations
                    
                    case 1:
                    addbook(library, sc);//Calling the addbook method
                        break;
                    case 2:
                    addUser(library, sc);//Calling the addUser method
                        break;
                    case 3:
                        library.displayBooks();//Displaying the books
                        break;
                    case 4:
                        borrowBook(library, sc);//Calling the borrowBook method
                        break;
                    case 5:
                        returnBook(library, sc);//Calling ReturnBook method
                        break;
                    case 6:
                        searchBooksByUser(library, sc);//Calling the searchBooksByUser method
                        break;
                    case 7:
                        searchBooksByTitleorAuthor(library,sc);//Calling the searchBooksByTitleorAuthor method
                        break;
                    case 9:
                        saveLibraryToFile(library, booksFilePath, usersFilePath); // Save data before exiting 
                        break;
                     case 8 :
                     showAvailableBooks(library);//Calling the showAvailableBooks method
                     break;   
                     
                    default://Default case
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                } while (choice != 9);
            }           
    catch (java.util.InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid integer.");
    }
    finally {
        sc.close();
    }
            } 
    

private static void menu() {//Menu method to display the menu
        designer();
        System.out.println("\nLibrary Management System Menu");
        System.out.println("Enter the function you want to perform :");
        System.out.println("1. Add Book");
        System.out.println("2. Add User");
        System.out.println("3. Display Books");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Search Books by User");
        System.out.println("7. Search Books by Author or Title");
        System.out.println("8. Show Available Books");
        System.out.println("9. Save and Exit the Library Management System");
        designer();
        System.out.print("Enter your choice: ");
    }



   // Add book method 
public static void addbook(Library library , Scanner sc){//Validation with try and catch block
    try{
        designer();
        System.out.println("Enter title of the book:");//Asking the user to enter the title of the book
        String title = sc.nextLine();
        // Validate title
        while (title.isEmpty()) {
            System.out.println("Title cannot be empty. Enter a valid title:");//Validation of title
            title = sc.nextLine();
        }

        System.out.println("Enter author of the book:");//Asking user to enter the author of the book
        String author = sc.nextLine();
        // Validate author
        while (author.isEmpty()) {
            System.out.println("Author cannot be empty. Enter a valid author:");//Validation of author
            author = sc.nextLine();
        }

        System.out.println("Enter genre of the book:");//Asking user to enter the genre of the book
        String genre = sc.nextLine();
        // Validate genre
        while (genre.isEmpty()) {
            System.out.println("Genre cannot be empty. Enter a valid genre:");//Validation of genre
            genre = sc.nextLine();
        }

        System.out.println("Enter availability status of the book:");//Asking user to Enter availability status of the book
        boolean availabilityStatus = sc.nextBoolean();

        System.out.println("Enter the id of the book:");//Asking user to enter the id of the book
       int bookID = sc.nextInt();

        // Validation of title
        while (isTitleAlreadyWritten("C:\\Users\\Sohaib\\Desktop\\Book.txt.txt", title)) {
            System.out.println("A book with the same title already exists. Enter a unique title:");
            title = sc.nextLine();
        }

        Book b = new Book(bookID, title, author, availabilityStatus, genre);//Creating an object of book class
        library.bookAdder(b);//Calling the bookAdder method
    System.out.println("Book added successfully.");

    } 
        catch(Exception e){
            System.out.println("Invalid input.");
         e.printStackTrace();
     
     }
 }
 // Add user method
public static void addUser(Library library , Scanner sc){
    try {
       designer();

        System.out.println("Enter name of the user:");//Asking user to enter the name of the user
        String name = sc.nextLine();
        // Validate name
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Enter a valid name:");//Validation of name
            name = sc.nextLine();
        }

        System.out.println("Enter contact information of the user:");//Asking user to enter the contact information of the user
        String contactInformation = sc.nextLine();
        // Validate contact information
        while (contactInformation.isEmpty()) {
            System.out.println("Contact information cannot be empty. Enter valid contact information:");//Validation of contact information
            contactInformation = sc.nextLine();
        }

      System.out.println("Enter the id of the user:");//Asking user to enter the id of the user
        int userID = sc.nextInt();
    
   User u = new User(userID, name, contactInformation);//Creating an object of user class
    library.userAdder(u);//Calling the userAdder method
    System.out.println("User added successfully.");
    }  catch (Exception e) {
        System.out.println("Invalid input.");
        e.printStackTrace();
    }}
 


private static void borrowBook(Library library, Scanner sc) {//Borrow book method
    designer();
    library.displayUsers();//Displaying the users
    designer();
    System.out.print("Enter User ID: ");//Asking user to enter the user id
    int userID = sc.nextInt();
    designer();

    library.displayBooks();//Displaying the books
    designer();
    System.out.println("Enter Book ID to borrow: ");
     int bookID;
        // Validate bookID
        while (true) {//Validation of book id
            try {
                bookID = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for book ID. Enter a valid integer:");
                sc.nextLine(); // invalid input is consumed
            }
        }

    User user = library.getUserByID(userID);//Creating an object of user class
    Book book = library.getBookByID(bookID);//Creating an object of book class

    if (user != null && book != null && book.getavailabilityStatus()) {//Validation of user and book
        // user.borrowBook(book);
        library.borrowBook(book);
         book.setAvailability(false);
        updateBookAvailability("C:\\\\Users\\\\Sohaib\\\\Desktop\\\\Book.txt.txt", bookID, false);//Calling the updateBookAvailability method
        System.out.println("Book borrowed successfully.");
    } else {
        System.out.println("Invalid User ID or Book ID, or the book is not available.");
    }}




private static void showAvailableBooks(Library library) {//Show available books method
    designer();
    System.out.println("Available Books:");//Displaying the available books
    for (Book book : library.getBooks()) {//Iterating over the books
        if (book.getavailabilityStatus()) {//Validation of availability status
            System.out.println(book.gettitle());
        }
    }
}




private static void returnBook(Library library, Scanner sc) {//Return book method
    designer();
    library.displayUsers();//Displaying the users
    designer();
    System.out.print("Enter User ID: ");//Asking user to enter the user id
    int userID = sc.nextInt();
    sc.nextLine(); // Consume the newline character
    designer();
    User user = library.getUserByID(userID);//Creating an object of user class

    if (user != null) {//Validation of user
     
        System.out.print("Enter Book ID to return: ");
        int bookID = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        Book book = library.getBookByID(bookID);//Creating an object of book class

        if (book != null && !book.getavailabilityStatus()) {//Validation of book
            // user.returnBook(book);
            library.returnBook(book);
            book.setAvailability(true);
            updateBookAvailability("C:\\\\Users\\\\Sohaib\\\\Desktop\\\\Book.txt.txt", bookID, true);//Calling the updateBookAvailability method
            System.out.println("Book returned successfully.");
        } else {//invalid input
            System.out.println("Invalid Book ID or the book is not currently borrowed by the user.");
        }
    } else {//invalid input
        System.out.println("Invalid User ID.");
    }
}




private static void searchBooksByUser(Library library , Scanner sc){//Search books by user method
    designer();
    System.out.print("Enter User ID: ");
    int userID = sc.nextInt();

   library.bookSearcherbyID(userID,library.users);//Calling the bookSearcherbyID method
}


private static void searchBooksByTitleorAuthor(Library library ,Scanner sc ){//Search books by title or author method
    designer();
    System.out.println("Enter title of the book :");
    String title = sc.nextLine();
    System.out.println("Enter author of the book :");
    String author = sc.nextLine(); 

    title.toLowerCase();//Converting the title to lower case
    author.toLowerCase();//Converting the author to lower case
    library.bookSearcher(title, author,library.books);//Calling the bookSearcher method
 }
   


public static void saveLibraryToFile(Library library, String filePath, String filepath1) {//Save library to file method
    try {
        // Clear the contents of the file
        PrintWriter writer = new PrintWriter(filePath);//Creating an object of printwriter class
        writer.close();

        PrintWriter writer3 = new PrintWriter(filepath1);//Creating an object of printwriter class
        writer3.close();

       

        // Iterate over the books in the library and write them to the file
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath, true))) {//Creating an object of bufferedwriter class
            for (Book book : library.getBooks()) {
                if (!isTitleAlreadyWritten(filePath, book.gettitle())) {
                writer2.write(book.gettitle() + "," + book.getauthor() + "," + book.getgenre() + "," + book.getbookid() + "," + book.getavailabilityStatus() + "\n");
            }
           
        }
    }

        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(filepath1, true))) {//Creating an object of bufferedwriter class
            for (User user : library.getUsers()) {
                writer1.write(user.getUserID() + "," + user.getName() + "," + user.getContactInformation() + "\n");
            }
           
        }

       

        System.out.println("Library saved to text file.");//Printing the message
    } catch (IOException e) {//Catching the exception
        e.printStackTrace();
    }
}




private static boolean isTitleAlreadyWritten(String filePath, String title) {//Validation of title
    try (Scanner scanner = new Scanner(new File(filePath))) {//Creating an object of scanner class
        while (scanner.hasNextLine()) {//Iterating over the file
            String line = scanner.nextLine();//Reading the line
            String[] bookData = line.split(",");//Splitting the line
            if (bookData.length >= 1 && bookData[0].equals(title)) {//Validation of book data
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}

private static void loadBooksFromFile(String filePath, Library library) {//Loading books from file method
        try (Scanner scanner = new Scanner(new File(filePath))) {//Creating an object of scanner class
            while (scanner.hasNextLine()) {//Iterating over the file
                String line = scanner.nextLine();//Reading the line
                String[] bookData = line.split(",");//Splitting the line
    
                if (bookData.length >= 5) {//Validation of book data
                    try {
                        int bookID = Integer.parseInt(bookData[3]);//Parsing the book id
                        String title = bookData[0];
                        String author = bookData[1];
                        boolean availabilityStatus = Boolean.parseBoolean(bookData[4]);//Parsing the availability status
                        String genre = bookData[2];
    
                        Book book = new Book(bookID, title, author, availabilityStatus, genre);//Creating an object of book class
                        library.bookAdder(book);//Calling the bookAdder method
                    } catch (NumberFormatException e) {//Catching the exception
                        System.out.println("Invalid book ID format in the file: " + line);
                    }
                } else {//invalid data format
                    System.out.println("Invalid data format in the file: " + line);//Printing the message
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {//Catching the exception
            e.printStackTrace();
        }
    }
    
    private static void loadUsersFromFile(String filePath, Library library) {//Loading users from file method
        try (Scanner scanner = new Scanner(new File(filePath))) {//Creating an object of scanner class
            while (scanner.hasNextLine()) {//Iterating over the file
                String line = scanner.nextLine();//Reading the line
                String[] userData = line.split(",");//Splitting the line
    
                int userID = Integer.parseInt(userData[0]);//Parsing the user id
                String name = userData[1];
                String contactInformation = userData[2];
    
                User user = new User(userID, name, contactInformation);//Creating an object of user class
                library.userAdder(user);//Calling the userAdder method
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }


  


    public static void updateBookAvailability(String filePath, int bookID, boolean newAvailability) {//Update book availability method
        try {
            File inputFile = new File(filePath);//Creating an object of file class
            File tempFile = new File("temp.txt");//Creating an object of file class
    
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));//Creating an object of bufferedreader class
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));//Creating an object of bufferedwriter class
    
            String currentLine;//Declaring a variable currentLine
            while ((currentLine = reader.readLine()) != null) {//Iterating over the file
                String[] bookData = currentLine.split(",");//Splitting the line
    
               
                if (bookData.length >= 4) {//Validation of book data
                    int currentBookID = Integer.parseInt(bookData[3]);//Parsing the book id
    
                    
                    if (currentBookID == bookID) {//Validation of book id
                        
                        bookData[4] = String.valueOf(newAvailability);//Converting the new availability to string
                    }
                }
    
                // Reconstruct the line and write it to the temporary file
                writer.write(String.join(",", bookData) + "\n");//Writing the line to the temporary file
            }
    
            // Close the readers and writers
            reader.close();
            writer.close();
    
            // Replacing the original file with the temporary file
            if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {//Validation of file
                System.out.println("Error updating book availability.");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void designer() {//Designer method to print the design
        System.out.println("*********************************************************************************************************************************************************************");
        System.out.println("*********************************************************************************************************************************************************************");
    }

}







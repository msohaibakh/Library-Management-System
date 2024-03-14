Library Management System
This Java application is a simple library management system that allows librarians to perform various tasks, including adding new books, updating book details, checking out books to users, and managing user accounts. The application also supports file-based data persistence to store book and user information between application runs.

Classes
1. Book Class
The Book class represents individual books in the library. It has the following attributes:

bookID: ID of the book.
title: Title of the book.
author: Author of the book.
genre: Genre of the book.
availabilityStatus: Availability status of the book.

2. User Class
The User class represents library users. It has the following attributes:

userID: ID of the user.
name: Name of the user.
contactInformation: Contact information of the user.

3. Library Class
The Library class contains arrays to store books and users. It provides methods for:

Adding new books.
Adding new users.
Checking out books.
Returning books.
Searching for books by title or author.
The class also supports file-based data persistence to load and save book and user information.

and has attributes: borrowedBooks: List of books borrowed by the user.

4. Main Class (LibraryManagementSystem)
The LibraryManagementSystem class serves as the entry point for the program. It implements a simple menu-driven interface to allow librarians to perform tasks such as adding books, adding users, displaying books, borrowing or checking out books, returning books, and searching for books by user ID.

File Handling
The application supports simple file-based data persistence. It loads book and user information from specified files on startup and saves the updated information before exiting.

Error Handling
Error handling has been implemented to gracefully handle invalid user inputs, file reading errors, and parsing errors.

Validation
Validation checks have been implemented to ensure that book and user information is entered correctly. For example, proper validation is performed when parsing integers and booleans from the input files.

How to Use
Compile the Java files:

1. Download a JDK.
2. Download VS code for better experience.
3. Extract the file to your Local Disk C( if not present then create one )if you have opened the zip file or if u have downloaded the files directly then just save them on your local disk C.
4. Then open the package assignment 1 on your IDE.
5. Then Run it.

The application will load existing book and user information from the specified files on startup. Any changes made during the session will be saved before exiting.

Sample Data Files
Book.txt: Contains information about books in the library. Each line represents a book in the format bookID,title,author,genre,availabilityStatus.

User.txt: Contains information about library users. Each line represents a user in the format userID,name,contactInformation.

Contributors
Muhammad Sohaib Akhtar

License
This project is licensed under the [ GNU GENERAL PUBLIC LICENSE] License - see the LICENSE.md file for details

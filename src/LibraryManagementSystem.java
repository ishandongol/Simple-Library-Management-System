import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LibraryManagementSystem {
    private static int option;
    private static Scanner sc;
    private static BookHandler bookHandler;
    private static UserHandler userHandler;
    private static boolean running = true;

    public static void main(String[] args) {
        bookHandler = new BookHandler();
        userHandler = new UserHandler();


        sc = new Scanner(System.in);

        while (running) {
            option = 0;
            addHeader();
            System.out.println("1. Login as Admin");
            System.out.println("2. Guest (Search)");
            System.out.println("3. Exit");
            underLine();
            System.out.println("\n");
            defaultInterface();
            if (option == 1) {
                Admin admin = new Admin();
                adminOperations(true);
            } else if (option == 2) {
                searchBooks();
            } else if (option == 3) {
                running = false;
                System.out.println("Good Bye!! ");
                sc.close();


            }

        }
    }

    private static void error() {
        System.out.println("Not Available");

    }

    private static void searchBooks() {
        addHeader();
        System.out.println("Search Books");
        boolean searching = true;
        while (searching) {
            underLine();
            System.out.print("* Type 'ex' to Exit *\n");
            underLine();
            System.out.print("Enter Book Name: ");
            String input = sc.nextLine();
            if (input.matches("ex")) {
                searching = false;
            }

            bookHandler.read(input);
        }


    }

    private static void adminOperations(boolean adminRunning) {

        while (adminRunning) {
            addHeader();
            System.out.println("Admin Mode");
            underLine();
            System.out.println("1. Issue Books");
            System.out.println("2. Inventory");
            System.out.println("3. User Management");
            System.out.println("4. Return Books");
            System.out.println("5. Exit");
            underLine();
            defaultInterface();
            if (option == 1) {
                issueBooks();
            } else if (option == 2) {
                updateInventory();
            } else if (option == 3) {
                manageUser();


            } else if (option == 4) {

                returnBooks();


            } else if (option == 5) {

                System.out.println("Good Bye!! ");
                adminRunning = false;


            } else {
                error();
            }

        }


    }

    private static void defaultInterface() {
        try {
            System.out.print("Enter Number: ");

            option = sc.nextInt();

        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Enter Number 1 - 5");
        }
    }

    private static void returnBooks() {
        addHeader();
        promptUser("Return Books");
        String userID = sc.nextLine();
        if (userID.matches("Ex")) {
            System.out.println("Cancelled");
        } else {
            try {
                User user = userHandler.read(Integer.valueOf(userID));
                if (user instanceof Student) {
                    System.out.print("Enter Book ID: ");
                    String bookID = sc.nextLine();
                    if (userID.matches("Ex")) {
                        System.out.println("Cancelled");
                    } else {
                        try {

                            Books books = bookHandler.read(Integer.valueOf(bookID));


                            if (books != null) {
                                if (((Student) user).removeIssuedBooks(books)) {
                                    books.updateBooksQuantity();
                                    books.returnBooks(user);
                                    userHandler.update(Integer.valueOf(userID), user);
                                    bookHandler.update(Integer.valueOf(bookID), books);
                                    System.out.println("Books returned By:");
                                    System.out.println(user);
                                    System.out.println(books);
                                    sc.nextLine();
                                } else {
                                    System.out.println("Books not Issued");
                                    timeout();
                                }

                            } else {
                                System.out.println("Books Not Found");
                                timeout();
                            }


                        } catch (InputMismatchException e) {
                            System.out.println("Enter a valid ID");
                        }
                    }


                } else {
                    System.out.println("Not Student");
                    timeout();
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid ID");
            }
        }

    }

    private static void manageUser() {

        while (true) {
            addHeader();
            System.out.println("User Management");
            underLine();
            System.out.println("1. Create new User");
            System.out.println("2. Delete User");
            System.out.println("3. Search User");
            System.out.println("4. Exit");
            underLine();

            defaultInterface();
            if (option == 1) {

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter ID, Name, Occupation :");
                String input = scanner.nextLine();
                List<String> userDetails = Arrays.asList(input.split(","));
                if (userDetails.size() > 3) {
                    userHandler.create(new Student(Integer.valueOf(userDetails.get(0)), userDetails.get(1), userDetails.get(2)));
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        addHeader();
                        System.out.println("User Management");
                        underLine();
                        System.out.println("1. Create new User");
                        System.out.println("2. Delete User");
                        System.out.println("3. Search User");
                        System.out.println("4. Exit");
                        underLine();
                    }
                }

            } else if (option == 2) {
                removeUser();
            } else if (option == 3) {

                searchUser();
            } else if (option == 4) {

                break;

            } else {
                error();
            }
        }
    }

    private static void updateUser() {
        promptUser("Update User");
        String input = sc.nextLine();
        if (input.matches("ex")) {
            System.out.println("Cancelled");
        } else {
            try {
                User user = userHandler.read(Integer.valueOf(input));
                System.out.println("Enter");

            } catch (NumberFormatException e) {
                System.out.println(" ");
                System.out.println("Please enter a valid ID");
            }

        }
        timeout();
    }

    private static void removeUser() {
        promptUser("Delete User");
        String input = sc.nextLine();
        if (input.matches("ex")) {
            System.out.println("Cancelled");
        } else {
            try {
                System.out.println(userHandler.delete(userHandler.read(Integer.valueOf(input))));

            } catch (NumberFormatException e) {
                System.out.println(" ");
                System.out.println("Please enter a valid ID");
            }

        }
        timeout();
    }

    private static void timeout() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void promptUser(String prompt) {
        addHeader();
        System.out.println(prompt);
        underLine();
        System.out.println("Enter 'ex' to Exit");
        underLine();
        System.out.print("Enter User ID (Number): ");
        sc.nextLine();
    }

    private static void searchUser() {
        addHeader();
        System.out.println("Search User");
        boolean searching = true;
        while (searching) {
            underLine();
            System.out.print("* Type 'ex' to Exit *\n");
            underLine();
            System.out.print("Enter User Name: ");
            String input = sc.nextLine();
            if (input.matches("ex")) {
                searching = false;
            }

            userHandler.read(input);
        }
    }


    private static void updateInventory() {
        addHeader();
        System.out.println("Inventory");
        underLine();
        System.out.println("1. Add new Books");
        System.out.println("2. Search Books");
        underLine();
        int input = sc.nextInt();
        if(input == 1){
            addHeader();
            System.out.println("Insert New Books");
            underLine();
            System.out.println("Enter 'ex' to Exit");
            underLine();
            sc.nextLine();
            System.out.print("Enter Book ID, Book Name, ISBN, Author, Copies, Cost: ");

            List<String> bookDetails = Arrays.asList(sc.nextLine().split(","));
            bookHandler.create(new Books(Integer.valueOf(bookDetails.get(0)),bookDetails.get(1),bookDetails.get(2),bookDetails.get(3),Integer.valueOf(bookDetails.get(4)),Float.valueOf(bookDetails.get(5))));
            System.out.print("\033[H\033[2J");

        }else if(input==2){
            searchBooks();
        }

    }

    private static void issueBooks() {
        addHeader();
        promptUser("Issue Books");
        String userID = sc.nextLine();
        if (userID.matches("Ex")) {
            System.out.println("Cancelled");
        } else {
            try {
                User user = userHandler.read(Integer.valueOf(userID));
                if (user instanceof Student) {
                    System.out.print("Enter Book ID: ");
                    String bookID = sc.nextLine();
                    if (userID.matches("Ex")) {
                        System.out.println("Cancelled");
                    } else {
                        try {
                            boolean issuebooks = true;
                            Books books = bookHandler.read(Integer.valueOf(bookID));
                            List<Books> issuedBooks = ((Student) user).getIssuedBooks();
                            for (Books book : issuedBooks) {
                                if (book.getBookNumber() == Integer.valueOf(bookID)) {
                                    issuebooks = false;
                                }
                            }
                            if (issuebooks) {
                                if (books != null) {
                                    ((Student) user).setIssuedBooks(books);
                                    books.issued(user);
                                    userHandler.update(Integer.valueOf(userID), user);
                                    bookHandler.update(Integer.valueOf(bookID), books);
                                    System.out.println("Books Issued TO:");
                                    System.out.println(user);
                                    System.out.println(books);
                                    sc.nextLine();
                                } else {
                                    System.out.println("Books Not Found");
                                    timeout();
                                }

                            } else {
                                System.out.println("Book already Issued");
                                timeout();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a valid ID");
                        }
                    }


                } else {
                    System.out.println("Not Student");
                    timeout();
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid ID");
            }
        }
        underLine();
    }

    private static void addHeader() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n");
        System.out.println("Simple Library Management System");
        underLine();
    }

    private static void underLine() {
        System.out.println("_________________________________\n");

    }

}

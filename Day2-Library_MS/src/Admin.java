public class Admin extends User {
    Admin(String Username, String Email, String Password) {
        super(Username, Email, Password);
    }
    public void addBookToSystem(Library library, String ISBN, String Name, String Author, String Genre) {
        System.out.println("[ADMIN ACCESS GRANTED] " + getUsername() + " is adding a book.");
        library.addBook(ISBN, Name, Author, Genre);
    }
    public void removeBookFromSystem(Library library, String ISBN) {
        System.out.println("[ADMIN ACCESS GRANTED] " + getUsername() + " is removing a book.");
        library.removeBook(ISBN);
    }
    public void viewClientAccount(Client client) {
        System.out.println("Admin Inspection: " + client.getUsername() + "'s borrowed books:");
        client.viewBorrowed();
    }
    @Override
    public void viewRole() {
        System.out.println("Role: Admin");
    }
}
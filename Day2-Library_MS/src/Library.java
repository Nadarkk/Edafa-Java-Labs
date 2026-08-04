public class Library {
    private Book[] Books;
    private int count;

    public Library(int capacity){
        Books = new Book[capacity];
        count=0;
    }
    public void addBook(String ISBN, String Name, String Author, String Genre) {
        Book newbook = new Book(ISBN, Name, Author, Genre);
        if (count < Books.length) {
            Books[count] = newbook;
            count++;
            System.out.println("Book added: " + Name);}
        else System.out.println("Library is full");
    }
    public Book searchByIsbn(String ISBN) {
        for (int i = 0; i < count; i++) {
            if (Books[i].getISBN().equals(ISBN)) {
                System.out.println("Book found: " + Books[i].getName());
                return Books[i];
            }
        }
        System.out.println("Book not found: " + ISBN);
        return null;
    }
    public Book searchByName(String Name) {
        for (int i = 0; i < count; i++) {
            if (Books[i].getName().equals(Name)) {
                System.out.println("Book found: " + Name);
                return Books[i];
            }
        }
        System.out.println("Book not found: " + Name);
        return null;
    }
    public boolean searchByGenre(String Genre) {
        for (int i = 0; i < count; i++) {
            if (Books[i].getGenre().equals(Genre)) {
                System.out.println("Found these Books in " + Genre + ": ");
                Books[i].displayInfo();
                return true;
            }
        }
        System.out.println("No books found in " + Genre);
        return false;
    }
    public boolean searchByAuthor(String Author) {
        for (int i = 0; i < count; i++) {
            if (Books[i].getAuthor().equals(Author)) {
                System.out.println("Found these Books by " + Author + ": ");
                Books[i].displayInfo();
                return true;
            }
        }
        System.out.println("No books found by " + Author);
        return false;
    }
    public void removeBook(String ISBN) {
        boolean removed=false;
        for(int i=0; i<count; i++){
            if (Books[i].getISBN().equals(ISBN)) {
                if(Books[i].checkAvailable()){
                    System.out.println("Book removed: " + Books[i].getName());
                    for(int j=i; j<count-1; j++){
                        Books[j] = Books[j+1];
                    }
                    Books[--count] = null;
                    removed=true;
                    break;
                }else System.out.println("Book is currently borrowed and cannot be removed: " + Books[i].getName());
            }
        }
        if (!removed) {
            System.out.println("Book not found: " + ISBN);
        }
    }
    public boolean borrowBook(String ISBN, Client client) {
        if(searchByIsbn(ISBN)!=null){
            Book book=searchByIsbn(ISBN);
            if(book.checkAvailable()){
                if(client.borrowBook(book)) {
                    book.setAvailable(false);
                    System.out.println("You borrowed successfully: " + book.getName());
                    return true;
                }else System.out.println("You have reached the maximum number of borrowed books");
            }
            else System.out.println("Book is unavailable");
        }else System.out.println("Book not found");
        return false;
    }
    public boolean returnBook(String ISBN, Client client) {
        if (searchByIsbn(ISBN) == null) {
            System.out.println("Book not found");
            return false;
        }
        Book book = searchByIsbn(ISBN);
        if (book.checkAvailable()) {
            System.out.println("Book was not borrowed");
            return false;
        }
        for (int i = 0; i < client.getBorrowedCount(); i++) {
            if (client.returnBook(book)) {
                book.setAvailable(true);
                System.out.println("You returned the book successfully: " + book.getName());
                return true;
            }
            System.out.println("You didn't borrow this book");
            return false;
        }
        return false;
    }

}

public class Client extends User{
    private Book[] BorrowedBooks;
    private int BorrowedCount;
    Client(String Username, String Email, String Password) {
        super(Username, Email, Password);
        this.BorrowedBooks = new Book[10];
        this.BorrowedCount = 0;
    }

    public Book[] getBorrowedBooks() {
        return BorrowedBooks;
    }
    public int getBorrowedCount() {
        return BorrowedCount;
    }
    public boolean borrowBook(Book book) {
        if (BorrowedCount < BorrowedBooks.length) {
            BorrowedBooks[BorrowedCount] = book;
            BorrowedCount++;
            return true;
        }
        return false;
    }
    public boolean returnBook(Book book) {
        for (int i = 0; i < BorrowedCount; i++) {
            if (BorrowedBooks[i] == book) {
                for (int j = i; j < BorrowedCount - 1; j++) {
                    BorrowedBooks[j] = BorrowedBooks[j + 1];
                }
                BorrowedBooks[--BorrowedCount] = null;
                return true;
            }
        }
        return false;
    }
    public void viewBorrowed(){
        if (BorrowedCount==0){
            System.out.println("No borrowed books");
            return;
        }
        for (int i = 0; i < BorrowedCount; i++) {
            BorrowedBooks[i].displayInfo();
        }
    }
    @Override
    public void viewRole() {
        System.out.println("Role: Client");
    }
}

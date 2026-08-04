public class Book {
    private String ISBN;
    private String Name;
    private String Author;
    private String Genre;
    private Boolean Available;

    Book(String ISBN, String Name, String Author, String Genre){
        this.ISBN=ISBN;
        this.Name=Name;
        this.Author=Author;
        this.Genre=Genre;
        Available=true;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return Author;
    }

    public String getGenre() {
        return Genre;
    }

    public Boolean checkAvailable() {
        return Available;
    }
    public void setAvailable(Boolean available) {
        Available = available;
    }
    public void displayInfo(){
        System.out.println("ISBN: " + ISBN + ", Name: " + Name + ", Author: " + Author + ", Genre: " + Genre + ", Available: " + Available);
    }
}

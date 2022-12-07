package src;

public class BookData {
    private String title;
    private String author;
    private int reviews;
    private double total;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public int compareTo(BookData bookData) {
        double nowRating = Rating(this);
        double otherRating = Rating(bookData);
        double result = compare(nowRating, otherRating);
        if (result == 1){
            return this.title.compareTo(bookData.title);
        }
        return (int) result;
    }

    public double Rating(BookData bookData){
        return bookData.total / bookData.reviews;
    }

    private int compare(double rating1, double rating2){
        if(rating1 > rating2){
            return 2;
        } else if (rating1 == rating2) {
            return 0;
        } else {
            return 1;
        }
    }


}


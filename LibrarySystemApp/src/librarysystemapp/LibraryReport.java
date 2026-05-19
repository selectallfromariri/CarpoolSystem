/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemapp;

/**
 *
 * @author harir
 */
public class LibraryReport {

    private Book[] book;

    public LibraryReport(Book[] book) {
        this.book = book;
    }

    public Book[] getBook() {
        return book;
    }

    public void setBook(Book[] book) {
        this.book = book;
    }

    public void displayBookTypeSummary() {
        int countPrinted = 0;
        int countEbook = 0;
        for (int i = 0; i < book.length; i++) {
            if (book[i] instanceof PrintedBook) {
                countPrinted++;
            } else {
                countEbook++;
            }

        }
        System.out.println("==Book Type Summary Report==");
        System.out.println("Total printer books : " + countPrinted);
        System.out.println("Total Ebooks : " + countEbook);
    }

    public void DisplayDetailedTypeReport() {
        System.out.println("===Detailed Type Report ===");
        for (int i = 0; i < book.length; i++) {
            System.out.println("Book ID : " + book[i].getBookID());
            System.out.println("Title : " + book[i].getTitle());

            if (book[i] instanceof PrintedBook) {
                System.out.println("Type : Printed Book");
                PrintedBook pb = (PrintedBook) book[i];
                System.out.println("Page Count : " + pb.getPageCount());
                System.out.println("Reading Time : " + pb.estimateReadingtTime());

            } else {
                System.out.println("Type : Ebook");
                EBook eb = (EBook) book[i];
                System.out.println("File Size : " + eb.getFileSize() + "MB");

                if (eb.isLargeFile()) {
                    System.out.println("File Status : Large File");

                } else {
                    System.out.println("File Status : Normal FIle");

                }
            }

        }
    }

    public void displayFineCategoryReport(int days) {
        System.out.println("== Fine category Report ==");
        for (int i = 0; i < book.length; i++) {
            double fine = book[i].calcLateFee(days);
            fine++;
            System.out.println("Title : " + book[i].getTitle());
            System.out.println("Fine : " + fine);
            if (fine >= 10) {
                System.out.println("Category : High Fine");
            } else if (fine >= 5) {
                System.out.println("Category : Medium Fine");

            } else {
                System.out.println("Category : Low Fine");

            }
        }
    }

}

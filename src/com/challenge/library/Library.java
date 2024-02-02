package com.challenge.library;

import com.challenge.books.Book;
import com.challenge.person.Librarian;
import com.challenge.person.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private Map<String, List<Book>> bookCategories;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.bookCategories = new HashMap<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }
    public void newBook(Book book) {
        books.add(book);
        System.out.println("New book added to the library: " + book.getName());
    }


    public void lendBook(Book book, Reader reader) {
        if (books.contains(book)) {
            if (book.isStatus()) { //Book available mı check eder.
                book.updateStatus(false); // Kitap ödünç alındığından status false çeker.
                book.changeOwner(reader); //Kitap owner'ı reader'a setler.
                reader.borrowBook(book); //Reader'ın ödünç aldığı kitaplara ekler.
                System.out.println("Book lent to reader: " + reader.getName() + ", Book Title: " + book.getName());
            } else {
                System.out.println("Book is already lent.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }
    public void takeBackBook(Book book) {
        if (books.contains(book) && !book.isStatus()) { // Kitabın kütüphanede olup olmadığını checkle.
            Reader reader = (Reader) book.getOwner(); // Kitabın sahibini yazdırır.
            reader.returnBook(book); // Kitabı geri alır.
            book.updateStatus(true); // Kitabın durumunu setler.
            book.changeOwner(null); // Kitabın sahibini null setler.
            System.out.println("Book taken back from owner: " + reader.getName() + ", Book Title: " + book.getName());
        } else {
            System.out.println("Book not found or not currently lent.");
        }
    }


}

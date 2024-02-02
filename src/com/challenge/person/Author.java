package com.challenge.person;

import com.challenge.books.Book;
import com.challenge.ShowInfo;

import java.time.LocalDate;

public class Author extends Person implements ShowInfo {
    private Book writtenBook;

    public Author(String name, Book writtenBook) {
        super(name);
        this.writtenBook = writtenBook;
    }
//    public void newBook(int id, String name, double price, boolean status, int edition, LocalDate dateOfPurchase, String category) {
//        writtenBook = new Book(id, getName(), name, price, status, edition, dateOfPurchase, null, category);
//        System.out.println(getName() + " has written a new book: " + name);
//    }

    public void showBookInfo() {
        if (writtenBook != null) {
            writtenBook.showInfo();
        } else {
            System.out.println(getName() + " hasn't written any book yet.");
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am an author named " + getName());
    }
    @Override
    public void showInfo() {
        System.out.println("Author - Name: " + getName());
    }

}

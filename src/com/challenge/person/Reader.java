package com.challenge.person;

import com.challenge.books.Book;

public class Reader extends Person implements Comparable<Reader> {
    private Book borrowedBook;

    public Reader(String name) {
        super(name);
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }


    public Book getBorrowedBook() {
        return borrowedBook;
    }


    public void purchaseBook(Book book) {
        System.out.println(getName() + " purchases the book: " + book.getName());
    }

    public void borrowBook(Book book) {
        System.out.println(getName() + " borrows the book: " + book.getName());
        borrowedBook = book;
    }

    public void returnBook(Book book) {
        if (borrowedBook != null) {
            System.out.println(getName() + " returns the book: " + borrowedBook.getName());
            borrowedBook = null;
        } else {
            System.out.println(getName() + " has no book to return.");
        }
    }

    public void showBook() {
        if (borrowedBook != null) {
            System.out.println(getName() + " has the book: " + borrowedBook.getName());
        } else {
            System.out.println(getName() + " doesn't have any borrowed book.");
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a reader named " + getName());
    }

    public int compareTo(Reader o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
}

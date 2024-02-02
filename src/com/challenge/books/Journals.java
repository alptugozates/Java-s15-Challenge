package com.challenge.books;

import com.challenge.person.Person;

import java.time.LocalDate;

public class Journals extends Book {

    public Journals(int id, String author, String name, double price, boolean status, int edition, LocalDate dateOfPurchase, Person owner, String category) {
        super(id, author, name, price, status, edition, dateOfPurchase, owner, category);
    }

    @Override
    public void showInfo() {
        System.out.println("Journal - ID: " + getId() + ", Author: " + getAuthor() + ", Name: " + getName() +
                ", Price: " + getPrice() + ", Status: " + (isStatus() ? "Available" : "Not Available") +
                ", Edition: " + getEdition() + ", Date of Purchase: " + getDateOfPurchase() +
        ", Category: " + getCategory());
    }
}

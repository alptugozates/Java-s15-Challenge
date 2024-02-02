package com.challenge.books;

import com.challenge.ShowInfo;
import com.challenge.person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements ShowInfo, Comparable<Book> {
    private int id;
    private String author;
    private String name;
    private double price;
    private boolean status;
    private int edition;
    private LocalDate dateOfPurchase;
    private Person owner;
    private String category;

    public Book(int id, String author, String name, double price, boolean status, int edition, LocalDate dateOfPurchase, Person owner, String category) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.owner = owner;
        this.category = category;
    }

    public Person getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public int getEdition() {
        return edition;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }
    public void changeOwner(Person newOwner) {
        owner = newOwner;
        if (newOwner != null) {
            System.out.println("Book ownership changed. New owner: " + newOwner.getName());
        } else {
            System.out.println("Book returned. Ownership set to null.");
        }
    }
    public void updateStatus(boolean newStatus) {
        status = newStatus;
        System.out.println("Book status updated. New status: " + (newStatus ? "Available" : "Not Available"));
    }
    @Override
    public void showInfo() {
        System.out.println("Book - ID: " + id + ", Author: " + author + ", Name: " + name +
                ", Price: " + price + ", Status: " + (status ? "Available" : "Not Available") +
                ", Edition: " + edition + ", Date of Purchase: " + dateOfPurchase +
                ", Owner: " + (owner != null ? owner.getName() : "No owner assigned") +
                ", Category: " + category);
    }
    public void display() {
        showInfo();
    }

    public void setDateOfPurchase(LocalDate newDateOfPurchase) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Book o) {
        return name.compareToIgnoreCase(o.getName());
    }
}

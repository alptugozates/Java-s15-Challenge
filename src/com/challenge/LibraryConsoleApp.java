package com.challenge;

import com.challenge.books.Book;
import com.challenge.library.Library;
import com.challenge.person.Reader;

import java.time.LocalDate;
import java.util.*;

public class LibraryConsoleApp {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        addDefaultBooks();

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    searchAndSelectBook();
                case 3:
                    updateBookInfo();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    listBooksByCategory();
                    break;
                case 6:
                    listBooksByAuthor();
                    break;
                case 7:
                    lendBook();
                    break;
                case 8:
                    returnBook();
                    break;
                case 9:
                    printFatura();
                    break;
                case 10:
                    listReaders();
                    break;
                case 11:
                    registerReader();
                    break;
                case 12:
                    listBorrowedBooks();
                    break;
                case 0:
                    System.out.println("Programdan çıkılıyor.");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }
    private static void addDefaultBooks() {
        Set<Book> setBooks = new TreeSet<>();

        setBooks.add(new Book(6, "Author6", "Book6", 45.0, true, 2, LocalDate.now(), null, "StudyBooks"));
        setBooks.add(new Book(6, "Author6", "Book6", 45.0, true, 2, LocalDate.now(), null, "StudyBooks"));
        setBooks.add(new Book(4, "Author4", "Book4", 15.0, true, 3, LocalDate.now(), null, "Magazine"));
        setBooks.add(new Book(1, "Author1", "Book1", 20.0, true, 1, LocalDate.now(), null, "StudyBooks"));
        setBooks.add(new Book(2, "Author2", "Book2", 25.0, true, 2, LocalDate.now(), null, "Magazine"));
        setBooks.add(new Book(3, "Author3", "Book3", 30.0, true, 1, LocalDate.now(), null, "Journal"));
        setBooks.add(new Book(2, "Author2", "Book2", 25.0, true, 2, LocalDate.now(), null, "Magazine"));
        setBooks.add(new Book(5, "Author5", "Book5", 18.0, true, 2, LocalDate.now(), null, "Journal"));

        library.getBooks().addAll(setBooks);

    }

    private static void printMenu() {
        System.out.println("\n--- Kütüphane Yönetim Sistemi ---");
        System.out.println("1. Yeni Kitap Ekle");
        System.out.println("2. Kitap Ara ve Seç");
        System.out.println("3. Kitap Bilgilerini Güncelle");
        System.out.println("4. Kitap Sil");
        System.out.println("5. Kategoriye Göre Kitapları Listele");
        System.out.println("6. Yazarın Kitaplarını Listele");
        System.out.println("7. Kitap Ödünç Al");
        System.out.println("8. Kitap Geri Teslim Et");
        System.out.println("9. Fatura Görüntüle");
        System.out.println("10. Okuyucuları Listele");
        System.out.println("11. Yeni Okuyucu Kayıt");
        System.out.println("12. Okuyucunun Ödünç Aldığı Kitaplar");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminiz: ");
    }

    private static void addNewBook() {
        System.out.print("Kitap ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Kitap Adı: ");
        String name = scanner.nextLine();

        System.out.print("Yazar: ");
        String author = scanner.nextLine();

        System.out.print("Fiyat: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Durum (true: Mevcut, false: Alınmış): ");
        boolean status = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Baskı: ");
        int edition = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Alım Tarihi (YYYY-MM-DD): ");
        LocalDate dateOfPurchase = LocalDate.parse(scanner.nextLine());

        System.out.print("Kategori: ");
        String category = scanner.nextLine();

        Book newBook = new Book(id, author, name, price, status, edition, dateOfPurchase, null, category );
        library.newBook(newBook);
    }

    private static Book searchAndSelectBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kitap arama ve seçme işlemi:");
        System.out.print("Kitap adını, yazarını veya ID'sini girin: ");
        String searchCriteria = scanner.nextLine();

        for (Book book : library.getBooks()) {
            if (book.getName().equalsIgnoreCase(searchCriteria) ||
                    book.getAuthor().equalsIgnoreCase(searchCriteria) ||
                    String.valueOf(book.getId()).equalsIgnoreCase(searchCriteria)) {
                System.out.println("Kitap bulundu:");
                book.display();
                return book;
            }
        }

        System.out.println("Kitap bulunamadı.");
        return null;
    }

    private static void updateBookInfo() {
        Book selectedBook = searchAndSelectBook();

        if (selectedBook != null) {
            System.out.println("Kitap bilgilerini güncelleme:");
            System.out.print("Yeni Kitap Adı: ");
            String newName = scanner.nextLine();

            System.out.print("Yeni Yazar: ");
            String newAuthor = scanner.nextLine();

            System.out.print("Yeni Fiyat: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Yeni Durum (true: Mevcut, false: Alınmış): ");
            boolean newStatus = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("Yeni Baskı: ");
            int newEdition = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Yeni Alım Tarihi (YYYY-MM-DD): ");
            LocalDate newDateOfPurchase = LocalDate.parse(scanner.nextLine());

            selectedBook.setName(newName);
            selectedBook.setAuthor(newAuthor);
            selectedBook.setPrice(newPrice);
            selectedBook.updateStatus(newStatus);
            selectedBook.setEdition(newEdition);
            selectedBook.setDateOfPurchase(newDateOfPurchase);

            System.out.println("Kitap bilgileri başarıyla güncellendi.");
        }
    }

    private static void deleteBook() {
        Book selectedBook = searchAndSelectBook();

        if (selectedBook != null) {
            System.out.print("Kitabı silmek istediğinize emin misiniz? (E/H): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("E")) {
                library.getBooks().remove(selectedBook);
                System.out.println("Kitap başarıyla silindi.");
            } else {
                System.out.println("Kitap silme işlemi iptal edildi.");
            }
        }
    }

    private static void listBooksByCategory() {
        System.out.print("Kategori adını girin: ");
        String category = scanner.nextLine();

        boolean categoryFound = false;

        for (Book book : library.getBooks()) {
            if (book.getCategory() != null && book.getCategory().equalsIgnoreCase(category)) {
                if (!categoryFound) {
                    System.out.println("Kategoriye Göre Kitaplar:");
                    categoryFound = true;
                }
                book.display();
            }
        }

        if (!categoryFound) {
            System.out.println("Belirtilen kategoride kitap bulunamadı.");
        }
    }

    private static void listBooksByAuthor() {
        System.out.print("Yazarın adını girin: ");
        String authorName = scanner.nextLine();

        boolean authorFound = false;

        for (Book book : library.getBooks()) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                if (!authorFound) {
                    System.out.println("Yazarın Kitapları:");
                    authorFound = true;
                }
                book.display();
            }
        }

        if (!authorFound) {
            System.out.println("Belirtilen yazarın kitapları bulunamadı.");
        }
    }

    private static void lendBook() {
        Book selectedBook = searchAndSelectBook();

        if (selectedBook != null) {
            if (selectedBook.isStatus()) {
                System.out.print("Ödünç almak isteyen okuyucunun adını girin: ");
                String readerName = scanner.nextLine();

                Reader reader = findReader(readerName);

                if (reader != null) {
                    library.lendBook(selectedBook, reader);
                } else {
                    System.out.println("Okuyucu bulunamadı.");
                }
            } else {
                System.out.println("Kitap zaten ödünç alınmış.");
            }
        }
    }

    private static Reader findReader(String readerName) {
        for (Reader reader : library.getReaders()) {
            if (reader.getName().equalsIgnoreCase(readerName)) {
                return reader;
            }
        }
        return null;
    }

    private static void returnBook() {
        Book selectedBook = searchAndSelectBook();

        if (selectedBook != null && !selectedBook.isStatus()) {
            Reader currentOwner = (Reader) selectedBook.getOwner();

            System.out.println("Kitap iade işlemi:");
            System.out.print("İade eden okuyucunun adını girin: ");
            String readerName = scanner.nextLine();

            if (currentOwner != null && currentOwner.getName().equalsIgnoreCase(readerName)) {
                library.takeBackBook(selectedBook);
            } else {
                System.out.println("Kitabı sadece ödünç alan okuyucu iade edebilir.");
            }
        } else {
            System.out.println("Kitap bulunamadı veya zaten kütüphanede.");
        }
    }
    private static void registerReader() {
        System.out.print("Okuyucu adını girin: ");
        String readerName = scanner.nextLine();


        Reader existingReader = findReader(readerName);

        if (existingReader != null) {
            System.out.println("Bu isimde bir okuyucu zaten kayıtlı.");
        } else {

            Reader newReader = new Reader(readerName);
            library.getReaders().add(newReader);
            System.out.println("Yeni okuyucu kaydedildi: " + newReader.getName());
        }
    }

    private static void printFatura() {
        System.out.println("---- Fatura ----");

        System.out.println("Kitaplar:");
        for (Book book : library.getBooks()) {
            System.out.println("ID: " + book.getId() + ", Kitap Adı: " + book.getName() +
                    ", Fiyat: " + book.getPrice() +
                    ", Satın Alınan Tarih: " + book.getDateOfPurchase() +
                    ", Sahip: " + (book.getOwner() != null ? book.getOwner().getName() : "Kütüphane"));
        }

        System.out.println("---- Fatura Sonu ----");
    }

    private static void listReaders() {
        Set<Reader> readers = new TreeSet<>(library.getReaders());
        if (readers.isEmpty()) {
            System.out.println("Kütüphanede kayıtlı okuyucu bulunmamaktadır.");
        } else {
            System.out.println("Kütüphanede Kayıtlı Okuyucular:");
            for (Reader reader : readers) {
                System.out.println("- " + reader.getName());
            }
        }
    }
    private static void listBorrowedBooks() {
        System.out.print("Okuyucunun adını girin: ");
        String readerName = scanner.nextLine();

        Reader reader = findReader(readerName);

        if (reader != null) {
            System.out.println(reader.getName() + " tarafından ödünç alınan kitaplar:");

            if (reader.getBorrowedBook() != null) {
                reader.showBook();
            } else {
                System.out.println("Okuyucunun ödünç aldığı kitap bulunmamaktadır.");
            }
        } else {
            System.out.println("Okuyucu bulunamadı.");
        }
    }

}
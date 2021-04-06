package ru.job4j.pojo;

public class Library {
    public static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book " + books[i].getName() + " with " + books[i].getPages() + " pages");
        }
    }

    public static void main(String[] args) {
        Book one = new Book("Apocalypse", 300);
        Book two = new Book("Prestuplenie i nakazanie", 650);
        Book three = new Book("Clean code", 400);
        Book four = new Book("War and peace", 4000);

        Book[] books = {one, two, three, four};

        printBooks(books);

        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;

        printBooks(books);

        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println("Book " + books[i].getName() + " with " + books[i].getPages() + " pages");
            }
        }
    }
}

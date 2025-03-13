package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;

@Data
@AllArgsConstructor
public class Library {
    private String name;
    private Map<String, Book> bookByIsbn;
    private List<Customer> customers;
    private TreeSet<BookLend> bookLends;

    public List<Book> getBooksByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookByIsbn.values()) {
            if (book.getGenres().contains(genre)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Customer> getCustomersbyZipCode(int zipCode) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getZipCode() == zipCode) {
                result.add(customer);
            }
        }
        return result;
    }

    public void createBookLend(String nif, String isbn) {
        BookLend bookLend = new BookLend(isbn, LocalDate.now(), nif);
        bookLends.add(bookLend);
    }

    public boolean removeGenre(String isbn, String genre) {
        if (bookByIsbn.containsKey(isbn)) {
            Book book = bookByIsbn.get(isbn);
            return book.getGenres().remove(genre);
        } else {
            return false;
        }
    }

    public boolean customerBorrowedBook(String isbn, int customerNumber){
        String nif = null;
        for (Customer customer : customers) {
            if (customer.getCustomerNumber() == customerNumber) {
                nif = customer.getNif();
            }
        }
        if (nif == null) {
            return false;
        }

        for (BookLend bookLend : bookLends) {
            if (bookLend.getIsbn().equals(isbn) && bookLend.getNif().equals(nif)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> getBookGenresByIsbn(String isbn) {
        if (bookByIsbn.containsKey(isbn)) {
            return bookByIsbn.get(isbn).getGenres();
        } else {
            return null;
        }
    }

    public List<BookLend> getBookLendsByIsbn(String isbn) {
        if (bookByIsbn.containsKey(isbn)) {
            List<BookLend> lends = new ArrayList<>();
            for (BookLend lend : bookLends) {
                if (lend.getIsbn().equals(isbn)) {
                    lends.add(lend);
                }
            }
            return lends;
        }
        return null;
    }
}

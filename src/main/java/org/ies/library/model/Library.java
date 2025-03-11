package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

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

    public List<Customer> getCustomersbyZipCode (int zipCode){
        List<Customer> result = new ArrayList<>();
        for(Customer customer: customers){
            if(customer.getZipCode()==zipCode){
                result.add(customer);
            }
        }
        return result;
    }

    public void createBookLend(String nif, String isbn) {


    }
}

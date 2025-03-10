package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class BookLend implements Comparable <BookLend> {
    private String isbn;
    private String date;
    private String nif;

    @Override
    public int compareTo(BookLend bookLend) {
        int compare = this.date.compareTo(bookLend.getDate());
        if(compare == 0){
           compare = this.isbn.compareTo(bookLend.getIsbn());
            if(compare == 0){
                compare = this.nif.compareTo(bookLend.getNif());
            }
        }
        return compare;
    }
}

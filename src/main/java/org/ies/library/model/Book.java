package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String tittle;
    private String author;
    private Set<String> genres;
}

package com.example.dsafinal.model;

// imports
import jakarta.persistence.*;
import lombok.*;  // Import Lombok annotations

/**
 * TreeEntity stores BST data, and is mapped to a database through the use of JPA annotations (anything with the @ symbol)
 */
@Entity
@Data // // forgot i had lombok setup so this class got so much smaller lol
public class TreeEntity {

    @Id // auto-generate the id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // @Lob is used both times here for when input strings become longer than expected, helps to handle them better
    private String inputNums;

    @Lob
    private String treeJson;
}
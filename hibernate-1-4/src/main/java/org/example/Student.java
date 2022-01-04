package org.example;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer studentId;

    private String name;

    private String email;

//    private Set<Book> books;
}

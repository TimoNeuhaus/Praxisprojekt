package com.springbootstart;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Person {

    @Id
    @SequenceGenerator(
            name = "person_id_sequence",
            sequenceName = "person_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_id_sequence"
    )
    private Integer id;
    private String name;
    private String description;
    private String ImagePath;
    private String details;

    public Person(Integer id, String name, String description, String imagePath, String details) {
        this.id = id;
        this.name = name;
        this.description = description;
        ImagePath = imagePath;
        this.details = details;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(description, person.description) && Objects.equals(ImagePath, person.ImagePath) && Objects.equals(details, person.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, ImagePath, details);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ImagePath='" + ImagePath + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}




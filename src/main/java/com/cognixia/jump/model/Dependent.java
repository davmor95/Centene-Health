package com.cognixia.jump.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Model for Dependent
 * @author David Morales
 * @version v1 (10/14/20)
 */

@Document(collection = "dependent")
public class Dependent implements Serializable {
    private static final long serialVersionUID = -4458870115303573931L;
    @Transient
    public static final String SEQUENCE_NAME = "dependent_sequence";

    @Id
    private Long id;
    private String name;
    private String birthDate;

    /**
     * The default constructor
     */

    public Dependent() {
        this( "N/A", "N/A");
    }

    /**
     * Overloaded constructor
     * @param name
     * @param birthDate
     */

    public Dependent(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     * Retrieve the id of the dependent
     * @return Long - id
     */

    public Long getId() {
        return id;
    }

    /**
     * Update the id of the dependent
     * @param id
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieve the dependent name name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Update the dependent name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the DOB of the dependent
     * @return
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Update the birthDate of the dependent
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}

package com.cognixia.jump.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Model for Users
 * @author David Morales
 * @version v2 (10/14/20)
 */
@Document(collection = "users")
public class User implements Serializable {
    private static final long serialVersionUID = -4458870115303573931L;

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    public enum Role {
        ROLE_USER, ROLE_ADMIN
    }

    @Id
    private Long id;
    private String name;
    private Role userRole;

    /**
     * The default constructor.
     * @author David Morales
     */
    public User() {
        this( "N/A", Role.ROLE_USER);
    }

    /**
     * Overloaded Constructor
     * @param name the name of the user.
     * @param userRole the role determines which priviledges are granted.
     */
    public User( String name, Role userRole) {

        this.name = name;
        this.userRole = userRole;
    }

    /**
     * Retrieves the user id
     * @return Long - userId
     */

    public Long getId() {
        return id;
    }

    /**
     * Updates the user id
     * @param id must provide the desire id to update
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the user's name
     * @return String - user's name
     */

    public String getName() {
        return name;
    }

    /**
     * Updates the user's name
     * @param name must provide the desire name to update
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the type of role the user is
     * @return Role - user's role
     */

    public Role getUserRole() {
        return userRole;
    }

    /**
     * Change the user's role either from ADMIN to USER or vice versa
     * @param userRole must state whether its ROLE_ADMIN or ROLE_USER
     */

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}

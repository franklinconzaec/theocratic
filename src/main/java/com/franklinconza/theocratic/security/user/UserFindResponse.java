package com.franklinconza.theocratic.security.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserFindResponse {

    @Id
    private int id;
    private String name;
}

package com.example.crudf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="project_tables")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name="first_name")
    private String firstName;

@Column(name="last_name")
    private String lastName;

@Column(name="habit")
    private String habit;





public Friend() {
	super();
	// TODO Auto-generated constructor stub
}

public Friend(Long id, String firstName, String lastName, String habit) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.habit = habit;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getHabit() {
	return habit;
}

public void setHabit(String habit) {
	this.habit = habit;
}

    


}

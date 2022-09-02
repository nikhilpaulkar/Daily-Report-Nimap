package com.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Where(clause="isactive=true")
@SQLDelete(sql="UPDATE STUDENT SET isactive=false WHERE id=?")
@Table(name="student")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;
 private String city;
 private  Boolean isactive =true;

public boolean isIsactive() {
	return isactive;
}
public void setIsactive(boolean isactive) {
	this.isactive = isactive;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

public Student() {
	super();

}

public Student(int id, String name, String city, Boolean isactive) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
   this.isactive = isactive;
}
}




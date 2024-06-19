package com.se.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	@NotEmpty(message = "khong duoc rong")
	@Pattern(regexp = "^[A-Z][a-zà-ỹ]+( [A-Z][a-zà-ỹ]+)+$",message = "kkkk")
	private String name;
	@NotNull(message = "khong duoc rong")
	@Min(value = 1)
	private int age;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	

}

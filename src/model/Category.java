package model;

import java.util.ArrayList;

public class Category {
	private String name;
	ArrayList<Emprendedor> emprendedores;

	public ArrayList<Emprendedor> getEmprendedores() {
		return emprendedores;
	}

	public void setEmprendedores(ArrayList<Emprendedor> emprendedores) {
		this.emprendedores = emprendedores;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}
	
}

package model;

import java.util.ArrayList;

//import javax.naming.InvalidNameException;


public class Emprendedor {
	private ArrayList<Product> products;
	private String name;
	private String empName;
	private String number;
	private ArrayList<Category> categories;
	private boolean activo;
	public Emprendedor(String n, String e, String nu, boolean a) {
		products = new ArrayList<>();
		setCategories(new ArrayList<>());
		name = n;
		setActivo(a);
		empName = e;
	}
	
	public String addCategory(String n) {
		String msg = "";
		return msg;
	}
	
	public String addProduct(String n, int p) throws Exception {
		String msg = "";
		if (n.isBlank())
			msg = "Por favor, introduzca un nombre valido";
			//throw new InvalidNameException("Por favor, introduzca un nombre valido");
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(n))
				msg = "El nombre " + n + " ya es uno de sus productos";
				//throw new InvalidNameException("El nombre " + n + " ya es uno de sus productos");
		}
		if (p <= 0) 
			msg = "El valor del producto es invalido";
			//throw new Exception("El valor del producto es invalido");
		if (msg.isEmpty()) {
			products.add(new Product(n, p));
			msg = "El producto ha sido agregado";
		}
		return msg;
			
		
	}
	
	public String removeProduct(int pos) {
		pos--;
		products.remove(pos);
		return "El producto ha sido eliminado";
	}
	
	public String showProducts() {
		String msg = "";
		for (int i = 0; i < products.size(); i++) {
			int pos = i + 1;
			msg += pos + ". " + products.get(i).getName() + "\t $" + products.get(i).getPrice() + "\n";
		}
		return msg;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	
	
}

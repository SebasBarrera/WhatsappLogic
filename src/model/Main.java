package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private ArrayList<Emprendedor> emprendedores;
	private ArrayList<Category> categories;
	private Emprendedor e;
	private Scanner scan = new Scanner(System.in);
	private Scanner strScan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.dataDummie();
		m.start();
	}

	private void dataDummie() throws Exception {
		categories = new ArrayList<>();
		categories.add(new Category("Sandwich"));
		categories.add(new Category("Bebidas"));
		categories.add(new Category("Fit"));
		categories.add(new Category("Dulce"));
		categories.add(new Category("Stickers"));


		emprendedores = new ArrayList<>();

		Emprendedor e = new Emprendedor("Juan", "Cubanitos", "3214650140", true);
		e.addProduct("Cubanito", 3000);
		e.addProduct("Cubanito XL", 4000);
		e.addProduct("Super Cubanito XL", 5000);
		e.addProduct("Cocacola", 3000);
		e.addProduct("Juguito Hit", 2000);
		ArrayList<Category> c = new ArrayList<>();
		c.add(categories.get(0));
		c.add(categories.get(1));
		e.setCategories(c);
		emprendedores.add(e);

		Emprendedor e1 = new Emprendedor("Laura", "Fitness", "3128556670", true);
		e1.addProduct("Sandwich Fit", 7000);
		e1.addProduct("Dulce 0 Calorias", 4000);
		e1.addProduct("Barra Energetica", 5000);
		e1.addProduct("Jugo natural", 10000);
		ArrayList<Category> c1 = new ArrayList<>();
		c1.add(categories.get(0));
		c1.add(categories.get(1));
		c1.add(categories.get(2));
		c1.add(categories.get(3));
		e1.setCategories(c1);
		emprendedores.add(e1);

		Emprendedor e2 = new Emprendedor("Esteban", "Ñam", "3211320410", true);
		e2.addProduct("Ñam de cordero", 6000);
		e2.addProduct("Ñam de pollo", 6000);
		e2.addProduct("Ñam de cerdo", 6000);
		e2.addProduct("Ñam de Roastbeef", 6000);
		ArrayList<Category> c2 = new ArrayList<>();
		c2.add(categories.get(0));
		e2.setCategories(c2);
		emprendedores.add(e2);

		Emprendedor e3 = new Emprendedor("Laura", "Fitness", "3129782575", true);
		e3.addProduct("Stickers de todos los motivos", 1000);
		ArrayList<Category> c3 = new ArrayList<>();
		c3.add(categories.get(4));
		e3.setCategories(c3);
		emprendedores.add(e3);
	}
	

	public void start() {
		scan.nextInt();
		boolean nuevo = true;
		if (e == null) {
			System.out.println(" ¡Hola!  Bienvenido a La Red de Emprendedores\r\n"
					+ "Soy tu chat bot preferido");
			System.out.println("Vemos que aun no estas registrado, tomaremos tus datos a continuación");

		} else {
			System.out.println(" ¡Hola!  Bienvenido a La Red de Emprendedores\r\n"
					+ "Soy tu chat bot preferido");
			nuevo = false;
		}
			
		
		System.out.println(  "Por favor escribe el número de la opción que desees para poder atenderte:\r\n"
				+ "1. Ver emprendimiento disponible\r\n"
				+ "2. Ver categorias disponibles \r\n"
				+ "3. ¿Eres un emprendedor?\r\n"
				+ "4. Pregunta, Queja, Reclamo, Sugerencia\r\n"
				+ "Al continuar, estas aceptando nuestras Políticas de Tratamientos de Datos y Términos y Condiciones");
		primerFlujo(nuevo);


	}
	public void primerFlujo(boolean esNuevo) {
		int opc = scan.nextInt();
		switch (opc) {
		case 1:
			showEmprendimientos(null);
			break;
		case 2:
			showCategorias();
			break;
		case 3:
			emprendedor(esNuevo);
			break;
		case 4:
			pqrs();
			break;
		case 5:
			
			break;

		default:
			System.out.println("Por favor, selecciona una opción valida");
			primerFlujo(true);
			break;
		}
	}

	private void showEmprendimientos(Category c) {
		ArrayList<Emprendedor> em = emprendedores;
		if (c != null)
			em = c.getEmprendedores();
		System.out.println();
		int inicial = 1;
		int max = inicial + 7;	
		int out = max + 1;
		boolean seleccionado = false;
		while(!seleccionado)	{	
			for (int i = inicial; i < em.size() && i <= max; i++) {
				System.out.println(i + ". " + em.get(i-1));
				
			}
			System.out.println("\n0. Volver al menu principal");
			if (max >= em.size())
				System.out.println(out + ". Mostrar más emprendedores");
			System.out.println("Por favor escoge una opción");
			
			int opc = scan.nextInt();
			
			if (opc == 0) {
				start();
			} else if (opc == out) {
				inicial = max + 1;
				max = inicial + 7;
				out = max + 1;
			} else if ( opc <= max) {
				showProductosEmprendedor(opc-1);
				seleccionado = true;
			}  else {
				System.out.println("Opción invalida, a la proxima por favor escoge una opción de las presentadas");
				start();
			}
		}
		
	}

	private void showProductosEmprendedor(int emprendedor) {
		String msg = "Listado de productos: \n";
		int precioTotal = 0;
		Emprendedor e = emprendedores.get(emprendedor);
		ArrayList<Product> products = e.getProducts();
		int inicial = 1;
		int max = inicial + 7;	
		int out = max + 1;
		boolean seleccionado = false;
		while(!seleccionado)	{	
			for (int i = inicial; i < products.size() && i <= max; i++) {
				System.out.println(i + ". " + products.get(i-1).getName() + "\n		$$$" + products.get(i-1).getPrice());
				
			}
			System.out.println("\n0. Volver al menu principal");
			if (max >= products.size())
				System.out.println(out+". Mostrar más productos");
			System.out.println("Por favor escoge una opción");
			
			int opc = scan.nextInt();
			
			if (opc == 0) {
				start();
			} else if (opc == out ) {
				inicial = max + 1;
				max = inicial + 7;
				out = max +1;
			} else if ( opc <= max) {
				System.out.println("¿Cuantos "+products.get(opc-1).getName()+" deseas?");
				int cuantos = scan.nextInt();
				if (cuantos != 0 && cuantos <= 20) {
					precioTotal+= products.get(opc-1).getPrice() * cuantos;
					msg += "\n"+products.get(opc-1).getName()+"...$ "+products.get(opc-1).getPrice() + ", Cantidad: "+ cuantos + "\n";
					System.out.println(msg);
					System.out.println("Precio total: $"+precioTotal);
					System.out.println("¿Deseas agregar más productos a tu pedido?");
					System.out.println("1. Si");
					System.out.println("2. No");
					int mas = scan.nextInt();
					if (mas == 2) {
						seleccionado = true;
					} else if (mas ==1) {
						System.out.println("Por favor, confirmanos tu numero de contacto");
						String num = strScan.nextLine();
						
						System.out.println("Perfecto, nuestro emprendedor "+e.getName()+" de "+e.getEmpName()+" con numero de celular "+e.getNumber()+", se comunicara contigo para concretar el pedido");
						//TODO enviar mensaje al emprendedor
						String msgToEmprendedor = "Un cliente con numero de celular: "+ num + "ha pedido: \n" + msg;
					}
				} else {
					System.out.println("Opción invalida, a la proxima por favor escoge entre 0 y 20 productos");
				}
			}  else {
				System.out.println("Opción invalida, a la proxima por favor escoge una opción de las presentadas");
				start();
			}
		}
		
		
		
	}

	private void showCategorias() {
		int inicial = 1;
		int max = inicial + 7;	
		int out = max + 1;
		boolean seleccionado = false;
		while(!seleccionado)	{	
			for (int i = inicial; i < categories.size() && i <= max; i++) {
				System.out.println(i + ". " + categories.get(i-1));
				
			}
			System.out.println("\n0. Volver al menu principal");
			if (max >= categories.size())
				System.out.println(out + ". Mostrar más categorias");
			System.out.println("Por favor escoge una opción");
			
			int opc = scan.nextInt();
			
			if (opc == 0) {
				start();
			} else if (opc == out) {
				inicial = max + 1;
				max = inicial + 7;
				out = max + 1;
			} else if ( opc <= max) {
				showEmprendimientos(categories.get(opc-1));
				seleccionado = true;
			}  else {
				System.out.println("Opción invalida, a la proxima por favor escoge una opción de las presentadas");
				start();
			}
		}
	}

	private void emprendedor(boolean esNuevo) {
		// TODO Auto-generated method stub
		
	}

	private void pqrs() {
		// TODO Auto-generated method stub
		
	}
}

package application;

import java.util.Date;

import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Departamento dep = new Departamento(1, "Livros");
		
		Vendedor vendedor = new Vendedor(1, "eudes", "eudes@eudes", new Date(), 3000.0, dep);
		System.out.println(vendedor);

	}

}

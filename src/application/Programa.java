package application;


import java.util.List;

import modelo.dao.DaoFabrica;
import modelo.dao.Vendedordao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("TESTE = 1");
		Vendedordao vendedordao = DaoFabrica.createVendadordao();	
		Vendedor vendedor = vendedordao.find(1);	
		System.out.println(vendedor);
		
		System.out.println();
		System.out.println("TESTE = 2");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedordao.findByDepartamento(departamento);
		for (Vendedor ven : lista) {
			System.out.println(ven);
			
		}
		
		System.out.println();
		System.out.println("TESTE = 3");
		lista  = vendedordao.lista();
		for (Vendedor ven : lista) {
			System.out.println(ven);
			
		}

	}

}

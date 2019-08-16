package application;

import java.util.Date;

import modelo.dao.DaoFabrica;
import modelo.dao.Vendedordao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Vendedordao vendedordao = DaoFabrica.createVendadordao();
		
		Vendedor vendedor = vendedordao.find(1);
		
		
		System.out.println(vendedor);

	}

}

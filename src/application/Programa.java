package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelo.dao.DaoFabrica;
import modelo.dao.Vendedordao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		

		System.out.println("TESTE = 1");
		Vendedordao vendedordao = DaoFabrica.createVendadordao();	
		Vendedor vendedor = vendedordao.find(1);	
		System.out.println(vendedor);
		
		System.out.println();
		System.out.println("TESTE = 2");
		Departamento dep = new Departamento(2, null);
		List<Vendedor> lista = vendedordao.findByDepartamento(dep);
		for (Vendedor ven : lista) {
			System.out.println(ven);
			
		}
		
		System.out.println();
		System.out.println("TESTE = 3, SELECT");
		lista  = vendedordao.lista();
		for (Vendedor ven : lista) {
			System.out.println(ven);
			
		}
		
		System.out.println();
		System.out.println("TESTE = 4, INSERT");
		System.out.print("Nome: ");
		String nome = entrada.nextLine();
		System.out.print("Email: ");
		String email = entrada.nextLine();
		System.out.print("Data: ");
		java.util.Date fdata = data.parse(entrada.next());
		System.out.print("Salario: ");
		Double salario = entrada.nextDouble();
		Vendedor vend = new Vendedor(null, nome, email, fdata, salario, dep);
		vendedordao.insert(vend);
		System.out.println("dados inseridos com Sucesso " + vend.getId()); 	
		
		System.out.println();
		System.out.println("TESTE = 5, UPTADE");
		System.out.print("ID: ");
		int id = entrada.nextInt();
		vendedor = vendedordao.find(id);
		entrada.nextLine();
		System.out.print("Nome: ");
		nome = entrada.nextLine();
		vendedor.setNome(nome);
		vendedordao.update(vendedor);
		System.out.println("Uptade completo " + vendedor.getNome());
		
		System.out.println();
		System.out.println("TESTE = 6, DELETE");
		System.out.print("Digite ID: ");
		int p = entrada.nextInt();
		vendedordao.delete(p);
		System.out.println("DELETADO " + p);

		entrada.close();
		
		
	}

}

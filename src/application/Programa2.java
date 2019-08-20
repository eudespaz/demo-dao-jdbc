package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelo.dao.DaoFabrica;
import modelo.dao.DepartmentDao;
import modelo.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFabrica.createDepartmentDao();

		System.out.println();
		System.out.println("TESTE = 0");
		List<Departamento> lista = departmentDao.lista();
		for (Departamento dep : lista) {
			System.out.println(dep);
		}

		System.out.println();
		System.out.println("TESTE = 1, INSERT");
		System.out.print("Nome: ");
		String nome = entrada.nextLine();
		Departamento departamento = new Departamento(null, nome);
		departmentDao.insert(departamento);
		System.out.println("Departamento criado " + departamento.getNome());

		System.out.println();
		System.out.println("TESTE = 2, UPDATE ");
		System.out.print("ID: ");
		int id = entrada.nextInt();
		Departamento dep2 = departmentDao.find(id);
		entrada.nextLine();
		System.out.print("Nome: ");
		nome = entrada.nextLine();
		dep2.setNome(nome);
		departmentDao.update(dep2);
		System.out.println("Update " + dep2.getNome());

		System.out.println();
		System.out.println("TESTE = 6, DELETE");
		System.out.print("Digite ID: ");
		id = entrada.nextInt();
		departmentDao.delete(id);
		System.out.println("DELETADO " + departamento.getId());

		entrada.close();

	}

}

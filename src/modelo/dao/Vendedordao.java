package modelo.dao;

import java.util.List;

import modelo.entidades.Vendedor;

public interface Vendedordao {

	void insert(Vendedor vendedor);
	void update(Vendedor vendedor);
	void delete(Integer id);
	Vendedor find(Integer id);
	List<Vendedor> lista();
	
}

package modelo.dao;

import modelo.dao.implem.VendedorDaoJDBC;

public class DaoFabrica {
	
	public static Vendedordao createVendadordao() {
		return new VendedorDaoJDBC();
	}

}

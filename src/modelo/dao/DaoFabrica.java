package modelo.dao;

import db.DB;
import modelo.dao.implem.VendedorDaoJDBC;

public class DaoFabrica {
	
	public static Vendedordao createVendadordao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}

}

package modelo.dao.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DbExcecao;
import modelo.dao.Vendedordao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJDBC implements Vendedordao {
	
	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
		
	}

	@Override
	public void insert(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor find(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.nome as depnome "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.departamentoid = departamento.id "
					+ "WHERE departamentoid = ? ");
			
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("departamentoid"));
				dep.setNome(rs.getString("DepNome"));
				Vendedor ven = new Vendedor();
				ven.setId(rs.getInt("id"));
				ven.setNome(rs.getString("nome"));
				ven.setEmail(rs.getString("email"));
				ven.setSalario(rs.getDouble("salario"));
				ven.setData(rs.getDate("data"));
				ven.setDepartamento(dep);
				return ven;			
			}
			return null;
			
		 } catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}
		
	}

	@Override
	public List<Vendedor> lista() {
		// TODO Auto-generated method stub
		return null;
	}

}

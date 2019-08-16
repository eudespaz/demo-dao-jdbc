package modelo.dao.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				Departamento dep = instantiateDepartamento(rs);
				Vendedor ven = instantiateVendedor(rs, dep);
				return ven;			
			}
			return null;
			
		 } catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}
		
	}

	private Vendedor instantiateVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor ven = new Vendedor();
		ven.setId(rs.getInt("id"));
		ven.setNome(rs.getString("nome"));
		ven.setEmail(rs.getString("email"));
		ven.setSalario(rs.getDouble("salario"));
		ven.setData(rs.getDate("data"));
		ven.setDepartamento(dep);
		return ven;
	}

	private Departamento instantiateDepartamento(ResultSet rs) throws SQLException {
		 	Departamento dep = new Departamento();
			dep.setId(rs.getInt("departamentoid"));
			dep.setNome(rs.getString("DepNome"));
			return dep;
	}

	@Override
	public List<Vendedor> lista() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.nome as depnome "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.departamentoid = departamento.id "
					+ "ORDER BY nome");
		
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("departamentoid"));
				if (dep == null) {
					dep = instantiateDepartamento(rs);
					map.put(rs.getInt("departamentoid"), dep);
					
				}
				
				Vendedor ven = instantiateVendedor(rs, dep);
				list.add(ven);
				
				
			}
			return list;
			
		 } catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}

	}

	@Override
	public List<Vendedor> findByDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.nome as depnome "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.departamentoid = departamento.id "
					+ "WHERE departamentoid = ? "
					+ "ORDER BY nome");
			
			st.setInt(1, departamento.getId());
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("departamentoid"));
				if (dep == null) {
					dep = instantiateDepartamento(rs);
					map.put(rs.getInt("departamentoid"), dep);
					
				}
				
				Vendedor ven = instantiateVendedor(rs, dep);
				list.add(ven);
				
				
			}
			return list;
			
		 } catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}

		
	}

}

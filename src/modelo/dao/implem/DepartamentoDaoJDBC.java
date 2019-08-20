package modelo.dao.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Statement;

import db.DB;
import db.DbExcecao;
import modelo.dao.DepartmentDao;
import modelo.entidades.Departamento;

public class DepartamentoDaoJDBC implements DepartmentDao{
	
	private Connection conn = null;
	
	 public DepartamentoDaoJDBC (Connection conn) {
		this.conn = conn;
		
	}

	@Override
	public void insert(Departamento departamento) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"INSERT INTO departamento "
					+ "(nome) "
					+ "VALUES "
					+ "(?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, departamento.getNome());
			
			int conectar = ps.executeUpdate();
			
			if (conectar > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					departamento.setId(id);
				}
				
			}
			else {
				throw new DbExcecao("Erro nenhuma linha foi afetada");
			}
			
			
			
		} catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}
		finally {
			DB.fecharConexao();
		}
		
	}

	@Override
	public void update(Departamento departamento) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"UPDATE departamento "
					+ "SET nome = ? "
					+ "WHERE id = ?");
			
			ps.setString(1, departamento.getNome());
			ps.setInt(2, departamento.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}
		finally {
			DB.fecharConexao();
		}
		
	}

	@Override
	public void delete(Integer id) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM departamento WHERE id = ?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
					
		} catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}
		finally {
			DB.fecharConexao();
		}
		
	}

	@Override
	public Departamento find(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM departamento WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("id"));
				dep.setNome(rs.getString("nome"));
				return dep;
				
			}
			return null;
			
		} 
		catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}
		
	}
		

	@Override
	public List<Departamento> lista() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM departamento ORDER BY id");
			rs = st.executeQuery();

			List<Departamento> list = new ArrayList<>();

			while (rs.next()) {
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}
	}
	
	}
		
	


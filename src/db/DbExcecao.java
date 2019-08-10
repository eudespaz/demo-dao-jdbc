package db;

public class DbExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DbExcecao (String msg) {
		super(msg);
	}
}

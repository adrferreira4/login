package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroUsuarioDao {
	private static final String URL = "jdbc:derby:db;create=true";
	
	public static void inclui(String usuario, String nome, String senha) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "insert into login (usuario, nome, senha) values (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usuario);
		pstmt.setString(2, nome);
		pstmt.setString(3, senha);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}
	
	public static void alterar(String usuario, String nome) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "update login set usuario = ? where nome = ?" ;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.setString(2, usuario);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}
	
	public static void excluir(String usuario) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "delete from login where usuario = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usuario);
		pstmt.executeUpdate();
		// Fechar senten�a.
		pstmt.close();
		// Fechar conex�o.
		conn.close();
	}
	
	public static boolean consultar(String usuario, String senha) throws SQLException{
        Connection conn = DriverManager.getConnection(URL);
        String sql = "select * from login where ? = usuario and ? = senha";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, usuario);
        pstmt.setString(2, senha);
        ResultSet rs = pstmt.executeQuery();
        boolean exists = rs.next();
        pstmt.close();
        conn.close();
        return exists;
    }
	
	public static List<Login> listar() throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "select usuario, nome from login";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// Represneta o resultado da execução.
		ResultSet rs = pstmt.executeQuery();
		
		List<Login> usuarios = new ArrayList<Login>();
		while (rs.next()) {
			String usuario = rs.getString("usuario");
			String nome = rs.getString("nome");
			Login user = new Login(usuario, nome);
			usuarios.add(user);
		}
	
		// Fechar resultado.
		rs.close();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
		
		return usuarios;
	}

}

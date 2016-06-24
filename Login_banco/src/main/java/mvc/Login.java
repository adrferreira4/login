package mvc;

public class Login {

	private String nome, usuario, senha;

	public Login() {
	}

	public Login(String usuario, String nome) {
		this.usuario = usuario;
		this.nome = nome;
	}
	
	public Login(String usuario, String nome, String senha) {
		this.usuario = usuario;
		this.nome = nome;
		this.setSenha(senha);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

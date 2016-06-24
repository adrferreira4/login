package mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletar_usuario")
public class DeletarController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String msg;
			String op = valor(req, "operacao", "");
			String usuario = valor(req, "usuario", "0");
			String nome = valor(req, "nome", "");
			String senha = valor(req, "senha", "");
			if (op.equals("incluir")) {
				CadastroUsuarioDao.inclui(usuario, nome, senha);
				msg = "Inclusão realizada com sucesso.";
			} else if (op.equals("alterar")) {
				CadastroUsuarioDao.alterar(usuario, nome);
				msg = "Alteração realizada com sucesso.";
			} else if (op.equals("excluir")) {
				CadastroUsuarioDao.excluir(usuario);
				resp.sendRedirect("aluno");
				msg = "Exclusão realizada com sucesso.";
			} else if (op.equals("")) {
				msg = "";
			} else {
				throw new IllegalArgumentException("Operação \"" + op + "\" não suportada.");
			}
			
			req.setAttribute("msg", msg);

			List<Login> usuarios = CadastroUsuarioDao.listar();
			req.setAttribute("usuarios", usuarios);
			
			req.getRequestDispatcher("DeletarView.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
	
}

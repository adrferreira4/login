package database;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginController extends HttpServlet {

	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	private int toInt(HttpServletRequest req, String param, String padrao) {
		return Integer.parseInt(valor(req, param, padrao));
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String msg = "";
			String op = valor(req, "operacao", "");
			String usuario = valor(req, "usuario", "");
			String senha = valor(req, "senha", "");
			if (op.equals("entrar")) {
				if (CadastroUsuarioDao.consultar(usuario, senha)==true) {
					//Obter a sess√£o.
					HttpSession session = req.getSession();
					//Incluir vari√°vel na regi√£o de mem√≥ria da sess√£o.
					session.setAttribute("usuario", usuario);
					
					resp.sendRedirect("cadastro_usuario");
				} else {
					msg = "Usu·rio ou senha incorreta.";
				}
			} else if (op.equals("")) {
				msg = "";
			} else {
				throw new IllegalArgumentException("OperaÁ„o \"" + op + "\" n„o suportada.");
			}
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("LoginView.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}

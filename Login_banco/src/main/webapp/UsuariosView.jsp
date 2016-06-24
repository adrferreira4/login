<!DOCTYPE html>
<%@page import="mvc.Login"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>
    <a href="cadastro_usuario">Cadastrar</a>
  </h1>
  <br>
  <br>
  <form>
    <table>
      <tr>
        <td>Usuario</td>
        <td><input name="usuario"></td>
      </tr>
      <tr>
        <td>Nome:</td>
        <td><input name="nome"></td>
      </tr>
      <tr>
        <td>Senha:</td>
        <td><input type="password" name="senha"></td>
      </tr>
    </table>
    <button name="operacao" value="incluir">Incluir</button>
    <button name="operacao" value="excluir">Excluir</button>
    <button name="operacao" value="alterar">Alterar</button>
  </form>
  
  
  <b>${msg}</b>
<hr>
  Usuários: ${usuario}
  <hr>
  <table>
    <tr>
      <th>Usuario</th>
      <th>Nome</th>
    </tr>
    <%
      //Obtém a lista de alunos criada pelo controlador.
  	List<Login> usuarios = (List<Login>) request.getAttribute("usuarios");

    if (usuarios != null && !usuarios.isEmpty()) {
      for (Login a : usuarios) {
    %>
    <tr>
      <td><%=a.getUsuario()%></td>
      <td><%=a.getNome()%></td>

      <td><a href="cadastro_usuario?operacao=excluir&usuario=<%=a.getUsuario()%>">Excluir</a></td>
    </tr>
    <%
      }
    }
    %>
  </table>
    
</body>
</html>
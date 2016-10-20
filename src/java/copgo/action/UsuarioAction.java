
package copgo.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import copgo.bean.Usuario;
import copgo.persistence.UsuarioDao;

public class UsuarioAction {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "novo":
                request.setAttribute("objUsuario", new Usuario());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "salvar":
                if (save(request)) {
                    request.setAttribute("msg", "Operação realizada com sucesso!");
                } else {
                    request.setAttribute("msg", "Erro ao realizar a operação!");
                }
                request.setAttribute("objUsuario", new Usuario());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "editar": {
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("objUsuario", new UsuarioDao().getUsuario(id));
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            }
            default: {
                int id = Integer.parseInt(request.getParameter("id"));
                new UsuarioDao().excluir(id);
                request.setAttribute("lstUsuarios", new UsuarioDao().getUsuarios());
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);
                break;
            }
        }

    }

    private boolean save(HttpServletRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));

        
        return new UsuarioDao().incluir(usuario);

    }

}

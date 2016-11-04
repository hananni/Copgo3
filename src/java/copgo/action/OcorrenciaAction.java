
package copgo.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import copgo.bean.Ocorrencia;
import copgo.persistence.OcorrenciaDao;

public class OcorrenciaAction {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "novo":
                request.setAttribute("objOcorrencia", new Ocorrencia());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "salvar":
                if (save(request)) {
                    request.setAttribute("msg", "Operação realizada com sucesso!");
                } else {
                    request.setAttribute("msg", "Erro ao realizar a operação!");
                }
                request.setAttribute("objOcorrencia", new Ocorrencia());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "editar": {
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("objOcorrencia", new OcorrenciaDao().getOcorrencia(id));
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            }
            default: {
                int id = Integer.parseInt(request.getParameter("id"));
                new OcorrenciaDao().excluir(id);
                request.setAttribute("lstOcorrencias", new OcorrenciaDao().getOcorrencias());
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);
                break;
            }
        }

    }

    private boolean save(HttpServletRequest request) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(request.getParameter("descricao"));
        ocorrencia.setData(request.getParameter("data"));
        ocorrencia.setTipoocorrencia(request.getParameter("tipoocorrencia"));
        ocorrencia.setLocalizacao(request.getParameter("localizacao"));

        
        return new OcorrenciaDao().incluir(ocorrencia);

    }

}

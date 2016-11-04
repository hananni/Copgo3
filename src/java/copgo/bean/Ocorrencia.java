
package copgo.bean;


public class Ocorrencia {
    
    private int id;
    private String descricao;
    private String data;
    private String tipoocorrencia;
    private String localizacao;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipoocorrencia() {
        return tipoocorrencia;
    }

    public void setTipoocorrencia(String tipoocorrencia) {
        this.tipoocorrencia = tipoocorrencia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}

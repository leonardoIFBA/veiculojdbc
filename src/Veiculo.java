public class Veiculo {
    private Integer codigo;
    private String fabricante;
    private String modelo;
    private Integer anofabricacao;
    private Integer anomodelo;
    private Double valor;
    
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Integer getAnofabricacao() {
        return anofabricacao;
    }
    public void setAnofabricacao(Integer anofabricacao) {
        this.anofabricacao = anofabricacao;
    }
    public Integer getAnomodelo() {
        return anomodelo;
    }
    public void setAnomodelo(Integer anomodelo) {
        this.anomodelo = anomodelo;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Veiculo other = (Veiculo) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Veiculo [codigo=" + codigo + ", fabricante=" + fabricante + ", modelo=" + modelo + ", anofabricacao="
                + anofabricacao + ", anomodelo=" + anomodelo + ", valor=" + valor + "]";
    }

    
}

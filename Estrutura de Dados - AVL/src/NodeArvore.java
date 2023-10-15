public class NodeArvore {
    // definindo atributos
    private Integer valor;
    private NodeArvore esquerdo;
    private NodeArvore direito;
    // metodo construtor
    public NodeArvore() {
        this.valor = null;
        this.esquerdo = null;
        this.direito = null;
    }
    // metodos get
    public Integer getValor() {
        return valor;
    }
    public NodeArvore getEsquerdo() {
        return esquerdo;
    }
    public NodeArvore getDireito() {
        return direito;
    }
    // metodos set
    public void setValor(Integer informacao) {
        this.valor = informacao;
    }
    public void setEsquerdo(NodeArvore esquerdo) {
        this.esquerdo = esquerdo;
    }
    public void setDireito(NodeArvore direito) {
        this.direito = direito;
    }

}
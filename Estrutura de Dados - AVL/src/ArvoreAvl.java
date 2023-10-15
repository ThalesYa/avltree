public class ArvoreAvl {

    private NodeArvore raiz;

    public ArvoreAvl(){
        this.raiz = null;
    }


    public void inserirAvl(int dado) {
        // Cria um novo nó com o valor informado
        NodeArvore no = new NodeArvore();
        no.setValor(dado);

        // Verifica se a árvore está vazia
        if (raiz == null) {
            // Se estiver vazia, o novo nó se torna a raiz da árvore
            raiz = no;
            // Em seguida, verifica o balanceamento da árvore com o novo nó
            verificarBalanceamento(no);
            return;
        }

        // Se a árvore não estiver vazia, começa a procurar o local de inserção
        NodeArvore atual = raiz;
        while (true) {
            // Se o valor a ser inserido for menor que o valor atual
            if (dado < atual.getValor()) {
                // Verifica se o nó à esquerda do nó atual é nulo
                if (atual.getEsquerdo() == null) {
                    // Se for nulo, o novo nó é inserido à esquerda do nó atual
                    atual.setEsquerdo(no);
                    // Verifica o balanceamento após a inserção
                    verificarBalanceamento(no);
                    break; // Sai do loop
                }
                // Caso contrário, continua navegando para a esquerda na árvore
                atual = atual.getEsquerdo();
            } else {
                // Se o valor a ser inserido for maior ou igual ao valor atual
                // (ou seja, vai para a direita)
                if (atual.getDireito() == null) {
                    // Verifica se o nó à direita do nó atual é nulo
                    if (atual.getDireito() == null) {
                        // Se for nulo, o novo nó é inserido à direita do nó atual
                        atual.setDireito(no);
                        // Verifica o balanceamento após a inserção
                        verificarBalanceamento(no);
                        break; // Sai do loop
                    }
                }
                // Caso contrário, continua navegando para a direita na árvore
                atual = atual.getDireito();
            }
        }
    }

    //Metodos pra printar

    public void imprimir(){
        System.out.print("Pré-ordem: "); // tipo de organizacao
        preOrdem(raiz); // metodo que imprime
        System.out.println("\n"); // pula uma linha
        System.out.print("In-ordem: "); // tipo de organizacao
        inOrdem(raiz); // metodo que imprime
        System.out.println("\n"); // pula uma linha
        System.out.print("Pós-ordem: "); // tipo de organizacao
        posOrdem(raiz); // metodo que imprime
        System.out.println("\n"); // pula uma linha
    }
    public void preOrdem(NodeArvore arvore){
        if (arvore != null){ // se o no nao for nulo
            System.out.print(arvore.getValor() + " "); // printa a informacao
            preOrdem(arvore.getEsquerdo()); // chamada recursiva com o proximo da esquerda
            preOrdem(arvore.getDireito()); // chamada recursiva com o proximo da direita
        }
    }
    private void inOrdem(NodeArvore arvore){
        if(arvore != null){ // se o no nao for nulo
            inOrdem(arvore.getEsquerdo()); // chamada recursiva com o proximo da esquerda
            System.out.print(arvore.getValor() + " "); // printa a informacao
            inOrdem(arvore.getDireito()); // chamada recursiva com o proximo da direita
        }
    }
    private void posOrdem(NodeArvore arvore){
        if(arvore != null){ // se o no nao for nulo
            posOrdem(arvore.getEsquerdo()); // chamada recursiva com o proximo da esquerda
            posOrdem(arvore.getDireito()); // chamada recursiva com o proximo da direita
            System.out.print(arvore.getValor() + " "); // printa a informacao
        }
    }

    //Verica se é folha

    private boolean Folha(NodeArvore no){
        if(no.getEsquerdo() == null && no.getDireito() == null){
            return true;
        } else {
            return false;
        }
    }

    //Encontrar pai que foi buscar cigarro
    public NodeArvore encontrarPai(NodeArvore no) {
        if (no == null || no == raiz) {
            return null; // O nó alvo não tem pai ou é a raiz.
        }
        NodeArvore percorre = raiz;
        NodeArvore pai = null;
        while (percorre != null) {
            if ((percorre.getEsquerdo() == no) || (percorre.getDireito() == no)) {
                pai = percorre;
                break; // Encontramos o pai do nó alvo.
            } else if (no.getValor() >= percorre.getValor()) {
                percorre = percorre.getDireito();
            } else {
                percorre = percorre.getEsquerdo();
            }
        }
        return pai;
    }

    //Remover valores especificos

    private void removerRaiz() {
        // Caso 0: Tem poha nenhuma na árvore
        if (raiz == null) {
            // A árvore está vazia, não há nada a ser removido.
            return;
        }

        // Caso 1: A raiz é uma folha
        if (raiz.getEsquerdo() == null && raiz.getDireito() == null) {
            raiz = null;
        }

        // Caso 2: A raiz tem apenas um filho (esquerdo ou direito)
        else if (raiz.getEsquerdo() != null && raiz.getDireito() == null) {
            raiz = raiz.getEsquerdo();
        } else if (raiz.getEsquerdo() == null && raiz.getDireito() != null) {
            raiz = raiz.getDireito();
        }
        // Caso 3: A raiz tem ambos os filhos
        else {
            // Encontre o nó mais à direita na subárvore esquerda
            NodeArvore noMaisDireita = raiz.getEsquerdo();
            while (noMaisDireita.getDireito() != null) {
                noMaisDireita = noMaisDireita.getDireito();
            }

            // Coloque o filho direito da raiz na parte direita do nó mais à direita
            noMaisDireita.setDireito(raiz.getDireito());

            // Atualize a raiz para ser o filho esquerdo da raiz
            raiz = raiz.getEsquerdo();
        }
    }

    //Buscar Avl

    public boolean buscar(int valor) {
        NodeArvore noAtual = raiz; // Inicializa um nó atual com a raiz da árvore.

        while (noAtual != null) { // Inicia um loop enquanto o nó atual não for nulo (ainda há nós para verificar).

            if (valor == noAtual.getValor()) { // Verifica se o valor do nó atual é igual ao valor procurado.
                System.out.println("Valor " + valor + " encontrado na árvore."); // Imprime uma mensagem indicando que o valor foi encontrado.
                return true; // Retorna verdadeiro (o valor foi encontrado na árvore).
            } else if (valor < noAtual.getValor()) { // Se o valor for menor que o valor do nó atual:
                noAtual = noAtual.getEsquerdo(); // Atualiza o nó atual para ser o nó à esquerda (valores menores são encontrados à esquerda na árvore).
            } else { // Se o valor for maior que o valor do nó atual:
                noAtual = noAtual.getDireito(); // Atualiza o nó atual para ser o nó à direita (valores maiores são encontrados à direita na árvore).
            }
        }

        // Quando o loop termina, significa que o valor não foi encontrado na árvore.
        System.out.println("Valor " + valor + " não encontrado na árvore."); // Imprime uma mensagem indicando que o valor não foi encontrado.
        return false; // Retorna falso (o valor não foi encontrado na árvore).
    }

    public boolean buscarComTempoAvl(int valor) {
        long inicio = System.nanoTime(); // Marca o tempo de início da busca
        NodeArvore noAtual = raiz; // Inicializa um nó atual com a raiz da árvore.

        while (noAtual != null) { // Inicia um loop enquanto o nó atual não for nulo (ainda há nós para verificar).

            if (valor == noAtual.getValor()) { // Verifica se o valor do nó atual é igual ao valor procurado.
                long fim = System.nanoTime(); // Marca o tempo de término da busca
                long tempoDecorrido = fim - inicio; // Calcula o tempo decorrido em nanossegundos
                System.out.println("Valor " + valor + " encontrado na árvore.");
                System.out.println("Tempo decorrido: " + tempoDecorrido + " nanossegundos");
                return true; // Retorna verdadeiro (o valor foi encontrado na árvore).
            } else if (valor < noAtual.getValor()) { // Se o valor for menor que o valor do nó atual:
                noAtual = noAtual.getEsquerdo(); // Atualiza o nó atual para ser o nó à esquerda (valores menores são encontrados à esquerda na árvore).
            } else { // Se o valor for maior que o valor do nó atual:
                noAtual = noAtual.getDireito(); // Atualiza o nó atual para ser o nó à direita (valores maiores são encontrados à direita na árvore).
            }
        }

        // Quando o loop termina, significa que o valor não foi encontrado na árvore.
        long fim = System.nanoTime(); // Marca o tempo de término da busca
        long tempoDecorrido = fim - inicio; // Calcula o tempo decorrido em nanossegundos
        System.out.println("Valor " + valor + " não encontrado na árvore.");
        System.out.println("Tempo decorrido: " + tempoDecorrido + " nanossegundos");
        return false; // Retorna falso (o valor não foi encontrado na árvore).
    }

    //Altura

    private int altura(NodeArvore no){
        if(no == null){ // se o no for null
            return -1; // retorna -1
        }
        int esquerda = altura(no.getEsquerdo()); // percorre a esquerda
        int direita = altura(no.getDireito()); // percorre a direita
        if(esquerda > direita){
            return 1 + esquerda;
        } else {
            return 1 + direita;
        }
    }

    // Rotações

    private NodeArvore rotacaoEsquerda(NodeArvore no){
        NodeArvore novaRaiz = no.getDireito(); // seta a nova raiz como sendo o no da direita
        no.setDireito(novaRaiz.getEsquerdo()); // seta a direita da antiga raiz o esquerdo da nova raiz
        novaRaiz.setEsquerdo(no); // atualiza o esquerdo da nova raiz como sendo a raiz antiga
        return novaRaiz; // retorna a raiz do jeito certo
    }
    private NodeArvore duplaRotacaoEsquerda(NodeArvore no){
        NodeArvore novaRaiz = no.getDireito().getEsquerdo(); // pega a nova raiz da arvore que vai ser o neto da raiz que entrou
        NodeArvore pai = no.getDireito(); // armazena o pai
        NodeArvore vo = no; // armazena o vo
        pai.setEsquerdo(novaRaiz.getDireito());
        vo.setDireito(novaRaiz.getEsquerdo());
        novaRaiz.setEsquerdo(vo);  // seta o vo a esquerda da nova raiz
        novaRaiz.setDireito(pai); // seta o pai a direita da nova raiz
        return novaRaiz; // retorna a raiz balanceada
    }

    private NodeArvore rotacaoDireita(NodeArvore no){
        NodeArvore novaRaiz = no.getEsquerdo(); // seta a nova raiz como sendo o no da esquerda
        no.setEsquerdo(novaRaiz.getDireito()); // seta a esquerda da raiz antiga o no direito da nova raiz
        novaRaiz.setDireito(no); // atualiza a direita da nova raiz como sendo o no antigo
        return novaRaiz; // retorna a raiz rotacionada
    }
    private NodeArvore duplaRotacaoDireita(NodeArvore no){
        NodeArvore novaRaiz = no.getEsquerdo().getDireito(); // pega a nova raiz da arvore que vai ser o neto da raiz que entrou
        NodeArvore pai = no.getEsquerdo(); // armazena o pai
        NodeArvore vo = no; // armazena o vo
        pai.setDireito(novaRaiz.getEsquerdo());
        vo.setEsquerdo(novaRaiz.getDireito());
        novaRaiz.setDireito(vo);  // seta o vo a direita da nova raiz
        novaRaiz.setEsquerdo(pai); // seta o pai a esquerda da nova raiz
        return novaRaiz; // retorna a raiz balanceada
    }

    //Balanceamento

    private void verificarBalanceamento(NodeArvore no) {
        if (no == null) {
            return;
        }

        // Recalcula o fator de balanceamento
        int balanceamento = altura(no.getEsquerdo()) - altura(no.getDireito());

        // Verifica se o balanceamento está fora do intervalo [-1, 1]
        if (balanceamento > 1) {
            if (altura(no.getEsquerdo().getEsquerdo()) >= altura(no.getEsquerdo().getDireito())) {
                no = rotacaoDireita(no);
            } else {
                no = duplaRotacaoDireita(no);
            }
        } else if (balanceamento < -1) {
            if (altura(no.getDireito().getDireito()) >= altura(no.getDireito().getEsquerdo())) {
                no = rotacaoEsquerda(no);
            } else {
                no = duplaRotacaoEsquerda(no);
            }

            // Atualiza o nó pai, se houver
            NodeArvore pai = encontrarPai(no);
            if (pai != null) {
                if (no.getValor() >= pai.getValor()) {
                    pai.setDireito(no);
                } else {
                    pai.setEsquerdo(no);
                }
                verificarBalanceamento(pai); // Verifica o balanceamento recursivamente subindo na árvore.
            } else {
                // No caso em que o balanceamento é corrigido na raiz, atualiza a raiz da árvore.
                raiz = no;
            }
        }
    }


    // Remover valor da árvore
    public void remover(int dado){
        //Não consegui implementar
    }

    //Get pra testar na main
    public NodeArvore getRaiz() {
        return raiz; // retorna a arvore
    }

}
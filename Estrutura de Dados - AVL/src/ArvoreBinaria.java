public class ArvoreBinaria {
    private NodeArvore raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(int dado) {
        // Cria um novo nó com o valor informado
        NodeArvore no = new NodeArvore();
        no.setValor(dado);

        // Verifica se a árvore está vazia
        if (raiz == null) {
            // Se estiver vazia, o novo nó se torna a raiz da árvore
            raiz = no;
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
        System.out.print("Pré-ordem: ");
        preOrdem(raiz);
        System.out.println("\n");
        System.out.print("In-ordem: ");
        inOrdem(raiz);
        System.out.println("\n");
        System.out.print("Pós-ordem: ");
        posOrdem(raiz);
        System.out.println("\n");
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

    //Buscar
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

    public boolean buscarComTempo(int valor) {
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
    //Remover raiz
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

    //Econtrar menor valor
    private NodeArvore encontrarMenorValor(NodeArvore no) {
        while (no.getEsquerdo() != null) {
            no = no.getEsquerdo();
        }
        return no;
    }

    // Remover valor da árvore
    private void removerSucessor(NodeArvore noAtual, NodeArvore pai) {
        if (Folha(noAtual)) {
            if (noAtual == raiz) {
                raiz = null;
            } else if (noAtual == pai.getEsquerdo()) {
                pai.setEsquerdo(null);
            } else {
                pai.setDireito(null);
            }
        } else {
            removerSucessor(noAtual.getEsquerdo(), noAtual);
        }
    }

    public void remover(int dado) {
        if (raiz == null) {
            return; // A árvore está vazia, nada a fazer.
        }

        NodeArvore noAtual = raiz;
        NodeArvore pai = null;
        boolean ehFilhoEsquerdo = true;

        // Encontre o nó a ser removido e seu pai
        while (noAtual != null && noAtual.getValor() != dado) {
            pai = noAtual;
            if (dado < noAtual.getValor()) {
                noAtual = noAtual.getEsquerdo();
                ehFilhoEsquerdo = true;
            } else {
                noAtual = noAtual.getDireito();
                ehFilhoEsquerdo = false;
            }
        }

        // Se o nó a ser removido não foi encontrado
        if (noAtual == null) {
            return; // O valor a ser removido não está na árvore.
        }

       // O nó a ser removido é uma folha (não possui filhos)
        if (Folha(noAtual)) {
            if (noAtual == raiz) {
                raiz = null;
            } else if (ehFilhoEsquerdo) {
                pai.setEsquerdo(null);
            } else {
                pai.setDireito(null);
            }
        }
        //O nó possui um filho a direita
        else if (noAtual.getEsquerdo() == null) {
            if (noAtual == raiz) {
                raiz = noAtual.getDireito();
            } else if (ehFilhoEsquerdo) {
                pai.setEsquerdo(noAtual.getDireito());
            } else {
                pai.setDireito(noAtual.getDireito());
            }
        }
        //O nó possui um filho a esquerda
        else if (noAtual.getDireito() == null) {
            if (noAtual == raiz) {
                raiz = noAtual.getEsquerdo();
            } else if (ehFilhoEsquerdo) {
                pai.setEsquerdo(noAtual.getEsquerdo());
            } else {
                pai.setDireito(noAtual.getEsquerdo());
            }
        }
        //Tiver 2 filhos
        else {
            NodeArvore sucessor = encontrarMenorValor(noAtual.getDireito());
            noAtual.setValor(sucessor.getValor());
            removerSucessor(noAtual.getDireito(), noAtual);
        }
    }

    public void removerComTempo(int dado) {
        long startTime = System.nanoTime(); // Inicie o cronômetro


        if (raiz == null) {
            return; // A árvore está vazia, nada a fazer.
        }

        NodeArvore noAtual = raiz;
        NodeArvore pai = null;
        boolean ehFilhoEsquerdo = true;

        // Encontre o nó a ser removido e seu pai
        while (noAtual != null && noAtual.getValor() != dado) {
            pai = noAtual;
            if (dado < noAtual.getValor()) {
                noAtual = noAtual.getEsquerdo();
                ehFilhoEsquerdo = true;
            } else {
                noAtual = noAtual.getDireito();
                ehFilhoEsquerdo = false;
            }
        }

        // Se o nó a ser removido não foi encontrado
        if (noAtual == null) {
            return; // O valor a ser removido não está na árvore.
        }

        // O nó a ser removido é uma folha (não possui filhos)
        if (Folha(noAtual)) {
            if (noAtual == raiz) {
                raiz = null;
            } else if (ehFilhoEsquerdo) {
                pai.setEsquerdo(null);
            } else {
                pai.setDireito(null);
            }
        }
        //O nó possui um filho a direita
        else if (noAtual.getEsquerdo() == null) {
            if (noAtual == raiz) {
                raiz = noAtual.getDireito();
            } else if (ehFilhoEsquerdo) {
                pai.setEsquerdo(noAtual.getDireito());
            } else {
                pai.setDireito(noAtual.getDireito());
            }
        }
        //O nó possui um filho a esquerda
        else if (noAtual.getDireito() == null) {
            if (noAtual == raiz) {
                raiz = noAtual.getEsquerdo();
            } else if (ehFilhoEsquerdo) {
                pai.setEsquerdo(noAtual.getEsquerdo());
            } else {
                pai.setDireito(noAtual.getEsquerdo());
            }
        }
        //Tiver 2 filhos
        else {
            NodeArvore sucessor = encontrarMenorValor(noAtual.getDireito());
            noAtual.setValor(sucessor.getValor());
            removerSucessor(noAtual.getDireito(), noAtual);
        }
        long endTime = System.nanoTime(); // Pare o cronômetro
        System.out.println("Tempo de execução: " + (endTime - startTime) + " nanossegundos");
    }

    public NodeArvore getRaiz() {
        return raiz;
    }
}



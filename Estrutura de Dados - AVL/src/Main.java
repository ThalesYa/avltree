import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArvoreAvl arvore = new ArvoreAvl();
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(14);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(18);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(16);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(17);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(14);
        arvoreBinaria.inserir(5);
        arvoreBinaria.imprimir();
        arvoreBinaria.removerComTempo( 5);

//        Scanner sc = new Scanner(System.in);
//        Random random = new Random();
//        long startTime = System.nanoTime(); // Início da medição
//
//        for (int i = 0; i < 20000; i++) {
//            int v = random.nextInt(100) + 1;
//            arvoreBinaria.inserir(v);
//        }
//
//        long endTime = System.nanoTime(); // Fim da medição
//        System.out.println("Tempo de inserção: " + (endTime - startTime) + " nanossegundos");
//
//        System.out.println("\n");
//
//        // Leitura contínua de valores
//        while (true) {
//            int dado = sc.nextInt();
//
//            startTime = System.nanoTime(); // Início da medição
//            arvoreBinaria.inserir(dado);
//            endTime = System.nanoTime(); // Fim da medição
//
//            System.out.println("Tempo de inserção: " + (endTime - startTime) + " nanossegundos");
//
//        }


//        arvore.inserirAvl(14);
//        arvore.inserirAvl(15);
//        arvore.inserirAvl(4);
//        arvore.inserirAvl(9);
//        arvore.inserirAvl(7);
//        arvore.inserirAvl(18);
//        arvore.inserirAvl(3);
//        arvore.inserirAvl(5);
//        arvore.inserirAvl(16);
//        arvore.inserirAvl(4);
//        arvore.inserirAvl(20);
//        arvore.inserirAvl(17);
//        arvore.inserirAvl(9);
//        arvore.inserirAvl(14);
//        arvore.inserirAvl(5);
//

//        Scanner sc = new Scanner(System.in);
//        Random random = new Random();
//        long startTime = System.nanoTime(); // Início da medição
//
//        for (int i = 0; i < 20000; i++) {
//            int v = random.nextInt(100) + 1;
//            arvore.inserirAvl(v);
//        }
//
//        long endTime = System.nanoTime(); // Fim da medição
//        System.out.println("Tempo de inserção: " + (endTime - startTime) + " nanossegundos");
//
//        System.out.println("\n");
//
//        // Leitura contínua de valores
//        while (true) {
//            int dado = sc.nextInt();
//
//            startTime = System.nanoTime(); // Início da medição
//            arvore.inserirAvl(dado);
//            endTime = System.nanoTime(); // Fim da medição
//
//            System.out.println("Tempo de inserção: " + (endTime - startTime) + " nanossegundos");
//
//        }


    }
}
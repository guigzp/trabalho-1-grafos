/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1_grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author guiza
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    private static void lerArquivo(Grafo g) {
        System.out.print("Insira o nome do arquivo de entrada: ");
        Scanner entrada = new Scanner(System.in);
        String nomeArquivo = entrada.nextLine();
        boolean verticesLido = false;
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            lerArq.readLine();
            while ((linha = lerArq.readLine()) != null) {
                if(linha.equals("#arestas")){
                    verticesLido = true;
                    continue;
                }
                if(!verticesLido){
                   g.addVertice(parseInt(linha));
                } else{
                    String[] lido = linha.split(" ");
                    g.addAresta(parseInt(lido[0]), parseInt(lido[1]), parseDouble(lido[2]));
                }
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            lerArquivo(g);
        }
    }
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        lerArquivo(grafo);
        int opcao = 1;
        Scanner entrada = new Scanner(System.in);
        while(opcao < 4 && opcao > 0){
            System.out.println("\n1) Importar outro arquivo \n2) Algoritmo de Dijkstra \n3) Algoritmo de Bellman Ford"
                    + " \n4) Algoritmo de Floyd Warshall \nEscolha sua opção: ");
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    grafo = new Grafo();
                    lerArquivo(grafo);
                    break;
                case 2:
                    System.out.println("\nAlgoritmo Dijkstra");
                    Dijkstra d = new Dijkstra();
                    d.calculaTodos(grafo);
                    break;
                case 3:
                    System.out.println("\nAlgoritmo Bellman Ford");
                    BellmanFord b = new BellmanFord();
                    b.calculaTodos(grafo);
                    break;
                case 4:
                    System.out.println("\nAlgoritmo Floyd Warshall");
                    FloydWarshall f = new FloydWarshall();
                    f.caminhoMinimo(grafo);
                    break;
                default:
                    System.out.println("\nEncerrando o programa!");
                    break;
            }
        }
    }
    
}

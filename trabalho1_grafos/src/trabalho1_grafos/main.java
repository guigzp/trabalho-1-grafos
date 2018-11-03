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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guiza
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    private static void lerArquivo(String nomeArquivo, Grafo g) {
        boolean verticesLido = false;
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            lerArq.readLine();  // Le a primeira linha da tabela que não precisa ser armazenada
            while ((linha = lerArq.readLine()) != null) {  // Le a tabela até o final armazenando cada linha na variavel linha
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
        }
    }
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        System.out.print("Insira o nome do arquivo de entrada: ");
        Scanner entrada = new Scanner(System.in);
        String nomeArquivo = entrada.nextLine();
        lerArquivo(nomeArquivo, grafo);
        grafo.mostraGrafo();
        /*
        
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addAresta(1, 2, 10);
        grafo.addAresta(2, 3, 0);
        grafo.addAresta(2, 1, 5);
        grafo.addAresta(1, 4, 9);
        grafo.addAresta(3, 1, 15);
        
*/
    }
    
}

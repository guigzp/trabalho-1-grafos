/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1_grafos;

/**
 *
 * @author Jukios
 */
public class FloydWarshall {
    private double matriz[][];
    private int predecessor[][];
    
    public void caminhoMinimo(Grafo g){
        int tamanho = g.getVertices().size();
        matriz = new double[tamanho][tamanho];
        predecessor = new int[tamanho][tamanho];
        preencheMatriz(g, tamanho);
        for(int k = 0; k < tamanho; k++){
            for(int i = 0; i < tamanho; i++){
                for(int j = 0; j < tamanho; j++){
                    if(matriz[i][k] + matriz[k][j] < matriz[i][j] ){
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                        predecessor[i][j] = predecessor[k][j];
                    }
                }
            }
        }
        for(int i = 0; i < tamanho; i++)
            for(int j = 0; j < tamanho; j++){
                System.out.print(i + " " + j + " ");
                if(matriz[i][j] == Double.POSITIVE_INFINITY)
                    System.out.println("inf");
                else
                    System.out.println(matriz[i][j]);
                mostraCaminho(i,j);
                System.out.println("");
            }
    }
    
    public void preencheMatriz(Grafo g, int tamanho){
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                if(i == j){
                    matriz[i][j] = 0;
                }else{
                    matriz[i][j] = Double.POSITIVE_INFINITY;
                }
                predecessor[i][j] = -1;
            }
        }
        for(Vertice v : g.getVertices()){
            for(Aresta a : v.getAdjacentes()){
                matriz[a.getOrigem().getId()][a.getDestino().getId()] = a.getPeso();
                predecessor[a.getOrigem().getId()][a.getDestino().getId()] = a.getOrigem().getId();
            }
        }
    }
    
    public void mostraCaminho(int i,int j){
        if (i == j){
            System.out.print(i + " ");
        }
        else if (predecessor[i][j] == -1)
            System.out.print("Não existe caminho");
        else{
            mostraCaminho(i, predecessor[i][j]);
            System.out.print(j + " ");
        }
    }
}

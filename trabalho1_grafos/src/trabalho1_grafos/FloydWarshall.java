/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1_grafos;

import java.util.Arrays;

/**
 *
 * @author Jukios
 */
public class FloydWarshall {
    private double matriz[][];
    
    public void caminhoMinimo(Grafo g){
        int tamanho = g.getVertices().size();
        matriz = new double[tamanho][tamanho];
        preencheMatriz(g, tamanho);
        for(int k = 0; k < tamanho; k++){
            for(int i = 0; i < tamanho; i++){
                for(int j = 0; j < tamanho; j++){
                    if(matriz[i][k] + matriz[k][j] < matriz[i][j] ){
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                    }
                }
            }
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
            }
        }
        for(Vertice v : g.getVertices()){
            for(Aresta a : v.getAdjacentes()){
                matriz[a.getOrigem().getId()][a.getDestino().getId()] = a.getPeso();
            }
        }
    }
    
    public void mostraMatriz(int tamanho){
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

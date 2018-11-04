/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1_grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jukios
 */
public class BellmanFord {
    
    public void caminhoMinimo(Grafo g, Vertice vertice){
        inicializa(g,vertice);
        for(int i = 1; i < g.getVertices().size() - 1; i++){
            for(Vertice v: g.getVertices()){
                for(Aresta a: v.getAdjacentes())
                    relax(a);
            }
        }
    }
    
    public void inicializa(Grafo g, Vertice ini){
        for(Vertice v : g.getVertices()){
            v.setDistancia(Double.POSITIVE_INFINITY);
            v.setPai(null);
        }
        ini.setDistancia(0);
    }
    
    public void relax(Aresta a){
        double distancia;
        distancia = a.getOrigem().getDistancia() + a.getPeso();
        if(a.getDestino().getDistancia() > distancia){
            a.getDestino().setPai(a.getOrigem());
            a.getDestino().setDistancia(distancia);
        }
    }
    
    public void calculaTodos(Grafo g){
        for(Vertice v: g.getVertices()){
            this.caminhoMinimo(g, v);
            mostraCaminho(g,v.getId());
        }
    }
    
    public void mostraCaminho(Grafo g, int id){
        List<Vertice> caminho = new ArrayList<>();
        for(Vertice v: g.getVertices()){
            System.out.println(id + " " + v.getId() + " " + v.getDistancia());
            if(v.getDistancia() != Double.POSITIVE_INFINITY){
                caminho.add(v);
                while((v = v.getPai()) != null){
                    caminho.add(v);
                }
                while(!caminho.isEmpty()){
                    System.out.print(caminho.get(caminho.size()-1).getId() + " ");
                    caminho.remove(caminho.size()-1);
                }
            } else{
                System.out.print("Nao existe caminho");
            }
            System.out.println();
        }
    }
}

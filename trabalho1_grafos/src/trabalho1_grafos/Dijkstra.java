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
public class Dijkstra {
    
    private List<Vertice> preto = new ArrayList<>();
    private List<Vertice> cinza = new ArrayList<>();
    private Vertice atual;
 
    public List<Vertice> caminhoMinimo(Grafo g, Vertice v){
        double distancia;
        preto.clear();
        inicializa(g,v);
        setAtual(v);
        cinza.add(v);
        while(!cinza.isEmpty()){

            cinza.remove(atual);
            for(Aresta a: atual.getAdjacentes()){
                if(preto.indexOf(a.getDestino()) == -1 && cinza.indexOf(a.getDestino()) == -1){
                    cinza.add(a.getDestino());
                    distancia = atual.getDistancia() + a.getPeso();
                    if(a.getDestino().getDistancia() > distancia){
                        a.getDestino().setPai(atual);
                        a.getDestino().setDistancia(distancia);
                        g.getVertices().get(g.getVertices().indexOf(a.getDestino())).setDistancia(distancia);
                    }
                }
            }
            preto.add(atual);
            setAtual(proxMenor());
        }
        return null;
    }
    
    public void inicializa(Grafo g, Vertice ini){
        for(Vertice v : g.getVertices()){
            v.setDistancia(Double.POSITIVE_INFINITY);
            v.setPai(null);
        }
        ini.setDistancia(0);
    }
    
    public Vertice proxMenor(){
        Vertice menor = new Vertice(0);
        Double distancia = Double.POSITIVE_INFINITY;
        for(Vertice v: this.cinza){
            if(v.getDistancia() < distancia){
                menor = v;
                distancia = menor.getDistancia();
            }
        }
        return menor;
    }

    public void setAtual(Vertice atual) {
        this.atual = atual;
    }

    public void iterator(Grafo g){
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

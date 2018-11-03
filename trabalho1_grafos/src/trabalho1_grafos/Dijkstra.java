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
    
    private List<Vertice> caminho = new ArrayList<>();
    private List<Vertice> preto = new ArrayList<>();
    private List<Vertice> cinza = new ArrayList<>();
    private Vertice atual;
 
    public List<Vertice> caminhoMinimo(Grafo g, Vertice v){
        inicializa(g,v);
        setAtual(v);
        cinza.add(v);
        while(!cinza.isEmpty()){
            for(Aresta a: atual.getAdjacentes()){
                if(preto.indexOf(a.getDestino()) == -1){
                    cinza.add(a.getDestino());
                    if(a.getDestino().getDistancia() > atual.getDistancia() + a.getPeso()){
                        a.getDestino().setDistancia(atual.getDistancia() + a.getPeso());
                        g.getVertices().get(g.getVertices().indexOf(a.getDestino())).setDistancia(atual.getDistancia() + a.getPeso());
                    }
                }
            }
            cinza.remove(atual);
            preto.add(atual);
            setAtual(proxMenor());
        }
        g.mostraGrafo();
        return null;
    }
    
    public void inicializa(Grafo g, Vertice ini){
        for(Vertice v : g.getVertices()){
            v.setDistancia(Double.POSITIVE_INFINITY);
        }
        ini.setDistancia(0);
    }
    
    public Vertice proxMenor(){
        Vertice menor = new Vertice(0);
        Double distancia = Double.POSITIVE_INFINITY;
        for(Vertice v: this.cinza){
            if(v.getDistancia() < distancia)
                menor = v;
                distancia = menor.getDistancia();
        }
        return menor;
    }

    public void setCaminho(List<Vertice> caminho) {
        this.caminho = caminho;
    }

    public void setAtual(Vertice atual) {
        this.atual = atual;
    }

    public List<Vertice> getPreto() {
        return preto;
    }

    public void setPreto(List<Vertice> preto) {
        this.preto = preto;
    }

    public List<Vertice> getCinza() {
        return cinza;
    }

    public void setCinza(List<Vertice> cinza) {
        this.cinza = cinza;
    }    

    public List<Vertice> getCaminho() {
        return caminho;
    }

    public Vertice getAtual() {
        return atual;
    }
    
    
}

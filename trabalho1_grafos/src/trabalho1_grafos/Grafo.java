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
 * @author guiza
 */
public class Grafo {
    private List<Vertice> vertices;

    public Grafo() {
        vertices = new ArrayList<>();
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public void addVertice(int id){
        Vertice novoVertice = new Vertice(id);
        this.vertices.add(novoVertice);
    }
    
    public void addAresta(int origem, int destino, double peso){
        int posicaoOrigem, posicaoDestino;
        if( (existeVertice(origem) != -1) && (existeVertice(destino) != -1) ){
            posicaoOrigem = existeVertice(origem);
            posicaoDestino = existeVertice(destino);
            this.vertices.get(posicaoOrigem).addAresta(this.vertices.get(posicaoOrigem), this.vertices.get(posicaoDestino) , peso);
        }
    }
    
    public int existeVertice(int id){
        int count = 0;
        for(Vertice v : this.vertices){
            if(v.getId() == id){
                return count;
            }else{
                count ++;
            }
        }
        return -1;
    }
    
    public void mostraGrafo(){
        for(Vertice v : this.vertices){
            System.out.println("Vertice: "+ v.getId() + " Distancia" + v.getDistancia());
            for(Aresta a : v.getAdjacentes()){
                System.out.println(a.getOrigem().getId() + " "+ a.getDestino().getId() + " " + a.getPeso() + "\n");
            }
        }
    }
}

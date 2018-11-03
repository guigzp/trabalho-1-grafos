/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1_grafos;

import java.util.List;

/**
 *
 * @author guiza
 */
public class Grafo {
    private List<Vertice> vertices;

    public Grafo() {
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public void addVertice(int id){
        Vertice novoVertice = new Vertice(id);
        vertices.add(novoVertice);
    }
    
    public void addAresta(int origem, int destino, double peso){
        int posicaoOrigem, posicaoDestino;
        if(existeVertice(origem) && existeVertice(destino)){
            posicaoOrigem = this.vertices.indexOf(origem);
            posicaoDestino = this.vertices.indexOf(destino);
            this.vertices.get(posicaoOrigem).addAresta(this.vertices.get(posicaoOrigem),this.vertices.get(posicaoDestino) , peso);
        }
    }
    
    public Boolean existeVertice(int id){
        if(this.vertices.indexOf(id) != -1){
            return true;
        }else{
            return false;
        }
    }
    
    public void mostraGrafo(){
        
    }
}

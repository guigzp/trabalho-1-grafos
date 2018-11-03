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
public class Vertice {
    private int id;
    private List<Aresta> adjacentes;
    
    public Vertice(int id){
        this.id = id;
        adjacentes = new ArrayList<>();
    }
    
    public void addAresta(Vertice origem, Vertice destino, double peso ){
        Aresta nova_aresta = new Aresta(origem, destino, peso);
        this.adjacentes.add(nova_aresta);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Aresta> getAdjacentes() {
        return adjacentes;
    }
    
}

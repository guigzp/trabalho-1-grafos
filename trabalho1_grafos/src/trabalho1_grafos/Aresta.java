/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1_grafos;

/**
 *
 * @author guiza
 */
public class Aresta {
    private Vertice origem;
    private Vertice destino;
    private double peso;

    public Aresta(Vertice origem, Vertice destino, double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    
    public Vertice getOrigem() {
        return origem;
    }
    
    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }


    public Vertice getDestino() {
        return destino;
    }

   
    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

  
    public double getPeso() {
        return peso;
    }

   
    public void setPeso(double peso) {
        this.peso = peso;
    }
}

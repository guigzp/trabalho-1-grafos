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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addAresta(1, 2, 10);
        grafo.addAresta(2, 3, 0);
        grafo.addAresta(2, 1, 5);
        grafo.addAresta(1, 4, 9);
        grafo.addAresta(3, 1, 15);
        grafo.mostraGrafo();
    }
    
}

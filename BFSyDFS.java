import java.util.*;
import java.util.LinkedList;

public class BFSyDFS {

    public static List generarLista(int [][] matrizAdyacencia){
        List <List<Integer>> listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }

        for(int ind = 0; ind < matrizAdyacencia.length; ind++){
            for(int ind2 = 0; ind2 < matrizAdyacencia.length; ind2++){
                if(matrizAdyacencia[ind][ind2] == 1){
                    listaAdyacencia.get(ind).add(ind2);
                }
            }
        }
        return listaAdyacencia;
    }

    public static void bfs(List<List<Integer>>grafo, int nodoInicial){
        Queue<Integer> cola = new LinkedList<>();
        boolean [] visitados = new boolean[grafo.size()];

        cola.offer(nodoInicial);
        visitados[nodoInicial] = true;

        while(!cola.isEmpty()){
            int nodoActual = cola.poll();
            System.out.print(nodoActual + " ");
            for(int vecino : grafo.get(nodoActual)){
                if(!visitados[vecino]){
                    cola.offer(vecino);
                    visitados[vecino] = true;
                }
            }
        }
    }

    public static void dfs(List<List<Integer>>grafo, int nodoInicial){
        boolean [] visitados = new boolean[grafo.size()];
        dfsRecursivo(grafo, nodoInicial, visitados);

    }

    private static void dfsRecursivo(List<List<Integer>>grafo, int nodoActual, boolean [] visitados){
        visitados[nodoActual] = true;
        System.out.print(nodoActual + " ");
        for(int vecino : grafo.get(nodoActual)){
            if(!visitados[vecino]){
                dfsRecursivo(grafo, vecino, visitados);
            }
        }

    }

    public static void main(String[] args) {
        int [][] matrizAdyacencia = {
                {0,1,0,0,1,0,1,0,0,0},
                {1,0,1,1,0,0,0,0,0,0},
                {0,1,0,0,1,0,0,1,1,0},
                {0,1,0,0,0,0,0,1,1,0},
                {1,0,1,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,1,1,0},
                {1,0,0,0,0,0,0,0,0,1},
                {0,0,1,1,0,1,0,0,1,1},
                {0,0,1,1,0,1,0,1,0,0},
                {0,0,0,0,1,0,1,1,0,0}};

        List<List<Integer>> listaAdyacencia = generarLista(matrizAdyacencia);
        int n;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Ingrese el nodo inicial: ");
            n = sc.nextInt();
        }while(n < 0 || n >= listaAdyacencia.size());

        System.out.println("BFS: ");
        bfs(listaAdyacencia, n);

        System.out.println("\nDFS: ");
        dfs(listaAdyacencia, n);
    }
}

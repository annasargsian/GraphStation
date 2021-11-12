package com.company;

import java.util.*;

public class Dijkstra {
    static public class Pair implements Comparable<Pair> {
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Dijkstra.Pair o) {
            if (this.second != o.second)
                return this.second - o.second;
            return this.first - o.first;
        }

        public int first;
        public int second;

    };
    static public class Graph {
        Graph(int V) {
            edges = new ArrayList<List<Pair>>(V);
            for (int i = 0; i < V; ++i) {
                edges.add(new ArrayList<Pair>());
            }
        }
        public void addEdge(int v1, int v2, int length) {
            edges.get(v1).add(new Pair(v2, length));
        }
        public int getVertexCount() {
            return edges.size();
        }
        public List<List<Pair>> edges;
    }

    public static Graph read_graph(Scanner sc) {
        int V = sc.nextInt();
        int E = sc.nextInt();
        Graph g = new Graph(V);
        int v1, v2, length;
        for (int i = 0; i < E; ++i) {
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            length = sc.nextInt();
            g.addEdge(v1 - 1, v2 - 1, length);
            // If undirected graph.
            g.addEdge(v2 - 1, v1 - 1, length);
        }
        return g;
    }

    public static int dijkstra(Graph g, int s, int t) {
        int V = g.getVertexCount();
        int D[] = new int[V];
        boolean marked[] = new boolean[V];
        for (int i = 0; i < V; ++i) {
            D[i] = Integer.MAX_VALUE;
        }
        D[s] = 0;
        Queue<Pair> Q = new PriorityQueue<Pair>();
        Q.add(new Pair(s, 0));
        for (int i = 0; i < V; ++i) {
            Pair best = Q.poll();
            int min_index = best.first;
            int min_value = best.second;
            marked[min_index] = true;
            for (Pair p : g.edges.get(min_index)) {
                int v2 = p.first;
                int length = p.second;
                if (D[min_index] + length < D[v2]) {
                    Q.remove(new Pair(v2, D[v2]));
                    D[v2] = D[min_index] + length;
                    Q.add(new Pair(v2, D[v2]));
                }
            }
        }
        return D[t];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph g = read_graph(sc);
        int s, t;
        s = sc.nextInt() - 1;
        t = sc.nextInt() - 1;

        System.out.println(dijkstra(g, s, t));
    }
}

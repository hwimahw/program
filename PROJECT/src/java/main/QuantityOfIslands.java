package java.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class QuantityOfIslands {
    public static void main(String[] args) throws FileNotFoundException {
        Matrix matrix = new Matrix();
        Graph graph = new Graph(matrix);
        for(int i = 0; i < graph.n; i++){
            for(int j = 0; j < graph.n; j++){
                System.out.print(graph.arrayGraph[i][j]);
            }
            System.out.println();
        }

        int quantityOfDots = 0;
        for(int i = 0; i < matrix.n; i++){
            for(int j = 0; j < matrix.m; j++){
                if(matrix.arrayMatrix[i][j] == '.'){
                    quantityOfDots++;
                }
            }
        }

        ArrayList<Island> islands = new ArrayList<>();
        System.out.println();
        System.out.println(quantityOfDots);
        System.out.println("Quantity of islands: " + (graph.quantityOfIslands(graph, islands) - quantityOfDots));
    }

}

class Island{
    ArrayList<Integer> island = new ArrayList<>();
    public void add(Integer integer){
        island.add(integer);
    }
}

class Matrix{
    int n;
    int m;
    char[][] arrayMatrix;

    Matrix() throws FileNotFoundException{
        fillMatrix();
    }

    public void fillMatrix() throws FileNotFoundException{
        try {
            Scanner sc = new Scanner(new FileReader("input.txt"));
            this.n = sc.nextInt();
            this.m = sc.nextInt();
            sc.nextLine();
            this.arrayMatrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                // System.out.println(str);
                char[] arr = str.toCharArray();
                System.arraycopy(arr, 0, arrayMatrix[i], 0, arr.length);
            }
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException");
            throw new FileNotFoundException();
        }


    }
}

class Graph {

    int n;
    char[][] arrayGraph;
    int[] color;

    Graph(Matrix matrix) {
        this.n = matrix.n * matrix.m;
        arrayGraph = new char[n][n];
        color = new int[n];
        for(int i = 0; i < n; i++){
            color[i] = 0;
        }
        fillGraph(matrix, matrix.n, matrix.m);
    }

    public void fillGraph(Matrix matrix, int n, int m) {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                arrayGraph[i][j] = '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i >= 1 && i <= n - 2) && (j >= 1 && j <= m - 2)) {
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                            arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                            arrayGraph[i * m + (j - 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                            arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                            arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                            arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                            arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                            arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                            arrayGraph[(i - 1) * m + j][i * m + j] = '1';
                        }
                    }
                }


                if(i == 0 && (j >= 1 && j <= m - 2)) {
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                            arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                            arrayGraph[i * m + (j - 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                            arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                            arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                            arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                            arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                        }
                    }
                }

                if((i == (n - 1)) && (j >= 1 && j <= m - 2)){
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                            arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                            arrayGraph[i * m + (j - 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                            arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                            arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                            arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                            arrayGraph[(i - 1) * m + j][i * m + j] = '1';
                        }
                    }
                }

                if((j == 0) && (i >= 1 && i <= n - 2)){
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                            arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                            arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                        }
                        System.out.println(i + " " + j);
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                            arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                            arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                            arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                            arrayGraph[(i - 1) * m + j][i * m + j] = '1';
                        }
                    }
                }

                if((j == (m - 1)) && (i >= 1 && i <= n - 2)){
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                            arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                            arrayGraph[i * m + (j - 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                            arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                            arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                            arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                            arrayGraph[(i - 1) * m + j][i * m + j] = '1';
                        }
                    }
                }

                if(i == 0 && j == 0){
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                            arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                            arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                            arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                            arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                        }
                    }
                }

                if(i == 0 && j == m - 1){
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if(matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                            arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                            arrayGraph[i * m + (j - 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                            arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                            arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                        }
                    }
                }

                if((i == (n - 1)) && j == 0){
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                            arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                            arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                            arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                            arrayGraph[(i - 1) * m + j][i * m + j] = '1';
                        }
                    }
                }

                if((i == (n - 1)) && (j == (m - 1))){
                    if (matrix.arrayMatrix[i][j] == '#') {
                        arrayGraph[i * m + j][i * m + j] = '1';
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                            arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                            arrayGraph[i * m + (j - 1)][i * m + j] = '1';
                        }
                        if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                            arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                            arrayGraph[(i - 1) * m + j][i * m + j] = '1';
                        }

                    }
                }
            }
        }
    }

    public int quantityOfIslands(Graph graph, ArrayList<Island> islands){

        int quantityOfConnectedComponent = 0;
        for(int i = 0; i < graph.n; i++){
            Island island;
            if(color[i] == 0){
                island = new Island();
                quantityOfConnectedComponent++;
                dfs(i, quantityOfConnectedComponent, island);
                islands.add(island);
            }
        }
        return islands.size();
    }


    public void dfs(int i, int quantity, Island island){
        island.add(i);
        color[i] = quantity;
        for(int j = 0; j < arrayGraph.length; j++){
            if(arrayGraph[i][j] == '1' && color[j] == 0){
                dfs(j, quantity, island);
            }
        }
    }
}

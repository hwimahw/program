package ru.ncd;

import ru.ncd.Graph;
import ru.ncd.Matrix;
import ru.ncd.Island;
import org.junit.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainTest{

    public Matrix matrix;
    public Graph graph;
    int quantityOfDots;

    @Before
    public void buildAndCheckBuildingOfElements() throws FileNotFoundException {
        System.out.println("Матрица из файла и её размер");
        matrix = new Matrix();
        System.out.println(matrix.n + " " + matrix.m);
        for(int i = 0; i < matrix.n; i++){
            for(int j = 0; j < matrix.m; j++){
                System.out.print(matrix.arrayMatrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Матрица смежности графа и её размер");
        graph = new Graph(matrix);
        System.out.println(graph.n);
        for(int i = 0; i < graph.n; i++){
            for(int j = 0; j < graph.n; j++){
                System.out.print(graph.arrayGraph[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void quantityOfDots(){
        System.out.println("Количество точек в файле");
        quantityOfDots = 0;
        for(int i = 0; i < matrix.n; i++){
            for(int j = 0; j < matrix.m; j++){
                if(matrix.arrayMatrix[i][j] == '.'){
                    quantityOfDots++;
                }
            }
        }
        System.out.println(quantityOfDots);
        System.out.println();
    }

    @Test
    public void checkResult(){
        System.out.println("Ответ");
        ArrayList<Island> islands = new ArrayList<>();
        quantityOfDots();
        System.out.println("Quantity of islands: " + (graph.quantityOfIslands(graph, islands) - quantityOfDots));
        System.out.println();
    }
}
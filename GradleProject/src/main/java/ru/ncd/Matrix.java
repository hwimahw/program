package ru.ncd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Matrix{
    public int n;
    public int m;
    public char[][] arrayMatrix;

    public Matrix() throws FileNotFoundException {
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
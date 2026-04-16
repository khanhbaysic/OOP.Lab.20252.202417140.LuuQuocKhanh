package hust.soict.dsai.lab01;
import java.util.Scanner;
public class Assignment6_6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int columns = sc.nextInt();
        int[][] A = new int[rows][columns];
        int[][] B = new int[rows][columns];
        int[][] C = new int[rows][columns];
        System.out.println("Enter the elements of matrix A: ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the elements of matrix B: ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                B[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("The sum of matrices A and B is: ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
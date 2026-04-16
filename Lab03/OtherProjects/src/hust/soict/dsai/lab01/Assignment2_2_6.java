package hust.soict.dsai.lab01;
import java.util.Scanner;
public class Assignment2_2_6{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Select a number: ");
            System.out.println("1. Solve the first-degree equations with one variable");
            System.out.println("2. Solve the first-degree equations with two variables");
            System.out.println("3. Solve the second-degree equations with one variable");
            System.out.println("4. Exit");
            int choice;
            if(sc.hasNextInt()){
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }
        switch(choice){
            case 1:
                double a, b;
                System.out.print("Enter coefficient a: ");
                a = sc.nextDouble();
                System.out.print("Enter coefficient b: ");
                b = sc.nextDouble();
                if (a != 0) {
                    double x = -b / a;
                    System.out.println("The solution is  " + x);
                } else {
                    if (b == 0) {
                        System.out.println("The equation has infinitely many solutions.");
                    } else {
                        System.out.println("The equation has no solution.");
                    }
                }
                break;
            case 2:
                    double a1, b1, c1, a2, b2, c2;
                    System.out.print("Enter coefficients a1, b1, c1 for the first equation: ");
                    a1 = sc.nextDouble();
                    b1 = sc.nextDouble();
                    c1 = sc.nextDouble();
                    System.out.print("Enter coefficients a2, b2, c2 for the second equation: ");
                    a2 = sc.nextDouble();
                    b2 = sc.nextDouble();
                    c2 = sc.nextDouble();
                    double det = a1 * b2 - a2 * b1;
                    if (det != 0) {
                        double x = (c1 * b2 - c2 * b1) / det;
                        double y = (a1 * c2 - a2 * c1) / det;
                        System.out.println("The solution is x = " + x + ", y = " + y);
                    } else {
                        if (a1 * c2 == a2 * c1 && b1 * c2 == b2 * c1) {
                            System.out.println("The system has infinitely many solutions.");
                        } else {
                            System.out.println("The system has no solution.");
                        }
                    }
                break;
            case 3:
                double a3, b3, c3;
                System.out.print("Enter coefficient a: ");
                a3 = sc.nextDouble();
                System.out.print("Enter coefficient b: ");
                b3 = sc.nextDouble();
                System.out.print("Enter coefficient c: ");
                c3 = sc.nextDouble();
                double delta = b3 * b3 - 4 * a3 * c3;
                if (delta > 0) {
                    double x1 = (-b3 + Math.sqrt(delta)) / (2 * a3);
                    double x2 = (-b3 - Math.sqrt(delta)) / (2 * a3);
                    System.out.println("The equation has two distinct roots: x1 = " + x1 + ", x2 = " + x2);
                } else if (delta == 0) {
                    double x = -b3 / (2 * a3);
                    System.out.println("The equation has one root: x = " + x);
                } else {
                    System.out.println("The equation has no4 roots.");
                }
                break;
            case 4:
                System.out.println("Exiting the program.");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice. Please select a number between 1 and 4.");}
        }
    }
}

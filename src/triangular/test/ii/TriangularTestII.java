/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangular.test.ii;
import java.util.*;

/**
 *
 * @author osiri
 */
public class TriangularTestII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean con = true;
        int in, es, min = 0, m;
        char c;
        String temp;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("Introduce el numero que quiera estimar");
        try {
            temp = sc.nextLine();
            in = Integer.parseInt(temp);
            if (in <= 0){
                System.out.println("No puedo hacer lo que me pide con un numero negativo");
            }else{
                es = estratoMasCercano(in);
                if (calcularEstrato(es) == in){
                    System.out.println("El numero que dio ya es triangular");
                }else{
                    min = getMin(in, es);
                }
                System.out.println("El minimo de conbinaciones de numeros triangulares es "+min);
                System.out.println("Para terminar la operacion precione 1");
                temp = sc.nextLine();
                if (temp.equals(1)){
                    con = false;
                }
            }
        } catch (NumberFormatException excepcion) {
            System.out.println("Ponga una opcion valida");
            System.out.println("Reiniciando proceso");
        }
        }while(con);
        
    }

    private static int estratoMasCercano(int in) {
        int c = 1;
        int s = 1;
        boolean fin = false;
        while (!fin){
            if (c + s + 1 > in){
                fin = true;
            } else {
                s = s + 1;
                c = c + s;
            }
        }
        return s;
    }

    private static int calcularEstrato(int es) {
        int to = 0;
        for (int i = 1; i  >= es; i++){
            to = to + i;
        }
        return to;
    }
    
    private static int getMin (int in, int es){
        boolean t = true;
        int total = 0;
        do{
            in = in - calcularEstrato(es);
            total++;
            if (in == 0){
                t = false;
            }else{
             es = estratoMasCercano(in);   
            }
        }while (t);
        return total;
    }
}

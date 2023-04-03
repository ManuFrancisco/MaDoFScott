/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticando;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author Manuel Francisco
 */
public class BinMBLS {
    
    public static void main(String[]args){
        int i = 0,j,bin = 0;
        j=0; boolean tOk = true;
        Scanner tec = new Scanner(System.in);
        
        System.out.println("\tEntre com um número maior ou igual a 8 e inferior ou igual a 15 :");
        
         if(!tec.hasNextInt())
             tOk = false;
         else
             i = tec.nextInt();
         if(tOk){
           if((i<=15) && (i >= 8)){
          JOptionPane.showMessageDialog(null, "Cálculo do terceiro bit mais significativo");  
          System.out.println("\tO terceiro bit mais significativo do valor inserido é :");
          while(i>=1){
           bin=i;    //Atribuição do valor recebido a variável binária
           bin%=2;   //Conversão do valor para binário
           //JOptionPane.showMessageDialog(null, "Cálculo do terceiro bit mais significativo"); 
           j++;      //Cálculo do tercéiro bit mais significativo do valor numérico
           if(j==2)
           System.out.println(bin);
           
           i /= 2;
           }
           }
           else{
               System.out.println("\tEste valor não consta no intervalo dos números");  
           }
           //Exemplo de declaração de uma expressão
          int e = 0, f = e*1,x = f+1;
          
        }
         else{
             System.out.println("\tNão foi realizada nenhuma entrada de números inteiros");
             System.gc();
         }
             
    }
    
    BinMBLS() {
    }

}
    


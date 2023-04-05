/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticando;

import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Francisco
 */
public class DecimalParaBinV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int dec, bin = 0, cont = 0,decimal = 0;  String str ="";
        int[] Bit = new int[010]; //valor 8 em octal (010)
      
        dec=Integer.parseInt(JOptionPane.showInputDialog("\t\n Insira um número para converter em binário:\n"));
       if(dec <= 255){
            
        while(dec >= 1){     /*Estamos a converter o valor inserido decimal para o estado em binário */
           bin = dec;              
           bin%= 2;                          
           Bit[cont] = bin;                       
           cont++; 
         dec/=2;
        }
       }
       else{
          System.out.println("Este valor excede 255, não pode ser convertido!");
          System.out.println("Valor convertido em binário sem sucesso!\n");
       }
       if(dec < 0)
               System.out.println("Lamento, este valor não pode ser convertido com sucesso!");
               
         for(cont=Bit.length-1; cont >= 0; cont--)
         //System.out.print(Bit[cont])
         str += Bit[cont]; //Conversão de vetor para sequência de caracteres
        
       
        JOptionPane.showMessageDialog(null, str); // Valor inserido transformado em binário
        //Conversão de binário para decimal
       for(cont=Bit.length-1; cont >= 0; cont--)
          Bit[cont] = Integer.getInteger(str, Bit[cont]); //**Conversão da sequencia de caracteres de volta para sequencia
                                                            //de valores inteiros**
       
       for(cont = Bit.length - 1; cont >= 0; cont--)
         System.out.print(Bit[cont]);  //Valor convertido de String para vetor de numeros inteiros e consequente -
         System.out.println("\n\n");    //mente apresenta - se novamente o valor convertido em binário
          
       int k = 0, pot = 1, num, aux = 0;
       
        for(cont = 0; cont <= Bit.length-1;  cont++){
              //System.out.print(Bit[cont]);
               num = Bit[cont];
               if(num == 1){
               aux = pot; k++;     //convertendo o valor binário de volta para decimal
               aux *= num;
               decimal += aux;
               }
               pot *= 2; 
                        
        }
           if(k > 0){ System.out.println("Valor convertido em binário com sucesso!\n");
               JOptionPane.showMessageDialog(null,"Que tal vê-lo novamente em decimal!?");
               JOptionPane.showMessageDialog(null,decimal);
             System.out.println("Valor convertido de volta em decimal é: "+ decimal);  //Valor binário convertido de volta para decimal e 
                      //apresentado com sucesso
                      System.out.println("\n");
           }
           
           
    }

    private DecimalParaBinV2() {
    }
  }
    


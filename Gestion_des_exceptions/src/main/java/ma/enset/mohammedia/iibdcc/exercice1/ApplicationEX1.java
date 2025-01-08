package ma.enset.mohammedia.iibdcc.exercice1;

import java.util.Scanner;

public class ApplicationEX1 {
    public static void main(String[] args) {
        EntierNaturel en = new EntierNaturel();
        try{
            int nb;
            do {
                System.out.println("1.Enter an integer: ");
                System.out.println("2.afficher an integer: ");
                System.out.println("3.decrementer an integer: ");
                System.out.println("4.Quitter le programme: ");
                nb = new Scanner(System.in).nextInt();
                switch (nb) {
                    case 1:
                        System.out.println("Enter an integer: ");
                        int val = new Scanner(System.in).nextInt();
                        en.setVal(val);
                        break;
                    case 2:
                        System.out.println(en);
                        break;
                    case 3:
                        en.decrementer();
                        break;
                    case 4:
                        System.out.println("Quitter le programme ... ");

                }

            }while (nb != 4);
        }catch (NombreNegatifException e){
            System.out.println("Exception levée : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getValeurErronee());
        }catch (Exception e){
            System.out.println("Autre exception levée : " + e.getMessage());

        }
    }
}

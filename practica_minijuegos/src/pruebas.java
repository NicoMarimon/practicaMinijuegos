import java.util.Scanner;
public class pruebas {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String entrada = "";
        entrada = input.next();
        char [] entrada_char_array = entrada.toCharArray();
        char letra = ' ';

        if (entrada_char_array.length == 1){
            letra = entrada_char_array[0];
        }
        System.out.println(letra);
    }
}

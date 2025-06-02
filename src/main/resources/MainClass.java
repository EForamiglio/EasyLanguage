import java.util.*;

public class MainClass {
  public static Scanner _key = new Scanner(System.in);

  public static int fatorial(String n) {
    if (n<=1) {
    return 1;
} else {
    return n*fatorial(n-1);
}
}
  public static void main(String args[]){
    int  numero;
    int  resultado;
    String  n;
    System.out.println("Digite um número para calcular o fatorial: ");
    numero= _key.nextInt();
    resultado = fatorial(numero);
    System.out.println("O fatorial de " + numero + " é " + resultado);
  }
}

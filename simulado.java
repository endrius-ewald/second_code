import java.util.*;

public class simulado{
  public static void main(String args[]){
    
    double x[];
    int n;
    
    Scanner leia = new Scanner(System.in);
    
    System.out.println("Digite a quantidade de numeros");
    
    n = leia.nextInt();
    
    x = new double[n];
    
    System.out.println("Digite os numeros");
    
    for(int i = 0; i < n; i++){
      x[i] = leia.nextDouble();
    }
    
    System.out.println("Media é " + media(x));
    
    
    
  }
  
  
  public static double media(double x[]){
    double media = 0;
    for(int I = 0; I < x.length; I++){
      media = media + x[I];
    }
    media = media / x.length;
    return media;
  }
}


public class Principal {

    public static void main(String[] args) {
        //Valor máximo a ser verificado se é primo
        int n = 10000;
        Crivo c = new Crivo(n);
        c.encontraPrimo();        
        for (int i = 1; i < n; ++i) {
            if (c.ePrimo(i)) {
                System.out.println(i + " é primo");
            }
        }
        System.out.println("Qtde de números primos: " + c.qtdePrimo());
    }
}

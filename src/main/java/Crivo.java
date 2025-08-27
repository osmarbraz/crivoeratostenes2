/**
 * Crivo de Erastóstenes.
 * 
 * Esta implementação utiliza um BitSet para criar a lista dos números a serem verificados.
 * 
 */
import java.util.BitSet;

public class Crivo {

    /* Bitset que armazena os números que são primos */
    private BitSet primos;

    /* Valor limite, o maior número que desejamos saber se é primo. */
    private int n;

    /**
     * Construtor com argumentos.
     *
     * @param n Valor limite, o maior número que desejamos saber se é primo.
     */
    public Crivo(int n) {
        this.n = n;
        //Cria o bitSet a ser verificado
        primos = new BitSet(n);
    }

     /**
     * Verifica se os números no intervalo de 0 até n são primos.
     * 
     * Executa o Crivo de Erastóstenes para encontrar os números primos até n.
     */
    public void encontraPrimo() {

        /* Faz a raiz quadrada do valor limite */
        int raiz = (int) Math.sqrt(n);

        /* marcando todos os bits como primos */
        primos.set(0, n, true);
        
        /* Procura o primeiro bit primo, e desmarcar todos os bits 
         que são múltiplos dele. */
        //O e 1 já são definidos como primos, portanto inicia em 2
        for (int i = 2; i <= raiz; i = primos.nextSetBit(i + 1)) {
            //Começa com o primeiro multiplo depois de i, ou seja 2 * i = i + 1
            //Avança para o próximo multiplo ou seja j = j + i
            for (int j = i + i; j <= n; j = j + i) {
                //Elimina o número, criva o bit!
                primos.clear(j);
            }
        }
    }

    /**
     * Verifica se um número i é primo verifica o vetor primos se é diferente de
     * 0.
     *
     * @param i Valor a ser verificado se é primo.
     * @return Verdadeiro ou falso se o número é primio.
     */
    public boolean ePrimo(int i) {
        return primos.get(i);
    }

    /**
     * Retorna a quantidade de números primos.
     *
     * @return Um valor inteiro com a quantidade de primos no vetor primos.
     */
    public int qtdePrimo() {
        int qtde = 0;
        for (int i = 1; i < n; ++i) {
            if (ePrimo(i)) {
                qtde = qtde + 1;
            }
        }
        return qtde;
    }

    /**
     * Recuperador de N.
     * 
     * @return Um inteiro com o valor máximo a ser verificados.
     */
    public int getN() {
        return n;
    }

    /**
     * Modificador de N.
     * 
     * @param n Um valor inteiro para o valor máximo a ser verificado.
     */
    public void setN(int n) {
        this.n = n;
    }
}

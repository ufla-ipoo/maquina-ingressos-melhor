/**
 * MaquinaIngressos modela uma máquina de ingressos que emite
 * ingressos de preço fixo.
 * O preço de um ingresso é definido através do construtor.
 * Objetos verificam se o usuário informou quantidades de
 * dinheiro que fazem sentido, e só imprimir um ingresso se
 * há quantidade de dinheiro suficiente.
 * 
 * Traduzido por Julio César Alves - 2023.09.07
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MaquinaIngressos
{
    // O preço de um ingresso desta máquina
    private int preco;
    // A quantidade de dinheiro que o usuário colocou até o momento.
    private int saldo;
    // A quantidade total de dinheiro coletada pela máquina.
    private int total;

    /**
     * Cria uma máquina que emite ingressos de um dado preço.
     */
    public MaquinaIngressos(int custoIngresso)
    {
        preco = custoIngresso;
        saldo = 0;
        total = 0;
    }

    /**
     * Retorna o preço do ingresso.
     */
    public int obterPreco()
    {
        return preco;
    }

    /**
     * Retorna a quantidade de dinheiro já inserida para o
     * próximo ingresso.
     */
    public int obterSaldo()
    {
        return saldo;
    }

    /**
     * Recebe uma quantidade de dinheiro de um cliente.
     * Verifica se a quantidade passada faz sentido.
     */
    public void inserirDinheiro(int quantidade)
    {
        if (quantidade > 0) {
            saldo = saldo + quantidade;
        }
        else {
            System.out.println("Informe uma quantidade positiva em vez de : " + 
                quantidade);
        }
    }

    /**
     * Imprime um ingresso se usuário inseriu uma quantidade de
     * dinheiro suficiente, reduz o saldo de acordo com o preço
     * do ingresso.
     * Imprime uma mensagem de erro se é necessário inserir mais
     * dinheiro.
     */
    public void imprimirIngresso()
    {
        if (saldo >= preco) {
            // Simula a impressão de um ingresso
            System.out.println("##################");
            System.out.println("# Ingressos & Cia ");
            System.out.println("# Ingresso");
            System.out.println("# " + preco + " centavos.");
            System.out.println("##################");
            System.out.println();

            // Atualiza o total coletado com o saldo
            total = total + preco;
            // Reduz o saldo de acordo com o preço do ingresso
            saldo = saldo - preco;
        }
        else {
            System.out.println("Você precisa inserir pelo menos mais : " +
                (preco - saldo) + " centavos.");
        }
    }

    /**
     * Devolve o troco existente no saldo.
     * O saldo é zerado.
     */
    public int retornarTroco()
    {
        int troco;
        troco = saldo;
        saldo = 0;
        return troco;
    }
}

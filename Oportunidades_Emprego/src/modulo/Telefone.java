package modulo;

/**
 * Classe que monta o telefone de uma empresa
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see DDD			inteiro do ddd do telefone
 * @see numero 		numero do telefone
 */
public class Telefone {
	private int DDD;
    private long numero;

    /**
     * Método que junta o ddd e o numero formando o telefone.
     * @param DDD		ddd do telefone
     * @param numero	numero do telefone
     */
    
    public Telefone(int DDD, long numero) {
        this.DDD = DDD;
        this.numero = numero;
    }
    
    //retorna o DDD do telefone
    public int getDDD() {
        return DDD;
    }
    
    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    //retorna o numero do telefone
    public long getNumero() {
        return numero;
    }
    
    public void setNumero(long numero) {
        this.numero = numero;
    }

    /**
     *  Método toString() da classe Telefone. Constroi uma String contendo o valor de todas as váriaveis da classe Telefone.
     *  @return String 
     */
    @Override
    public String toString() {
        return "DDD: "+DDD+"\nNumero: "+numero;
    }
}

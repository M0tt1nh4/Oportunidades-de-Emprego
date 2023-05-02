package modulo;

public class Telefone {
	private int DDD;
    private long numero;

    public Telefone(int DDD, long numero) {
        this.DDD = DDD;
        this.numero = numero;
    }

    public int getDDD() {
        return DDD;
    }
    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public long getNumero() {
        return numero;
    }
    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "DDD: "+DDD+"\nNumero: "+numero;
    }
}

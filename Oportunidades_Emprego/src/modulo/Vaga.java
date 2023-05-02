package modulo;

public abstract class Vaga {
	protected String funcao;
    protected int qtd;
    protected int carga;
    protected double salario;

    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String Funcao) {
        funcao = Funcao;
    }

    public int getQtd() {
        return qtd;
    }
    public void setQtd(int Qtd) {
        qtd = Qtd;
    }

    public int getCarga() {
        return carga;
    }
    public void setCarga(int Carga) {
        carga = Carga;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double Salario) {
        salario = Salario;
    }
}

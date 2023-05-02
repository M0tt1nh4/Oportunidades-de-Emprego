package modulo;

public class VagaInexperiente extends Vaga{
	private boolean estagio;
    private boolean remunerado;

    public VagaInexperiente() {
        super();
    }

    public VagaInexperiente(String funcao, int qtd, int carga, double salario, boolean estagio, boolean remunerado){
        this.funcao = funcao;
        this.qtd = qtd;
        this.carga = carga;
        this.salario = salario;
        this.estagio = estagio;
        this.remunerado = remunerado;
    }

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

    public boolean getEstagio() {
        return estagio;
    }
    public void setEstagio(boolean est) {
        estagio = est;
    }

    public boolean getRemunerado() {
        return remunerado;
    }
    public void setRemunerado(boolean rem) {
        remunerado = rem;
    }

    @Override
    public String toString() {
        return "Funcao: "+funcao+
                "\nQuantidade de vagas: "+qtd+
                "\nCarga Horaria: "+carga+" horas"+
                "\nSalario inicial: R$"+salario+
                "\nEstagio: "+estagio+
                "\nRemunerado: "+remunerado;
    }
}

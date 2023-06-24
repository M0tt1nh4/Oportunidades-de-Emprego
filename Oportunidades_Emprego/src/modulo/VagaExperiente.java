package modulo;

public class VagaExperiente extends Vaga{
	private int anosdeExp;
    private String prerequisito;


    public VagaExperiente() {
        super();
    }

    public VagaExperiente(String funcao, int carga, int qtd, double salario, int anos, String Prerequisito){
        this.funcao = funcao;
        this.qtd = qtd;
        this.carga = carga;
        this.salario = salario;
        anosdeExp = anos;
        prerequisito = Prerequisito;
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

    public int getAnosdeExp() {
        return anosdeExp;
    }
    public void setAnosdeExp(int Anos) {
        anosdeExp = Anos;
    }

    public String getPrerequisito() {
        return prerequisito;
    }
    public void setPrerequisito(String prereq) {
        prerequisito = prereq;
    }

    @Override
    public String toString() {
        return "Funcao: "+funcao+
                "\nQuantidade de vagas: "+qtd+
                "\nCarga Horaria: "+carga+" horas"+
                "\nSalario inicial: R$"+salario+
                "\nAnos de Experiancia na area: "+anosdeExp+
                "\nPrerequisitos: "+prerequisito;
    }
}

package modulo;

public class Empresa {
	private long CNPJ;
    private String nome;
    private Telefone telefone;
    public VagaExperiente[] vagaExp = new VagaExperiente[50];
    public VagaInexperiente[] vagaInxp = new VagaInexperiente[50];
    private int qtdVagaExp;
    private int qtdVagaInxp;

    public Empresa(long cnpj, String nome, Telefone telefone, int qtdVagasexp, int qtdVagasinxp) {
        CNPJ = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        qtdVagaExp = qtdVagasexp;
        qtdVagaInxp = qtdVagasinxp;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public VagaExperiente[] getVagasExp() {
        return vagaExp;
    }
    public void setVagaExp(VagaExperiente[] vaga) {
        vagaExp = vaga;
    }
    public VagaInexperiente[] getVagasInxp() {
        return vagaInxp;
    }
    public void setVagaInxp(VagaInexperiente[] vaga) {
        vagaInxp = vaga;
    }

    public VagaExperiente getVagaExp(int pos) {
        return vagaExp[pos];
    }
    public void setVagaExp(VagaExperiente vaga, int pos) {
        vagaExp[pos] = vaga;
        vagaExp[pos].setEmpresa(this);
    }

    public VagaInexperiente getVagaInxp(int pos) {
        return vagaInxp[pos];
    }
    public void setVagaInxp(VagaInexperiente vaga, int pos) {
        vagaInxp[pos] = vaga;
        vagaInxp[pos].setEmpresa(this);
    }

    public int getQtdVagaExp() {
        return qtdVagaExp;
    }
    public void setQtdVagaExp(int qtdVagaexp) {
        qtdVagaExp = qtdVagaexp;
    }

    public int getQtdVagaInxp() {
        return qtdVagaInxp;
    }
    public void setQtdVagaInxp(int qtdVagainxp) {
        qtdVagaInxp = qtdVagainxp;
    }
    public int getQtdVagaTotal() {
    	return qtdVagaExp + qtdVagaInxp;
    }

    @Override
    public String toString() {
    	return "CNPJ: "+CNPJ+"\nNome: "+nome+"\nTelefone: "+telefone.getDDD()+" "+telefone.getNumero()+
    			"\nQuantidade de empregos oferecidos: "+(getQtdVagaExp()+getQtdVagaInxp());
    }
    @Override
    public boolean equals(Object emp) {
    	if (this.CNPJ == ((Empresa) emp).getCNPJ() && this.nome == ((Empresa) emp).getNome()  && this.telefone == ((Empresa) emp).getTelefone()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}

package modulo;

/**
 * Classe Empresa apresenta informações das Empresas possibilitando o CRUD de empresa. 
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see CNPJ
 * @see nome
 * @see telefone
 * @see vagaExp
 * @see vagaInxp
 * @see qtdVagaExp
 * @see qtdVagaInxp
 */

public class Empresa {
	private long CNPJ;
    private String nome;
    private Telefone telefone;
    public VagaExperiente[] vagaExp = new VagaExperiente[50];
    public VagaInexperiente[] vagaInxp = new VagaInexperiente[50];
    private int qtdVagaExp;
    private int qtdVagaInxp;

    /**
     * Este método apresenta as informações da empresa.
     * @param cnpj            cnpj da empresa.
     * @param nome			  nome da empresa.
     * @param telefone		  telefone da empresa.
     * @param qtdVagasexp	  quantidade de vagas experientes na empresa.
     * @param qtdVagasinxp    quantidade de vagas inexperientes na empresa.
     */
    
    public Empresa(long cnpj, String nome, Telefone telefone, int qtdVagasexp, int qtdVagasinxp) {
        CNPJ = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        qtdVagaExp = qtdVagasexp;
        qtdVagaInxp = qtdVagasinxp;
    }

    //get que retorna o CNPJ da empresa.
    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    //get que retorna o Nome da empresa.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //get que retorna o telefone da empresa.
    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    //get que retorna as Vagas Experientes da empresa.
    public VagaExperiente[] getVagasExp() {
        return vagaExp;
    }
    
    public void setVagaExp(VagaExperiente[] vaga) {
        vagaExp = vaga;
    }
    
    //get que retorna as Vagas Inexperientes da empresa.
    public VagaInexperiente[] getVagasInxp() {
        return vagaInxp;
    }
    
    public void setVagaInxp(VagaInexperiente[] vaga) {
        vagaInxp = vaga;
    }

    //get que retorna as Vagas Experientes da empresa de acordo com sua posição.
    public VagaExperiente getVagaExp(int pos) {
        return vagaExp[pos];
    }
    
    public void setVagaExp(VagaExperiente vaga, int pos) {
        vagaExp[pos] = vaga;
        vagaExp[pos].setEmpresa(this);
    }

    ////get que retorna as Vagas Inexperientes da empresa de acordo com sua posição
    public VagaInexperiente getVagaInxp(int pos) {
        return vagaInxp[pos];
    }
    
    public void setVagaInxp(VagaInexperiente vaga, int pos) {
        vagaInxp[pos] = vaga;
        vagaInxp[pos].setEmpresa(this);
    }

    //get que retorna a quantidade de Vagas Experientes.
    public int getQtdVagaExp() {
        return qtdVagaExp;
    }
    
    public void setQtdVagaExp(int qtdVagaexp) {
        qtdVagaExp = qtdVagaexp;
    }

    // //get que retorna a quantidade de Vagas Inexperientes.
    public int getQtdVagaInxp() {
        return qtdVagaInxp;
    }
    
    public void setQtdVagaInxp(int qtdVagainxp) {
        qtdVagaInxp = qtdVagainxp;
    }
    
    //get que retorna a quantidade de Vagas Totais da empresa.
    public int getQtdVagaTotal() {
    	return qtdVagaExp + qtdVagaInxp;
    }

    //toString que guarda as informações da empresa.
    @Override
    public String toString() {
    	return "CNPJ: "+CNPJ+"\nNome: "+nome+"\nTelefone: "+telefone.getDDD()+" "+telefone.getNumero()+
    			"\nQuantidade de empregos oferecidos: "+(getQtdVagaExp()+getQtdVagaInxp());
    }
    
    @Override
    public boolean equals(Object emp) {
    	if(this.CNPJ == ((Empresa) emp).getCNPJ() && this.nome == ((Empresa) emp).getNome()  && this.telefone == ((Empresa) emp).getTelefone()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}

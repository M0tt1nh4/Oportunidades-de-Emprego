package controle;

import modulo.*;

public class ControleDados {
    private Dados d = new Dados();

    public ControleDados() {
        d.fillWithSomeData();
    }

    public Dados getDados() {
        return d;
    }

    public void setDados(Dados dado) {
        d = dado;
    }

    public Empresa[] getEmpresas() {
        return d.getEmpresas();
    }

    public Empresa getEmpresa(int pos) {
        return d.getEmpresa(pos);
    }

    public int getQtdEmpresas() {
        return d.getQtdEmpresas();
    }

    public VagaExperiente[] getVagasExp() {
        return d.getVagasExp();
    }

    public VagaExperiente[] getVagasExp(int pos) {
        return d.getVagasExp(pos);
    }

    public VagaInexperiente[] getVagasInxp() {
        return d.getVagasInxp();
    }

    public VagaInexperiente[] getVagasInxp(int pos) {
        return d.getVagasInxp(pos);
    }

    public int getQtdVagasExp(int pos) {
        return d.getEmpresa(pos).getQtdVagaExp();
    }

    public int getQtdVagasInxp(int pos) {
        return d.getEmpresa(pos).getQtdVagaInxp();
    }

    public int getQtdVagas() {
        int qtdTotal = 0;
        for (int i = 0; i < d.getQtdEmpresas(); i++) {
            qtdTotal += d.getEmpresa(i).getQtdVagaExp() + d.getEmpresa(i).getQtdVagaInxp();
        }

        return qtdTotal;
    }
    public int getQtdExp() {
    	int qtdExp = 0;
        for (int i = 0; i < d.getQtdEmpresas(); i++) {
            qtdExp += d.getEmpresa(i).getQtdVagaExp() ;
        }
        return qtdExp;
    }
    public int getQtdInxp() {
    	int qtdInxp = 0;
        for (int i = 0; i < d.getQtdEmpresas(); i++) {
            qtdInxp += d.getEmpresa(i).getQtdVagaInxp() ;
        }
        return qtdInxp;
    }

    public boolean inserirEditarEmpresa(String[] novosDados) {
        if (!novosDados[1].matches("[0-9]+") || !novosDados[3].matches("[0-9]+") || novosDados[4].matches("[0-9]+")) {
            return false;
        } else {
            Telefone newTel = new Telefone(Integer.parseInt(novosDados[3]), Integer.parseInt(novosDados[4]));
            Empresa emp = new Empresa(Long.parseLong(novosDados[0]), novosDados[2], newTel, 0, 0);
            d.inserirEditarEmpresa(Integer.parseInt(novosDados[0]), emp);
            return true;
        }
    }

    public boolean inserirEditarVaga(String[] novosDados, int posEmp, int op) {
    	
	    double dbl;
	    try {
	    	dbl = Double.parseDouble(novosDados[4]);
	    } catch (NumberFormatException e){
	    	return false;
	    }
	    
	    if (op == 1) {
	    	
	    	if (!novosDados[2].matches("[0-9]+") || !novosDados[3].matches("[0-9]+") || !novosDados[5].matches("[0-9]+")) {
    			return false;
    		} else {
    			
    			VagaExperiente vg = new VagaExperiente(novosDados[1], Integer.parseInt(novosDados[2]), Integer.parseInt(novosDados[3]), dbl,
    					Integer.parseInt(novosDados[5]), novosDados[6]);
    			
    			d.inserirEditarVagaExp(Integer.parseInt(novosDados[0]), posEmp, vg);
    			
    			return true;
    		}
    		
	    } else {
	    	
	    	if (!novosDados[2].matches("[0-9]+") || !novosDados[3].matches("[0-9]+")) {
    			return false;
    		} else {

        			VagaInexperiente vg = new VagaInexperiente(novosDados[1], Integer.parseInt(novosDados[2]), Integer.parseInt(novosDados[3]), dbl,
        					Boolean.parseBoolean(novosDados[7]), Boolean.parseBoolean(novosDados[8]));
        			
        			d.inserirEditarVagaInxp(Integer.parseInt(novosDados[0]), posEmp, vg);
        			
        			return true;
    		}
	    	
	    }
	    	
    }
    
}
package modulo;

public class Dados {
	private Empresa[] empresas = new Empresa[50];
    int qtdEmpresas = 0;

    public void fillWithSomeData() {
        for (int i = 0; i < 5; i++) {
        	
            Telefone tel = new Telefone((i+1)*100, (i+1)*1000000);
            empresas[i] = new Empresa((i+1)*12345678912345L, "Empresa "+(i+1), tel, i+2, i+2);
            
            for (int j = 0; j < i+2; j++) {
            	
                VagaExperiente Vexp = new VagaExperiente(""+(j+1), (j+1)*10, j+1, (j+1)*1000, j*3, "A ser definido");
                VagaInexperiente Vinxp = new VagaInexperiente(""+(j+2), (j+2)*10, j+2, (j+2)*1000, false, true);
                
                empresas[i].setVagaExp(Vexp, j);
                empresas[i].setVagaInxp(Vinxp, j);
                
            }
            
            qtdEmpresas++;
            
        }
        
    }

    public Empresa[] getEmpresas() {
        return empresas;
    }
    
    public Empresa getEmpresa(int empresa) {
        return empresas[empresa];
    }
    
    public void setEmpresas(Empresa[] empresas) {
        this.empresas = empresas;
    }

    public int getQtdEmpresas() {
        return qtdEmpresas;
    }
    
    public void setQtdEmpresas(int a) {
        qtdEmpresas = a;
    }
    
    public VagaExperiente[] getVagasExp() {
    	int qtdVgs = 0;
    	
    	for (int i = 0; i < getQtdEmpresas(); i++) qtdVgs += getEmpresa(i).getQtdVagaExp();
    	
    	VagaExperiente[] vgs = new VagaExperiente[qtdVgs];
    	int x = 0;
    	
    	for (int i = 0; i < getQtdEmpresas(); i++) {
    		
    		for (int j = 0; j < getEmpresa(i).getQtdVagaExp(); j++) {
    			
    			vgs[x] = getEmpresa(i).getVagaExp(j);
    			x++;
    			
    		}
    		
    	}
    	
    	return vgs;
    }
    
    public VagaInexperiente[] getVagasInxp() {
    	int qtdVgs = 0;
    	
    	for (int i = 0; i < getQtdEmpresas(); i++) qtdVgs += getEmpresa(i).getQtdVagaInxp();
    	
    	VagaInexperiente[] vgs = new VagaInexperiente[qtdVgs];
    	int x = 0;
    	
    	for (int i = 0; i < getQtdEmpresas(); i++) {
    		
    		for (int j = 0; j < getEmpresa(i).getQtdVagaInxp(); j++) {
    			
    			vgs[x] = getEmpresa(i).getVagaInxp(j);
    			x++;
    		}
    		
    	}
    	
    	return vgs;
    }
    
    public VagaExperiente[] getVagasExp(int pos) {
    	VagaExperiente[] vgs = new VagaExperiente[50];
    	
    	int x = 0;
    	
    	for (int j = 0; j < getEmpresa(pos).getQtdVagaExp(); j++) {
    		
			vgs[x] = getEmpresa(pos).getVagaExp(j);
			x++;
			
		}
    	
    	return vgs;
    }
    
    public VagaInexperiente[] getVagasInxp(int pos) {
    	VagaInexperiente[] vgs = new VagaInexperiente[50];
    	
    	int x = 0;

		for (int j = 0; j < getEmpresa(pos).getQtdVagaInxp(); j++) {
			
			vgs[x] = getEmpresa(pos).getVagaInxp(j);
			x++;
			
		}
		
    	return vgs;
    }
    
    public void inserirEditarEmpresa(int pos, Empresa emp) {
    	
    	if (pos == qtdEmpresas) qtdEmpresas++;
    }
    
    public void inserirEditarVagaExp(int posVaga, int posEmp, VagaExperiente vg) {
    	empresas[posEmp].setVagaExp(vg, posVaga);
    	
    	if (posVaga == empresas[posEmp].getQtdVagaExp()) empresas[posEmp].setQtdVagaExp(posVaga+1);
    }
    
    public void inserirEditarVagaInxp(int posVaga, int posEmp, VagaInexperiente vg) {
    	empresas[posEmp].setVagaInxp(vg, posVaga);
    	
    	if (posVaga == empresas[posEmp].getQtdVagaInxp()) empresas[posEmp].setQtdVagaInxp(posVaga+1);
    }
}

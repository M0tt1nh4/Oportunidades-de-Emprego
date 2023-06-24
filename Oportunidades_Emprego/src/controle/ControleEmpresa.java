package controle;
import modulo.*;

public class ControleEmpresa {
	private Empresa[] empresas ;
	private int qtdEmp ;
	
	public ControleEmpresa(ControleDados d) {
		empresas = d.getEmpresas();
		qtdEmp = d.getQtdEmpresas();
	}
	
	public Empresa[] getempresa() {
		return empresas;
	}
	
    public int getqtdEmp() {
    	return qtdEmp;
    }
    
    public String[] getNomeEmpresas() {
    	String[] b = new String[qtdEmp];
    	for(int i =0; i<qtdEmp;i++) {
    		b[i]=empresas[i].getNome();
    	}
    	return b;
    }
    
    public int getPosEmp(Empresa emp) {
    	for (int i = 0; i < qtdEmp; i++) {
    		if (empresas[i].equals(emp)) return i;
    	}
    	return -1;
    }
    
}

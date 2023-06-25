package controle;
import modulo.*;

/**
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see empresa		vetor empresas
 * @see qtdEmp		quantidade de empresas
 */

public class ControleEmpresa {
	private Empresa[] empresas ;
	private int qtdEmp ;
	
	/**
	 * Método que controla a empresa
	 * @param d		dados da Controle Dados
	 */
	
	public ControleEmpresa(ControleDados d) {
		empresas = d.getEmpresas();
		qtdEmp = d.getQtdEmpresas();
	}
	
	//get de empresa
	public Empresa[] getempresa() {
		return empresas;
	}
	
	//get quantidade de empresa
    public int getqtdEmp() {
    	return qtdEmp;
    }
    
    //get nome de empresas
    public String[] getNomeEmpresas() {
    	String[] b = new String[qtdEmp];
    	for(int i =0; i<qtdEmp;i++) {
    		b[i]=empresas[i].getNome();
    	}
    	return b;
    }
    
    //get posição de empresa
    public int getPosEmp(Empresa emp) {
    	for (int i = 0; i < qtdEmp; i++) {
    		if (empresas[i].equals(emp)) return i;
    	}
    	return -1;
    }
    
}

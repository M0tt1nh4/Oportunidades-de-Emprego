package controle;
import modulo.*;
import view.TelaListaVagas;
public class ControleVagas {
    private Empresa emp;
    private VagaExperiente[] exp;
    private VagaInexperiente[] inexp;
    private int qtdexp;
    private int qtdinexp;
    private int qtdVagas;
	public ControleVagas(ControleDados d) {
		exp = d.getVagasExp();
		inexp = d.getVagasInxp();
		qtdexp = d.getQtdExp();
		qtdinexp = d.getQtdInxp();
		qtdVagas = d.getQtdVagas();
	}
	public ControleVagas(ControleDados d,int posi) {
		emp = d.getEmpresa(posi);
		exp = d.getVagasExp(posi);
		inexp = d.getVagasInxp(posi);
		qtdexp = d.getQtdVagasExp(posi);
		qtdinexp = d.getQtdVagasExp(posi);
		qtdVagas = d.getEmpresa(posi).getQtdVagaTotal();
	}
	public VagaExperiente[] getVagasExperientes() {
		return exp;
	}
	public VagaInexperiente[] getVagasInexperientes() {
		return inexp;
	}
	public int getQtdExp() {
		return qtdexp;
	}
	public int getQtdInexp() {
		return qtdinexp;
	}
	public String getNomeEmp() {
		return emp.getNome();
	}
	public String[] getFuncVagas(){
		String[] a = new String[qtdVagas];
		int x=0;
		for(int i=0;i<qtdexp;i++) {
			a[x] = exp[i].getFuncao();
			x++;
		}
		for(int i=0; i<qtdinexp;i++) {
			a[x] = inexp[i].getFuncao();
			x++;
		}
		return a;
	}
	public Empresa getEmpresaVaga(int pos) {
		if(pos<qtdexp) {
			return exp[pos].getEmpresa();
		}
		else {
			return inexp[pos-qtdexp].getEmpresa();
		}
	}
	public int getPosEmp(ControleDados d, int pos) {
		Empresa emp = getEmpresaVaga(pos);
		int i;
		for(i=0;i<d.getQtdEmpresas();i++) {
			if(emp.equals(d.getEmpresa(i))) break;
		}
		return i;
	}
	public String[] qualVaga(String funcao) {
		String [] a= new String[qtdVagas];
		int x=0;
		for(int i=0;i<qtdexp;i++) {
			if(!funcao.isEmpty()) {
			   if (exp[i].getFuncao()==funcao) {
				   a[x]=funcao;
				   x ++;
			   }
		    }
	    }
		for(int i=0;i<qtdinexp;i++) {
			if(!funcao.isEmpty()) {
				if(inexp[i].getFuncao()==funcao) {
					a[x]=funcao;
					x++;
				}
			}
		}
		return a;
	}
}

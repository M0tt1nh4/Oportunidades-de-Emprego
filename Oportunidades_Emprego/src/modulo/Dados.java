package modulo;

public class Dados {
	private Empresa[] empresas = new Empresa[50];
    int qtdEmpresas = 0;

    public void fillWithSomeData() {
        for (int i = 0; i < 5; i++) {
            Telefone tel = new Telefone((i+1)*100, (i+1)*1000000);
            empresas[i] = new Empresa((i+1)*12345678912345L, "Empresa "+(i+1), tel, i+2, i+2);
            for (int j = 0; j < i+2; j++) {
                VagaExperiente Vexp = new VagaExperiente(""+(j+1), j+1, (j+1)*10, (j+1)*1000, j*3, "A ser definido");
                VagaInexperiente Vinxp = new VagaInexperiente(""+(j+2), j+2, (j+2)*10, (j+2)*1000, true, false);
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
}

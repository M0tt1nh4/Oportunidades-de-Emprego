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

    public boolean inserirEditarEmpresa(String[] dados) {
        if (!dados[1].matches("[0-9]+") || !(dados[3].matches("[0-9]+") && dados[4].matches("[0-9]+"))) {
            return false;
        } else {
            Telefone newTel = new Telefone(Integer.parseInt(dados[3]), Integer.parseInt(dados[4]));
          //  d.inserirEditarEmpresa(Integer.parseInt(dados[0]), Long.parseLong(dados[1]), dados[2], newTel);
            return true;
        }
    }
}
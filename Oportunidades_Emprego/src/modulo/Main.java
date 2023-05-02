package modulo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Dados d = new Dados();
        Empresa[] empresas;

        d.fillWithSomeData();

        empresas = d.getEmpresas();

        int z = d.getQtdEmpresas();
        for (int i = 0; i < z; i++) {
            System.out.println("--------------------------------------");
        	System.out.println(empresas[i].toString());
        	System.out.println("--------------------------------------\n");
        }

        Scanner entrada = new Scanner(System.in);
        System.out.println("Voce deseja saber as vagas de qual empresa?");
        int in = entrada.nextInt();
        entrada.close();

        for (int i = 0; i < (empresas[in-1].getQtdVagaExp()+empresas[in-1].getQtdVagaInxp()); i++) {
            if (i < empresas[in-1].getQtdVagaExp()) {
                System.out.println("--------------------------------------");
                System.out.println("||Vaga Experiente||");
                System.out.println(empresas[in-1].vagaExp[i].toString());
                System.out.println("--------------------------------------\n");
            } else {
                System.out.println("--------------------------------------");
                System.out.println("||Vaga Inexperiente||");
                System.out.println(empresas[in-1].vagaInxp[i-empresas[in-1].getQtdVagaExp()].toString());
                System.out.println("--------------------------------------\n");
            }
        }
	}
}

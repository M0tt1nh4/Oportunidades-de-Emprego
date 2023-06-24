package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controle.*;


public class TelaInfoVaga implements ActionListener {
	private JFrame janela = new JFrame("Informação de Vaga");
	private JLabel labelFuncao = new JLabel("Função: ");
	private JTextField funcao = new JTextField();
	private JLabel labelCargahoraria = new JLabel("Carga Horária: ");
	private JTextField cargaHoraria = new JTextField();
	private JLabel labelQuantidade = new JLabel("Quantidade: ");
	private JTextField quantidade = new JTextField();
	private JLabel labelSalario = new JLabel("Salário: ");
	private JTextField salario = new JTextField();
	private JLabel labelAnosdeExp = new JLabel("Anos de Experiencia: ");
	private JTextField anosdeExp = new JTextField();
	private JLabel labelPreRequisitos = new JLabel("Pré-Requisitos: ");
	private JTextField preRequisitos = new JTextField();
	private JLabel labelRemunerado = new JLabel("Remunerado: ");
	private JRadioButton remunerado1 = new JRadioButton("Sim");
	private JRadioButton remunerado2 = new JRadioButton("Não");
	private JLabel labelEstagio = new JLabel("Estágio: ");
	private JRadioButton estagio1 = new JRadioButton("Sim");
	private JRadioButton estagio2 = new JRadioButton("Não");
	private JButton botaoEditar = new JButton("Editar");
	private ButtonGroup grupo1 = new ButtonGroup();
	private ButtonGroup grupo2 = new ButtonGroup();	
	private boolean editar=false;
	private static ControleDados dados;
	private int posi , posEmp ;
	private int  opc;
	
	public void mostrarInfoVaga(int opc, ControleDados d , int posEmp, int posi) {
		dados = d;
		this.posi = posi;
		this.posEmp=posEmp;
		this.opc=opc;
		switch(opc) {
			//vaga experiente
			case 1 : 
				janela.setSize(500, 350);
				janela.setLayout(null);
				
				labelFuncao.setBounds(100, 50, 150, 20);
				funcao.setBounds(240, 50, 150, 20);
				labelCargahoraria.setBounds(100, 80, 150, 20);
				cargaHoraria.setBounds(240, 80, 150, 20);
				labelQuantidade.setBounds(100, 110, 150, 20);
				quantidade.setBounds(240, 110, 150, 20);
				labelSalario.setBounds(100, 140, 150, 20);
				salario.setBounds(240,140 , 150, 20);
				labelAnosdeExp.setBounds(100, 170, 200, 20);
				anosdeExp.setBounds(240, 170, 150, 20);
				labelPreRequisitos.setBounds(100,200 ,200 , 20);
				preRequisitos.setBounds(240, 200, 150, 20);
				botaoEditar.setBounds(180, 230,130 ,20);
				
				funcao.setEditable(editar);
				cargaHoraria.setEditable(editar);
				quantidade.setEditable(editar);
				salario.setEditable(editar);
				anosdeExp.setEditable(editar);
				preRequisitos.setEditable(editar);
				
				funcao.setText(dados.getEmpresa(posEmp).getVagaExp(posi).getFuncao());
				cargaHoraria.setText(String.valueOf((dados.getEmpresa(posEmp).getVagaExp(posi).getCarga())));
				quantidade.setText(String.valueOf((dados.getEmpresa(posEmp).getVagaExp(posi).getQtd())));
				salario.setText(String.valueOf((dados.getEmpresa(posEmp).getVagaExp(posi).getSalario())));
				anosdeExp.setText(String.valueOf((dados.getEmpresa(posEmp).getVagaExp(posi).getAnosdeExp())));
				preRequisitos.setText(dados.getEmpresa(posEmp).getVagaExp(posi).getPrerequisito());
				
				janela.add(labelFuncao);
				janela.add(labelCargahoraria);
				janela.add(labelQuantidade);
				janela.add(labelSalario);
				janela.add(labelAnosdeExp);
				janela.add(labelPreRequisitos);
				janela.add(funcao);
				janela.add(cargaHoraria);
				janela.add(quantidade);
				janela.add(salario);
				janela.add(anosdeExp);
				janela.add(preRequisitos);
				janela.add(botaoEditar);
				
				
				janela.setVisible(true);
				
				botaoEditar.addActionListener(this);
				break;
			//vaga inexperiente
			case 2:
				janela.setSize(500, 350);
				janela.setLayout(null);
				
				labelFuncao.setBounds(100, 50, 150, 20);
				funcao.setBounds(240, 50, 150, 20);
				labelCargahoraria.setBounds(100, 80, 150, 20);
				cargaHoraria.setBounds(240, 80, 150, 20);
				labelQuantidade.setBounds(100, 110, 150, 20);
				quantidade.setBounds(240, 110, 150, 20);
				labelSalario.setBounds(100, 140, 150, 20);
				salario.setBounds(240,140 , 150, 20);
				labelRemunerado.setBounds(100, 170, 200, 20);
				remunerado1.setBounds(240, 170, 60, 20);
				remunerado2.setBounds(310, 170, 60, 20);
				grupo1.add(remunerado1);
				grupo1.add(remunerado2);
				labelEstagio.setBounds(100,200 ,200 , 20);
				estagio1.setBounds(240, 200, 60, 20);
				estagio2.setBounds(310, 200, 60, 20);
				grupo2.add(estagio1);
				grupo2.add(estagio2);
				botaoEditar.setBounds(160, 230,130 , 20);
				
				funcao.setEditable(editar);
				cargaHoraria.setEditable(editar);
				quantidade.setEditable(editar);
				salario.setEditable(editar);
			    if((dados.getEmpresa(posEmp).getVagaInxp(posi).getRemunerado())) {
			    	remunerado1.setSelected(true);
			    }else {
			    	remunerado2.setSelected(true);
			    }
				remunerado1.setEnabled(editar);
				remunerado2.setEnabled(editar);
				 if((dados.getEmpresa(posEmp).getVagaInxp(posi).getEstagio())) {
				    	estagio1.setSelected(true);
				    }else {
				    	estagio2.setSelected(true);
				    }
				estagio1.setEnabled(editar);
				estagio2.setEnabled(editar);
			
				funcao.setText(dados.getEmpresa(posEmp).getVagaExp(posi).getFuncao());
				cargaHoraria.setText(String.valueOf((dados.getEmpresa(posEmp).getVagaExp(posi).getCarga())));
				quantidade.setText(String.valueOf((dados.getEmpresa(posEmp).getVagaExp(posi).getQtd())));
				salario.setText(String.valueOf((dados.getEmpresa(posEmp).getVagaExp(posi).getSalario())));
				
				janela.add(labelFuncao);
				janela.add(labelCargahoraria);
				janela.add(labelQuantidade);
				janela.add(labelSalario);
				janela.add(labelRemunerado);
				janela.add(labelEstagio);
				janela.add(funcao);
				janela.add(cargaHoraria);
				janela.add(quantidade);
				janela.add(salario);
				janela.add(remunerado1);
				janela.add(remunerado2);
				janela.add(estagio1);
				janela.add(estagio2);
				janela.add(botaoEditar);
				
				janela.setVisible(true);
				
				botaoEditar.addActionListener(this);
				break;
			case 3:
				ControleVagas vgs=new ControleVagas(dados);
				if(posi<vgs.getQtdExp()) {
					janela.setSize(500, 350);
					janela.setLayout(null);
					
					labelFuncao.setBounds(100, 50, 150, 20);
					funcao.setBounds(240, 50, 150, 20);
					labelCargahoraria.setBounds(100, 80, 150, 20);
					cargaHoraria.setBounds(240, 80, 150, 20);
					labelQuantidade.setBounds(100, 110, 150, 20);
					quantidade.setBounds(240, 110, 150, 20);
					labelSalario.setBounds(100, 140, 150, 20);
					salario.setBounds(240,140 , 150, 20);
					labelAnosdeExp.setBounds(100, 170, 200, 20);
					anosdeExp.setBounds(240, 170, 150, 20);
					labelPreRequisitos.setBounds(100,200 ,200 , 20);
					preRequisitos.setBounds(240, 200, 150, 20);
					botaoEditar.setBounds(180, 230,130 , 20);
					
					funcao.setEditable(editar);
					cargaHoraria.setEditable(editar);
					quantidade.setEditable(editar);
					salario.setEditable(editar);
					anosdeExp.setEditable(editar);
					preRequisitos.setEditable(editar);
					
					funcao.setText(vgs.getVagasExperientes()[posi].getFuncao());
					cargaHoraria.setText(String.valueOf(vgs.getVagasExperientes()[posi].getCarga()));
					quantidade.setText(String.valueOf(vgs.getVagasExperientes()[posi].getQtd()));
					salario.setText(String.valueOf(vgs.getVagasExperientes()[posi].getSalario()));
					anosdeExp.setText(String.valueOf(vgs.getVagasExperientes()[posi].getAnosdeExp()));
					preRequisitos.setText(vgs.getVagasExperientes()[posi].getPrerequisito());
					
					janela.add(labelFuncao);
					janela.add(labelCargahoraria);
					janela.add(labelQuantidade);
					janela.add(labelSalario);
					janela.add(labelAnosdeExp);
					janela.add(labelPreRequisitos);
					janela.add(funcao);
					janela.add(cargaHoraria);
					janela.add(quantidade);
					janela.add(salario);
					janela.add(anosdeExp);
					janela.add(preRequisitos);
					janela.add(botaoEditar);
					
					
					janela.setVisible(true);
					
					botaoEditar.addActionListener(this);
				}
				else {
					janela.setSize(500, 350);
					janela.setLayout(null);
					
					labelFuncao.setBounds(100, 50, 150, 20);
					funcao.setBounds(240, 50, 150, 20);
					labelCargahoraria.setBounds(100, 80, 150, 20);
					cargaHoraria.setBounds(240, 80, 150, 20);
					labelQuantidade.setBounds(100, 110, 150, 20);
					quantidade.setBounds(240, 110, 150, 20);
					labelSalario.setBounds(100, 140, 150, 20);
					salario.setBounds(240,140 , 150, 20);
					labelRemunerado.setBounds(100, 170, 200, 20);
					remunerado1.setBounds(240, 170, 60, 20);
					remunerado2.setBounds(310, 170, 60, 20);
					grupo1.add(remunerado1);
					grupo1.add(remunerado2);
					labelEstagio.setBounds(100,200 ,200 , 20);
					estagio1.setBounds(240, 200, 60, 20);
					estagio2.setBounds(310, 200, 60, 20);
					grupo2.add(estagio1);
					grupo2.add(estagio2);
					botaoEditar.setBounds(160, 230,130 , 20);
					
					funcao.setEditable(editar);
					cargaHoraria.setEditable(editar);
					quantidade.setEditable(editar);
					salario.setEditable(editar);
				    if(vgs.getVagasInexperientes()[posi-vgs.getQtdExp()].getRemunerado()) {
				    	remunerado1.setSelected(true);
				    }else {
				    	remunerado2.setSelected(true);
				    }
					remunerado1.setEnabled(editar);
					remunerado2.setEnabled(editar);
					 if(vgs.getVagasInexperientes()[posi-vgs.getQtdExp()].getEstagio()) {
					    	estagio1.setSelected(true);
					    }else {
					    	estagio2.setSelected(true);
					    }
					estagio1.setEnabled(editar);
					estagio2.setEnabled(editar);
				
					funcao.setText(vgs.getVagasInexperientes()[posi-vgs.getQtdExp()].getFuncao());
                    cargaHoraria.setText(String.valueOf(vgs.getVagasInexperientes()[posi-vgs.getQtdExp()].getCarga()));
                    quantidade.setText(String.valueOf(vgs.getVagasInexperientes()[posi-vgs.getQtdExp()].getQtd()));
                    salario.setText(String.valueOf(vgs.getVagasInexperientes()[posi-vgs.getQtdExp()].getSalario()));
					
					janela.add(labelFuncao);
					janela.add(labelCargahoraria);
					janela.add(labelQuantidade);
					janela.add(labelSalario);
					janela.add(labelRemunerado);
					janela.add(labelEstagio);
					janela.add(funcao);
					janela.add(cargaHoraria);
					janela.add(quantidade);
					janela.add(salario);
					janela.add(remunerado1);
					janela.add(remunerado2);
					janela.add(estagio1);
					janela.add(estagio2);
					janela.add(botaoEditar);
					
					janela.setVisible(true);
					
					botaoEditar.addActionListener(this);
				}
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src==botaoEditar) {
			editar=true;
			mostrarInfoVaga(opc, dados , posEmp, posi);
		}
	}
	

}

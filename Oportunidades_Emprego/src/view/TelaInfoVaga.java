package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controle.*;

/**
 * Classe da Tela Informações de Vaga
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see funcao	   		 função das vagas
 * @see cargaHoraria	 Carga horária da vaga
 * @see qtd		   		 quantidade de vagas
 * @see salario	   		 Salario de uma vaga 
 * @see anosdeExp		 Anos de Experiência que a vaga pede
 * @see preRequisitos	 Pré Requisito da vaga
 * @see remunerado		 Se a vaga é remunerada ou não
 * @see estagio			 Se a vaga é estágio ou não
 */

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
	private JButton botaoSalvar = new JButton("Salvar");
	private ButtonGroup grupo1 = new ButtonGroup();
	private ButtonGroup grupo2 = new ButtonGroup();	
	private String[] novosDados = new String[9];
	private static ControleDados dados;
	private int posi; 
	private int posEmp;
	private int  opc;
	
	/**
	 * Método que monstra a tela Info Vaga 
	 * @param opc		de que tela o usuário está vindo
	 * @param d			dados da Controle Dados
	 * @param posEmp	posição da empresa
	 * @param posi		posição da vaga
	 */
	
	public void mostrarInfoVaga(int opc, ControleDados d , int posEmp, int posi) {
		
		dados = d;
		this.posi = posi;
		this.posEmp = posEmp;
		this.opc = opc;
		
		if (posEmp == -1) {
			
			ControleVagas vgs = new ControleVagas(dados);
			this.posEmp = vgs.getPosEmp(dados, posi);
			this.posi = vgs.getPosVg(dados, this.posEmp, this.posi);
			
			if (posi < vgs.getQtdExp()) {
				this.opc = 1;
			} else this.opc = 2;
		}
		
		switch(this.opc) {
		
			//Vaga experiente
			case 1 : 
				janela.setSize(500, 350);
				janela.setLayout(null);
				
				labelFuncao.setBounds(100, 50, 150, 20);
				labelCargahoraria.setBounds(100, 80, 150, 20);
				labelQuantidade.setBounds(100, 110, 150, 20);
				labelSalario.setBounds(100, 140, 150, 20);
				labelAnosdeExp.setBounds(100, 170, 200, 20);
				labelPreRequisitos.setBounds(100,200 ,200 , 20);
				
				funcao.setBounds(240, 50, 150, 20);
				cargaHoraria.setBounds(240, 80, 150, 20);
				quantidade.setBounds(240, 110, 150, 20);
				salario.setBounds(240,140 , 150, 20);
				anosdeExp.setBounds(240, 170, 150, 20);
				preRequisitos.setBounds(240, 200, 150, 20);
				
				botaoSalvar.setBounds(180, 230, 130, 30);
				
				funcao.setText(dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getFuncao());
				cargaHoraria.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getCarga())));
				quantidade.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getQtd())));
				salario.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getSalario())));
				anosdeExp.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getAnosdeExp())));
				preRequisitos.setText(dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getPrerequisito());
				
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
				janela.add(botaoSalvar);
				
				
				janela.setVisible(true);
				
				botaoSalvar.addActionListener(this);
				
				break;
				
			//Vaga inexperiente
			case 2:
				
				janela.setSize(500, 350);
				janela.setLayout(null);
				
				labelFuncao.setBounds(100, 50, 150, 20);
				labelCargahoraria.setBounds(100, 80, 150, 20);
				labelQuantidade.setBounds(100, 110, 150, 20);
				labelSalario.setBounds(100, 140, 150, 20);
				labelRemunerado.setBounds(100, 170, 200, 20);
				labelEstagio.setBounds(100,200 ,200 , 20);
				
				salario.setBounds(240,140 , 150, 20);
				quantidade.setBounds(240, 110, 150, 20);
				cargaHoraria.setBounds(240, 80, 150, 20);
				funcao.setBounds(240, 50, 150, 20);
				
				remunerado1.setBounds(240, 170, 60, 20);
				remunerado2.setBounds(310, 170, 60, 20);
				
				grupo1.add(remunerado1);
				grupo1.add(remunerado2);
				
				estagio1.setBounds(240, 200, 60, 20);
				estagio2.setBounds(310, 200, 60, 20);
				
				grupo2.add(estagio1);
				grupo2.add(estagio2);
				
				botaoSalvar.setBounds(180, 230, 130, 30);
				
			    if (dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getRemunerado()) {
			    	
			    	remunerado1.setSelected(true);
			    	
			    } else {
			    	
			    	remunerado2.setSelected(true);
			    	
			    }
			    
				 if(dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getEstagio()) {
					 
				    	estagio1.setSelected(true);
				    	
				    } else {
				    	
				    	estagio2.setSelected(true);
				    	
				    }
				 
				funcao.setText(dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getFuncao());
				cargaHoraria.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getCarga())));
				quantidade.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getQtd())));
				salario.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getSalario())));
				
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
				janela.add(botaoSalvar);
				
				janela.setVisible(true);
				
				botaoSalvar.addActionListener(this);
				
				break;
				
			default: 
				JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
						JOptionPane.ERROR_MESSAGE);
		
		}
	}
	
	/**
	 * Método que monstra em que o usuário clicou e determina o que vai acontecer na tela 
	 */
		
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//botão que salva novos dados
		if (src == botaoSalvar) {
			
			try {

				boolean save;
				
				novosDados[0] = Integer.toString(posi);
				novosDados[1] = funcao.getText();
				novosDados[2] = cargaHoraria.getText();
				novosDados[3] = quantidade.getText();
				novosDados[4] = salario.getText();
				
				if (opc == 1) {
					
					novosDados[5] = anosdeExp.getText();
					novosDados[6] = preRequisitos.getText();
					
				} else {
					
					if (remunerado1.isSelected()) {
						
						novosDados[7] = "true";
						
					} else novosDados[7] = "false";
					
					if (estagio1.isSelected()) {
						
						novosDados[8] = "true";
						
					} else novosDados[8] = "false";
					
				}
				
				save = dados.inserirEditarVaga(novosDados, posEmp, opc);
				
				if (save) {
					
					mensagemSucessoCadastro();
					
				}
				
			} catch (NullPointerException exc1) {
				
			} catch (NumberFormatException exc2) {
				
			}
			
		}
	}
	
	/**
	 * Método que monstra uma mensagem de Suceesso se os dados forem salvos 
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	

}

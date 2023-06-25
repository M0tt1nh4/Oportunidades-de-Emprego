package view;
import controle.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/**
 * Classe da Tela Listagem de Vagas
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see pesq 	pesquisa da vaga
 * @see lista	listagem das vagas
 */

public class TelaListaVagas implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Lista de Vagas");
	private JLabel pesq = new JLabel("Pesquisar Vagas");
	private JTextField barra = new JTextField();
	private JList<String> lista;
	private JScrollPane scroll ;
	private JButton busca = new JButton("Buscar");
	private JButton refresh = new JButton("Atualizar");
	private static ControleDados dados;
	private int op;
	private int posEmp;
	
	/**
	 * Método que monstra as vagas na tela
	 * @param d		dados do Controle Dados
	 * @param opc	de onde na tela vai monstrar as vagas
	 * @param posi	posição da vaga
	 */
	
	public void mostrarVagas(ControleDados d,int opc,int posi) {
		
		dados = d;
		op = opc;
		posEmp = posi;
		
		//monstra de onde na tela vem o monstrar vagas
		switch (op) {
			case 1:
				
				pesq.setBounds(90, 5, 160, 15);
				barra.setBounds(90, 20, 160, 25);
				busca.setBounds(290, 20, 100, 25);
				refresh.setBounds(180 ,260, 100, 30);
				
				lista = new JList<String>(new ControleVagas(dados,posEmp).getFuncVagas());
				scroll= new JScrollPane(lista);
				scroll.setBounds(90, 50, 300, 200);
				
		        janela.setLayout(null);
				
				janela.add(pesq);
				janela.add(barra);
				janela.add(busca);
				janela.add(refresh);
				janela.getContentPane().add(scroll);
				
				janela.setSize(500, 350);
				janela.setVisible(true);
				
				lista.addListSelectionListener(this);
				refresh.addActionListener(this);
				busca.addActionListener(this);
				
				break;
				
			case 2:
				pesq.setBounds(90, 5, 160, 15);
				barra.setBounds(90, 20, 160, 25);
				busca.setBounds(290, 20, 100, 25);
				refresh.setBounds(180 ,260, 100, 30);
				
				lista = new JList<String>(new ControleVagas(dados).getFuncVagas());
				scroll= new JScrollPane(lista);
				scroll.setBounds(90, 50, 300, 200);
				
		        janela.setLayout(null);
				
				janela.add(pesq);
				janela.add(barra);
				janela.add(busca);
				janela.add(refresh);
				janela.getContentPane().add(scroll);
				
				janela.setSize(500, 350);
				janela.setVisible(true);
				
				lista.addListSelectionListener(this);
				refresh.addActionListener(this);
				busca.addActionListener(this);
				
				break;
		}
	}
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//atualiza lista
		if (src == refresh) {
			
			if (op == 1) {
				
				lista.setListData(new ControleVagas(dados, posEmp).getFuncVagas());
				lista.updateUI();
				
			} else {
				
				lista.setListData(new ControleVagas(dados).getFuncVagas());
				lista.updateUI();
				
			}
			
		}
		//busca na lista
		if(src ==busca) {
			lista.setListData(new ControleVagas(dados).buscaVaga(barra.getText()));
			//recarrega lista
			lista.updateUI();
		}
		
	}
	
	/**
	 * Método que monstra em qual vaga da lista o usuário clicou e o que vai acontecer na tela
	 */
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(src==lista && e.getValueIsAdjusting()) {
			
			int posi=lista.getSelectedIndex();
			
			if(posi!=-1) {
				
				if(op==1) {
					
					if(posi < dados.getQtdVagasExp(posEmp)) {
						
						new TelaInfoVaga().mostrarInfoVaga(1,dados, posEmp, posi);
						
					} else {
						
						new TelaInfoVaga().mostrarInfoVaga(2,dados, posEmp, posi-dados.getQtdVagasExp(posEmp));
						
					}
					
				}
				
				else {
					new TelaInfoVaga().mostrarInfoVaga(3, dados, -1, posi);
				}
				
	    	}
			
		}
    		
	}

}

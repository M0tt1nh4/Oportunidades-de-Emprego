package view;
import controle.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Classe da Tela Informações de Empresa
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see CNPJ			CNPJ da empresa
 * @see nome			Nome da empresa
 * @see ddd				ddd da empresa
 * @see numero			numero da empresa
 * @see qtdVagas		quantidade de vagas da empresa
 */

public class TelaInfoEmpresa implements ActionListener {
	private JFrame janela = new JFrame("Informação de Empresa");
	private JLabel labelCNPJ = new JLabel("CNPJ: ");
	private JTextField cnpj = new JTextField();
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField nome = new JTextField();
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField ddd = new JTextField();
	private JTextField numero = new JTextField();
	private JLabel labelQtdVagas = new JLabel("Quantidade de Vagas: ");
	private JTextField qtdVagas = new JTextField();
	private JButton botaoCadastrarVagas = new JButton("Cadastrar Vagas");
	private JButton botaoVagas = new JButton("Vagas");
	private JButton botaoEditar = new JButton("Editar Empresa");
	private static ControleDados dados;
	private int posi;
	private boolean editar=false;
	
	/**
	 * Método que monstra a tela Info Empresa
	 * @param d		os dados da Controle Dados
	 * @param posi  posição da empresa
	 */
	
	public void mostrarInfoEmpresa(ControleDados d , int posi) {
		dados = d;
		this.posi = posi;
		
		//determina o tamanho da janela
		janela.setSize(500, 350);
		janela.setLayout(null);
		
		//determina o tamanho de cada texto na janela
		labelCNPJ.setBounds(100, 50, 50, 20);
		cnpj.setBounds(240, 50, 150, 20);
		labelNome.setBounds(100, 80, 150, 20);
		nome.setBounds(240, 80, 150, 20);
		labelTelefone.setBounds(100, 110, 150, 20);
		ddd.setBounds(240, 110, 40, 20);
		numero.setBounds(285, 110, 105, 20);
		labelQtdVagas.setBounds(100, 140, 200, 20);
		qtdVagas.setBounds(240,140 , 150, 20);
		botaoCadastrarVagas.setBounds(110, 260, 130, 30);
		botaoVagas.setBounds(250, 260, 130, 30);
		botaoEditar.setBounds(180, 180,130 ,30);
		
		//determina as informações da empresa
		cnpj.setText(String.valueOf(dados.getEmpresa(posi).getCNPJ()));
		nome.setText(dados.getEmpresa(posi).getNome());
		ddd.setText(String.valueOf(dados.getEmpresa(posi).getTelefone().getDDD()));
		numero.setText(String.valueOf(dados.getEmpresa(posi).getTelefone().getNumero()));
		qtdVagas.setText(String.valueOf(dados.getEmpresa(posi).getQtdVagaExp()+dados.getEmpresa(posi).getQtdVagaInxp()));
		
		//inclui o botão editar em todas as informações da tela
		cnpj.setEditable(editar);
		nome.setEditable(editar);
		ddd.setEditable(editar);
		numero.setEditable(editar);
		qtdVagas.setEditable(editar);
		
		//adiciona todos textos na janela
		janela.add(labelCNPJ);
		janela.add(labelNome);
		janela.add(labelTelefone);
		janela.add(labelQtdVagas);
		janela.add(cnpj);
		janela.add(nome);
		janela.add(ddd);
		janela.add(numero);
		janela.add(qtdVagas);
		janela.add(botaoCadastrarVagas);
		janela.add(botaoVagas);
		janela.add(botaoEditar);
		
		janela.setVisible(true);
		
		//adiciona o botão editar e Vagas na janela
		botaoEditar.addActionListener(this);
		botaoVagas.addActionListener(this);
		
	}
	/**
	 * Método que monstra em que o usuário clicou e determina o que vai acontecer na tela 
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src==botaoEditar){
			
			editar=true;
			mostrarInfoEmpresa( dados ,  posi);
			
		}else if(src == botaoVagas){
			
			new TelaListaVagas().mostrarVagas(dados,1,posi);
			
		}
	}
}

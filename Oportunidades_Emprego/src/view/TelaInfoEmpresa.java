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
	private JLabel tipohEmp = new JLabel("Tipo de Empresa a ser cadastrada:");
	private JLabel qtdVagas = new JLabel();
	private JButton botaoVagas = new JButton("Vagas");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoContinuar = new JButton("Continuar");
	private String[] novosDados = new String[6];
	private static ControleDados dados;
	private int posi;
	private int posEmp;
	
	/**
	 * Método que monstra a tela Info Empresa
	 * @param d		os dados da Controle Dados
	 * @param posi  posição da empresa
	 */
	
	public void mostrarInfoEmpresa(ControleDados d , int posi) {
		dados = d;
		this.posi = posi;
		this.posEmp = posEmp;
		
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
		botaoVagas.setBounds(250, 200, 130, 30);
		botaoSalvar.setBounds(110, 200, 130, 30);
		
		//determina as informações da empresa
		if (posi < dados.getQtdEmpresas()) {
			cnpj.setText(String.valueOf(dados.getEmpresa(posi).getCNPJ()));
			nome.setText(dados.getEmpresa(posi).getNome());
			ddd.setText(String.valueOf(dados.getEmpresa(posi).getTelefone().getDDD()));
			numero.setText(String.valueOf(dados.getEmpresa(posi).getTelefone().getNumero()));
			qtdVagas.setText(String.valueOf(dados.getEmpresa(posi).getQtdVagaExp()+dados.getEmpresa(posi).getQtdVagaInxp()));
		} else labelQtdVagas.setVisible(false);
		
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
		janela.add(botaoVagas);
		janela.add(botaoSalvar);
		
		janela.setVisible(true);
		
		//adiciona o botão editar e Vagas na janela
		botaoSalvar.addActionListener(this);
		botaoVagas.addActionListener(this);
		
	}
		public void tipoEmpresaCadastro(ControleDados d, int posEmp) {
		
		dados = d;
		this.posEmp = posEmp;
		
		janela.setSize(300, 200);
		janela.setLayout(null);
		
		tipohEmp.setBounds(50, 10, 200, 30);
		botaoContinuar.setBounds(90, 110, 100, 30);
		
		janela.add(tipohEmp);
		janela.add(botaoContinuar);
		
		janela.setVisible(true);
		
		botaoContinuar.addActionListener(this);
		
	}
	/**
	 * Método que monstra em que o usuário clicou e determina o que vai acontecer na tela 
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == botaoSalvar){
			
			boolean save;
			
			novosDados[0] = String.valueOf(posi);
			novosDados[1] = cnpj.getText();
			novosDados[2] = nome.getText();
			novosDados[3] = ddd.getText();
			novosDados[4] = numero.getText();
			novosDados[5] = qtdVagas.getText();
			
			save = dados.inserirEditarEmpresa(novosDados);
			
			if (save) mensagemSucessoCadastro();
			
		}
		
		if (src == botaoVagas){
			
			janela.dispose();
			new TelaListaVagas().mostrarVagas(dados, 1, posi);
			
		}
		if (src == botaoContinuar) {
			
				janela.dispose();
				new TelaInfoEmpresa().mostrarInfoEmpresa(dados, posi);
				
		} else {
				
				JOptionPane.showMessageDialog(null, "É necessário selecionar um tipo de Empresa!", null, JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		
	
	
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram Cadastrados com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
}

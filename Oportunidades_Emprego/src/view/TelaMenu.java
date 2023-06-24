package view;
import controle.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaMenu implements ActionListener {
	private static JFrame janela = new JFrame("Oportunidades de Emprego");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton empresas = new JButton("Empresas");
	private static JButton vagas = new JButton("Vagas");
	private static ControleDados dados = new ControleDados();
	
	public TelaMenu() {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(180, 12, 160, 25);
		empresas.setBounds(175, 110, 150, 40);
		vagas.setBounds(175, 190, 150, 40);
		
        janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(empresas);
		janela.add(vagas);
		
		janela.setSize(500, 350);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		empresas.addActionListener(menu);
		vagas.addActionListener(menu);
		
	}
	
    public void actionPerformed(ActionEvent e) {
    	Object src = e.getSource();
    	
    	if(src==empresas) {
    		
    		new TelaListaEmpresa().mostrarEmpresas(dados);
    		
    	}
    	
    	if(src==vagas) {
    		
    		new TelaListaVagas().mostrarVagas(dados,2,-1);
    		
    	}
    }
}

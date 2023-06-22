package view;
import controle.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class TelaListaEmpresa implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Lista de Empresas");
	private JLabel pesq = new JLabel("Pesquisar Empresa");
	private JTextField barra = new JTextField();
	private JList<String> lista;
	private static ControleDados dados;
	private JScrollPane scroll ;
	private JButton busca = new JButton("Buscar");
	public void mostrarEmpresas(ControleDados d) {
		dados =d;
		pesq.setBounds(90, 5, 160, 15);
		barra.setBounds(90, 20, 160, 25);
		busca.setBounds(290, 20, 100, 25);
		lista = new JList<String>(new ControleEmpresa(dados).getNomeEmpresas());
		scroll= new JScrollPane(lista);
		scroll.setBounds(90, 50, 300, 200);
		
        janela.setLayout(null);
		
		janela.add(pesq);
		janela.add(barra);
		janela.add(busca);
		janela.getContentPane().add(scroll);
		
		janela.setSize(500, 350);
		janela.setVisible(true);
		lista.addListSelectionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		if(src==lista && e.getValueIsAdjusting()) {
			int posi=lista.getSelectedIndex();
			if(posi!=-1) {
				new TelaInfoEmpresa().mostrarInfoEmpresa(dados,posi);
	    	}
			}

	}

}

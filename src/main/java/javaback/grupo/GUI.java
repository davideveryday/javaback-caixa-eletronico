package javaback.grupo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modulo do Cliente:");
		lblNewLabel.setBounds(10, 11, 113, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Efetuar Saque");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 48, 324, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Modulo do Cliente:");
		lblNewLabel_1.setBounds(10, 91, 113, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRelatorioDeCedulas = new JButton("Relatorio de Cedulas");
		btnRelatorioDeCedulas.setBounds(10, 128, 324, 32);
		contentPane.add(btnRelatorioDeCedulas);
		
		JButton btnValorTotalDisponivel = new JButton("Valor total disponivel");
		btnValorTotalDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValorTotalDisponivel.setBounds(10, 171, 324, 32);
		contentPane.add(btnValorTotalDisponivel);
		
		JButton btnReposicaoDeCedulas = new JButton("Reposicao de Cedulas");
		btnReposicaoDeCedulas.setBounds(10, 214, 324, 32);
		contentPane.add(btnReposicaoDeCedulas);
		
		JButton btnCotaMinima = new JButton("Cota Minima");
		btnCotaMinima.setBounds(10, 257, 324, 32);
		contentPane.add(btnCotaMinima);
		
		JLabel lblNewLabel_1_1 = new JLabel("Modulo do Cliente:");
		lblNewLabel_1_1.setBounds(10, 300, 113, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_4_1 = new JButton("Sair");
		btnNewButton_4_1.setBounds(10, 337, 324, 32);
		contentPane.add(btnNewButton_4_1);

	}

}

package javaback.grupo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CaixaEletronico caixa = new CaixaEletronico();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(CaixaEletronico.class);
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
	public GUI(Class<CaixaEletronico> caixaEletronicoClass) {
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
				String input = javax.swing.JOptionPane.showInputDialog("Digite o valor do saque:");
				if (input == null) {
					return;
				}

				int valor = Integer.parseInt(input);

				String resultado = caixa.sacar(valor);

				javax.swing.JOptionPane.showMessageDialog(null, resultado);
			}
		});
		btnNewButton.setBounds(10, 48, 324, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Modulo do Administrador:");
		lblNewLabel_1.setBounds(10, 91, 220, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRelatorioDeCedulas = new JButton("Relatorio de Cedulas");
		btnRelatorioDeCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = caixa.pegaRelatorioCedulas();
				javax.swing.JOptionPane.showMessageDialog(null, "<html><pre>" + resultado + "</pre></html>");
			}
		});
		btnRelatorioDeCedulas.setBounds(10, 128, 324, 32);
		contentPane.add(btnRelatorioDeCedulas);


		JButton btnValorTotalDisponivel = new JButton("Valor total disponivel");
		btnValorTotalDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = caixa.pegaValorTotalDisponivel();
				javax.swing.JOptionPane.showMessageDialog(null, resultado);
			}
		});
		btnValorTotalDisponivel.setBounds(10, 171, 324, 32);
		contentPane.add(btnValorTotalDisponivel);
		
		JButton btnReposicaoDeCedulas = new JButton("Reposicao de Cedulas");
		btnReposicaoDeCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ced = javax.swing.JOptionPane.showInputDialog("Cedula:");
				if (ced == null) return;
				String qtd = javax.swing.JOptionPane.showInputDialog("Quantidade:");
				if (qtd == null) return;

				String resultado = caixa.reposicaoCedulas(
						Integer.parseInt(ced),
						Integer.parseInt(qtd)
				);

				javax.swing.JOptionPane.showMessageDialog(null, resultado);
			}
		});
		btnReposicaoDeCedulas.setBounds(10, 214, 324, 32);
		contentPane.add(btnReposicaoDeCedulas);
		
		JButton btnCotaMinima = new JButton("Cota Minima");
		btnCotaMinima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String min = javax.swing.JOptionPane.showInputDialog("Valor minimo:");

				String resultado = caixa.armazenaCotaMinima(Integer.parseInt(min));

				javax.swing.JOptionPane.showMessageDialog(null, resultado);

			}
		});
		btnCotaMinima.setBounds(10, 257, 324, 32);
		contentPane.add(btnCotaMinima);

		JButton btnPopular = new JButton("Popular Caixa");
		btnPopular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				caixa.reposicaoCedulas(100, 10);
				caixa.reposicaoCedulas(50, 10);
				caixa.reposicaoCedulas(20, 10);
				caixa.reposicaoCedulas(10, 10);
				caixa.reposicaoCedulas(5, 10);
				caixa.reposicaoCedulas(2, 10);

				javax.swing.JOptionPane.showMessageDialog(null, "Caixa abastecido!");
			}
		});
		btnPopular.setBounds(10, 300, 324, 32);
		contentPane.add(btnPopular);

		JLabel lblNewLabel_1_1 = new JLabel("Módulo de Ambos:");
		lblNewLabel_1_1.setBounds(10, 332, 113, 26);
		contentPane.add(lblNewLabel_1_1);

		JButton btnNewButton_4_1 = new JButton("Sair");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcao = javax.swing.JOptionPane.showConfirmDialog(
						null,
						"Deseja sair?",
						"Confirmação",
						javax.swing.JOptionPane.YES_NO_OPTION
				);

				if (opcao == javax.swing.JOptionPane.YES_OPTION) {

					String extrato = caixa.getHistoricoSaques();

					javax.swing.JOptionPane.showMessageDialog(
							null,
							"<html><pre>" + extrato + "</pre></html>"
					);

					System.exit(0);
				}
			}
		});
		btnNewButton_4_1.setBounds(10, 370, 324, 32);
		contentPane.add(btnNewButton_4_1);
	}

}

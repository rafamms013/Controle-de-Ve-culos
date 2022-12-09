import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.table.TableModel;

public class TelaControleV extends JFrame {

	private JPanel contentPane;
	private JTextField textPlaca;
	private JTextField textCondutor;
	private JTextField textDataEntrada;
	private JTextField textHorarioEntrada;
	private JTextField textDataSaida;
	private JTextField textHorarioSaida;
	private JTable tblInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaControleV frame = new TelaControleV();
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
	public TelaControleV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setForeground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GERENCIAMENTO DE VEÍCULOS IFES");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(133, 0, 323, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblPlaca = new JLabel("Placa do Veículo");
		lblPlaca.setBounds(10, 41, 123, 30);
		contentPane.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(143, 44, 136, 25);
		contentPane.add(textPlaca);
		textPlaca.setColumns(10);
		
		JLabel lblCondutor = new JLabel("Condutor do Veículo");
		lblCondutor.setBounds(313, 45, 159, 22);
		contentPane.add(lblCondutor);
		
		textCondutor = new JTextField();
		textCondutor.setBounds(476, 44, 136, 25);
		contentPane.add(textCondutor);
		textCondutor.setColumns(10);
		
		JLabel lblDataEntrada = new JLabel("Data de Entrada");
		lblDataEntrada.setBounds(10, 90, 123, 22);
		contentPane.add(lblDataEntrada);
		
		textDataEntrada = new JTextField();
		textDataEntrada.setBounds(143, 90, 136, 22);
		contentPane.add(textDataEntrada);
		textDataEntrada.setColumns(10);
		
		JLabel lblHorarioEntrada = new JLabel("Horário de Entrada");
		lblHorarioEntrada.setBounds(313, 94, 115, 14);
		contentPane.add(lblHorarioEntrada);
		
		textHorarioEntrada = new JTextField();
		textHorarioEntrada.setBounds(471, 91, 141, 20);
		contentPane.add(textHorarioEntrada);
		textHorarioEntrada.setColumns(10);
		
		JLabel lblDataSaida = new JLabel("Data de Saída");
		lblDataSaida.setBounds(10, 141, 97, 14);
		contentPane.add(lblDataSaida);
		
		textDataSaida = new JTextField();
		textDataSaida.setBounds(143, 138, 136, 20);
		contentPane.add(textDataSaida);
		textDataSaida.setColumns(10);
		
		JLabel lblHorarioSaida = new JLabel("Horário de Saída");
		lblHorarioSaida.setBounds(309, 141, 106, 14);
		contentPane.add(lblHorarioSaida);
		
		textHorarioSaida = new JTextField();
		textHorarioSaida.setBounds(471, 138, 141, 20);
		contentPane.add(textHorarioSaida);
		textHorarioSaida.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar Veículo");
		btnCadastrar.setForeground(new Color(0, 128, 255));
		btnCadastrar.setBackground(new Color(128, 255, 255));
		btnCadastrar.setBounds(10, 224, 151, 36);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MsgErro = "";
				if(textPlaca.getText().isEmpty()) {
					MsgErro = MsgErro + "lblPlaca\n";
				}
				if(textCondutor.getText().isEmpty()) {
					MsgErro = MsgErro + "textCondutor\n";
				}
				if(textDataEntrada.getText().isEmpty()) {
					MsgErro = MsgErro + "textDataEntrada\n";
				}
				if(textHorarioEntrada.getText().isEmpty()) {
					MsgErro = MsgErro +  "textHorarioEntrada\n";
				}
				
				if(!MsgErro.isEmpty()) {
					JOptionPane.showMessageDialog(btnCadastrar,"Há campos vazios, por favor realize o preenchimento!!\n" + MsgErro,"Erro", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					DefaultTableModel modelo = (DefaultTableModel) 
							tblInfo.getModel();
					
					int Linhas = modelo.getRowCount();
					for(int cont = 0; cont < Linhas; cont++) {
						String Mat = (String) modelo.getValueAt(cont, 1);
						if(textCondutor.getText().equals(Mat)) {
							MsgErro = "Esse Veiculo já está registrado!";
							break;
						}
					}
					
					if(!MsgErro.isEmpty()) {
						JOptionPane.showMessageDialog(btnCadastrar,MsgErro,"Erro", JOptionPane.ERROR_MESSAGE);
					}
					else {
						modelo = (DefaultTableModel) tblInfo.getModel();
						modelo.addRow(new Object[] {textPlaca.getText(),textCondutor.getText(),textDataEntrada.getText(),textHorarioEntrada.getText()});
						tblInfo.setModel(modelo);
					}
				}
			}
				
			
		});
			
		
		
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 339, 795, 141);
		contentPane.add(scrollPane);
		
		tblInfo = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Placa do Veículo");
		modelo.addColumn("Condutor do Veículo");
		modelo.addColumn("Data de Entrada");
		modelo.addColumn("Horário de Entrada");
		modelo.addColumn("Data de Saída");
		modelo.addColumn("Horário de Saída");
		tblInfo.setModel(modelo);
		scrollPane.setViewportView(tblInfo);
		
		
		JButton btnRemover = new JButton("Remover Veículo");
		btnRemover.setBackground(new Color(0, 255, 255));
		btnRemover.setForeground(new Color(0, 0, 0));
		btnRemover.setBounds(192, 224, 151, 36);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) 
						tblInfo.getModel();
				int Linha=modelo.getRowCount();
				for(int cont = 0; cont < Linha; cont++) {
					String Placa = (String) modelo.getValueAt(cont, 0);
					if(textPlaca.getText().equals(Placa)) {
						
						 tblInfo.getModel().setValueAt(textDataSaida.getText(), cont,4);
						 tblInfo.getModel().setValueAt(textHorarioSaida.getText(), cont,5);
						 modelo.addRow(new Object[] {textDataSaida.getText(),textHorarioSaida.getText()});
							
					}
					else {
						modelo = (DefaultTableModel) tblInfo.getModel();
						modelo.addRow(new Object[] {textDataSaida.getText(),textHorarioSaida.getText()});
						
						/*modelo.addRow(new Object[] {textDataSaida.getText(),textHorarioSaida.getText()});*/
					
						tblInfo.setModel(modelo);
					}
					break;
				}
			}
		}
			
	);
		
		contentPane.add(btnRemover);
		
		JButton btnSair = new JButton("Finalizar Programa");
		btnSair.setForeground(new Color(128, 0, 64));
		btnSair.setBackground(new Color(128, 128, 192));
		btnSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
	}
});

		btnSair.setBounds(567,224,160,36);
		contentPane.add(btnSair);
		
		JButton btnlimpar = new JButton("Limpar Campos");
		btnlimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPlaca.setText("");
				textCondutor.setText("");
				textDataEntrada.setText("");
				textHorarioEntrada.setText("");
				textDataSaida.setText("");
				textHorarioSaida.setText("");
				
				
				
			}
		});
		btnlimpar.setForeground(new Color(192, 192, 192));
		btnlimpar.setBackground(new Color(128, 128, 128));
		btnlimpar.setBounds(375, 224, 151, 36);
		contentPane.add(btnlimpar);
		}
}

/*
 * tblInfo=new JTable(); tblInfo.setBackground(new Color(128,255,255));
 * tblInfo.setBounds(10,271,590,131);contentPane.add(tblInfo);}}
 */

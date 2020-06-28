package br.quixada.ufc.si.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.quixada.ufc.si.controller.ControlerAdmin;
import br.quixada.ufc.si.view.listaimage.ManipularImagem;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class menuAdm extends JFrame {
	
	BufferedImage Recepcionista;
	BufferedImage imagem1;
	BufferedImage imagem2;
	BufferedImage imagem3;
	BufferedImage imagem4;
	private JPanel contentPane;
	private JTextField textDescricao;
	private JTextField textPreco;
	private JTextField textURLfoto1;
	private JTextField textURLfoto2;
	private JTextField textURLfoto3;
	private JTextField textURLfoto4;
	private int indexCombo = 0;
	private JTextField textSalario;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textTurno;
	private JTextField textField_7;
	private JPasswordField passwordField;
	private ControlerAdmin ca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		   try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Windows".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(menuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(menuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(menuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(menuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		   
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuAdm frame = new menuAdm();
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
	public menuAdm() {
		ca = new ControlerAdmin();
		setIconImage(Toolkit.getDefaultToolkit().getImage(menuAdm.class.getResource("/br/quixada/ufc/si/img/service-bell.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1032, 609);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 69, 1016, 35);
		contentPane.add(menuBar);
		
		JMenu mnQuarto = new JMenu("  Quarto  ");
		mnQuarto.setForeground(Color.BLACK);
		mnQuarto.setFont(new Font("Arial", Font.BOLD, 17));
		menuBar.add(mnQuarto);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar");
		
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 13));
		mnQuarto.add(mntmNewMenuItem);
		
		JMenuItem mntmAtualizarPreo = new JMenuItem("Atualizar pre\u00E7o");
		mntmAtualizarPreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarQuartos at = new atualizarQuartos();
				at.setVisible(true);
				dispose();
			}
		});
		mntmAtualizarPreo.setFont(new Font("Arial", Font.PLAIN, 13));
		mnQuarto.add(mntmAtualizarPreo);
		
		JMenu mnRecepcionista = new JMenu("Recepcionista");
		mnRecepcionista.setForeground(Color.BLACK);
		mnRecepcionista.setFont(new Font("Arial", Font.BOLD, 17));
		menuBar.add(mnRecepcionista);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		
		mntmCadastrar.setFont(new Font("Arial", Font.PLAIN, 13));
		mnRecepcionista.add(mntmCadastrar);
		
		
		JPanel panelQuarto = new JPanel();
		panelQuarto.setBounds(0, 103, 1016, 467);
		panelQuarto.setBackground(new Color(255, 99, 70));
		panelQuarto.setVisible(false);
		
		JPanel panelRecepcionista = new JPanel();
		panelRecepcionista.setBounds(0, 103, 1016, 467);
		panelRecepcionista.setVisible(false);
		contentPane.add(panelRecepcionista);
		panelRecepcionista.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(848, 70, 150, 200);
		panelRecepcionista.add(label_3);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(175, 78, 67, 13);
		panelRecepcionista.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 15));
		
		textNome = new JTextField();
		textNome.setBounds(254, 70, 584, 28);
		panelRecepcionista.add(textNome);
		textNome.setToolTipText("");
		textNome.setText("");
		textNome.setOpaque(false);
		textNome.setForeground(Color.WHITE);
		textNome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textNome.setColumns(10);
		textNome.setBorder(new LineBorder(Color.WHITE, 1, true));
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setBounds(175, 139, 53, 13);
		panelRecepcionista.add(label_2);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.BOLD, 15));
		
		textCPF = new JTextField();
		textCPF.setBounds(254, 131, 584, 28);
		panelRecepcionista.add(textCPF);
		textCPF.setToolTipText("");
		textCPF.setText("");
		textCPF.setOpaque(false);
		textCPF.setForeground(Color.WHITE);
		textCPF.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textCPF.setColumns(10);
		textCPF.setBorder(new LineBorder(Color.WHITE, 1, true));
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setBounds(175, 214, 84, 13);
		panelRecepcionista.add(lblTurno);
		lblTurno.setForeground(Color.WHITE);
		lblTurno.setFont(new Font("Arial", Font.BOLD, 15));
		
		textTurno = new JTextField();
		textTurno.setBounds(254, 206, 256, 28);
		panelRecepcionista.add(textTurno);
		textTurno.setToolTipText("");
		textTurno.setText("");
		textTurno.setOpaque(false);
		textTurno.setForeground(Color.WHITE);
		textTurno.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textTurno.setColumns(10);
		textTurno.setBorder(new LineBorder(Color.WHITE, 1, true));
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setBounds(520, 214, 64, 13);
		panelRecepcionista.add(lblSalrio);
		lblSalrio.setForeground(Color.WHITE);
		lblSalrio.setFont(new Font("Arial", Font.BOLD, 15));
		
		textSalario = new JTextField();
		textSalario.setBounds(580, 206, 256, 28);
		panelRecepcionista.add(textSalario);
		textSalario.setToolTipText("");
		textSalario.setText("");
		textSalario.setOpaque(false);
		textSalario.setForeground(Color.WHITE);
		textSalario.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textSalario.setColumns(10);
		textSalario.setBorder(new LineBorder(Color.WHITE, 1, true));
		
		JLabel label_5 = new JLabel("Senha:");
		label_5.setBounds(175, 286, 75, 13);
		panelRecepcionista.add(label_5);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton button_2 = new JButton("Selecione sua foto");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionImageSelectedRecepcionista(arg0, label_3);
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(Color.WHITE, 1, true));
		passwordField.setOpaque(false);
		passwordField.setBounds(254, 275, 584, 28);
		panelRecepcionista.add(passwordField);
		button_2.setBounds(477, 330, 137, 23);
		panelRecepcionista.add(button_2);
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		button_2.setBackground(Color.WHITE);
		
		textField_7 = new JTextField();
		textField_7.setBounds(856, 275, 56, 28);
		panelRecepcionista.add(textField_7);
		textField_7.setToolTipText("");
		textField_7.setText("");
		textField_7.setOpaque(false);
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField_7.setColumns(10);
		textField_7.setBorder(new LineBorder(Color.WHITE, 1, true));
		
		
		JButton button_4 = new JButton("Cadastrar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textNome.getText().isEmpty() || textCPF.getText().isEmpty() || textSalario.getText().isEmpty() || textTurno.getText().isEmpty()|| new String(passwordField.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio no cadastro");
				}else {
					if (textCPF.getText().matches("\\d+") && (textCPF.getText().length() == 11) && (!textNome.getText().matches("\\d+"))) {
						ca.cadastroRecepcionista(textCPF.getText(), textNome.getText(), new String(passwordField.getPassword()), textSalario.getText(), textTurno.getText());
					}else {
						JOptionPane.showMessageDialog(null, "CPF não pode receber letras e nome não pode receber numeros");
					}
				}
			}
		});
		button_4.setBounds(410, 418, 96, 23);
		panelRecepcionista.add(button_4);
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		button_4.setBackground(Color.WHITE);
		

		JButton button_3 = new JButton("Voltar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelRecepcionista.setVisible(false);
			}
		});
		button_3.setBounds(575, 419, 87, 23);
		panelRecepcionista.add(button_3);
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		button_3.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon(menuAdm.class.getResource("/br/quixada/ufc/si/img/foto2 (1).png")));
		lblNewLabel_1.setBounds(0, 0, 1016, 467);
		panelRecepcionista.add(lblNewLabel_1);
		contentPane.add(panelQuarto);
		panelQuarto.setLayout(null);
		
		
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(198, 36, 110, 18);
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 16));
		panelQuarto.add(lblDescricao);
		
		
		
		textDescricao = new JTextField();
		textDescricao.setOpaque(false);
		textDescricao.setBounds(303, 11, 468, 70);
		textDescricao.setToolTipText("");
		textDescricao.setText("");
		textDescricao.setForeground(Color.WHITE);
		textDescricao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textDescricao.setColumns(10);
		textDescricao.setBorder(new LineBorder(Color.WHITE, 1, true));
		panelQuarto.add(textDescricao);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(229, 110, 79, 18);
		lblPreo.setForeground(Color.WHITE);
		lblPreo.setFont(new Font("Arial", Font.BOLD, 16));
		panelQuarto.add(lblPreo);
		
		textPreco = new JTextField();
		textPreco.setBounds(303, 109, 216, 21);
		textPreco.setToolTipText("");
		textPreco.setText("");
		textPreco.setOpaque(false);
		textPreco.setForeground(Color.WHITE);
		textPreco.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textPreco.setColumns(10);
		textPreco.setBorder(new LineBorder(Color.WHITE, 1, true));
		panelQuarto.add(textPreco);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTipo.setBounds(529, 109, 54, 18);
		panelQuarto.add(lblTipo);
		
		textURLfoto1 = new JTextField();
		textURLfoto1.setToolTipText("");
		textURLfoto1.setText("");
		textURLfoto1.setOpaque(false);
		textURLfoto1.setForeground(Color.BLACK);
		textURLfoto1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textURLfoto1.setEditable(false);
		textURLfoto1.setColumns(10);
		textURLfoto1.setBorder(new LineBorder(Color.WHITE, 1, true));
		textURLfoto1.setBounds(58, 226, 194, 21);
		panelQuarto.add(textURLfoto1);
		
		JLabel labelFoto1 = new JLabel("");
		labelFoto1.setBounds(290, 165, 142, 92);
		panelQuarto.add(labelFoto1);
		
		JLabel labelFoto2 = new JLabel("");
		labelFoto2.setBounds(290, 286, 142, 92);
		panelQuarto.add(labelFoto2);
		
		JLabel labelFoto3 = new JLabel("");
		labelFoto3.setBounds(827, 165, 142, 92);
		panelQuarto.add(labelFoto3);
		
		JLabel labelFoto4 = new JLabel("");
		labelFoto4.setBounds(827, 286, 142, 92);
		panelQuarto.add(labelFoto4);
		
		JButton btnUploadImagem1 = new JButton("Upload Imagem 1");		
		btnUploadImagem1.setForeground(Color.BLACK);
		btnUploadImagem1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUploadImagem1.setBackground(Color.WHITE);
		btnUploadImagem1.setBounds(91, 190, 130, 25);
		btnUploadImagem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionImageSelected1(e, labelFoto1);
			}
		});
		panelQuarto.add(btnUploadImagem1);
		
		textURLfoto2 = new JTextField();
		textURLfoto2.setToolTipText("");
		textURLfoto2.setText("");
		textURLfoto2.setOpaque(false);
		textURLfoto2.setForeground(Color.BLACK);
		textURLfoto2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textURLfoto2.setEditable(false);
		textURLfoto2.setColumns(10);
		textURLfoto2.setBorder(new LineBorder(Color.WHITE, 1, true));
		textURLfoto2.setBounds(58, 347, 194, 21);
		panelQuarto.add(textURLfoto2);
		JButton btnUploadImagem_2 = new JButton("Upload Imagem 2\r\n");
		btnUploadImagem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionImageSelected2(e, labelFoto2);
				//actionImageSelected(e, imagem2, textURLfoto2);
			}
		});
		btnUploadImagem_2.setForeground(Color.BLACK);
		btnUploadImagem_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUploadImagem_2.setBackground(Color.WHITE);
		btnUploadImagem_2.setBounds(91, 311, 130, 25);
		panelQuarto.add(btnUploadImagem_2);
		
		textURLfoto3 = new JTextField();
		textURLfoto3.setEditable(false);
		textURLfoto3.setToolTipText("");
		textURLfoto3.setText("");
		textURLfoto3.setOpaque(false);
		textURLfoto3.setForeground(Color.BLACK);
		textURLfoto3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textURLfoto3.setColumns(10);
		textURLfoto3.setBorder(new LineBorder(Color.WHITE, 1, true));
		textURLfoto3.setBounds(564, 226, 222, 21);
		panelQuarto.add(textURLfoto3);
		JButton btnUploadImagem_3 = new JButton("Upload Imagem 3\r\n");
		btnUploadImagem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionImageSelected3(e, labelFoto3);
				//actionImageSelected(e, imagem3, textURLfoto3);
			}
		});
		btnUploadImagem_3.setForeground(Color.BLACK);
		btnUploadImagem_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUploadImagem_3.setBackground(Color.WHITE);
		btnUploadImagem_3.setBounds(617, 190, 130, 25);
		panelQuarto.add(btnUploadImagem_3);
		
		textURLfoto4 = new JTextField();
		textURLfoto4.setEditable(false);
		textURLfoto4.setToolTipText("");
		textURLfoto4.setText("");
		textURLfoto4.setOpaque(false);
		textURLfoto4.setForeground(Color.BLACK);
		textURLfoto4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textURLfoto4.setColumns(10);
		textURLfoto4.setBorder(new LineBorder(Color.WHITE, 1, true));
		textURLfoto4.setBounds(564, 347, 222, 21);
		panelQuarto.add(textURLfoto4);
		JButton btnUploadImagem_4 = new JButton("Upload Imagem 4");
		btnUploadImagem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionImageSelected4(e, labelFoto4);
				//actionImageSelected(e, imagem4, textURLfoto4);
			}
		});
		btnUploadImagem_4.setForeground(Color.BLACK);
		btnUploadImagem_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUploadImagem_4.setBackground(Color.WHITE);
		btnUploadImagem_4.setBounds(617, 311, 130, 25);
		panelQuarto.add(btnUploadImagem_4);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//panelRecepcionista.setVisible(false);
				panelQuarto.setVisible(false);
				
			}
		});
		button.setBounds(552, 418, 87, 25);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Times New Roman", Font.BOLD, 13));
		button.setBackground(Color.WHITE);
		panelQuarto.add(button);
		
		JButton button_1 = new JButton("Cadastrar");
		button_1.setBounds(400, 418, 101, 25);
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		button_1.setBackground(Color.WHITE);
		panelQuarto.add(button_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(589, 111, 182, 20);
		comboBox.addItem("Suíte");
		comboBox.addItem("Suíte Casal");
		comboBox.addItem("Suíte Executiva");
		comboBox.addItem("Suíte Presidencial");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem() == comboBox.getItemAt(0)){
					indexCombo = 0;

				}else if(comboBox.getSelectedItem() == comboBox.getItemAt(1)) {
					indexCombo = 1;

				}else if(comboBox.getSelectedItem() == comboBox.getItemAt(2)) {
					indexCombo = 2;

				}else {
					indexCombo = 3;
				}
			}
		});
		panelQuarto.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1016, 467);
		lblNewLabel.setIcon(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/foto2 (1).png")));
		panelQuarto.add(lblNewLabel);
		
		JPanel panelInicial = new JPanel();
		panelInicial.setBounds(0, 103, 1016, 467);
		panelInicial.setVisible(true);
		contentPane.add(panelInicial);
		panelInicial.setLayout(null);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroQuarto = -1;
				ControlerAdmin ch = new ControlerAdmin();
				if(textPreco.getText().isEmpty() || textDescricao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Os campos preço e descrição não podem ficar vazios");
				}else {
					try {
						numeroQuarto = ch.adicionarQuarto(Double.parseDouble(textPreco.getText()),(String) comboBox.getSelectedItem(), textDescricao.getText());
					}catch(NumberFormatException e1) {
						e1.getMessage();
						JOptionPane.showMessageDialog(null,"O campo preco não aceita letras");
					}
				}
				if(numeroQuarto != -1) {
					blnEnviarActionPerformed1(e, numeroQuarto);
					blnEnviarActionPerformed2(e, numeroQuarto);
					blnEnviarActionPerformed3(e, numeroQuarto);
					blnEnviarActionPerformed4(e, numeroQuarto);
					 JOptionPane.showMessageDialog(null, "Quarto "+ numeroQuarto+" Cadastrado" );
				}else {
					 JOptionPane.showMessageDialog(null, "Error ao cadastrar.");
				}
			}
		});
		
		JPanel panelTopo = new JPanel();
		panelTopo.setBounds(-10, 0, 1036, 73);
		contentPane.add(panelTopo);
		panelTopo.setLayout(null);
		panelTopo.setBackground(Color.WHITE);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(367, 11, 321, 48);
		ImageIcon imagem2topo = new ImageIcon(telaLogin.class.getResource("/br/quixada/ufc/si/img/paradise_azul.jpg"));
		Image imag2 = imagem2topo.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH);
		label_1.setIcon(new ImageIcon(imag2));
		panelTopo.add(label_1);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelRecepcionista.setVisible(false);
				panelQuarto.setVisible(false);
				panelInicial.setVisible(true);
			}
		});
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			panelInicial.setVisible(false);
			panelRecepcionista.setVisible(false);
			panelQuarto.setVisible(true);
			}
		});
		
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			panelInicial.setVisible(false);
			panelQuarto.setVisible(false);
			panelRecepcionista.setVisible(true);
			}
		});
	}
	
	
	private void actionImageSelectedRecepcionista(ActionEvent e, JLabel labelFoto) {
		JFileChooser fc = new JFileChooser();
		int res = fc.showOpenDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
		    File arquivo = fc.getSelectedFile();
		
		    try {
		    	textURLfoto1.setText(arquivo.getAbsolutePath());
		    	Recepcionista = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 142, 92);
		        labelFoto.setIcon(new ImageIcon(Recepcionista));
		        
		    } catch (Exception ex) {
		       // System.out.println(ex.printStackTrace().toString());
		    }
		
		} else {
		    JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo.");
		}
	}
	
	private void actionImageSelected1(ActionEvent e, JLabel labelFoto) {
		JFileChooser fc = new JFileChooser();
		int res = fc.showOpenDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
		    File arquivo = fc.getSelectedFile();
		
		    try {
		    	textURLfoto1.setText(arquivo.getAbsolutePath());
		    	imagem1 = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 142, 92);
		        labelFoto.setIcon(new ImageIcon(imagem1));
		        
		    } catch (Exception ex) {
		       // System.out.println(ex.printStackTrace().toString());
		    }
		
		} else {
		    JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo.");
		}
	}
	
	private void actionImageSelected2(ActionEvent e, JLabel labelFoto) {
		JFileChooser fc = new JFileChooser();
		int res = fc.showOpenDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
		    File arquivo = fc.getSelectedFile();
		
		    try {
		    	textURLfoto2.setText(arquivo.getAbsolutePath());
		    	imagem2 = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 142, 92);
		        labelFoto.setIcon(new ImageIcon(imagem2));
		        
		    } catch (Exception ex) {
		       // System.out.println(ex.printStackTrace().toString());
		    }
		
		} else {
		    JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo.");
		}
	}
	
	private void actionImageSelected3(ActionEvent e, JLabel labelFoto) {
		JFileChooser fc = new JFileChooser();
		int res = fc.showOpenDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
		    File arquivo = fc.getSelectedFile();
		
		    try {
		    	textURLfoto3.setText(arquivo.getAbsolutePath());
		    	imagem3 = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 142, 92);
		        labelFoto.setIcon(new ImageIcon(imagem3));
		        
		    } catch (Exception ex) {
		       // System.out.println(ex.printStackTrace().toString());
		    }
		
		} else {
		    JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo.");
		}
	}
	
	private void actionImageSelected4(ActionEvent e, JLabel labelFoto) {
		JFileChooser fc = new JFileChooser();
		int res = fc.showOpenDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
		    File arquivo = fc.getSelectedFile();
		
		    try {
		    	textURLfoto4.setText(arquivo.getAbsolutePath());
		    	imagem4 = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
		        labelFoto.setIcon(new ImageIcon(imagem4));
		        
		    } catch (Exception ex) {
		       // System.out.println(ex.printStackTrace().toString());
		    }
		
		} else {
		    JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo.");
		}
	}
	
	private void blnEnviarActionPerformed1Recepcionista(ActionEvent evt) {//GEN-FIRST:event_blnEnviarActionPerformed
        try {
        	if(Recepcionista != null) {
	            String caminho = getClass().getResource("../img/quartos/").toString().substring(5);
	            File outputfile = new File(caminho+"image1.jpg");
	            ImageIO.write(Recepcionista, "jpg", outputfile);
	            JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
        	}
        } catch (IOException ex) {
            Logger.getLogger(menuAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
	
	private void blnEnviarActionPerformed1(ActionEvent evt, int numeroQuarto) {//GEN-FIRST:event_blnEnviarActionPerformed
        try {
        	if(imagem1 != null) {
	            String caminho = getClass().getResource("../img/quartos/").toString().substring(5);
	            imagem1 = ManipularImagem.setImagemDimensao(textURLfoto1.getText(), 560, 374);
	           switch(indexCombo) {
		           case 0:
			            File outputfile0 = new File(caminho+"Quarto"+numeroQuarto+"_Suite1.jpg");
			            ImageIO.write(imagem1, "jpg", outputfile0);
			            break;
		           case 1:
		        	   File outputfile1 = new File(caminho+"Quarto"+numeroQuarto+"_SuiteCasal1.jpg");
			           ImageIO.write(imagem1, "jpg", outputfile1);
			           break;
		           case 2:
		        	   File outputfile2 = new File(caminho+"Quarto"+numeroQuarto+"_SuiteExecutiva1.jpg");
			           ImageIO.write(imagem1, "jpg", outputfile2);
		        	   break;
		           case 3:
		        	   File outputfile3 = new File(caminho+"Quarto"+numeroQuarto+"_SuitePresidencial1.jpg");
			           ImageIO.write(imagem1, "jpg", outputfile3);
		        	   break;
		           default:
		        	   JOptionPane.showMessageDialog(null, "Error");
		        	   break;
	           }	   
	            JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
        	}
        } catch (IOException ex) {
            Logger.getLogger(menuAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
	
	private void blnEnviarActionPerformed2(ActionEvent evt, int numeroQuarto) {//GEN-FIRST:event_blnEnviarActionPerformed
        try {
        	if(imagem2 != null) {
	            String caminho = getClass().getResource("../img/quartos/").toString().substring(5);
	            imagem2 = ManipularImagem.setImagemDimensao(textURLfoto2.getText(), 560, 374);
	            switch(indexCombo) {
		           case 0:
			            File outputfile0 = new File(caminho+"Quarto"+numeroQuarto+"_Suite2.jpg");
			            ImageIO.write(imagem2, "jpg", outputfile0);
			            break;
		           case 1:
		        	   File outputfile1 = new File(caminho+"Quarto"+numeroQuarto+"_SuiteCasal2.jpg");
			           ImageIO.write(imagem2, "jpg", outputfile1);
			           break;
		           case 2:
		        	   File outputfile2 = new File(caminho+"Quarto"+numeroQuarto+"_SuiteExecutiva2.jpg");
			           ImageIO.write(imagem2, "jpg", outputfile2);
		        	   break;
		           case 3:
		        	   File outputfile3 = new File(caminho+"Quarto"+numeroQuarto+"_SuitePresidencial2.jpg");
			           ImageIO.write(imagem2, "jpg", outputfile3);
		        	   break;
		           default:
		        	   JOptionPane.showMessageDialog(null, "Error");
		        	   break;
	           }
	            JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
        	}
        } catch (IOException ex) {
            Logger.getLogger(menuAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
	
	private void blnEnviarActionPerformed3(ActionEvent evt, int numeroQuarto) {//GEN-FIRST:event_blnEnviarActionPerformed
        try {
        	if(imagem3 != null) {
	            String caminho = getClass().getResource("../img/quartos/").toString().substring(5);
	            imagem3 = ManipularImagem.setImagemDimensao(textURLfoto3.getText(), 560, 374);
	            switch(indexCombo) {
		           case 0:
			            File outputfile0 = new File(caminho+"Quarto"+numeroQuarto+"_Suite3.jpg");
			            ImageIO.write(imagem3, "jpg", outputfile0);
			            break;
		           case 1:
		        	   File outputfile1 = new File(caminho+"Quarto"+numeroQuarto+"_SuiteCasal3.jpg");
			           ImageIO.write(imagem3, "jpg", outputfile1);
			           break;
		           case 2:
		        	   File outputfile2 = new File(caminho+"Quarto"+numeroQuarto+"_SuiteExecutiva3.jpg");
			           ImageIO.write(imagem3, "jpg", outputfile2);
		        	   break;
		           case 3:
		        	   File outputfile3 = new File(caminho+"Quarto"+numeroQuarto+"_SuitePresidencial3.jpg");
			           ImageIO.write(imagem3, "jpg", outputfile3);
		        	   break;
		           default:
		        	   JOptionPane.showMessageDialog(null, "Error");
		        	   break;
	           }	            JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
        	}
        } catch (IOException ex) {
            Logger.getLogger(menuAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
	
	private void blnEnviarActionPerformed4(ActionEvent evt, int numeroQuarto) {//GEN-FIRST:event_blnEnviarActionPerformed
        try {
        	if(imagem4 != null) {
	            String caminho = getClass().getResource("../img/quartos/").toString().substring(5);
	            imagem4 = ManipularImagem.setImagemDimensao(textURLfoto4.getText(), 560, 374);
	            switch(indexCombo) {
		           case 0:
			            File outputfile0 = new File(caminho+"Quarto"+numeroQuarto+"_Suite4.jpg");
			            ImageIO.write(imagem4, "jpg", outputfile0);
			            break;
		           case 1:
		        	   File outputfile1 = new File(caminho+"Quarto"+numeroQuarto+"_SuiteCasal4.jpg");
			           ImageIO.write(imagem4, "jpg", outputfile1);
			           break;
		           case 2:
		        	   File outputfile2 = new File(caminho+"Quarto"+numeroQuarto+"_SuiteExecutiva4.jpg");
			           ImageIO.write(imagem4, "jpg", outputfile2);
		        	   break;
		           case 3:
		        	   File outputfile3 = new File(caminho+"Quarto"+numeroQuarto+"_SuitePresidencial	4.jpg");
			           ImageIO.write(imagem4, "jpg", outputfile3);
		        	   break;
		           default:
		        	   JOptionPane.showMessageDialog(null, "Error");
		        	   break;
	           }
	            JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
        	}
        } catch (IOException ex) {
            Logger.getLogger(menuAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

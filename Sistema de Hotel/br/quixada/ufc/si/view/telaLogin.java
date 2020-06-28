package br.quixada.ufc.si.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuListener;

import br.quixada.ufc.si.controller.ControlerHospede;
import br.quixada.ufc.si.controller.ControlerLogin;
import br.quixada.ufc.si.model.Administrador;
import br.quixada.ufc.si.model.Hospede;
import br.quixada.ufc.si.model.Recepcionista;
import br.quixada.ufc.si.view.listaimage.ManipularImagem;

import javax.swing.event.PopupMenuEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import com.toedter.calendar.JDateChooser;

public class telaLogin extends JFrame {

	BufferedImage imagem1;
	private JPanel contentPane;
	private JTextField txtCpf;
	private JPasswordField textSenha;
	ButtonGroup bg = new ButtonGroup();
	private int indexCombo = 0;
	private JTextField textNome;
	private JTextField textcpf;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textNumero;
	private JTextField txtEe;
	private JTextField textEmail;
	private JTextField textCidade;
	private JTextField textTelefone;
	private JPasswordField passwordField;

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
			java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaLogin frame = new telaLogin();
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
	public telaLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 994, 550);
		setIconImage(Toolkit.getDefaultToolkit().getImage(telaLogin.class.getResource("/br/quixada/ufc/si/img/service-bell.png")));
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		ImageIcon imagem2 = new ImageIcon(telaLogin.class.getResource("/br/quixada/ufc/si/img/tela_login (2).png"));
		JLabel fundo = new JLabel("");
		fundo.setBounds(0, 0, 994, 550);
		Image imag2 = imagem2.getImage().getScaledInstance(fundo.getWidth(), fundo.getHeight(), Image.SCALE_SMOOTH);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(717, 143, 159, 20);
		comboBox.setMaximumRowCount(4);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(204, 153, 51));
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		comboBox.addItem("Escolha uma opção: ");
		comboBox.addItem("Administrador");
		comboBox.addItem("Hóspede");
		comboBox.addItem("Recepcionista");
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				comboBox.setBorder(new LineBorder(Color.WHITE, 1, true));
				comboBox.setBackground(new Color(204, 153, 51));
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				comboBox.setBorder(new LineBorder(Color.BLACK, 1, true));
				comboBox.setBackground(Color.WHITE);
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				comboBox.setBorder(new LineBorder(Color.BLACK, 1, true));
				comboBox.setBackground(Color.WHITE);
			}

		});
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox.setBorder(new LineBorder(Color.BLACK, 1, true));
				comboBox.setBackground(Color.WHITE);
			}
			public void mouseClicked(MouseEvent e) {
				comboBox.setBorder(new LineBorder(Color.BLACK, 1, true));
				comboBox.setBackground(new Color(204, 153, 51));
			}
			public void mouseExited(MouseEvent e) {
				comboBox.setBorder(new LineBorder(Color.WHITE, 1, true));
				comboBox.setBackground(Color.WHITE);
			}

			public void mouseReleased(MouseEvent e) {
				comboBox.setBorder(new LineBorder(Color.WHITE, 1, true));
				comboBox.setBackground(Color.WHITE);
			}

		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() == comboBox.getItemAt(0)) {
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

		JPanel J = new JPanel();
		J.setBounds(0, 0, 994, 550);
		J.setOpaque(false);
		J.setBackground(new Color(0, 0, 139, 30));
		J.setVisible(false);
		contentPane.setLayout(null);
		contentPane.add(J);
		J.setLayout(null);


		textNome = new JTextField();
		textNome.setBounds(213, 65, 584, 28);
		textNome.setToolTipText("");
		textNome.setText("");
		textNome.setOpaque(false);
		textNome.setForeground(Color.WHITE);
		textNome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textNome.setColumns(10);
		textNome.setBorder(new LineBorder(Color.WHITE, 1, true));
		J.add(textNome);

		textcpf = new JTextField();
		textcpf.setBounds(213, 119, 584, 28);
		textcpf.setToolTipText("");
		textcpf.setText("");
		textcpf.setOpaque(false);
		textcpf.setForeground(Color.WHITE);
		textcpf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textcpf.setColumns(10);
		textcpf.setBorder(new LineBorder(Color.WHITE, 1, true));
		J.add(textcpf);

		textEmail = new JTextField();
		textEmail.setToolTipText("");
		textEmail.setText("");
		textEmail.setOpaque(false);
		textEmail.setForeground(Color.WHITE);
		textEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textEmail.setColumns(10);
		textEmail.setBorder(new LineBorder(Color.WHITE, 1, true));
		textEmail.setBounds(213, 174, 584, 28);
		J.add(textEmail);

		textRua = new JTextField();
		textRua.setBounds(213, 327, 271, 28);
		textRua.setToolTipText("");
		textRua.setText("");
		textRua.setOpaque(false);
		textRua.setForeground(Color.WHITE);
		textRua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textRua.setColumns(10);
		textRua.setBorder(new LineBorder(Color.WHITE, 1, true));
		J.add(textRua);

		textCidade = new JTextField();
		textCidade.setToolTipText("");
		textCidade.setText("");
		textCidade.setOpaque(false);
		textCidade.setForeground(Color.WHITE);
		textCidade.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textCidade.setColumns(10);
		textCidade.setBorder(new LineBorder(Color.WHITE, 1, true));
		textCidade.setBounds(213, 277, 271, 28);
		J.add(textCidade);

		textTelefone = new JTextField();
		textTelefone.setToolTipText("");
		textTelefone.setText("");
		textTelefone.setOpaque(false);
		textTelefone.setForeground(Color.WHITE);
		textTelefone.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textTelefone.setColumns(10);
		textTelefone.setBorder(new LineBorder(Color.WHITE, 1, true));
		textTelefone.setBounds(214, 224, 270, 28);
		J.add(textTelefone);


		txtEe = new JTextField();
		txtEe.setToolTipText("");
		txtEe.setOpaque(false);
		txtEe.setForeground(Color.WHITE);
		txtEe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtEe.setColumns(10);
		txtEe.setBorder(new LineBorder(Color.WHITE, 1, true));
		txtEe.setBounds(438, 380, 46, 28);
		J.add(txtEe);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Arial", Font.BOLD, 15));
		lblCidade.setBounds(112, 285, 64, 13);
		J.add(lblCidade);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(126, 73, 82, 13);
		lblNome.setFont(new Font("Arial", Font.BOLD, 15));
		lblNome.setForeground(Color.WHITE);
		J.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(140, 127, 75, 13);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		J.add(lblCpf);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmail.setBounds(126, 183, 56, 13);
		J.add(lblEmail);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setForeground(Color.WHITE);
		labelTelefone.setFont(new Font("Arial", Font.BOLD, 15));
		labelTelefone.setBounds(100, 232, 96, 13);
		J.add(labelTelefone);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setForeground(Color.WHITE);
		lblDataDeNascimento.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataDeNascimento.setBounds(504, 232, 170, 13);
		J.add(lblDataDeNascimento);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(141, 335, 64, 13);
		lblRua.setForeground(Color.WHITE);
		lblRua.setFont(new Font("Arial", Font.BOLD, 15));
		J.add(lblRua);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(126, 388, 75, 13);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 15));
		J.add(lblSenha);



		JPanel cadastrofundo2 = new JPanel();
		cadastrofundo2.setBounds(0, 0, 994, 550);
		contentPane.add(cadastrofundo2);
		cadastrofundo2.setBackground(new Color(0, 0, 0, 130));
		cadastrofundo2.setLayout(null);
		cadastrofundo2.setVisible(false);
		contentPane.add(comboBox);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(749, 174, 87, 23);
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseEntered(MouseEvent e) {
				btnEntrar.setBorder(new LineBorder(Color.BLACK, 1, true));
				btnEntrar.setBackground(new Color(41, 55, 118));
			}
			public void mouseClicked(MouseEvent e) {
				btnEntrar.setBackground(new Color(41, 55, 118));
			}
			public void mouseExited(MouseEvent e) {
				btnEntrar.setBorder(new LineBorder(Color.WHITE, 1, true));
				btnEntrar.setBackground(Color.WHITE);
			}
			public void mousePressed(MouseEvent e) {
				btnEntrar.setBackground(new Color(41, 55, 118));
			}
			public void mouseReleased(MouseEvent e) {
				btnEntrar.setBackground(new Color(41, 55, 118));
			}
		});
		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ControlerLogin login = new ControlerLogin();
				
				if(indexCombo == 0) {
					JOptionPane.showMessageDialog(null, "Nenhuma Opção selecionada\n Por favor, scolha uma opção: ");

				}else if(indexCombo == 1) { //
					if ((txtCpf.getText().isEmpty()) || (new String(textSenha.getPassword()).isEmpty())) { // verifica se os campos  estao vazios 
						JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
					} else {
						Administrador adm = login.logarADM(txtCpf.getText(), new String(textSenha.getPassword()), indexCombo);
						if(adm != null) {
							dispose();
							menuAdm obj = new menuAdm();
							obj.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "ERRO! CPF ou Senha não existe\n");
						}
					}
				}else if(indexCombo == 2) {
					if ((txtCpf.getText().isEmpty()) || (new String(textSenha.getPassword()).isEmpty())) { // verifica se os campos  estao vazios 
						JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
					} else {
						Hospede hospede = login.logarClien(txtCpf.getText(), new String(textSenha.getPassword()), indexCombo);
						if(hospede != null) {
							dispose();
							principal obj = new principal(hospede);
							obj.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "ERRO! CPF ou Senha não existe\n");
						}
					}
				}else {
					if ((txtCpf.getText().isEmpty()) || (new String(textSenha.getPassword()).isEmpty())) { // verifica se os campos  estao vazios 
						JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
					} else {
						Recepcionista recep = login.logarRecep(txtCpf.getText(), new String(textSenha.getPassword()), indexCombo);
						if(recep != null) {
							dispose();
							menuRecep obj = new menuRecep(recep);
							obj.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "ERRO! CPF ou Senha não existe\n");
						}
					}
				}
			}
		});
		contentPane.add(btnEntrar);

		txtCpf = new JTextField();
		txtCpf.setBounds(682, 65, 223, 28);
		txtCpf.setText("");
		txtCpf.setForeground(Color.WHITE);
		txtCpf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtCpf.setToolTipText("");
		txtCpf.setOpaque(false);
		txtCpf.setBorder(new LineBorder(Color.WHITE, 1, true));
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		textSenha = new JPasswordField();
		textSenha.setBounds(682, 104, 223, 28);
		textSenha.setForeground(Color.WHITE);
		textSenha.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textSenha.setOpaque(false);
		textSenha.setBorder(new LineBorder(Color.WHITE, 1, true));
		contentPane.add(textSenha);

		JLabel cpf_login = new JLabel("CPF:");
		cpf_login.setBounds(632, 73, 45, 13);
		cpf_login.setForeground(Color.WHITE);
		cpf_login.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(cpf_login);

		JLabel senha_login = new JLabel("Senha:");
		senha_login.setBounds(620, 112, 52, 13);
		senha_login.setForeground(Color.WHITE);
		senha_login.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(senha_login);

		JLabel naoPossui = new JLabel("N\u00E3o possui uma conta?");
		naoPossui.setBounds(682, 208, 223, 14);
		naoPossui.setHorizontalAlignment(SwingConstants.CENTER);
		naoPossui.setForeground(Color.WHITE);
		naoPossui.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(naoPossui);

		JLabel lblAcesseSuaConta = new JLabel("Acesse sua conta");
		lblAcesseSuaConta.setBounds(682, 40, 223, 14);
		lblAcesseSuaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcesseSuaConta.setForeground(Color.WHITE);
		lblAcesseSuaConta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblAcesseSuaConta);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(508, 388, 64, 13);
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial", Font.BOLD, 15));
		J.add(lblBairro);

		JLabel labelFoto1 = new JLabel("");
		labelFoto1.setBounds(816, 65, 150, 200);
		J.add(labelFoto1);

		JButton btnUploadFoto = new JButton("Selecione sua foto");
		btnUploadFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionImageSelected(e, labelFoto1);

			}
		});
		btnUploadFoto.setForeground(Color.BLACK);
		btnUploadFoto.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUploadFoto.setBackground(Color.WHITE);
		btnUploadFoto.setBounds(429, 419, 137, 23);
		J.add(btnUploadFoto);

		textBairro = new JTextField();
		textBairro.setBounds(567, 380, 125, 28);
		textBairro.setToolTipText("");
		textBairro.setText("");
		textBairro.setOpaque(false);
		textBairro.setForeground(Color.WHITE);
		textBairro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textBairro.setColumns(10);
		textBairro.setBorder(new LineBorder(Color.WHITE, 1, true));
		J.add(textBairro);

		textNumero = new JTextField();
		textNumero.setToolTipText("");
		textNumero.setText("");
		textNumero.setOpaque(false);
		textNumero.setForeground(Color.WHITE);
		textNumero.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textNumero.setColumns(10);
		textNumero.setBorder(new LineBorder(Color.WHITE, 1, true));
		textNumero.setBounds(745, 380, 56, 28);
		J.add(textNumero);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setOpaque(false);
		passwordField.setBorder(new LineBorder(Color.WHITE, 1, true));
		passwordField.setBounds(213, 380, 219, 28);
		J.add(passwordField);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setForeground(Color.WHITE);
		dateChooser.setBounds(660, 224, 137, 28);
		J.add(dateChooser);

		JLabel lblN = new JLabel("N\u00BA");
		lblN.setForeground(Color.WHITE);
		lblN.setFont(new Font("Arial", Font.BOLD, 15));
		lblN.setBounds(717, 389, 30, 13);
		J.add(lblN);


		JLabel labelTextConta = new JLabel("Criar uma conta");
		labelTextConta.setBounds(682, 225, 223, 14);
		labelTextConta.setHorizontalAlignment(SwingConstants.CENTER);
		labelTextConta.setForeground(Color.WHITE);
		labelTextConta.setFont(new Font("Times New Roman", Font.BOLD, 13));
		labelTextConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelTextConta.setForeground(new Color(41, 55, 118));
			}
			public void mouseExited(MouseEvent e) {
				labelTextConta.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox.setVisible(false);
				btnEntrar.setVisible(false);
				textSenha.setVisible(false);
				txtCpf.setVisible(false);
				naoPossui.setVisible(false);
				labelTextConta.setVisible(false);
				lblAcesseSuaConta.setVisible(false);
				cpf_login.setVisible(false);
				senha_login.setVisible(false);

				J.setVisible(true);
				cadastrofundo2.setVisible(true);


			}
		});
		contentPane.add(labelTextConta);

		fundo.setIcon(new ImageIcon(imag2));
		contentPane.add(fundo);



		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(534, 464, 87, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textcpf.setBorder(new LineBorder(Color.WHITE, 1, true));
				textNome.setBorder(new LineBorder(Color.WHITE, 1, true));
				passwordField.setBorder(new LineBorder(Color.WHITE, 1, true));
				textEmail.setBorder(new LineBorder(Color.WHITE, 1, true));
				textTelefone.setBorder(new LineBorder(Color.WHITE, 1, true));
				dateChooser.setBorder(new LineBorder(Color.BLACK, 1, true));
				textNome.setText("");
				textcpf.setText("");
				//textNascimento.setText("");
				textRua.setText("");
				textBairro.setText("");
				textNumero.setText("");
				passwordField.setText("");
				txtEe.setText("");


				J.setVisible(false);
				cadastrofundo2.setVisible(false);

				comboBox.setVisible(true);
				btnEntrar.setVisible(true);
				textSenha.setVisible(true);
				txtCpf.setVisible(true);
				naoPossui.setVisible(true);
				labelTextConta.setVisible(true);
				lblAcesseSuaConta.setVisible(true);
				cpf_login.setVisible(true);
				senha_login.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(Color.WHITE);
		J.add(btnVoltar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blnEnviarActionPerformed1(e, textcpf.getText());
				ControlerHospede hosp = new ControlerHospede();
				String dataNasc = "";
				if(dateChooser.getDate() != null) {
					java.util.Date pega1 = dateChooser.getDate();
					SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
					dataNasc = formato1.format(pega1);
				}
				if (textcpf.getText().matches("\\d+") && (textcpf.getText().length() == 11) && (!textNome.getText().matches("\\d+"))) {
					//System.out.println("Data: " +dataNasc+ "\nSenha: " + new String(passwordField.getPassword()));
					if(textcpf.getText().isEmpty() || textNome.getText().isEmpty() ||  new String(passwordField.getPassword()).isEmpty() || textEmail.getText().isEmpty() || textTelefone.getText().isEmpty() || dataNasc.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Um ou mais campos obrigatórios estão vazios");
						if(textcpf.getText().isEmpty()){
							textcpf.setBorder(new LineBorder(Color.RED, 1, true));
						}else {
							textcpf.setBorder(new LineBorder(Color.WHITE, 1, true));
						}
						if(textNome.getText().isEmpty()) {
							textNome.setBorder(new LineBorder(Color.RED, 1, true));
						}else {
							textNome.setBorder(new LineBorder(Color.WHITE, 1, true));
						}
						if(new String(passwordField.getPassword()).isEmpty()) {
							passwordField.setBorder(new LineBorder(Color.RED, 1, true));
						}else {
							passwordField.setBorder(new LineBorder(Color.WHITE, 1, true));
						}
						if(textEmail.getText().isEmpty()) {
							textEmail.setBorder(new LineBorder(Color.RED, 1, true));
						}else {
							textEmail.setBorder(new LineBorder(Color.WHITE, 1, true));
						}
						if(textTelefone.getText().isEmpty()){
							textTelefone.setBorder(new LineBorder(Color.RED, 1, true));
						}else {
							textTelefone.setBorder(new LineBorder(Color.WHITE, 1, true));
						}
						if(dataNasc.isEmpty()) {
							dateChooser.setBorder(new LineBorder(Color.RED, 1, true));
						}else {
							dateChooser.setBorder(new LineBorder(Color.BLACK, 1, true));
						}
					}else {
						textcpf.setBorder(new LineBorder(Color.WHITE, 1, true));
						textNome.setBorder(new LineBorder(Color.WHITE, 1, true));
						dateChooser.setBorder(new LineBorder(Color.BLACK, 1, true));
						passwordField.setBorder(new LineBorder(Color.WHITE, 1, true));
						textEmail.setBorder(new LineBorder(Color.WHITE, 1, true));
						textTelefone.setBorder(new LineBorder(Color.WHITE, 1, true));
						if(textNumero.getText().isEmpty()) {
							textNumero.setText("0");
						}
						hosp.cadastrarHospede(textcpf.getText(), textNome.getText(), new String(passwordField.getPassword()), textEmail.getText(), textTelefone.getText(), dataNasc, textRua.getText(), Integer.parseInt(textNumero.getText()), textBairro.getText(), textCidade.getText());
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Os campos Nome não pode conter números e o CPF não pode conter letras");
				}
			}
		});
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(374, 464, 96, 23);
		J.add(btnCadastrar);	
	}

	private void actionImageSelected(ActionEvent e, JLabel labelFoto) {
		JFileChooser fc = new JFileChooser();
		int res = fc.showOpenDialog(null);

		if (res == JFileChooser.APPROVE_OPTION) {
			File arquivo = fc.getSelectedFile();

			try {
				imagem1 = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 150, 200);
				labelFoto.setIcon(new ImageIcon(imagem1));

			} catch (Exception ex) {
				// System.out.println(ex.printStackTrace().toString());
			}

		} else {
			JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo.");
			imagem1 = ManipularImagem.setImagemDimensao(getClass().getResource("../img/clientes/user_male.png").toString().substring(5), 150, 200);
			labelFoto.setIcon(new ImageIcon(imagem1));
		}
	}

	private void blnEnviarActionPerformed1(ActionEvent evt, String nomeFoto) {//GEN-FIRST:event_blnEnviarActionPerformed
		try {
			if(imagem1 != null) {
				String caminho = getClass().getResource("../img/clientes/").toString().substring(5);
				File outputfile = new File(caminho + nomeFoto + ".jpg");
				ImageIO.write(imagem1, "jpg", outputfile);
				JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
			}
		} catch (IOException ex) {
			Logger.getLogger(menuAdm.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}


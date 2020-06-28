package br.quixada.ufc.si.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.quixada.ufc.si.controller.ControlerAdmin;
import br.quixada.ufc.si.controller.ControlerHospede;
import br.quixada.ufc.si.model.Quarto;

import javax.swing.border.LineBorder;

public class atualizarQuartos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atualizarQuartos frame = new atualizarQuartos();
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
	public atualizarQuartos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 35, 295, 299);
		contentPane.add(scrollPane);
		
		DefaultTableCellRenderer titulos = new DefaultTableCellRenderer() {
			public void setValue(Object value) {
			setHorizontalAlignment(JLabel.CENTER);
			super.setValue(value);
			}
		};

		table = new JTable();
		table.setFont(new Font("Arial", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "Número", "Preço" }));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 11));
		textField.setForeground(Color.WHITE);
		textField.setBorder(new LineBorder(Color.WHITE));
		textField.setOpaque(false);
		textField.setBounds(442, 130, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pre\u00E7o:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(390, 132, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtualizar.setBounds(390, 192, 89, 23);
		contentPane.add(btnAtualizar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuAdm ma = new menuAdm();
				ma.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(503, 193, 89, 23);
		contentPane.add(btnVoltar);

		ControlerHospede ch = new ControlerHospede();
		table.getColumn("Número").setCellRenderer(titulos);
		table.getColumn("Preço").setCellRenderer(titulos);

		ArrayList<Quarto> listaQuartos = ch.listarQuartos();

		// SETANDO PARA A TABELA COMEÇAR COM NENHUMA LINHA
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);

		for (int i = 0; i < listaQuartos.size(); i++) {
			modelo.addRow(new Object[] { listaQuartos.get(i).getNumero(), listaQuartos.get(i).format(listaQuartos.get(i).getValorDiaria()) });
		}

	}
	}



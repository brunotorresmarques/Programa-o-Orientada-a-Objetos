package br.quixada.ufc.si.view.listaimage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.quixada.ufc.si.view.principal;

public class listaIcon {
	private int indice = 0;
	private ArrayList<ImageIcon> listaSuite;
	private ArrayList<ImageIcon> listaSuiteCasal;
	private ArrayList<ImageIcon> listaSuiteExecutiva;
	private ArrayList<ImageIcon> listaSuitePresidencial;
	
	public listaIcon(String tipo) {
		if(tipo.equals("Suíte")) {
			this.indice = 0;
			listaSuite = new ArrayList<ImageIcon>();
			listaSuite.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suite01.jpg")));
			listaSuite.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suite02.jpg")));
			listaSuite.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suite03.jpg")));

		}else if(tipo.equals("Suíte Casal")) {
			this.indice = 0;
			listaSuiteCasal = new ArrayList<ImageIcon>();
			listaSuiteCasal.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suitecasal01.jpg")));
			listaSuiteCasal.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suitecasal02.jpg")));
			listaSuiteCasal.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suitecasal03.jpg")));

		}else if(tipo.equals("Suíte Executiva")) {
			this.indice = 0;
			listaSuiteExecutiva = new ArrayList<ImageIcon>();
			listaSuiteExecutiva.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suiteexecutiva01.jpg")));
			listaSuiteExecutiva.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suiteexecutiva02.jpg")));
			listaSuiteExecutiva.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suiteexecutiva03.jpg")));


			
		}else if(tipo.equals("Suíte Presidencial")) {
			this.indice = 0;
			listaSuitePresidencial = new ArrayList<ImageIcon>();
			listaSuitePresidencial.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suitepresidencial01.jpg")));
			listaSuitePresidencial.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suitepresidencial02.jpg")));
			listaSuitePresidencial.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suitepresidencial03.jpg")));
			listaSuitePresidencial.add(new ImageIcon(principal.class.getResource("/br/quixada/ufc/si/img/quartos/suitepresidencial04.jpg")));		
		}else {
			JOptionPane.showMessageDialog(null, "ERRO 404");
		}
	}
	
	public int getIndice() {
		return indice;
	}

	public ArrayList<ImageIcon> getListaSuite() {
		return listaSuite;
	}
	
	public ArrayList<ImageIcon> getListaSuiteCasal() {
		return listaSuiteCasal;
	}

	public ArrayList<ImageIcon> getListaSuiteExecutiva() {
		return listaSuiteExecutiva;
	}

	public ArrayList<ImageIcon> getListaSuitePresidencial() {
		return listaSuitePresidencial;
	}

	public void addImageSuite(String endereco) {
		if(endereco != null) {
			listaSuite.add(new ImageIcon(principal.class.getResource(endereco)));
		}else {
			JOptionPane.showMessageDialog(null,"Imagem inexistente!");
		}
	}
	
	public void addImageSuiteCasal(String endereco) {
		if(endereco != null) {
			listaSuiteCasal.add(new ImageIcon(principal.class.getResource(endereco)));
		}else {
			JOptionPane.showMessageDialog(null,"Imagem inexistente!");
		}
	}
	
	public void addImageSuiteExecutiva(String endereco) {
		if(endereco != null) {
			listaSuiteExecutiva.add(new ImageIcon(principal.class.getResource(endereco)));
		}else {
			JOptionPane.showMessageDialog(null,"Imagem inexistente!");
		}
	}
	
	public void addImageSuitePresidencial(String endereco) {
		if(endereco != null) {
			listaSuitePresidencial.add(new ImageIcon(principal.class.getResource(endereco)));
		}else {
			JOptionPane.showMessageDialog(null,"Imagem inexistente!");
		}
	}
	
	/*
	public ImageIcon askImage(ImageIcon procura) {
		for(ImageIcon image: listaSuite) {
			if(image.equals(procura)) {
				return image;
			}
		}
		return null;
	}*/
	
	public ImageIcon BackImageSuite() {
		if(this.indice == 0) {
			this.indice = listaSuite.size();
		}
		this.indice--;
		return listaSuite.get(this.indice);
	}
	
	public ImageIcon NextImageSuite() {
		if(this.indice == listaSuite.size() - 1) {
			this.indice = -1;
		}
		this.indice++;	
		return listaSuite.get(this.indice);
	}
	
	public ImageIcon BackImageSuiteCasal() {
		if(this.indice == 0) {
			this.indice = listaSuiteCasal.size();
		}
		this.indice--;
		return listaSuiteCasal.get(this.indice);
	}
	
	public ImageIcon NextImageSuiteCasal() {
		if(this.indice == listaSuiteCasal.size() - 1) {
			this.indice = -1;
		}
		this.indice++;	
		return listaSuiteCasal.get(this.indice);
	}
	
	public ImageIcon BackImageSuiteExecutiva() {
		if(this.indice == 0) {
			this.indice = listaSuiteExecutiva.size();
		}
		this.indice--;
		return listaSuiteExecutiva.get(this.indice);
	}
	
	public ImageIcon NextImageSuiteExecutiva() {
		if(this.indice == listaSuiteExecutiva.size() - 1) {
			this.indice = -1;
		}
		this.indice++;	
		return listaSuiteExecutiva.get(this.indice);
	}
	
	public ImageIcon BackImageSuitePresidencial() {
		if(this.indice == 0) {
			this.indice = listaSuitePresidencial.size();
		}
		this.indice--;
		return listaSuitePresidencial.get(this.indice);
	}
	
	public ImageIcon NextImageSuitePresidencial() {
		if(this.indice == listaSuitePresidencial.size() - 1) {
			this.indice = -1;
		}
		this.indice++;	
		return listaSuitePresidencial.get(this.indice);
	}

}

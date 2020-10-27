package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Algoritmos.Fifo;
import Algoritmos.Rr;
import Algoritmos.Sjf;
import Algoritmos.Srt;
import Controlador.ControladorSIMPRO;

public class MiMouseListener implements ActionListener {

	/**
	 * Override de actionPerformed para capturar evento del click en los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// iniciamos procesamiento

		// comprueba textFields
		if (compruebaTxtF()) {
			ControladorSIMPRO.getWindow().getTaResultado().setText("*********** Comienzo **********\n");
			// comprueba y ejecuta los procesos seleccionados
			compruebaChk();
		} else {
			JOptionPane.showMessageDialog(ControladorSIMPRO.getWindow().getFrame(),"tanto las llegadas como las ráfagas tienen que ser números enteros positivos");
		}

	}

		/**
		 * Comprueba los 6 Textfields
		 * @return
		 */
	private boolean compruebaTxtF() {
		boolean resultado = true;
		
		// Comprueba B1
		resultado = compruebaTF (ControladorSIMPRO.getWindow().getTextFieldB1());
		//  Comprueba B2
		if (resultado) resultado = compruebaTF (ControladorSIMPRO.getWindow().getTextFieldB2());		
		// Comprueba B3
		if (resultado) resultado = compruebaTF (ControladorSIMPRO.getWindow().getTextFieldB3());		
		// Comprueba B4
		if (resultado) resultado = compruebaTF (ControladorSIMPRO.getWindow().getTextFieldB4());		
		// Comprueba C1
		if (resultado) resultado = compruebaTF (ControladorSIMPRO.getWindow().getTextFieldC1());		
		// Comprueba C2
		if (resultado) resultado = compruebaTF (ControladorSIMPRO.getWindow().getTextFieldC2());		
		// Comprueba C3
		if (resultado) resultado = compruebaTF (ControladorSIMPRO.getWindow().getTextFieldC3());
		// Comprueba C4
		if (resultado) resultado = compruebaTF (ControladorSIMPRO.getWindow().getTextFieldC4());		

		
		
		return resultado;
	}
	/**
	 * Conprueba si es nulo o menor de 0
	 * @param tf textfield a comprobar
	 * @return false si es nulo o menor de 0
	 */
	private boolean compruebaTF(JTextField tf) {
			boolean resultado=true;
			
			if(tf.getText().length()>0){
				if (Integer.parseInt(tf.getText())<0){
					resultado=false;
				}
			} else {
				resultado=false;
			}
			return resultado;
		}

	/**
	 * comprueba y ejecuta los procesos seleccionados en los CheckBox
	 */
	private void compruebaChk() {
		// Fifo Seleccionado
				if (ControladorSIMPRO.getWindow().getChkFIFO().isSelected()) {
					ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
							+ "******* FIFO *********\n");
					ControladorSIMPRO.cargaProcesos();
					Fifo miFifo = new Fifo(ControladorSIMPRO.getMiLista());
				}

				// SRT seleccionado
				if (ControladorSIMPRO.getWindow().getChkRST().isSelected()) {
					ControladorSIMPRO.cargaProcesos();
					ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
							+ "******* SRT *********\n");
					Srt miSrt = new Srt(ControladorSIMPRO.getMiLista());
				}

				//SJF seleccionado
				if (ControladorSIMPRO.getWindow().getChkSJF().isSelected()) {
					ControladorSIMPRO.cargaProcesos();
					ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
							+ "******* SJF *********\n");
					Sjf miSjf = new Sjf(ControladorSIMPRO.getMiLista());
				}

				//RR seleccionado
				if (ControladorSIMPRO.getWindow().getChkRR().isSelected()) {
					//comprobamos quantum
					if ((ControladorSIMPRO.getWindow().getTfQuantum().getText().length()>0)
							&& (Integer.parseInt(ControladorSIMPRO.getWindow().getTfQuantum().getText())>0)){
						
						ControladorSIMPRO.cargaProcesos();
						ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
								+ "******* RR *********\n");
						Rr miRr = new Rr(ControladorSIMPRO.getMiLista());
					} else {
						// no hay quantum o es nulo
						JOptionPane.showMessageDialog(ControladorSIMPRO.getWindow().getFrame(),"Si se elige Round Robin el Quantum debe ser mayor de 0");
					}

				}
		
	}

}

package Controlador;

import GUI.GUI;
import Modelos.ListaProcesos;
import Modelos.Proceso;

public abstract class ControladorSIMPRO {
	/**

	 * Esta clase define el controlador de nuestra aplicación

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	//Estados
	private static ListaProcesos miLista;
	private static GUI miWindow;
	
	//Comportamientos
	// Constructor vacio
	public ControladorSIMPRO() {
;
	}

		// inicia las variables
	public static void inicio() {
		System.out.println("******************************");
		//  iniciar la GUI 
		try {
			miWindow = new GUI();
			miWindow.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Carga los procesos desde la GUI
	 */
	public static void cargaProcesos () {
		miLista=new ListaProcesos();
		//crea los procesos, PID, llegada (de 0 en adelante, debe de haber uno que comience en 0), ráfaga
		Proceso miProcesoA = new Proceso(0,Integer.parseInt(miWindow.getTextFieldB1().getText()),Integer.parseInt(miWindow.getTextFieldC1().getText()));
		Proceso miProcesoB = new Proceso(1,Integer.parseInt(miWindow.getTextFieldB2().getText()),Integer.parseInt(miWindow.getTextFieldC2().getText()));
		Proceso miProcesoC = new Proceso(2,Integer.parseInt(miWindow.getTextFieldB3().getText()),Integer.parseInt(miWindow.getTextFieldC3().getText()));
		Proceso miProcesoD = new Proceso(3,Integer.parseInt(miWindow.getTextFieldB4().getText()),Integer.parseInt(miWindow.getTextFieldC4().getText()));

		// borra la lista y carga los procesos
		miLista.clear();
		miLista.add(miProcesoA);
		miLista.add(miProcesoB);
		miLista.add(miProcesoC);
		miLista.add(miProcesoD);
		// la ordena
		miLista.ordenarxLlegada();
		// la carga en el Text area
		miWindow.getTaResultado().setText(miWindow.getTaResultado().getText() + "procesando la lista de procesos:\n");
		miWindow.getTaResultado().setText(miWindow.getTaResultado().getText() + miLista.toOut() +"\n");	
		miWindow.getTaResultado().setText((miWindow.getTaResultado().getText() + "***************************\n"));
	}

	
	/**
	 * getWindow
	 * @return
	 */
	public static GUI getWindow() {
		return miWindow;
	}
	/*
	 * Get lista de procesos
	 */
	public static ListaProcesos getMiLista() {
		// TODO Auto-generated method stub
		return miLista;
	}
}

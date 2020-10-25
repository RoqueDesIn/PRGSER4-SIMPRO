package Algoritmos;

import Controlador.ControladorSIMPRO;
import Modelos.ListaProcesos;
import Modelos.Proceso;

public class Procesador {
	
	
	/**

	 * Esta clase define el objeto que procesa el algoritmo común.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	// estados
	static  protected ListaProcesos cola;
	static protected Proceso procesado;
	static protected ListaProcesos listaAux; 
	static protected int iterador;
	//***************************************************
	// crea el quatum
	static protected int quantum=2;
	static protected int cntQuantum;
	// comportamientos
	/**
	 * constructor
	 */
	public Procesador(ListaProcesos miLista) {
		// guarda la lista en una lista auxiliar
		listaAux=new ListaProcesos(miLista);
		procesa(miLista);
		calcula();
	}
	
	private void calcula() {
		/*
		 *  Rendimiento = Media de penalizaciones	
		 * 	Penalización = (tiempo fin-tiempo llegada)/Tiempo CPU								
		 */
		float penalizacion=0;
		float sumatoria=0;
		float media=0;
		// añade titulos
		ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
				+("--------------------------\n"));
		ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
				+("|Proc. | Penalización    |\n"));
		ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
				+("--------------------------\n"));
		
		// calcula rendimiento y penalización
		for (int i=0;i<listaAux.size();i++) {
			// 	Penalización = (tiempo fin-tiempo llegada)/Tiempo CPU
			penalizacion=(float) (listaAux.get(i).getFin()-listaAux.get(i).getLlegada())/listaAux.prtoTot();
			ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
					+ ("|   "+i+"  | "+penalizacion) +("\n"));
			sumatoria=sumatoria+penalizacion;
		}
		media=sumatoria/listaAux.prtoTot();
		
		// añade al texto totales
		ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
				+("--------------------------\n"));
		ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
				+ "|Rendimiento  "+media+"  |" + ("\n"));
		ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
				+("--------------------------\n"));
	}

	public void procesa(ListaProcesos miLista) {
		// calcula el procesamiento total
		int procesamiento=miLista.prtoTot();
		// crea la cola de procesamiento 
		cola = new ListaProcesos();
		// inicia contadoir de quantum
		cntQuantum=0;
		
// Ejecución
		int contador=0;
		procesado=null;
		//recorre todos los pasos de proceso
		for (iterador=0;iterador<procesamiento;iterador++) {
			// recorremos listaProcesos y añadimos a la cola si le toca entrar a algún proceso
			contador=0;
			while ( contador<miLista.size()) {
				if (iterador==miLista.get(contador).getLlegada()) cola.add(miLista.get(contador));
				contador++;
			}
			//finaliza while
			// si procesado es null es el primer proceso
				// sacamos un proceso de la cola para procesarlo
				if (procesado==null) {
					// sacamos el último proceso de la cola
					procesado=cola.get(0);
					// borramos el último proceso de la cola
					cola.borraIndex(0);
				} else {
					// comprobamos
					comprueba();
				}
			
			// procesa el proceso actual quita uno a la ráfaga para simular el procesado
			if (procesado!=null) {
				ControladorSIMPRO.getWindow().getTaResultado().setText(ControladorSIMPRO.getWindow().getTaResultado().getText()
						+ procesado.toOut() + "\n");
				procesado.setRafaga(procesado.getRafaga()-1);
				// solo para RR
				cntQuantum++;
			}
		}
		// guarda el tiempo de reloj de fin del último proceso en la lista auxiliar
		listaAux.get((listaAux.findByPid(procesado.getPID()))).setFin(procesamiento);
		// finaliza for		

	}
	/**
	 * comprueba el algoritmo en cuestión, al ser el padre no hace nada, está solo para ser Override

	 */
	public void comprueba() {
		// no hacemos nada, está solo para ser reescrito

		
	}
}

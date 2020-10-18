import java.util.LinkedList;
import java.util.Queue;

import javax.print.attribute.standard.MediaSize.Other;

public class ControladorSIMPRO {
	/**

	 * Esta clase define el controlador denuestra aplicación

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	//Estados
	private ListaProcesos miLista;
	
	//Comportamientos
	// Constructor vacio
	public ControladorSIMPRO() {
		miLista=new ListaProcesos();
	}

		// inicia las variables
	public void inicio() {
		//crea los procesos, PID, llegada (de 0 en adelante, debe de haber uno que comience en 0), ráfaga
		Proceso miProcesoA = new Proceso(0,5,5);
		Proceso miProcesoB = new Proceso(1,4,2);
		Proceso miProcesoC = new Proceso(2,1,5);
		Proceso miProcesoD = new Proceso(3,2,4);

		// borra la lista y carga los procesos
		miLista.clear();
		miLista.add(miProcesoA);
		miLista.add(miProcesoB);
		miLista.add(miProcesoC);
		miLista.add(miProcesoD);
		// la ordena
		miLista.ordenarxLlegada();
		// la muestra por pantalla
		System.out.println("procesando la lista de procesos:\n");
		miLista.toOut();	
		System.out.println("***************************");
	}

	/**
	 * * procesa los procesos en el modo solicitado
	 * @param tipoAlg
	 * 0=FIFO
	 * 1=SRT
	 * 2=SJF
	 * 3=RR
	 */
	public void procesa(int tipoAlg) {
		switch (tipoAlg) {
			case 0:
				Fifo.procesa(miLista);
				break;
			case 1:
				Srt.procesa(miLista);
				break;
			case 2:
				//Sjf.procesa(miLista);
				break;
			case 3:
				//Rr.procesa(miLista);
				break;
			default:
				System.out.println("Eing??");
				
		}
	}
	
}

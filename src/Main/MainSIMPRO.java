package Main;
import Controlador.ControladorSIMPRO;

public class MainSIMPRO {
	/**

	 * Esta clase define el objeto de Procesos con los campos PID, llegada y ráfaga.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	//estados
	// constantes para llamar a los correspondientes algoritmos
	// 0=FIFO
	// 1=SRT
	// 2=SJF
	// 3=RR
	private static final int FIFO=0;
	private static final int SRT=1;	
	private static final int SJF=2;	
	private static final int RR=3;
	
	//comportamientos
	/**
	 * módulo principal de la aplicación
	 * @param args
	 */
	public static void main(String[] args) {
		//llamada a la GUI y al controlador
		ControladorSIMPRO miController=new ControladorSIMPRO();

		System.out.println("******************************");
		// aqui habría que iniciar la GUI y traspasar los datos al controller
		
		// procesa la lista de procesos

		System.out.println("******* FIFO *********");
		// inicializa las variables
		miController.inicio();
		miController.procesa(FIFO);
		
		System.out.println("******* SRT *********");
		// inicializa las variables
		miController.inicio();
		miController.procesa(SRT);
		
		System.out.println("******* SJF *********");
		// inicializa las variables
		miController.inicio();
		miController.procesa(SJF);
		
		System.out.println("******* RR *********");
		// inicializa las variables
		miController.inicio();
		miController.procesa(RR);
		System.out.println("\n*********************************\n"
				+ "      Fin \n*********************************\n");
	}

}

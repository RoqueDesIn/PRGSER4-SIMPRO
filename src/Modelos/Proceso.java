package Modelos;

public class Proceso implements Comparable<Proceso>{
	/**

	 * Esta clase define el objeto de Procesos con los campos PID, llegada, 
	 * ráfaga y fin(-1 si no se ha procesado).

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	
	// ESTADOS
	protected int PID;
	protected int llegada;
	protected int rafaga;
	protected int fin;
	
	// COMPORTAMIENTOS
	/**
     * Constructor para el objeto Proceso 
	 * @param pID: ID de proceso.
	 * @param llegada: ciclo de reloj en la que llega el proceso.
	 * @param rafaga: ciclos de reloj que tarda el proceso en ejecutarse.
	 */
	public Proceso(int pID, int llegada, int rafaga) {
		super();
		PID = pID;
		this.llegada = llegada;
		this.rafaga = rafaga;
		this.fin=-1;
	}
	
	/**
	 * Sobreescribe Comparable para poder ordenar por llegada
	 * @return integer -1 es menor, 1 es mayor, 0 es igual.
	 */
	@Override
	public int compareTo(Proceso p) {
		if (llegada<p.llegada) {
			return -1;
		} 
		if (llegada>p.llegada) {
			return 1;
		} 
		return 0;
		
	}

	 // Getters y setters
	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public int getLlegada() {
		return llegada;
	}

	public void setLlegada(int llegada) {
		this.llegada = llegada;
	}

	public int getRafaga() {
		return rafaga;
	}

	public void setRafaga(int rafaga) {
		this.rafaga = rafaga;
	}
	public void setFin(int fin) {
		this.fin=fin;
	}

	public int getFin() {
		// TODO Auto-generated method stub
		return this.fin;
	}
	/**
	 * escribe por pantalla el proceso
	 */
	public String  toOut() {
		return "Proceso: "+PID+" Llegada: "+llegada+" Ráfaga: "+rafaga;
	}


	
	
}

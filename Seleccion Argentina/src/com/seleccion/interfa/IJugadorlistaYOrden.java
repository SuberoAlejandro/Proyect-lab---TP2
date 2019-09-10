package com.seleccion.interfa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.seleccion.modelo.Jugador;

public interface IJugadorlistaYOrden {

	
	public List<Jugador> listaPantalla = new ArrayList<Jugador>();
	public List<Jugador> lista = new ArrayList<Jugador>();
	public List<Jugador> listab = new ArrayList<Jugador>();
    
	
	//metodo de ordenacion  de jugadores por calificasion
	default public void metodoSiOrden(String orden) {
		System.out.println(orden+" 4");
		for (Jugador pe : this.lista) {
			if (pe.getPosicion().equals(orden)) {
				listab.add(pe);
			}
		}
		listab.sort(new Comparator<Jugador>() {
			@Override
			public int compare(Jugador o1, Jugador o2) {
				return o2.getCalificasion() - o1.getCalificasion();
			}
		});
	}


}

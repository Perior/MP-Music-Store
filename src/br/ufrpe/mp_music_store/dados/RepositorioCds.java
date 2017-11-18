package br.ufrpe.mp_music_store.dados;
import br.ufrpe.mp_music_store.negocio.beans.Cd;

public class RepositorioCds {
	
	private Cd[] cd;
	private int proxima;
	
	//Construtor
	public RepositorioCds(int tamanho){
		this.cd = new Cd[tamanho];
		this.proxima = 0;
	}
	
}

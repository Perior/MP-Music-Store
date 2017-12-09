package br.ufrpe.mp_music_store.negocio.beans;

public class Cd {

	private String titulo;
	private int anoLancamento;
	private String artista;
	private double preco;
	
	//Construtor
	public Cd(String titulo, int anoLancamento, String artista, float preco) {
		super();
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.artista = artista;
		this.preco = preco;
	}

	//M�todos Getters e Setters
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getAnoLancamento() {
		return anoLancamento;
	}
	
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	//M�todo toString
	public String toString(){
		String texto = "\nT�tulo: " + this.getTitulo();
		texto += "\nAno de Lan�amento: " + this.getAnoLancamento();
		texto += "\nArtista: " + this.getArtista();
		texto += "\nPre�o : R$" + this.getPreco();
		return texto;
	}
	
	//M�todo Equals
	public boolean equals(Cd c){
		boolean r;
		if(c != null && this.titulo != null && this.anoLancamento != 0){
			r = (this.titulo.equals(c.getTitulo()) 
					&& this.anoLancamento == c.getAnoLancamento());
		}else{
			r = false;
		}
		
		return r;
	}
	
}

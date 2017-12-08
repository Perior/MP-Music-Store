package br.ufrpe.mp_music_store.dados;
import br.ufrpe.mp_music_store.negocio.beans.Cd;

public class RepositorioCds {
	
	private Cd[] cd;
	private int proxima;
	private static RepositorioCds instance;
	
	//Construtor
	public RepositorioCds(int tamanho){
		this.cd = new Cd[tamanho];
		this.proxima = 0;
	}
	
	//Singleton
		public static RepositorioCds getInstance() {
			if(instance == null) {
				instance = new RepositorioCds(100);
			}
			
			return instance;
		}
	
	//Catalogar CD
	public void cadastrar(Cd c){
		this.cd[this.proxima] = c;
		this.proxima += 1;
		if(this.proxima == cd.length){
			this.duplicarArrayCds();
		}
	}
	
	public void cadastrar(String titulo, int ano, String artista, float preco){
		Cd c = new Cd(titulo, ano, artista, preco);
		this.cadastrar(c);
	}
	
	//Buscar CD pelo t�tulo
	public Cd procurar(String nome){
		int i = this.procurarIndice(nome);
		Cd resultado = null;
		if(i != this.proxima){
			resultado = this.cd[i];
		}
		
		return resultado;
	}
	
	//Buscar �ndice
	private int procurarIndice(String titulo){
		int i = 0;
		boolean achou = false;
		
		while((!achou) && (i < this.proxima)){
			if(titulo.equals(this.cd[i].getTitulo())){
				achou = true;
			}else{
				i += 1;
			}
		}
		return i;
	}
	
	//Verificar exist�ncia
	public boolean existe(String titulo){
		boolean existe = false;
		int indice = this.procurarIndice(titulo);
		if(indice != proxima){
			existe = true;
		}
		return existe;
	}
	
	//Atualizar informa��es do CD
	public void atualizar(String titulo, String newTitulo, int anoLancamento, String artista, float preco){
		int i = procurarIndice(titulo);
		
		if(i >= 0){
			this.cd[i].setTitulo(newTitulo);
			this.cd[i].setAnoLancamento(anoLancamento);
			this.cd[i].setArtista(artista);
			this.cd[i].setPreco(preco);
		}
		
	}
	
	//Remover do array de CD's
	public void remover(String nome){
		int i = this.procurarIndice(nome);
		if(i != this.proxima){
			this.cd[i] = this.cd[this.proxima - 1];
			this.cd[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else{
			
		}
	
	}
	
	//Dobrar tamanho do array de CD's
	public void duplicarArrayCds(){
		if(this.cd != null && this.cd.length > 0){
			Cd[] arrayDuplicado = new Cd[this.cd.length * 2];
			for(int i = 0; i<this.cd.length; i++){
				arrayDuplicado[i] = this.cd[i];
			}
			
			this.cd = arrayDuplicado;
		}
	}
}

package br.ufrpe.mp_music_store.negocio;

import br.ufrpe.mp_music_store.negocio.beans.*;

public class Fachada {
	private CadastroClientes cadastroClientes;
	private CadastroFuncionarios cadastroFuncionarios;
	private CatalogoCds cadastroCds;
	private RegistroVendas registroVendas;
	private static Fachada instance;
	
	
	private Fachada() {
		this.cadastroClientes = CadastroClientes.getInstance();
		this.cadastroFuncionarios = CadastroFuncionarios.getInstance();
		this.cadastroCds = CatalogoCds.getInstance();
		this.registroVendas = RegistroVendas.getInstance();
	}
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		
		return instance;
	}
	
	/* Clientes */
	public void adicionarCliente(Cliente c) {
		this.cadastroClientes.adicionarCliente(c);
	}
	
	public Cliente buscarCliente(long cpf) {
		return this.cadastroClientes.buscarCliente(cpf);
	}
	
	public void removerCliente(long cpf) {
		this.cadastroClientes.removerCliente(cpf);
	}
	
	public void atualizarCliente(String nome, long cpfCliente, long newCpfCliente, String endereco, long telefoneCliente, int numCadastro, boolean tipoCliente){
		this.cadastroClientes.atualizarCliente(nome, cpfCliente, newCpfCliente, endereco, telefoneCliente, numCadastro, tipoCliente);
	}
	
	public boolean existeCliente(long cpf) {
		return this.cadastroClientes.existeCliente(cpf);
	}
	
	/* Funcion�rios */
	public void adicionarFuncionario(Funcionario f) {
		this.cadastroFuncionarios.adicionaFuncionario(f);
	}
	
	public Funcionario buscarFuncionario(long cpf) {
		return this.cadastroFuncionarios.buscarFuncionario(cpf);
	}
	
	public void atualizarFuncionario(String nome, long cpfFuncionario, long newCpfFuncionario, String endereco, long telefoneFuncionario, float salario,
			int numContrato){
		this.cadastroFuncionarios.atualizar(nome, cpfFuncionario, newCpfFuncionario, endereco, telefoneFuncionario, salario, numContrato);
	}
	
	public void removerFuncionario(long cpf) {
		this.cadastroFuncionarios.removerFuncionario(cpf);
	}
	
	public boolean existeFuncionario(int cpf) {
		return this.cadastroFuncionarios.existeFuncionario(cpf);
	}
	
	/* CDs */
	public void adicionarCd(Cd c) {
		this.cadastroCds.adicionaCds(c);
	}
	
	public Cd buscarCd(String nome) {
		return this.cadastroCds.buscarCds(nome);
	}
	
	public void removerCd(String nome) {
		this.cadastroCds.removerCds(nome);
	}
	
	public boolean existeCd(String titulo) {
		return this.cadastroCds.existeCd(titulo);
	}
	
	public void atualizarCd(String nome, String newNome, int anoLancamento, String artista, float preco){
		this.cadastroCds.atualizarCds(nome, newNome, anoLancamento, artista, preco);
	}
	
	/* Vendas */
	public void registrarVenda(Venda venda){
		this.registroVendas.registrarVenda(venda);
	}
	
	public Venda buscarVenda(long codigo){
		return this.registroVendas.buscarVenda(codigo);
	}
	
	public void removerVenda(long codigo){
		this.registroVendas.remover(codigo);
	}
	
	public boolean existeVenda(long codigo){
		return this.registroVendas.existeVenda(codigo);
	}
}

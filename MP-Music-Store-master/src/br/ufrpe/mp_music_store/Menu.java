package br.ufrpe.mp_music_store;

import java.util.Scanner;
import br.ufrpe.mp_music_store.negocio.Fachada;
import br.ufrpe.mp_music_store.negocio.beans.Cd;
import br.ufrpe.mp_music_store.negocio.beans.Cliente;
import br.ufrpe.mp_music_store.negocio.beans.Funcionario;
import br.ufrpe.mp_music_store.negocio.beans.Venda;

public class Menu {
	
	private Fachada fachada = Fachada.getInstance();
	private Scanner in = new Scanner(System.in);
	
	public void moldura(){
		System.out.println("**********MP MUSIC STORE**********\n");
	}
	
	public void menuCd(int operadorAuxiliar) {
		this.moldura();
		
		while(operadorAuxiliar != 5){
			System.out.println("MENU DE CD's\n");
			System.out.println("Escolha uma opera��o: ");
			System.out.println("1 - Cadastrar\n"
								+ "2 - Pesquisar"
								+ "\n3 - Remover"
								+ "\n4 - Editar"
								+ "\n5 - Sair\n");
		
			int op = in.nextInt();
			
			switch(op){
				case 1: 
					
					boolean realizado = false;
					String pesquisa;
					
					do{
						in.nextLine();//Limpar buffer
						System.out.println();
						
						System.out.println("T�tulo do CD: ");
						String tituloCd = in.nextLine();
						
						System.out.println("Ano de lan�amento: ");
						int anoLancamentoCd = in.nextInt();
						
						in.nextLine();//Limpar buffer
						
						System.out.println("Artista: ");
						String artistaCd = in.nextLine();
						
						System.out.println("Defina um pre�o ");
						float precoCd = in.nextFloat();
						
						Cd cd = new Cd(tituloCd, anoLancamentoCd, artistaCd, precoCd);
						fachada.adicionarCd(cd);
						
						realizado = true;
						System.out.println("CD catalogado com sucesso!");
						
					}while(realizado == false);
					
					break;
				
				case 2 : 
					
					in.nextLine();//Limpa buffer
					System.out.println("Exibir informa��es de um CD");
					
					System.out.println("Digite o t�tulo do CD: ");
					pesquisa = in.nextLine();
					
					Cd busca = null;
					busca = fachada.buscarCd(pesquisa);
					
					if(busca != null){
						System.out.println("Informa��es gerais: ");
						System.out.println(busca.toString());
					}else{
						System.out.println("CD n�o encontrado!");
					}
					
					break;
			
				case 3: 
					this.moldura();
					
					in.nextLine();//Limpar buffer
					System.out.println("Remo��o de CD's do cat�logo");
					
					System.out.println("Digite o t�tulo do CD a ser removido: ");
					pesquisa = in.nextLine();
					
					Cd apaga = null;
					apaga = fachada.buscarCd(pesquisa);
					
					if(apaga != null){
						System.out.println("Deseja realmente excluir " 
											+apaga.getTitulo() + "?\n"
											+ "1 - Sim"
											+ "2 - N�o");
						
						int decisao = in.nextInt();
						
						if(decisao == 1){
							fachada.removerCd(apaga.getTitulo());
							System.out.println("CD removido");
						}else{
							System.out.println("CD n�o removido!");
						}
					}
				
					break;
				
				case 4:
					this.moldura();
					
					in.nextLine();//Limpa buffer
					System.out.println("Atualiza��o de informa��es de um CD");
					
					System.out.println("Digite o t�tulo do CD a ser editado: ");
					pesquisa = in.nextLine();
					
					Cd edita = null;
					edita = fachada.buscarCd(pesquisa);
					
					if(edita != null){
						System.out.println("Insira os novos dados abaixo: ");
						
						System.out.println("T�tulo do CD: ");
						String tituloCd = in.nextLine();
						
						System.out.println("Ano de lan�amento: ");
						int anoLancamentoCd = in.nextInt();
						
						in.nextLine();//Limpar buffer
						
						System.out.println("Artista: ");
						String artistaCd = in.nextLine();
						
						System.out.println("Defina um pre�o ");
						float precoCd = in.nextFloat();
						
						fachada.atualizarCd(pesquisa, tituloCd, anoLancamentoCd, artistaCd, precoCd);
						System.out.println("Dados atualizados!");
					}else{
						System.out.println("CD n�o encontrado.");
					}
					
					break;
				
				case 5:
					
					System.out.println("Retornando ao menu...");
					in.nextLine();
					operadorAuxiliar = 5;
			}
		}
	}
	
	public void menuClientes(int operadorAuxiliar) {
		this.moldura();
		
		while(operadorAuxiliar != 5){
			System.out.println("Menu de Clientes\n");
			System.out.println("Escolha uma opera��o: \n\n");
			System.out.println("1 - Cadastrar\n"
								+ "2 - Pesquisar\n"
			                    + "3 - Remover\n"
								+ "4 - Editar\n"
			                    + "5 - Sair\n");
			
			int op = in.nextInt();
			
			switch(op){
				
				case 1:
						this.moldura();
						boolean realizado = false;
						
						do{
						in.nextLine();//Limpar buffer
						System.out.println("Nome do cliente: ");
						String nomeCliente = in.nextLine();
						
						System.out.println("CPF do cliente: ");
						long cpfCliente = in.nextLong();
						
						in.nextLine();//Limpar buffer
						
						System.out.println("Endere�o do cliente: ");
						String enderecoCliente = in.nextLine();
						
						System.out.println("Telefone para contato: ");
						long telefoneCliente = in.nextLong();
						
						in.nextLine();//Limpar buffer
						
						System.out.println("Defina um n�mero de cadastro");
						int numCadastroCliente = in.nextInt();
						
						in.nextLine();//Limpar buffer
						
						System.out.println("Quer ser um cliente Premium?");
						System.out.println("\n1 - Sim "
											+ " 2 - N�o");
						
						int decisao = in.nextInt();
						boolean tipoCliente;
						
						if(decisao == 1){
							tipoCliente = true;
						}else{
							tipoCliente = false;
						}
						
						
						Cliente cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente,
								telefoneCliente, numCadastroCliente, tipoCliente);
						
						fachada.adicionarCliente(cliente);
						realizado = true;
						System.out.println("Cliente cadastrado com sucesso!");
			
						}while(realizado == false);
						
						break;
				
				case 2: 
						this.moldura();
						long pesquisa;
						
						in.nextLine();//Limpar buffer
						System.out.println("Exibir informa��es de um Cliente");
						
						System.out.println("\nDigite o CPF do cliente: ");
						pesquisa = in.nextLong();
						
						Cliente busca = null;
						busca = fachada.buscarCliente(pesquisa);
						
						if(busca != null){
							System.out.println("Informa��es gerais: ");
							System.out.println(busca.toString());
						}else{
							System.out.println("Cliente n�o encontrado!");
						}
						break;
						
				case 3:
						this.moldura();
						in.nextLine();//Limpar buffer
						System.out.println("Remo��o de Clientes");
						
						System.out.println("Digite o CPF do cliente a ser removido: ");
						pesquisa = in.nextLong();
						
						Cliente apaga = null;
						apaga = fachada.buscarCliente(pesquisa);
						
						if(apaga != null){
							System.out.println("Deseja realmente excluir " 
												+apaga.getNome() + "?\n"
												+ "1 - Sim "
												+ " 2 - N�o");
							
							int decisao = in.nextInt();
							
							if(decisao == 1){
								fachada.removerCliente(apaga.getCpf());
								System.out.println("Cliente removido");
							}else{
								System.out.println("Cliente n�o removido!");
							}
						}
					
						break;
						
				case 4: 
						this.moldura();
						
						in.nextLine();//Limpa buffer
						System.out.println("Atualiza��o de informa��es de um Cliente");
						
						System.out.println("Digite o CPF do cliente a ser editado: ");
						pesquisa = in.nextLong();
						
						in.nextLine();//Limpar buffer
						
						Cliente edita = null;
						edita = fachada.buscarCliente(pesquisa);
						
						if(edita != null){
							System.out.println("Insira os novos dados abaixo: ");
							
							System.out.println("Nome: ");
							String nomeCliente = in.nextLine();
							
							System.out.println("CPF: ");
							long cpfCliente = in.nextLong();
							
							in.nextLine();//Limpar buffer
							
							System.out.println("Endere�o: ");
							String enderecoCliente = in.nextLine();
							
							System.out.println("Telefone: ");
						    long telefoneCliente = in.nextLong();
						    
						    in.nextLine();
						    
						    System.out.println("N�mero de Cadastro: ");
						    int numCadastroCliente = in.nextInt();
						    
						    in.nextLine();//Limpar buffer
							
							System.out.println("Quer ser um cliente Premium?");
							System.out.println("\n1 - Sim "
												+ " 2 - N�o");
							
							int decisao = in.nextInt();
							boolean tipoCliente;
							
							if(decisao == 1){
								tipoCliente = true;
								
							}else{
								tipoCliente = false;
							}
							
							
							fachada.atualizarCliente(nomeCliente, pesquisa, cpfCliente, enderecoCliente,
									telefoneCliente, numCadastroCliente, tipoCliente);
							System.out.println("Dados atualizados!");
						}else{
							System.out.println("Cliente n�o encontrado.");
						}
						
						break;
				case 5:
						System.out.println("Retornando ao menu...");
						in.nextLine();//Limpar buffer
						operadorAuxiliar= 5;
			}
		}
	}
	
	public void menuFuncionarios(int operadorAuxiliar) {
		this.moldura();
		
		while(operadorAuxiliar != 5){
			System.out.println("Menu de Funcion�rios\n");
			System.out.println("Escolha uma opera��o: \n\n");
			System.out.println("1 - Cadastrar\n"
								+ "2 - Pesquisar\n"
			                    + "3 - Remover\n"
								+ "4 - Editar\n"
			                    + "5 - Sair\n");
			
			int op = in.nextInt();
			
			switch(op){
				
			case 1: 
				this.moldura();
				boolean realizado = false;
				
				do{
				in.nextLine();//Limpar buffer
				System.out.println("Nome do funcion�rio: ");
				String nomeFuncionario = in.nextLine();
				
				System.out.println("CPF do funcion�rio: ");
				long cpfFuncionario = in.nextLong();
				
				in.nextLine();//Limpar buffer
				
				System.out.println("Endere�o do funcion�rio: ");
				String enderecoFuncionario = in.nextLine();
				
				System.out.println("Telefone para contato: ");
				long telefoneFuncionario = in.nextLong();
				
				in.nextLine();//Limpar buffer
				
				System.out.println("Defina o sal�rio do funcion�rio: ");
				float salarioFuncionario = in.nextFloat();
				
				in.nextLine();//Limpar buffer
				
				System.out.println("Defina um n�mero de contrato(4 d�gitos)");
				int numContratoFuncionario = in.nextInt();
				
				in.nextLine();//Limpar buffer
				
				Funcionario funcionario = new Funcionario(nomeFuncionario, cpfFuncionario, enderecoFuncionario,
						telefoneFuncionario, salarioFuncionario, numContratoFuncionario);
				
				fachada.adicionarFuncionario(funcionario);
				realizado = true;
				System.out.println("Funcionario cadastrado com sucesso!");
	
				}while(realizado == false);
				
				break;
				
			case 2: 
					this.moldura();
					long pesquisa;
					
					in.nextLine();//Limpar buffer
					System.out.println("Exibir informa��es de um funcion�rio");
					
					System.out.println("Digite o CPF do funcion�rio: ");
					pesquisa = in.nextLong();
					
					Funcionario busca = null;
					busca = fachada.buscarFuncionario(pesquisa);
					
					if(busca != null){
						System.out.println("Informa��es gerais: ");
						System.out.println(busca.toString());
					}else{
						System.out.println("Funcion�rio n�o encontrado!");
					}
					
					break;
					
			case 3 : 
					this.moldura();
					in.nextLine();//Limpar buffer
					System.out.println("Remo��o de Funcion�rios");
					
					System.out.println("Digite o CPF do funcion�rio a ser removido: ");
					pesquisa = in.nextLong();
					
				    Funcionario apaga = null;
					apaga = fachada.buscarFuncionario(pesquisa);
					
					if(apaga != null){
						System.out.println("Deseja realmente excluir " 
											+apaga.getNome() + "?\n"
											+ "1 - Sim "
											+ " 2 - N�o");
						
						int decisao = in.nextInt();
						
						if(decisao == 1){
							fachada.removerFuncionario(apaga.getCpf());
							System.out.println("Funcion�rio removido");
						}else{
							System.out.println("Funcion�rio n�o removido!");
						}
					}
				
					break;
					
			case 4 : 
					this.moldura();
					
					in.nextLine();//Limpa buffer
					System.out.println("Atualiza��o de informa��es de um funcion�rio");
					
					System.out.println("Digite o CPF do funcion�rio a ser editado: ");
					pesquisa = in.nextLong();
					
					in.nextLine();//Limpar buffer
					
					Funcionario edita = null;
					edita = fachada.buscarFuncionario(pesquisa);
					
					if(edita != null){
						System.out.println("Insira os novos dados abaixo: ");
						
						System.out.println("Nome: ");
						String nomeFuncionario = in.nextLine();
						
						System.out.println("CPF: ");
						long cpfFuncionario = in.nextLong();
						
						in.nextLine();//Limpar buffer
						
						System.out.println("Endere�o: ");
						String enderecoFuncionario = in.nextLine();
						
						System.out.println("Telefone: ");
					    long telefoneFuncionario = in.nextLong();
					    
					    in.nextLine();
					    
					    System.out.println("Sal�rio: ");
					    float salarioFuncionario = in.nextFloat();
					    
					    in.nextLine();
					    
					    System.out.println("N�mero de Contrato (4 d�gitos): ");
					    int numContratoFuncionario = in.nextInt();
					    
					    in.nextLine();
						
						fachada.atualizarFuncionario(nomeFuncionario, pesquisa, cpfFuncionario, enderecoFuncionario,
								telefoneFuncionario, salarioFuncionario, numContratoFuncionario);
						System.out.println("Dados atualizados!");
					}else{
						System.out.println("Funcion�rio n�o encontrado.");
					}
					
					break;
		case 5:
				System.out.println("Retornando ao menu...");
				in.nextLine();//Limpar buffer
				operadorAuxiliar= 5;
			}
		}
	}
	
	public void menuVendas(int operadorAuxiliar) {
		this.moldura();
		
		while(operadorAuxiliar != 4){
			System.out.println("Menu de vendas\n");
			System.out.println("Escolha uma opera��o: \n\n");
			System.out.println("1 - Registrar venda"
								+ "\n2 - Buscar venda nos registros"
								+ "\n3 - Remover dos registros"
								+ "\n4 - Sair");
			
			int op = in.nextInt();
			
			switch(op){
				
				case 1:
					
						this.moldura();
						boolean realizado = false;
						
						in.nextLine();//Limpar buffer
						
						do{
							
							Cliente buscaCliente = null;
							
							do{
								
							System.out.println("Digite as informa��es da venda: ");
							System.out.println("\nDigite o CPF do cliente que est� comprando: ");
							long pesquisaCliente = in.nextLong();
							
							buscaCliente = fachada.buscarCliente(pesquisaCliente);
							
							}while(buscaCliente == null);
							
							Cd buscaCd = null;
							in.nextLine();//Limpar buffer
							
							do{
								
							System.out.println("Digite o t�tulo do CD a ser vendido: ");
							String pesquisaCd = in.nextLine();
							
							buscaCd = fachada.buscarCd(pesquisaCd);
								
							}while(buscaCd == null);
							
							System.out.println("Defina um c�digo para representar esta venda: ");
							long codigoVenda = in.nextLong();
							
							Venda venda = new Venda(buscaCliente, buscaCd, codigoVenda);
							fachada.registrarVenda(venda);
							System.out.println("Venda registrada! C�digo da venda: " + venda.getCodigoVenda());
							realizado = true;
							
						}while(realizado == false);
						
						break;
				case 2: 
						this.moldura();
						long pesquisa;
						
						in.nextLine();//Limpar buffer
						System.out.println("Buscar inform��es sobre uma venda");
						System.out.println("Digite o c�digo da venda: ");
						pesquisa = in.nextLong();
						
						Venda busca = null;
						busca = fachada.buscarVenda(pesquisa);
						
						if(busca != null){
							System.out.println("Informa��es gerais: ");
							System.out.println(busca.toString());
						}else{
							System.out.println("Venda n�o encontrada!");
						}
						
						break;
				
				case 3:
						this.moldura();
						in.nextLine();//Limpar buffer
						System.out.println("Remo��o de vendas do hist�rico");
						
						System.out.println("Digite o c�digo da venda a ser removida: ");
						pesquisa = in.nextLong();
						
					    Venda apaga = null;
						apaga = fachada.buscarVenda(pesquisa);
						
						if(apaga != null){
							System.out.println("Deseja realmente excluir " 
												+apaga.getCodigoVenda() + "?\n"
												+ "1 - Sim "
												+ " 2 - N�o");
							
							int decisao = in.nextInt();
							
							if(decisao == 1){
								fachada.removerVenda(apaga.getCodigoVenda());
								System.out.println("Venda removida do hist�rico");
							}else{
								System.out.println("Venda n�o removida!");
							}
						}
					
						break;
				case 4 : 
						System.out.println("Retornando ao menu...");
						in.nextLine();//Limpar buffer
						operadorAuxiliar = 4;
			}
		}
	}

	
	
	public void menuPrincipal(){
	int operacao;
	int operadorAuxiliar = 0;
		
	do{
		this.moldura();
		System.out.println("Escolha uma opera��o: ");
		System.out.println("1 - CD's\n"
							+ "2 - Clientes\n"
							+ "3 - Funcion�rios\n"
							+ "4 - Vendas\n"
							+ "5 - Sair\n");
		
		operacao = in.nextInt();
		
		switch(operacao){
			case 1 : 
					menuCd(operadorAuxiliar);
					break;
					
			case 2: 
					menuClientes(operadorAuxiliar);
					break;
					
			case 3 : 
					menuFuncionarios(operadorAuxiliar);
					break;
					
			case 4 : 
					menuVendas(operadorAuxiliar);
					break;
					
			case 5:
					System.out.println("Obrigado por usar nosso sistema.");
		}

		}while(operacao != 5);
	}
}

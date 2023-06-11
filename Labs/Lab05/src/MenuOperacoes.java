/*

Enum para menu externo.

Cada constante é vista como uma descrição e uma lista de outras
constantes (que são as constantes do submenu).

'new SubMenuOperacoes[]{}' cria uma lista de constantes do submenu.

https://github.com/rebecapadovani/ExemploEnumMenu

*/
public enum MenuOperacoes {
	CADASTRAR("Cadastrar", new SubMenuOperacoes[] {
			SubMenuOperacoes.CADASTRAR_SEGURADORA,
			SubMenuOperacoes.CADASTRAR_CLIENTE,
			SubMenuOperacoes.CADASTRAR_VEICULO,
			SubMenuOperacoes.CADASTRAR_FROTA,
			SubMenuOperacoes.VOLTAR
	}),
	LISTAR("Listar", new SubMenuOperacoes[] {
			SubMenuOperacoes.LISTAR_CLIENTES,
			SubMenuOperacoes.LISTAR_VEICULOS,
			SubMenuOperacoes.LISTAR_SINISTROS,
			SubMenuOperacoes.LISTAR_SEGUROS,
			SubMenuOperacoes.VOLTAR
	}),
	EXCLUIR("Excluir", new SubMenuOperacoes[] {
			SubMenuOperacoes.EXCLUIR_CLIENTE,
			SubMenuOperacoes.EXCLUIR_VEICULO,
			SubMenuOperacoes.EXCLUIR_SINISTRO,
			SubMenuOperacoes.EXCLUIR_SEGURO,
			SubMenuOperacoes.VOLTAR
	}),
	GERAR_SINISTRO("Gerar Sinistro", new SubMenuOperacoes[] {
			SubMenuOperacoes.VOLTAR
	}),
	TRANSFERIR_SEGURO("Transferir Seguro", new SubMenuOperacoes[] {
			SubMenuOperacoes.VOLTAR
	}),
	CALCULAR_RECEITA("Calcular Receita", new SubMenuOperacoes[] {
			SubMenuOperacoes.VOLTAR
	}),
	SAIR("Sair", new SubMenuOperacoes[] {
	});


	// Atributos
	private final String descricao;
	private final SubMenuOperacoes[] submenu;


	// Construtor
	MenuOperacoes(String descricao, SubMenuOperacoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}


	// Getters
	public String getDescricao() {
		return descricao;
	}
	
	public SubMenuOperacoes[] getSubMenu() {
		return submenu;
	}
}

// Rever
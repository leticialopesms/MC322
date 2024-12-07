/*

Enum para menu externo.

Cada constante é vista como uma descrição e uma lista de outras
constantes (que são as constantes do submenu).

'new SubMenuOperacoes[]{}' cria uma lista de constantes do submenu.

https://github.com/rebecapadovani/ExemploEnumMenu

*/
public enum Operacoes {
	CADASTRAR("Cadastrar", new SubOperacoes[] {
			SubOperacoes.CADASTRAR_SEGURADORA,
			SubOperacoes.CADASTRAR_CLIENTE,
			SubOperacoes.CADASTRAR_VEICULO,
			SubOperacoes.CADASTRAR_FROTA,
			SubOperacoes.VOLTAR
	}),
	LISTAR("Listar", new SubOperacoes[] {
			SubOperacoes.LISTAR_SEGURADORAS,
			SubOperacoes.LISTAR_CLIENTES,
			SubOperacoes.LISTAR_CONDUTORES,
			SubOperacoes.LISTAR_VEICULOS,
			SubOperacoes.LISTAR_FROTAS,
			SubOperacoes.LISTAR_SEGUROS_SEGURADORA,
			SubOperacoes.LISTAR_SEGUROS_CLIENTE,
			SubOperacoes.LISTAR_SINISTROS_SEGURO,
			SubOperacoes.LISTAR_SINISTROS_CLIENTE,
			SubOperacoes.LISTAR_SINISTROS_CONDUTOR,
			SubOperacoes.VOLTAR
	}),
	VISUALIZAR("Visualizar", new SubOperacoes[] {
			SubOperacoes.VISUALIZAR_SEGURADORA,
			SubOperacoes.VISUALIZAR_CLIENTE,
			SubOperacoes.VISUALIZAR_CONDUTOR,
			SubOperacoes.VISUALIZAR_VEICULO,
			SubOperacoes.VISUALIZAR_FROTA,
			SubOperacoes.VISUALIZAR_SEGURO,
			SubOperacoes.VISUALIZAR_SINISTRO,
			SubOperacoes.VOLTAR
	}),
	EXCLUIR("Excluir", new SubOperacoes[] {
			SubOperacoes.EXCLUIR_SEGURADORA,
			SubOperacoes.EXCLUIR_CLIENTE,
			SubOperacoes.EXCLUIR_VEICULO,
			SubOperacoes.EXCLUIR_FROTA,
			SubOperacoes.EXCLUIR_SEGURO,
			SubOperacoes.EXCLUIR_SINISTRO,
			SubOperacoes.VOLTAR
	}),
	GERAR("Gerar", new SubOperacoes[] {
			SubOperacoes.GERAR_SEGURO,
			SubOperacoes.GERAR_SINISTRO,
			SubOperacoes.VOLTAR
	}),
	ATUALIZAR("Atualizar", new SubOperacoes[] {
			SubOperacoes.AUTORIZAR_CONDUTOR,
			SubOperacoes.DESAUTORIZAR_CONDUTOR,
			SubOperacoes.ADICIONAR_VEICULO_FROTA,
			SubOperacoes.REMOVER_VEICULO_FROTA,
			SubOperacoes.VOLTAR
	}),
	CALCULAR_RECEITA("Calcular Receita", new SubOperacoes[] {
			SubOperacoes.VOLTAR
	}),
	SAIR("Sair", new SubOperacoes[] {
	});


	// Atributos
	private final String descricao;
	private final SubOperacoes[] submenu;


	// Construtor
	Operacoes(String descricao, SubOperacoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}


	// Getters
	public String getDescricao() {
		return descricao;
	}
	
	public SubOperacoes[] getSubMenu() {
		return submenu;
	}
}

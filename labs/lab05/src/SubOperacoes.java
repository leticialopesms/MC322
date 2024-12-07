/*

Define as constantes dos submenus.
https://github.com/rebecapadovani/ExemploEnumMenu

 */
public enum SubOperacoes {
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veículo"),
	CADASTRAR_FROTA("Casdastrar frota"),

	LISTAR_SEGURADORAS("Listar seguradoras"),
	LISTAR_CLIENTES("Listar clientes"),
	LISTAR_CONDUTORES("Listar condutores"),
	LISTAR_VEICULOS("Listar veículos"),
	LISTAR_FROTAS("Listar frotas"),
	LISTAR_SEGUROS_SEGURADORA("Listar os seguros de uma seguradora"),
	LISTAR_SEGUROS_CLIENTE("Listar os seguros de um cliente"),
	LISTAR_SINISTROS_SEGURO("Listar os sinistros de um seguro"),
	LISTAR_SINISTROS_CLIENTE("Listar os sinistros de um cliente"),
	LISTAR_SINISTROS_CONDUTOR("Listar os sinistros de um condutor"),

	VISUALIZAR_SEGURADORA("Visualizar seguradora"),
	VISUALIZAR_CLIENTE("Visualizar cliente"),
	VISUALIZAR_CONDUTOR("Visualizar condutor"),
	VISUALIZAR_VEICULO("Visualizar veículo"),
	VISUALIZAR_FROTA("Visualizar frota"),
	VISUALIZAR_SEGURO("Visualizar seguro"),
	VISUALIZAR_SINISTRO("Visualizar sinistro"),

	EXCLUIR_SEGURADORA("Excluir seguradora"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veículo"),
	EXCLUIR_FROTA("Exluir frota"),
	EXCLUIR_SEGURO("Excluir seguro"),
	EXCLUIR_SINISTRO("Excluir sininstro"),
	
	GERAR_SEGURO("Gerar seguro"),
	GERAR_SINISTRO("Gerar sinistro"),
	
	AUTORIZAR_CONDUTOR("Condutor: autorizar"),
	DESAUTORIZAR_CONDUTOR("Condutor: desautorizar"),
	ADICIONAR_VEICULO_FROTA("Frota: adicionar veículo"),
	REMOVER_VEICULO_FROTA("Frota: remover veículo"),

	VOLTAR("Voltar");


	// Atributo
	private final String descricao;


	// Construtor
    SubOperacoes(String descricao){
		this.descricao = descricao;
	}


	// Getter
	public String getDescricao() {
		return descricao;
	}
}

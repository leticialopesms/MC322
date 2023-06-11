/*

Define as constantes dos submenus.
https://github.com/rebecapadovani/ExemploEnumMenu

 */
public enum SubMenuOperacoes {
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_FROTA("Casdastrar frota"),
	LISTAR_CLIENTES("Listar cliente"),
	LISTAR_SINISTROS("Listar sinistros"),
	LISTAR_VEICULOS("Listar veiculo"),
	LISTAR_SEGUROS("Listar veiculo"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	EXCLUIR_SINISTRO("Excluir sininstro"),
	EXCLUIR_SEGURO("Excluir seguro"),
	VOLTAR("Voltar");


	// Atributo
	private final String descricao;


	// Construtor
    SubMenuOperacoes(String descricao){
		this.descricao = descricao;
	}


	// Getter
	public String getDescricao() {
		return descricao;
	}
}

// Rever
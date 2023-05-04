// import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente{
    // Propriedades
    private final String CNPJ;
    private Date dataFundacao;
    private int qtdeFuncionarios;


    // Construtor
    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao, int qtdeFuncionarios) {
        super(nome, endereco);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }


    // Métodos
    // Getters (acessors) e Setters (mutators)
    public String getCNPJ() {
        return CNPJ;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }


    // - Funções da classe ClientePJ

    public boolean validarCNPJ(String cnpj) {
        // 1. Removendo todos os caracteres não numéricos do CPF
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // 2. Verificando se o CNPJ tem 14 dígitos
        if (cnpj.length() != 14) return false;

        // 3. Verificando se todos os dígitos são iguais
        char primeiro = cnpj.charAt(0);
        int k = 13;
        while (k > 0) {
            if (primeiro != cnpj.charAt(k)) k = -1;
            else k--;
        }
        if (k == 0) return false;

        // 4. Calculando os dígitos verificadores
        int temp;
        int resto;
        int verificador_calculado_1 = 0;  // 1º verificador calculado
        int verificador_calculado_2 = 0;  // 2º verificador calculado

        // 1º DÍGITO:
        int[] fatores_1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        temp = 0;
        for (int i = 0; i < 12; i++)
            temp = temp + (Character.getNumericValue(cnpj.charAt(i)) * (fatores_1[i]));
        resto = temp % 11;
        if (temp <= 1) verificador_calculado_1 = 0;
        else verificador_calculado_1 = 11 - resto;

        // 2º DÍGITO:
        int[] fatores_2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        temp = 0;
        for (int i = 0; i < 12; i++)
            temp = temp + (Character.getNumericValue(cnpj.charAt(i)) * (fatores_2[i]));
        temp = temp + (verificador_calculado_1 * fatores_2[12]);
        resto = temp % 11;
        if (temp <= 1) verificador_calculado_2 = 0;
        else verificador_calculado_2 = 11 - resto;

        // 5.Verificando se os dígitos verificadores calculados são iguais aos dígitos do CNPJ
        int verificador_cpf_1 = Character.getNumericValue(cnpj.charAt(12));  // 1º verificador do CNPJ = dígito 13
        int verificador_cpf_2 = Character.getNumericValue(cnpj.charAt(13));  // 2º verificador do CNPJ = dígito 14
        
        if (verificador_calculado_1 == verificador_cpf_1 && verificador_calculado_2 == verificador_cpf_2) return true;
        else return false;
    }


    // Adicionar -----------------------
    // calculaScore() -> retorna double [VALOR_BASE * (1 + (quantidadeFunc/100)) * quantidadeCarros]


    @Override
    public String toString() {
        return super.toString() +
               "CNPJ: " + this.CNPJ + "\n" +
               "Data de Fundação: " + this.dataFundacao + "\n";
    }
}

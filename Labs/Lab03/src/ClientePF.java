import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
    private String CPF;
    private String genero;
    private Date dataLicensa;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;


    // Construtores
    public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String CPF, String genero,
            Date dataLicensa, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco, listaVeiculos);
        this.CPF = CPF;
        this.genero = genero;
        this.dataLicensa = dataLicensa;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }


    // Métodos
    // Getters (acessors) and Setters (mutators)
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataLicensa() {
        return dataLicensa;
    }

    public void setDataLicensa(Date dataLicensa) {
        this.dataLicensa = dataLicensa;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }
    

    // Funções da Classe
    public boolean validarCPF(String cpf) {
        // 1. Removendo todos os caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // 2. Verificando se o CPF tem 11 dígitos
        if (cpf.length() != 11) return false;

        // 3. Verificando se todos os dígitos são iguais
        char primeiro = cpf.charAt(0);
        for (int i = 1; i < 11; i++) {
            if (primeiro == cpf.charAt(i)) return false;
        }

        // 4. Calculando os dígitos verificadores
        // Convertendo String para int
        int temp = 0;
        int primeiro_verificador_calculado = 0;
        int segundo_verificador_calculado = 0;

        // Primeiro dígito:
        for (int i = 0; i < 9; i++) {
            temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (10 - i));
        }
        temp = temp % 11;
        if (temp > 1) primeiro_verificador_calculado = 11 - temp;

        // Segundo dígito
        temp = 0;
        for (int i = 0; i < 10; i++) {
            temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (11 - i));
        }
        temp = temp % 11;
        if (temp > 1) segundo_verificador_calculado = 11 - temp;

        // 5.Verificando se os dígitos verificadores calculados são iguais aos dígitos
        int primeiro_verificador_cpf = Character.getNumericValue(cpf.charAt(9));
        int segundo_verificador_cpf = Character.getNumericValue(cpf.charAt(10));
        
        if (primeiro_verificador_calculado == primeiro_verificador_cpf 
            && segundo_verificador_calculado == segundo_verificador_cpf) return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() +
               "CPF: " + this.CPF + "\n" +
               "Gênero: " + this.genero + "\n" +
               "Data da Licensa: " + this.dataLicensa + "\n" +
               "Educação: " + this.educacao + "\n" +
               "Data de Nascimento: " + this.dataNascimento + "\n" +
               "classe Econômica: " + this.classeEconomica + "\n";
    }
}

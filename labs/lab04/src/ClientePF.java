import java.util.Date;

public class ClientePF extends Cliente {
    // // Atributos (Propriedades)
    private final String CPF;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;


    // Construtor
    public ClientePF(String nome, String endereco, String CPF, String genero,
            Date dataLicensa, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco);
        this.CPF = CPF;
        this.genero = genero;
        this.dataLicenca = dataLicensa;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }


    // Métodos
    // - Getters (acessors) and Setters (mutators)

    public String getCPF() {
        return CPF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicensa) {
        this.dataLicenca = dataLicensa;
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
    

    // - Funções da Classe ClientePF

    public int calculaIdade() {
        Date hoje = new Date();
        long tempo = hoje.getTime() - dataNascimento.getTime();
        double diferenca = tempo/((double)1000*60*60*24*365);
        int idade = (int)diferenca;
        return idade;
    }

    public double calculaScore() {
        /* Calcula o valor do seguro.
        Utiliza o conceito de sobrecarga de métodos, a partir da
        superclasse Cliente. 
        
        Utiliza os fatores da classe CalcSeguro, segundo os
        seguintes critérios:
        Se 18 <= idade < 30: fator = 1.2;
        Se 30 <= idade < 60: fator = 1.0;
        Se 60 <= idade <= 90: fator = 1.5.
    
        Aqui, é considerado que o cliente foi cadastrado com sucesso
        e, portanto, está apto para realizar o seguro. Isto é:
        18 <= idade <= 90. */

        // 1. Definindo o fator idade
        int idade = this.calculaIdade();
        double fatorIdade;
        if (idade >= 18 && idade < 30)
            fatorIdade = CalcSeguro.FATOR_18_30.getValor();
        else if (idade >= 30 && idade < 60)
            fatorIdade = CalcSeguro.FATOR_30_60.getValor();
        else
            fatorIdade = CalcSeguro.FATOR_60_90.getValor();

        // 2. Definindo o valor base
        double valorBase = CalcSeguro.VALOR_BASE.getValor();

        // 3. Definindo a quantidade de veículos
        int qtdeVeiculos = this.getListaVeiculos().size();

        return  valorBase * fatorIdade * qtdeVeiculos;
    }


    @Override
    public String toString() {
        return super.toString() +
               "CPF: " + this.CPF + "\n" +
               "Gênero: " + this.genero + "\n" +
               "Data da Licensa: " + this.dataLicenca + "\n" +
               "Educação: " + this.educacao + "\n" +
               "Data de Nascimento: " + this.dataNascimento + "\n" +
               "classe Econômica: " + this.classeEconomica + "\n";
    }
}
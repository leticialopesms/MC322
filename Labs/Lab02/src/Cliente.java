public class Cliente {
    // Propriedades
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    // Construtor
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters (acessors) e Setters (mutators)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
                "CPF: " + this.cpf + "\n" +
                "Data de Nascimento: " + this.dataNascimento + "\n" +
                "Idade: " + this.idade + "\n" +
                "Endereço: " + this.endereco + "\n";
    }


    public boolean validarCPF(String cpf) {
        // 1. Removendo todos os caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // 2. Verificando se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // 3. Verificando se todos os dígitos são iguais
        char primeiro = cpf.charAt(0);
        for (int i = 1; i < 11; i++) {
            if (primeiro == cpf.charAt(i)) {
                return false;
            }
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
        if (temp > 1) {
            primeiro_verificador_calculado = 11 - temp;
        }

        // Segundo dígito
        temp = 0;
        for (int i = 0; i < 10; i++) {
            temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (11 - i));
        }
        temp = temp % 11;
        if (temp > 1) {
            segundo_verificador_calculado = 11 - temp;
        }

        // 5.Verificando se os dígitos verificadores calculados são iguais aos dígitos
        int primeiro_verificador_cpf = Character.getNumericValue(cpf.charAt(9));
        int segundo_verificador_cpf = Character.getNumericValue(cpf.charAt(10));
        if (primeiro_verificador_calculado == primeiro_verificador_cpf && segundo_verificador_calculado == segundo_verificador_cpf) {
            return true;
        } else {
            return false;
        }
    }
}

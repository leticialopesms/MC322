public class Validacao {

    public static boolean validaCPF(String cpf) {
        /* Verifica se um dado CPF de um ClientePF é válido. */

        // 1. Removendo todos os caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // 2. Verificando se o CPF tem 11 dígitos
        if (cpf.length() != 11) return false;

        // 3. Verificando se todos os dígitos são iguais
        char primeiro = cpf.charAt(0);
        int k = 10;
        while (k > 0) {
            if (primeiro != cpf.charAt(k)) k = -1;
            else k--;
        }
        if (k == 0) return false;

        // 4. Calculando os dígitos verificadores
        int temp;
        int resto;
        int verificador_calculado_1 = 0;  // 1º verificador calculado
        int verificador_calculado_2 = 0;  // 2º verificador calculado

            // 1º DÍGITO:
            temp = 0;
            for (int i = 0; i < 9; i++)
                temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (10 - i));
            resto = temp % 11;
            if (temp > 1) verificador_calculado_1 = 11 - resto;

            // 2º DÍGITO:
            temp = 0;
            for (int i = 0; i < 10; i++)
                temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (11 - i));
            resto = temp % 11;
            if (temp > 1) verificador_calculado_2 = 11 - resto;

        // 5.Verificando se os dígitos verificadores calculados são iguais aos dígitos do CPF
        int verificador_cpf_1 = Character.getNumericValue(cpf.charAt(9));  // 1º verificador do CPF = dígito 10
        int verificador_cpf_2 = Character.getNumericValue(cpf.charAt(10)); // 2º verificador do CPF = dígito 11
        
        if (verificador_calculado_1 == verificador_cpf_1 && verificador_calculado_2 == verificador_cpf_2) return true;
        else return false;
    }


    public static boolean validaCNPJ(String cnpj) {
        /* Verifica se um dado CNPJ de um ClientePJ é válido. */

        // 1. Removendo todos os caracteres não numéricos do CNPJ
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


    public static boolean validaNome (String nome) {
        /* Verifica se o nome é composto somente por letras de A a Z.
        Acentos não são permitidos.
        Se for válido, retorna True. Se não, retorna False. */
        return (nome.matches("^[a-zA-Z]*$"));
    } // Verificar


   
    // public static boolean validaTelefone (String telefone) {
    //     /* Verifica se o número de telefone possui 11 ou 12
    //     algarismos numéricos.
    //     Caso seja, assume-se que é do tipo (DDD)XXXX-XXXX para
    //     telefones fixos, ou (DDD)XXXXX-XXXX para celulares.
    //     Se for válido, retorna True. Se não, retorna False. */
    //     telefone = telefone.replaceAll("[^0-9]", "");
    //     return (telefone.length() > 10 && telefone.length() < 13);
    // }


    public static boolean validaPlaca (String placa) {
        /* Verifica se a placa possui exatamente 7 caracteres
        alfanuméricos.
        Se for válida, retorna True. Se não, retorna False. */
        placa = placa.replaceAll("[^a-zA-Z0-9]", "");
        return (placa.length() == 7);
    }

    public static boolean validaIdade (Cliente cliente) {
        /* Verifica se o cliente pode ser cadastrado. Isto é,
        se 18 <= idade do cliente <= 90.
        Se for válida, retorna True. Se não, retorna False. */
        int idade = ((ClientePF)cliente).calculaIdade();
        return (idade >= 18 && idade <= 90);
    }
} 

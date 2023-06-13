import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Leitura {
    /* Essa classe é responsável por instanciar os objetos a partir da leitura
    dos dados obtidos na entrada (scanner). */

    public static LocalDate formataData (String dataString) {
        /* Transforma uma string em um objeto do tipo LocalDate.*/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataString, formatter);
        return data;
    }

    public static LocalDate leData (Scanner entrada) {
        /* Lê as informações necessárias para criar um objeto do tipo LocalDate.
        Aqui, há o tratamento de exceção para converter um objeto do tipo String
        para LocalDate, usando try e catch. */
        Boolean dataValida = false;
        LocalDate data = null;
        do {
            try {
                String dataString = entrada.nextLine();
                data = formataData(dataString);
                dataValida = true;
            }
            catch (DateTimeParseException e) {
                System.out.println("ERRO: Formato de data inválido. Insira a data novamente no formato dd/mm/aaaa. ");
                dataValida = false;
            }
        } while(!dataValida);
        return data;
    }


    public static Seguradora leSeguradora (Scanner entrada) {
        /* Lê as informações necessárias para criar um objeto do tipo Seguradora.
        Retorna a seguradora se for instanciada com sucesso.
        Caso contrário, retorna null e indica o erro. */
        System.out.println("--- Nova Seguradora ---");
        System.out.print("Digite o CNPJ da Seguradora: ");
        String cnpj = entrada.nextLine();
        Boolean cnpjValidado = Validacao.validaCNPJ(cnpj);
        if (!cnpjValidado) {
            System.out.println("ERRO: CNPJ inválido!");
            return null;
        }
        System.out.print("Digite o nome da seguradora: ");
        String nome = entrada.nextLine();
        System.out.print("Digite o telefone da seguradora: ");
        String telefone = entrada.nextLine();
        System.out.print("Digite o endereço da seguradora: ");
        String endereco = entrada.nextLine();
        System.out.print("Digite o email da seguradora: ");
        String email = entrada.nextLine();

        Seguradora s = new Seguradora(cnpj, nome, telefone, endereco, email);
        return s;
    }
    
    
    public static Cliente leCliente(Scanner entrada) {
        /* Lê as informações necessárias para criar um objeto do tipo cliente.
        Retorna o cliente se for instaciado com sucesso.
        Caso contrário, retorna null e indica o erro. */
        Boolean identificadorValidado = false,
                nomeValidado = true,
                telefoneValidado = true,
                idadeValidada = true;
        System.out.println("--- Novo cliente ---");

        // Informações gerais do Cliente
        System.out.print("Digite o nome do cliente: ");
        String nome = entrada.nextLine();
        nomeValidado = Validacao.validaNome(nome);
        if (!nomeValidado) {
            System.out.println("ERRO: nome inválido!");
            return null;
        }
        System.out.print("Digite o número de telefone do cliente ((DDD) XXXX-XXXX ou (DDD) X XXXX-XXXX): ");
        String telefone = entrada.nextLine();
        telefoneValidado = Validacao.validaTelefone(telefone);
        if (!telefoneValidado) {
            System.out.println("ERRO: número de telefone inválido!");
            return null;
        }
        System.out.print("Digite o endereço do cliente: ");
        String endereco = entrada.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = entrada.nextLine();

        System.out.print("Escolha o tipo de cliente a ser cadastrado (PF ou PJ): ");
        String tipoCliente = entrada.nextLine();

        // Cliente PF (Pessoa Física)
        if (tipoCliente.equals("PF")) {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = entrada.nextLine();
            identificadorValidado = Validacao.validaCPF(cpf);
            if (!identificadorValidado) {
                System.out.println("ERRO: CPF inválido!");
                return null;
            }
            System.out.print("Digite o gênero do cliente: ");
            String genero = entrada.nextLine();
            System.out.print("Digite o grau de escolaridade do cliente: ");
            String educacao = entrada.nextLine();
            System.out.print("Digite a data de nascimento do cliente (dd/mm/aaaa): ");
            LocalDate dataNascimento = leData(entrada);
            
            ClientePF c = new ClientePF(nome, telefone, endereco, email, 
                                        cpf, genero, educacao, dataNascimento);
            
            idadeValidada = Validacao.validaIdade(c);
            if (!idadeValidada) {
                System.out.println("ERRO: Cliente não é apto para realizar o seguro.");
                return null;
            }
            return c;
        }

        // Cliente PJ (Pessoa Jurídica)
        if (tipoCliente.equals("PJ")) {
            System.out.print("Digite o CNPJ do cliente: ");
            String cnpj = entrada.nextLine();
            identificadorValidado = Validacao.validaCNPJ(cnpj);
            if (!identificadorValidado) {
                System.out.println("ERRO: CNPJ inválido!");
                return null;
            }
            System.out.print("Digite a data de fundação (dd/mm/aaaa): ");
            LocalDate dataFundacao = leData(entrada);
            System.out.print("Digite o número de funcionários do cliente: ");
            int qtdeFuncionarios = Integer.parseInt(entrada.nextLine());

            ClientePJ c = new ClientePJ(nome, telefone, endereco, email,
                                        cnpj, dataFundacao, qtdeFuncionarios);
            return c;
        }

        System.out.println("ERRO: tipo de cliente inválido!");
        return null;
    }


    public static Condutor leCondutor(Scanner entrada) {
        /* Lê as informações necessárias para criar um objeto do tipo Condutor.
        Retorna o condutor se for instanciado com sucesso.
        Caso contrário, retorna null e indica o erro. */
        System.out.println("--- Novo condutor ---");
        System.out.print("Digite o CPF do condutor: ");
        String cpf = entrada.nextLine();
        System.out.print("Digite o nome do condutor: ");
        String nome = entrada.nextLine();
        Boolean nomeValidado = Validacao.validaNome(nome);
        if (!nomeValidado) {
            System.out.println("ERRO: nome inválido!");
            return null;
        }
        System.out.print("Digite o número de telefone do condutor ((DDD) XXXX-XXXX ou (DDD) X XXXX-XXXX): ");
        String telefone = entrada.nextLine();
        Boolean telefoneValidado = Validacao.validaTelefone(telefone);
        if (!telefoneValidado) {
            System.out.println("ERRO: número de telefone inválido!");
            return null;
        }
        System.out.print("Digite o endereço do condutor: ");
        String endereco = entrada.nextLine();
        System.out.print("Digite o email do condutor: ");
        String email = entrada.nextLine();
        System.out.print("Digite a data de nascimento do condutor: ");
        LocalDate dataNascimento = leData(entrada);

        Condutor c = new Condutor(cpf, nome, telefone, endereco, email, dataNascimento);
        return c;
    }


    public static Veiculo leVeiculo(Scanner entrada) {
        /* Lê as informações necessárias para criar um objeto do tipo Veiculo.
        Retorna o veículo se for instanciado com sucesso.
        Caso contrário, retorna null e indica o erro. */
        System.out.println("--- Novo veículo ---");
        System.out.print("Digite a placa do veículo: ");
        String placa = entrada.nextLine();
        Boolean placaValidada = Validacao.validaPlaca(placa);
        if (!placaValidada) {
            System.out.println("ERRO: Placa Inválida.");
            return null;
        }
        System.out.print("Digite a marca do veículo: ");
        String marca = entrada.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = entrada.nextLine();
        System.out.print("Digite o ano de fabricação do veículo: ");
        int anoFabricacao = Integer.parseInt(entrada.nextLine());

        Veiculo v = new Veiculo(placa, modelo, marca, anoFabricacao);
        return v;
    }

    
    public static Frota leFrota(Scanner entrada) {
        /* Lê as informações necessárias para criar um objeto do tipo Frota.
        Retorna a frota se for instanciada com sucesso.
        Caso contrário, retorna null e indica o erro. */
        System.out.println("--- Nova frota ---");
        System.out.print("Digite o código da frota: ");
        String code = entrada.nextLine();
        Frota f = new Frota(code);
        // Adicionando veículos na frota
        System.out.print("Digite quantos veículos pertencem à frota: ");
        int nVeiculos = Integer.parseInt(entrada.nextLine());
        while (nVeiculos > 0) {
            Veiculo v = leVeiculo(entrada);
            f.adicionarVeiculoFrota(v);
            nVeiculos--;
        }
        return f;
    }


    public static Seguro leSeguro(Scanner entrada, Seguradora seguradora) {
        /* Lê as informações necessárias para criar um objeto do tipo Seguro
        e associá-lo a uma seguradora dada como parâmetro.
        Retorna o seguro se ele for instanciado com sucesso.
        Caso contrário, retorna null e indica o erro.*/
        System.out.println("--- Novo seguro ---");
        System.out.print("Digite a data de início do seguro (dd/mm/aaaa): ");
        LocalDate dataInicio = leData(entrada);
        System.out.print("Digite a data de término do seguro (dd/mm/aaaa): ");
        LocalDate dataFim = leData(entrada);

        System.out.print("Digite o tipo de cliente associado ao seguro (PF ou PJ): ");
        String tipoCliente = entrada.nextLine();
        if (tipoCliente.equals("PF")) {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = entrada.nextLine();
            Cliente cliente = seguradora.buscarCliente(cpf);
            if (cliente == null) {
                System.out.println("ERRO: cliente não encontrado!");
                return null;
            }
            System.out.print("Digite a placa do veículo do cliente: ");
            String placa = entrada.nextLine();
            Veiculo veiculo = ((ClientePF)cliente).buscarVeiculo(placa);
            if (veiculo == null) {
                System.out.println("ERRO: veículo não encontrado!");
                return null;
            }
            SeguroPF s = new SeguroPF(dataInicio, dataFim, seguradora, (ClientePF)cliente, veiculo);
            return s;
        }
        if (tipoCliente.equals("PJ")) {
            System.out.print("Digite o CNPJ do cliente: ");
            String cnpj = entrada.nextLine();
            Cliente cliente = seguradora.buscarCliente(cnpj);
            if (cliente == null) {
                System.out.println("ERRO: cliente não encontrado!");
                return null;
            }
            System.out.print("Digite o código da frota do cliente: ");
            String code = entrada.nextLine();
            Frota frota = ((ClientePJ)cliente).buscarFrota(code);
            if (frota == null) {
                System.out.println("ERRO: frota não encontrada!");
                return null;
            }
            SeguroPJ s = new SeguroPJ(dataInicio, dataFim, seguradora, (ClientePJ)cliente, frota);
            return s;
        }
        System.out.println("ERRO: tipo de cliente inválido!");
        return null;
    }


    public static Sinistro leSinistro(Scanner entrada, Seguro seguro) {
        /* Lê as informações necessárias para criar um objeto do tipo Sinistro
        e associá-lo a um seguro dado como parâmetro.
        Retorna o sinistro se ele for instanciado com sucesso.
        Caso contrário, retorna null e indica o erro.*/
        System.out.println("--- Novo sinistro ---");
        System.out.print("Digite a data do sinistro (dd/mm/aaaa): ");
        LocalDate data = leData(entrada);
        System.out.print("Digite o endereço do local do sinistro: ");
        String endereco = entrada.nextLine();
        System.out.print("Digite o CPF do condutor envolvido no sinistro: ");
        String cpf = entrada.nextLine();
        Condutor condutor = seguro.buscarCondutor(cpf);
        if (condutor == null) {
            System.out.println("ERRO: Condutor não encontrado.");
            return null;
        }
        Sinistro s = new Sinistro(data, endereco, condutor, seguro);
        return s;
    }


}

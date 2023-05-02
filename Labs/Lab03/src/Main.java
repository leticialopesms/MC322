import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        // Instaciando uma Seguradora
        Seguradora seguradora = new Seguradora("UNICAMP Seguros", 
                                               "3248-7052", 
                                               "seguros@unicamp.br", 
                                               "Campinas");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem vind@ ao sistema de " + seguradora.getNome() + "!\n");
        System.out.println("--- Dados da seguradora ---");
        System.out.println(seguradora.toString());

        String resposta;  // Utilizada para perguntas do tipo S ou N (Sim ou Não)

        // Cadastrando clientes
        System.out.print("Insira o número de clientes a serem cadastrados: ");
        int numClientes = Integer.parseInt(entrada.nextLine());
        while (numClientes > 0) {
            System.out.println("--- Novo Cliente ---");
            System.out.print("Escolha o tipo de cliente a ser cadastrado (PF ou PJ): ");
            String tipoCliente = entrada.nextLine();

            // Cliente PF (Pessoa Física)
            if (tipoCliente.equals("PF")) {
                System.out.print("Digite o nome do cliente: ");
                String nomeCliente = entrada.nextLine();
                System.out.print("Digite o endereço do cliente: ");
                String enderecoCliente = entrada.nextLine();
                System.out.print("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
                System.out.print("Digite o gênero do cliente: ");
                String genero = entrada.nextLine();
                System.out.print("Digite a data da licença do cliente (dd-mm-aaaa): ");
                Date dataLicenca = formatarData(entrada);
                System.out.print("Digite o grau de escolaridade do cliente: ");
                String educacao = entrada.nextLine();
                System.out.print("Digite a data de nascimento do cliente (dd-mm-aaaa): ");
                Date dataNascimento = formatarData(entrada);
                System.out.print("Digite a classe econômica do cliente: ");
                String classeEconomica = entrada.nextLine();
                System.out.println("-");

                ClientePF clientePF = new ClientePF(nomeCliente,
                                                    enderecoCliente, 
                                                    cpf,
                                                    genero,
                                                    dataLicenca,
                                                    educacao, 
                                                    dataNascimento,
                                                    classeEconomica);

                Boolean validado = clientePF.validarCPF(cpf);
                if (validado == true) {
                    Boolean cliente_cadastrado = seguradora.cadastrarCliente(clientePF);
                    
                    if (cliente_cadastrado == true) {
                        
                        // Inserindo veículos do clientePF
                        System.out.print("Insira o número de veículos a serem cadastrados: ");
                        int numVeiculos = Integer.parseInt(entrada.nextLine());
                        while (numVeiculos > 0) {
                            Veiculo v = leituraVeiculo(entrada);
                            Boolean veiculo_inserido = clientePF.inserirVeiculo(v);
                            if (veiculo_inserido == true)
                                System.out.println("- Veículo cadastrado com sucesso!" + "\n");
                            else
                                System.out.println("- Erro ao cadastrar veículo.");
                            numVeiculos--;
                        } // Fim da inserção de veículos

                        System.out.println("\n" + "- Cliente " + clientePF.getNome() + " está no cadastro!");
                        System.out.println(clientePF.listarVeiculos());
                    }
                    else {
                        System.out.println("- Erro ao cadastrar cliente.");
                        System.out.println("- Gostaria de tentar novamente? (S ou N)");
                        resposta = entrada.nextLine();
                        if (resposta.equals("S"))
                            numClientes++;
                    }
                }
                else {
                    System.out.println("- CPF Inválido!");
                    System.out.println("- Gostaria de tentar novamente? (S ou N)");
                    resposta = entrada.nextLine();
                    if (resposta.equals("S"))
                        numClientes++;
                }
            }
            
            // Cliente PJ (Pessoa Jurídica)
            else if (tipoCliente.equals("PJ")) {
                System.out.print("Digite o nome do cliente: ");
                String nomeCliente = entrada.nextLine();
                System.out.print("Digite o endereço do cliente: ");
                String enderecoCliente = entrada.nextLine();
                System.out.print("Digite o CNPJ do cliente: ");
                String cnpj = entrada.nextLine();
                System.out.print("Digite a data de fundação (dd-mm-aaaa): ");
                Date dataFundacao = formatarData(entrada);
                System.out.println("-");

                ClientePJ clientePJ = new ClientePJ(nomeCliente,
                                                    enderecoCliente,
                                                    cnpj, 
                                                    dataFundacao);
                
                Boolean validado = clientePJ.validarCNPJ(cnpj);
                if (validado == true) {
                    Boolean cliente_cadastrado = seguradora.cadastrarCliente(clientePJ);
                    
                    if (cliente_cadastrado == true) {
                        
                        // Inserindo veículos do clientePJ
                        System.out.print("Insira o número de veículos a serem cadastrados: ");
                        int numVeiculos = Integer.parseInt(entrada.nextLine());
                        while (numVeiculos > 0) {
                            Veiculo v = leituraVeiculo(entrada);
                            Boolean veiculo_inserido = clientePJ.inserirVeiculo(v);
                            if (veiculo_inserido == true)
                                System.out.println("- Veículo cadastrado com sucesso!" + "\n");
                            else
                                System.out.println("- Erro ao cadastrar veículo.");
                            numVeiculos--;
                        } // Fim da inserção de veículos
                        
                        System.out.println("\n" + "- Cliente " + clientePJ.getNome() + " está no cadastro!");
                        System.out.println(clientePJ.listarVeiculos());
                    }
                    else {
                        System.out.println("- Erro ao cadastrar cliente.");
                        System.out.println("- Gostaria de tentar novamente? (S ou N)");
                        resposta = entrada.nextLine();
                        if (resposta.equals("S"))
                            numClientes++;
                    }
                }
                else {
                    System.out.println("- CNPJ Inválido!");
                    System.out.println("- Gostaria de tentar novamente? (S ou N)");
                    resposta = entrada.nextLine();
                    if (resposta.equals("S"))
                        numClientes++;
                }
            }
            else {
                System.out.println("- Tipo de cliente inválido!");
                System.out.println("- Gostaria de tentar novamente? (S ou N)");
                resposta = entrada.nextLine();
                if (resposta.equals("S"))
                    numClientes++;
            }
            numClientes--;
        } // Fim de cadastro de clientes

        System.out.println("Clientes cadastrados na seguradora " + seguradora.getNome() + ":");
        System.out.println(seguradora.listarClientes("PF"));
        System.out.println(seguradora.listarClientes("PJ"));


        // Removendo clientes
        System.out.println("Gostaria de remover algum cliente? (S ou N)");
        resposta = entrada.nextLine();
        if (resposta.equals("S")) {
            System.out.print("Insira o número de clientes a serem removidos: ");
            int remocaoClientes = Integer.parseInt(entrada.nextLine());
            while (remocaoClientes > 0) {
                System.out.println("--- Nova Remoção ---");
                System.out.print("Digite o nome do cliente a ser removido: ");
                String nome_remocao = entrada.nextLine();
                Cliente cliente_remocao = seguradora.buscarCliente(nome_remocao);
                Boolean cliente_removido = seguradora.removerCliente(cliente_remocao);
                if (cliente_removido == true) {
                    System.out.println("- Cliente removido com sucesso!" + "\n");
                }
                else {
                    System.out.println("- Erro na remoção do cliente!");
                    System.out.println("- Gostaria de tentar novamente? (S ou N)");
                    resposta = entrada.nextLine();
                    if (resposta.equals("S"))
                        remocaoClientes++;
                }
                remocaoClientes--;
            }
        } // Fim de remoção de clientes

        System.out.println("Clientes cadastrados na seguradora " + seguradora.getNome() + ":");
        System.out.println(seguradora.listarClientes("PF"));
        System.out.println(seguradora.listarClientes("PJ"));


        // Gerando sinistros
        System.out.println("Gostaria de gerar algum sinistro? (S ou N)");
        resposta = entrada.nextLine();
        if (resposta.equals("S")) {
            System.out.print("Insira o número de sinistros a serem gerados: ");
            int numSinistros = Integer.parseInt(entrada.nextLine());
            while (numSinistros > 0) {
                Sinistro sinistro = leituraSinistro(entrada, seguradora);
                if (sinistro == null) {
                    System.out.println("- Erro ao gerar Sinistro!");
                    System.out.println("- Gostaria de tentar novamente? (S ou N)");
                    resposta = entrada.nextLine();
                    if (resposta.equals("S"))
                        numSinistros++;
                }
                else {
                    seguradora.gerarSinistro(sinistro);
                    System.out.println("- Sinistro gerado com sucesso!" + "\n");
                }
                numSinistros--;
            }
        } // Fim da geração de sinistros
        
        System.out.println(seguradora.listarSinistros());


        // Visualizando sinistros
        System.out.println("Gostaria de visualizar algum sinistro? (S ou N)");
        resposta = entrada.nextLine();
        if (resposta.equals("S")) {
            System.out.print("Insira o número de sinistros a serem visualizados: ");
            int visualizacoes = Integer.parseInt(entrada.nextLine());
            while (visualizacoes > 0) {
                System.out.print("Digite o nome do cliente associado ao sinistro: ");
                String clienteSinistro = entrada.nextLine();
                System.out.println(seguradora.visualizarSinistro(clienteSinistro));
                visualizacoes--;
            }
        } // Fim da visualização de sinistros

    entrada.close();
    } // fim do método main


    public static Date formatarData (Scanner entrada) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dataString = entrada.nextLine();
        Date data = formatter.parse(dataString);
        return data;
    }


    public static Veiculo leituraVeiculo(Scanner entrada) {
        System.out.println("--- Novo veículo ---");
    
        System.out.print("Digite a placa do veículo: ");
        String placa = entrada.nextLine();
        System.out.print("Digite a marca do veículo: ");
        String marca = entrada.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = entrada.nextLine();
        System.out.print("Digite o ano de fabricação do veículo: ");
        int anoFabricacao = Integer.parseInt(entrada.nextLine());

        Veiculo v = new Veiculo(placa, modelo, marca, anoFabricacao);
        return v;
    }


    public static Sinistro leituraSinistro(Scanner entrada, Seguradora seguradora) throws ParseException {
        System.out.println("--- Novo sinistro ---");
    
        System.out.print("Digite o nome do cliente associado ao sinistro: ");
        String nomeCliente = entrada.nextLine();
        Cliente cliente = seguradora.buscarCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("- Cliente não encontrado.");
            return null;
        }
        System.out.print("Digite a placa do veículo envolvido: ");
        String placa = entrada.nextLine();
        Veiculo veiculo = cliente.buscarVeiculo(placa);
        if (veiculo == null) {
            System.out.println("- Veículo não encontrado.");
            return null;
        }
        System.out.print("Digite o endereço do local do sinistro: ");
        String endereco = entrada.nextLine();
        System.out.print("Digite a data do sinistro: ");
        Date data = formatarData(entrada);

        Sinistro s = new Sinistro(data, endereco, seguradora, veiculo, cliente);
        return s;
    }

} // Fim da classe Main

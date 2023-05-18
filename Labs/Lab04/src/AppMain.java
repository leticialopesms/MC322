import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AppMain {
    public static void main(String[] args) throws ParseException {
        // Instaciando uma Seguradora

        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();

        Seguradora seguradora1 = new Seguradora("UNICAMP Seguros", 
                                                "3248-7052", 
                                                "seguros@unicamp.br", 
                                                "Cidade Universitaria, Campinas, SP");

        listaSeguradoras.add(seguradora1);
        System.out.println("------------------------------");
        System.out.println("Seguradora instanciada:");
        System.out.println("------------------------------");
        System.out.println(seguradora1);
        // Instanciando um ClientePF
        ClientePF cliente1 = new ClientePF("Leticia",
                                           "Marco, Belem, PA", 
                                           "546.125.523-00",
                                           "Feminino",
                                           formataData("03/06/2022"),
                                           "Ensino Superior Incompleto", 
                                           formataData("19/09/2002"),
                                           "Classe Média");
        // Instanciando um ClientePJ
        ClientePJ cliente2 = new ClientePJ("IC Enterprises",
                                           "R. Saturnino de Brito, 573 - Cidade Universitaria, Campinas - SP", 
                                           "98.810.825/0001-76",
                                           formataData("03/06/2022"),
                                           30);

        // Instanciando veículos
        Veiculo veiculo1 = new Veiculo("BRA-1988",
                                       "Fiat",
                                       "Uno",
                                       2021);

        Veiculo veiculo2 = new Veiculo("JUN-3421",
                                       "Volkswagen",
                                       "GOL",
                                       2023);

        // Adicionando um veículo a cada cliente
        cliente1.inserirVeiculo(veiculo1);
        cliente2.inserirVeiculo(veiculo2);

        // Cadastrando os clientes na seguradora
        seguradora1.cadastrarCliente(cliente1);
        seguradora1.cadastrarCliente(cliente2);

        System.out.println("- Receita Total da seguradora " + seguradora1.getNome() +
                           " após cadastrar os veículos: " + seguradora1.calcularReceita());

        // Gerando sinistros
        Sinistro sinistro1 = new Sinistro(formataData("12/05/2023"),
                                          "Marco, Belem, PA",
                                          seguradora1,
                                          veiculo1,
                                          cliente1);
        
        Sinistro sinistro2 = new Sinistro(formataData("15/05/2023"),
                                          "Butanta, Sao Paulo, SP",
                                          seguradora1,
                                          veiculo2,
                                          cliente2);
        
        seguradora1.gerarSinistro(sinistro1);
        seguradora1.gerarSinistro(sinistro2);

        // Atualização do valorSeguro para cada cliente após a geração de sinistros
        seguradora1.calcularPrecoSeguroCliente(cliente1);
        seguradora1.calcularPrecoSeguroCliente(cliente2);
    
        // Chamando os métodos da classe Seguradora
        System.out.println(seguradora1.listarClientes("PF"));
        System.out.println(seguradora1.listarClientes("PJ"));

        System.out.println(seguradora1.visualizarSinistro(cliente1.getCPF()));
        System.out.println(seguradora1.visualizarSinistro(cliente2.getCNPJ()));

        System.out.println(seguradora1.listarSinistros());

        System.out.println("- Receita Total da seguradora " + seguradora1.getNome() +
                           " após a geração de sinistros: " + seguradora1.calcularReceita());

        // Adicionando mais um veículo para cliente1
        Veiculo veiculo3 = new Veiculo("NHJ-1098",
                                       "Renault",
                                       "Kwid",
                                       2023);
        cliente1.inserirVeiculo(veiculo3);

        // Correção da quantidade de funcionarios do cliente2
        cliente2.setQtdeFuncionarios(45);

        // Atualização do valorSeguro para cada cliente após as alterações
        seguradora1.calcularPrecoSeguroCliente(cliente1);
        seguradora1.calcularPrecoSeguroCliente(cliente2);
        
        System.out.println("- Receita Total da seguradora " + seguradora1.getNome() +
                           " após as alterações finais: " + seguradora1.calcularReceita());
        
        System.out.println("");



        // Chamando o Menu de Operações
        executarMenu(listaSeguradoras);

    } // fim do método main


    public static String exibirMenu(){
        String telaOperacoes = "Que operação você deseja realizar?\n";
        int indice = 0;
        for (MenuOperacoes operacao : MenuOperacoes.values()) {
            indice++;
            telaOperacoes += " [" + indice + "] ";
            telaOperacoes += operacao.getDescricao() + "\n";
        }
        return telaOperacoes;
    }

    public static String exibirSubMenu(MenuOperacoes operacao){
        String telaOperacoes = "O que você gostaria de " + operacao.getDescricao() + "?\n";
        int subIndice = 0;
        for (SubMenuOperacoes subOperacao : operacao.getSubMenu()) {
            subIndice++;
            telaOperacoes += " [" + subIndice + "] ";
            telaOperacoes += subOperacao.getDescricao() + "\n";
        }
        return telaOperacoes;
    }


    public static void executarMenu (ArrayList<Seguradora> listaSeguradoras) throws ParseException {
        /* Transforma uma string em um objeto do tipo Date.*/

        Scanner entrada = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("--- Bem vind@ ao sistema de cadastro de Seguros! ---");
        System.out.println("----------------------------------------------------");
        
        int indice;
        do {
            System.out.println(exibirMenu());
            indice = Integer.parseInt(entrada.nextLine());

            MenuOperacoes operacao;
            operacao = MenuOperacoes.values()[indice-1];

            String nomeSeguradora, doadorID, recebedorID;
            Cliente doador, recebedor;
            Seguradora seguradora;

            switch (operacao) {
                case CADASTRAR:
                    executarSubMenu(entrada, operacao, listaSeguradoras);
                    break;

                case LISTAR:
                    executarSubMenu(entrada, operacao, listaSeguradoras);
                    break;

                case EXCLUIR:
                    executarSubMenu(entrada, operacao, listaSeguradoras);
                    break;

                case GERAR_SINISTRO:
                    System.out.print("Digite o nome da seguradora na qual deseja gerar o sinistro: ");
                    nomeSeguradora = entrada.nextLine();
                    seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                    if (seguradora == null)
                        System.out.print("ERRO: Seguradora não encontrada!");
                    else
                        leituraSinistro(entrada, seguradora);
                    break;

                case TRANSFERIR_SEGURO:
                    System.out.print("Digite o nome da seguradora na qual ocorrerá a transferência: ");
                    nomeSeguradora = entrada.nextLine();
                    seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                    if (seguradora == null)
                        System.out.println("ERRO: Seguradora não encontrada.");
                    else {
                        System.out.print("Digite o identificador do cliente transferidor: ");
                        doadorID = entrada.nextLine();
                        doador = seguradora.buscarCliente(doadorID);
                        if (doador == null)
                            System.out.println("ERRO: Cliente doador não encontrado.");
                        else {
                            System.out.print("Digite o identificador do cliente receptor: ");
                            recebedorID = entrada.nextLine();
                            recebedor = seguradora.buscarCliente(recebedorID);
                            if (recebedor == null)
                                System.out.println("ERRO: Cliente recebedor não encontrado.");
                            else {
                                Boolean seguroTransferido = seguradora.transferirSeguro(doador, recebedor);
                                if (seguroTransferido)
                                    System.out.println("- Transfência completa!");
                                else
                                    System.out.println("ERRO: Falha na transfência.");
                            }
                        }
                    }
                    break;

                case CALCULAR_RECEITA:
                    System.out.print("Digite o nome da seguradora da qual deseja calcular a receita: ");
                    nomeSeguradora = entrada.nextLine();
                    seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                    if (seguradora == null)
                        System.out.print("ERRO: Seguradora não encontrada!");
                    else
                        System.out.println("Receita Total da seguradora " + seguradora.getNome() + ": " + seguradora.calcularReceita());
                    break;

                case SAIR:
                    break;
            }
        } while (indice != 7);
        entrada.close();    
    }


    public static void executarSubMenu (Scanner entrada, MenuOperacoes operacao, ArrayList<Seguradora> listaSeguradoras) throws ParseException {
        System.out.println(exibirSubMenu(operacao));

        int subIndice = Integer.parseInt(entrada.nextLine());

        SubMenuOperacoes subOperacao;
        subOperacao = operacao.getSubMenu()[subIndice - 1];

        String nomeSeguradora, identificadorCliente;
        Seguradora seguradora;
        Cliente cliente;

        switch(subOperacao) {
            case CADASTRAR_CLIENTE:
                System.out.print("Digite o nome da seguradora na qual será cadastrado o cliente: ");
                nomeSeguradora = entrada.nextLine();
                seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                if (seguradora != null)
                    System.out.print("ERRO: Seguradora não encontrada!");
                else
                    leituraCliente(entrada, seguradora);
                break;

            case CADASTRAR_VEICULO:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nomeSeguradora = entrada.nextLine();
                seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                if (seguradora == null)
                    System.out.print("ERRO: Seguradora não encontrada!");
                else {
                    System.out.print("Digite o identificador do cliente (CPF ou CNPJ): ");
                    identificadorCliente = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificadorCliente);
                    if (cliente == null)
                        System.out.print("ERRO: Cliente não encontrado!");
                    else
                        leituraVeiculo(entrada, cliente);
                }
                break;
            
            case CADASTRAR_SEGURADORA:
                leituraSeguradora(entrada, listaSeguradoras);
                break;

            case LISTAR_CLIENTES:
                System.out.print("Digite o nome da seguradora na qual estão os clientes a serem listados: ");
                nomeSeguradora = entrada.nextLine();
                seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                System.out.println(seguradora.listarClientes("PF"));
                System.out.println(seguradora.listarClientes("PJ"));
                break;

            case LISTAR_VEICULOS:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nomeSeguradora = entrada.nextLine();
                seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                System.out.print("Digite o identificador do cliente (CPF ou CNPJ): ");
                identificadorCliente = entrada.nextLine();
                cliente = seguradora.buscarCliente(identificadorCliente);
                System.out.println(cliente.listarVeiculos());
                break;

            case LISTAR_SINISTROS:
                System.out.print("Digite o nome da seguradora: ");
                nomeSeguradora = entrada.nextLine();
                seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                System.out.println(seguradora.listarSinistros());
                break;
            
            case EXCLUIR_CLIENTE:
                System.out.print("Digite o nome da seguradora: ");
                nomeSeguradora = entrada.nextLine();
                seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                System.out.print("Digite o identificador do cliente (CPF ou CNPJ): ");
                identificadorCliente = entrada.nextLine();
                cliente = seguradora.buscarCliente(identificadorCliente);
                Boolean clienteRemovido = seguradora.removerCliente(cliente);
                if (clienteRemovido)
                    System.out.println("- Cliente removido com sucesso.");
                else
                    System.out.println("- Erro ao remover cliente.");
                break;

            case EXCLUIR_VEICULO:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nomeSeguradora = entrada.nextLine();
                seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                System.out.print("Digite o identificador do cliente (CPF ou CNPJ): ");
                identificadorCliente = entrada.nextLine();
                cliente = seguradora.buscarCliente(identificadorCliente);
                System.out.print("Digite a placa do veículo que deseja remover: ");
                String placa = entrada.nextLine();
                Veiculo veiculo = cliente.buscarVeiculo(placa);
                Boolean veiculoRemovido = cliente.removerVeiculo(veiculo);
                if (veiculoRemovido)
                    System.out.println("- Veículo removido com sucesso.");
                else
                    System.out.println("- Erro ao remover veículo.");
                break;

            case EXCLUIR_SINISTRO:
                System.out.print("Digite o nome da seguradora: ");
                nomeSeguradora = entrada.nextLine();
                seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                System.out.print("Digite o id do sinistro: ");
                int sinistroID = Integer.parseInt(entrada.nextLine());
                Sinistro sinistro = seguradora.buscarSinistro(sinistroID);
                if (sinistro == null) {
                    System.out.println("- Sinistro não encontrado.");
                }
                else {
                    Boolean sinistroRemovido = seguradora.removerSinistro(sinistro);
                    if (sinistroRemovido)
                        System.out.println("- Sinistro removido com sucesso.");
                    else
                        System.out.println("- Erro ao remover sinistro.");
                }
                break;
            
                case VOLTAR:
                break;
        }
    }


    public static Date formataData (String dataString) throws ParseException {
        /* Transforma uma string em um objeto do tipo Date.*/
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatter.parse(dataString);
        return data;
    }


    public static void leituraCliente(Scanner entrada, Seguradora seguradora) throws ParseException {
        /* Lê as informações necessárias para criar um objeto do tipo cliente.
        Retorna true se o cliente for cadastrado com sucesso.
        Caso contrário, retorna false. */
        Boolean validado = false;
        Cliente cliente = null;
        String identificador = null;

        System.out.println("--- Novo Cliente ---");
        System.out.print("Escolha o tipo de cliente a ser cadastrado (PF ou PJ): ");
        String tipoCliente = entrada.nextLine();

        // Informações gerais do Cliente
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = entrada.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String enderecoCliente = entrada.nextLine();

        // Cliente PF (Pessoa Física)
        if (tipoCliente.equals("PF")) {
            identificador = "CPF";
            System.out.print("Digite o CPF do cliente: ");
            String cpf = entrada.nextLine();
            System.out.print("Digite o gênero do cliente: ");
            String genero = entrada.nextLine();
            System.out.print("Digite a data da licença do cliente (dd/mm/aaaa): ");
            String dataLicensaString = entrada.nextLine();
            Date dataLicenca = formataData(dataLicensaString);
            System.out.print("Digite o grau de escolaridade do cliente: ");
            String educacao = entrada.nextLine();
            System.out.print("Digite a data de nascimento do cliente (dd/mm/aaaa): ");
            String dataNascimentoString = entrada.nextLine();
            Date dataNascimento = formataData(dataNascimentoString);
            System.out.print("Digite a classe econômica do cliente: ");
            String classeEconomica = entrada.nextLine();
            System.out.println("-");

            cliente = new ClientePF(nomeCliente,
                                    enderecoCliente, 
                                    cpf,
                                    genero,
                                    dataLicenca,
                                    educacao, 
                                    dataNascimento,
                                    classeEconomica);

            validado = Validacao.validaCPF(cpf);
        }
        
        // Cliente PJ (Pessoa Jurídica)
        else if (tipoCliente.equals("PJ")) {
            identificador = "CNPJ";
            System.out.print("Digite o CNPJ do cliente: ");
            String cnpj = entrada.nextLine();
            System.out.print("Digite a data de fundação (dd/mm/aaaa): ");
            String dataFundacaoString = entrada.nextLine();
            Date dataFundacao = formataData(dataFundacaoString);
            System.out.print("Digite o número de funcionários do cliente: ");
            int qtdeFuncionarios = Integer.parseInt(entrada.nextLine());
            System.out.println("-");

            cliente = new ClientePJ(nomeCliente,
                                    enderecoCliente,
                                    cnpj, 
                                    dataFundacao,
                                    qtdeFuncionarios);
            
            validado = Validacao.validaCNPJ(cnpj);
        }
            
        if (validado) {
            Boolean cliente_cadastrado = seguradora.cadastrarCliente(cliente);
            if (cliente_cadastrado)
                System.out.println("\n" + "- Cliente " + cliente.getNome() + " está no cadastro!");
            else
                System.out.println("\n" + "- Erro ao cadastrar cliente.");
        }
        else
            System.out.println(identificador + " inválido!");
    }


    public static void leituraVeiculo(Scanner entrada, Cliente cliente) {
        /* Lê as informações necessárias para criar um objeto do tipo Veiculo. */
        System.out.println("--- Novo veículo ---");    
        System.out.print("Digite a placa do veículo: ");
        String placa = entrada.nextLine();
        Boolean validada = Validacao.validaPlaca(placa);
        if (!validada) {
            System.out.println("ERRO: Placa Inválida.");
        }
        else {
            System.out.print("Digite a marca do veículo: ");
            String marca = entrada.nextLine();
            System.out.print("Digite o modelo do veículo: ");
            String modelo = entrada.nextLine();
            System.out.print("Digite o ano de fabricação do veículo: ");
            int anoFabricacao = Integer.parseInt(entrada.nextLine());

            Veiculo v = new Veiculo(placa, modelo, marca, anoFabricacao);

            Boolean veiculo_inserido = cliente.inserirVeiculo(v);
            if (!veiculo_inserido)
                System.out.println("ERRO: Falha ao cadastrar veículo.");
            else
                System.out.println("- Veículo cadastrado com sucesso!" + "\n");
        }
    }


    public static void leituraSeguradora (Scanner entrada, ArrayList<Seguradora> listaSeguradoras) {
        /* Lê as informações necessárias para criar um objeto do tipo Seguradora.
        Insere a nova seguradora em uma lista de Seguadoras. */
        System.out.println("--- Nova Seguradora ---");
        System.out.print("Digite o nome da seguradora: ");
        String nome = entrada.nextLine();
        System.out.print("Digite o telefone da seguradora: ");
        String telefone = entrada.nextLine();
        System.out.print("Digite o e-mail da seguradora: ");
        String email = entrada.nextLine();
        System.out.print("Digite o endereço da seguradora: ");
        String endereco = entrada.nextLine();

        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);

        if (listaSeguradoras.contains(seguradora))
            System.out.println("ERRO: Seguradora já está no cadastro.");
        else {
            listaSeguradoras.add(seguradora);
            System.out.println("- Seguradora cadastrada com sucesso!" + "\n");
        }
    }


    public static void leituraSinistro(Scanner entrada, Seguradora seguradora) throws ParseException {
        /* Lê as informações necessárias para criar um objeto do tipo Sinistro. */
        System.out.println("--- Novo sinistro ---");
        System.out.print("Digite o CPF ou o CNPJ do cliente associado ao sinistro: ");
        String identificacaoCliente = entrada.nextLine();
        Cliente cliente = seguradora.buscarCliente(identificacaoCliente);
        if (cliente == null) {
            System.out.println("ERRO: Cliente não encontrado.");
        }
        else {
            System.out.print("Digite a placa do veículo envolvido: ");
            String placa = entrada.nextLine();
            Veiculo veiculo = cliente.buscarVeiculo(placa);
            if (veiculo == null) {
                System.out.println("ERRO: Veículo não encontrado.");
            }
            else {
                System.out.print("Digite o endereço do local do sinistro: ");
                String endereco = entrada.nextLine();
                System.out.print("Digite a data do sinistro (dd/MM/yyyy): ");
                String dataString = entrada.nextLine();
                Date data = formataData(dataString);

                Sinistro s = new Sinistro(data, endereco, seguradora, veiculo, cliente);
                
                Boolean sinistroGerado = seguradora.gerarSinistro(s);
                if (!sinistroGerado)
                    System.out.println("ERRO: Falha ao gerar sinistro!");
                else
                    System.out.println("- Sinistro gerado com sucesso!");
            }
        }
    }


    public static Seguradora buscaSeguradora (String nome, ArrayList<Seguradora> listaSeguradoras){
        /* Faz uma busca por uma seguradora, dado seu nome, em uma lista de Seguradoras. */
        for (Seguradora s : listaSeguradoras)
            if (s.getNome().equals(nome))
                return s;
        return null;
    }

} // Fim da classe AppMain


// Tratar Exceptions e Validações
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    public static String exibirMenu(){
        /* Exibe as operações do enum Operacoes no terminal. */
        String telaOperacoes = "\nQue operação você deseja realizar?\n";
        int indice = 0;
        for (Operacoes operacao : Operacoes.values()) {
            indice++;
            telaOperacoes += " [" + indice + "] ";
            telaOperacoes += operacao.getDescricao() + "\n";
        }
        telaOperacoes += "\nInsira um dígito: ";
        return telaOperacoes;
    }

    public static String exibirSubMenu(Operacoes operacao){
        /* Exibe as operações do enum SubOperacoes no terminal. */
        String telaSubOperacoes = "O que você gostaria de " + operacao.getDescricao() + "?\n";
        int subIndice = 0;
        for (SubOperacoes subOperacao : operacao.getSubMenu()) {
            subIndice++;
            telaSubOperacoes += " [" + subIndice + "] ";
            telaSubOperacoes += subOperacao.getDescricao() + "\n";
        }
        telaSubOperacoes += "\nInsira um dígito: ";
        return telaSubOperacoes;
    }

    public static void executarMenu (ArrayList<Seguradora> listaSeguradoras) {
        /* Executa as funionalidades do Menu Interativo que dependem
        do enum Operacoes. */
        Scanner entrada = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("-- Bem vind@ ao sistema de cadastro de Seguros! --");
        System.out.println("--------------------------------------------------");
        int indice;
        do {
            // System.out.println(exibirMenu());
            System.out.print(exibirMenu());
            try {
                indice = Integer.parseInt(entrada.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("ERRO: Entrada inválida!");
                indice = 0;
                continue;
            }
            if (indice < 1 || indice > 8) {
                System.out.println("ERRO: Índice inválido!");
                continue;
            }

            Operacoes operacao;
            operacao = Operacoes.values()[indice-1];

            String nomeSeguradora;
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

                case VISUALIZAR:
                    executarSubMenu(entrada, operacao, listaSeguradoras);
                    break;

                case GERAR:
                    executarSubMenu(entrada, operacao, listaSeguradoras);
                    break;
                
                case ATUALIZAR:
                    executarSubMenu(entrada, operacao, listaSeguradoras);
                    break;

                case CALCULAR_RECEITA:
                    System.out.print("Digite o nome da seguradora da qual deseja calcular a receita: ");
                    nomeSeguradora = entrada.nextLine();
                    seguradora = buscaSeguradora(nomeSeguradora, listaSeguradoras);
                    if (seguradora == null)
                        System.out.println("ERRO: Seguradora não encontrada!");
                    else
                        System.out.println("Receita Total da seguradora " + seguradora.getNome() +
                                           ": " + seguradora.calcularReceita() + "\n");
                    break;

                case SAIR:
                    break;
            }
            System.out.println(""); // Fim da Operação
        } while (indice != 8); // Nova Operação

        System.out.println("- Fim do Menu Interativo.\n");
        entrada.close();    
    } // Fim do Menu Interativo


    public static void executarSubMenu (Scanner entrada, Operacoes operacao, ArrayList<Seguradora> listaSeguradoras) {
        /* Executa as funionalidades do Menu Interativo que dependem
        do enum SubOperacoes. */
        // System.out.println(exibirSubMenu(operacao));
        System.out.print(exibirSubMenu(operacao));

        int subIndice = Integer.parseInt(entrada.nextLine());

        SubOperacoes subOperacao;
        subOperacao = operacao.getSubMenu()[subIndice - 1];

        String nome, identificador, code, placa;
        int id;
        Seguradora seguradora;
        Cliente cliente;
        Condutor condutor;
        Veiculo veiculo;
        Frota frota;
        Seguro seguro;
        Sinistro sinistro;
        Boolean cadastrado, excluido, autorizado, desautorizado, adicionado, removido;

        switch(subOperacao) {
            case CADASTRAR_SEGURADORA:
                seguradora = Leitura.leSeguradora(entrada);
                if (seguradora != null) {
                    if (listaSeguradoras.contains(seguradora)) {
                        System.out.println("ERRO: Seguradora já cadastrada.");
                    }
                    else {
                        listaSeguradoras.add(seguradora);
                        System.out.println("- Seguradora cadastrada com sucesso!");
                    }
                }
                break;

            case CADASTRAR_CLIENTE:
                System.out.print("Digite o nome da seguradora na qual será cadastrado o cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    cliente = Leitura.leCliente(entrada);
                    if (cliente != null) {
                        cadastrado = seguradora.cadastrarCliente(cliente);
                        if (!cadastrado) {
                            System.out.println("ERRO: Cliente já cadastrado.");
                        }
                        else {
                            System.out.println("- Cliente cadastrado com sucesso!");
                        }
                    }
                }
                break;

            case CADASTRAR_VEICULO:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CPF do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePF clientePF = (ClientePF)cliente;
                        veiculo = Leitura.leVeiculo(entrada);
                        if (veiculo != null) {
                            cadastrado = clientePF.cadastrarVeiculo(veiculo);
                            if (!cadastrado) {
                                System.out.println("ERRO: Veículo já cadastrado.");
                            }
                            else {
                                System.out.println("- Veículo cadastrado com sucesso!");
                            }
                        }
                    }
                }
                seguradora.atualizarSeguros();
                break;
            
            case CADASTRAR_FROTA:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CNPJ do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePJ clientePJ = (ClientePJ)cliente;
                        frota = Leitura.leFrota(entrada);
                        if (frota != null) {
                            cadastrado = clientePJ.cadastrarFrota(frota);
                            if (!cadastrado) {
                                System.out.println("ERRO: Frota já cadastrada.");
                            }
                            else {
                                System.out.println("- Frota cadastrada com sucesso!");
                            }
                        }
                    }
                }
                seguradora.atualizarSeguros();
                break;
            
            case LISTAR_SEGURADORAS:
                String lista;
                if (listaSeguradoras.size() == 0) {
                    lista = "Ainda não há seguradoras cadastradas.\n";
                }
                else {
                    lista = "--------------------------------------------------\n" +
                            "Lista de seguradoras:\n" +
                            "--------------------------------------------------\n";
                    for (Seguradora s : listaSeguradoras) {
                        lista += s + "------------------------------\n";
                    }
                }
                System.out.println(lista);
                break;

            case LISTAR_CLIENTES:
                System.out.print("Digite o nome da seguradora na qual estão os clientes a serem listados: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.println(seguradora.listarTodosClientes());
                }
                break;
            
            case LISTAR_CONDUTORES:
                System.out.print("Digite o nome da seguradora na qual estão os condutores a serem listados: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro no qual estão os condutores a serem listados: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado!");
                    }
                    else {
                        System.out.println(seguro.listarCondutores());
                    }
                }
                break;

            case LISTAR_VEICULOS:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CPF do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePF clientePF = (ClientePF)cliente;
                        System.out.println(clientePF.listarVeiculos());
                    }
                }
                break;

            case LISTAR_FROTAS:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CNPJ do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePJ clientePJ = (ClientePJ)cliente;
                        System.out.println(clientePJ.listarFrotas());
                    }
                }
                break;
            
            case LISTAR_SEGUROS_SEGURADORA:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null)
                    System.out.println("ERRO: Seguradora não encontrada.");
                else {
                    System.out.println(seguradora.listarSeguros());
                }
                break;
            
            case LISTAR_SEGUROS_CLIENTE:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null)
                    System.out.println("ERRO: Seguradora não encontrada.");
                else {
                    System.out.print("Digite o CPF do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        System.out.println(seguradora.listarSegurosPorCliente(cliente));
                    }
                }
                break;

            case LISTAR_SINISTROS_SEGURO:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null)
                    System.out.println("ERRO: Seguradora não encontrada.");
                else {
                    System.out.print("Digite o ID do seguro: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado!");
                    }
                    else {
                        System.out.println(seguro.listarSinistros());
                    }
                }
                break;
            
            case LISTAR_SINISTROS_CLIENTE:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null)
                    System.out.println("ERRO: Seguradora não encontrada.");
                else {
                    System.out.print("Digite o CPF do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        System.out.println(seguradora.listarSinistrosPorCliente(cliente));
                    }
                }
                break;
            
            case LISTAR_SINISTROS_CONDUTOR:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null)
                    System.out.println("ERRO: Seguradora não encontrada.");
                else {
                    System.out.print("Digite o ID do seguro: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado.");
                    }
                    else {
                        System.out.print("Digite o CPF do condutor: ");
                        identificador = entrada.nextLine();
                        condutor = seguro.buscarCondutor(identificador);
                        if (condutor == null) {
                            System.out.println("ERRO: Condutor não encontrado.");
                        }
                        else {
                            System.out.println(condutor.listarSinistros());
                        }
                    }
                }
                break;

            case VISUALIZAR_SEGURADORA:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null)
                    System.out.println("ERRO: Seguradora não encontrada.");
                else
                    System.out.print(seguradora);
                break;
            
            case VISUALIZAR_CLIENTE:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o identificador do cliente (CPF ou CNPJ): ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null)
                        System.out.println("ERRO: Cliente não encontrado.");
                    else
                        System.out.print(cliente);
                }
                break;

            case VISUALIZAR_CONDUTOR:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado.");
                    }
                    else {
                        System.out.print("Digite o CPF do condutor: ");
                        identificador = entrada.nextLine();
                        condutor = seguro.buscarCondutor(identificador);
                        if (condutor == null)
                            System.out.println("ERRO: Condutor não encontrado.");
                        else
                            System.out.print(condutor);
                    }
                }
                break;

            case VISUALIZAR_VEICULO:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CPF do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePF clientePF = (ClientePF)cliente;
                        System.out.print("Digite a placa do veículo: ");
                        placa = entrada.nextLine();
                        veiculo = clientePF.buscarVeiculo(placa);
                        if (veiculo == null)
                            System.out.println("ERRO: Veículo não encontrado.");
                        else
                            System.out.print(veiculo);
                    }
                }
                break;

            case VISUALIZAR_FROTA:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CNPJ do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePJ clientePJ = (ClientePJ)cliente;
                        System.out.print("Digite o código (code) da frota: ");
                        code = entrada.nextLine();
                        frota = clientePJ.buscarFrota(code);
                        if (frota == null)
                            System.out.println("ERRO: Frota não encontrada.");
                        else
                            System.out.print(frota);
                    }
                }
                break;
            
            case VISUALIZAR_SEGURO:
                System.out.print("Digite o nome da seguradora do seguro: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null)
                        System.out.println("ERRO: Seguro não encontrado.");
                    else
                        System.out.print(seguro);
                }
                break;

            case VISUALIZAR_SINISTRO:
                System.out.print("Digite o nome da seguradora do sinistro a ser excluído: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro onde foi gerado o sinistro: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado.");
                    }
                    else {
                        System.out.print("Digite o ID do sinistro: ");
                        id = Integer.parseInt(entrada.nextLine());
                        sinistro = seguro.buscarSinistro(id);
                        if (sinistro == null)
                            System.out.println("ERRO: Sinistro não encontrado.");
                        else
                            System.out.print(sinistro);
                    }
                }
                break;

            case EXCLUIR_SEGURADORA:
                System.out.print("Digite o nome da seguradora a ser excluída: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null)
                    System.out.println("ERRO: Seguradora não encontrada.");
                else {
                    listaSeguradoras.remove(seguradora);
                    System.out.println("- Seguradora excluída com sucesso!");
                }
                break;
                
            case EXCLUIR_CLIENTE:
                System.out.print("Digite o nome da seguradora: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o identificador do cliente (CPF ou CNPJ): ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    excluido = seguradora.removerCliente(cliente);
                    if (!excluido)
                        System.out.println("ERRO: Cliente não encontrado.");
                    else
                        System.out.println("- Cliente excluído com sucesso!");
                }
                break;

            case EXCLUIR_VEICULO:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CPF do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePF clientePF = (ClientePF)cliente;
                        System.out.print("Digite a placa do veículo que deseja remover: ");
                        placa = entrada.nextLine();
                        veiculo = clientePF.buscarVeiculo(placa);
                        excluido = clientePF.excluirVeiculo(veiculo);
                        if (!excluido)
                            System.out.println("ERRO: Veículo não encontrado.");
                        else {
                            System.out.println("- Veículo excluído com sucesso!");
                        }
                    }
                }
                seguradora.atualizarSeguros();
                break;
            
            case EXCLUIR_FROTA:
                System.out.print("Digite o nome da seguradora do cliente: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CNPJ do cliente: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePJ clientePJ = (ClientePJ)cliente;
                        System.out.print("Digite o código (code) da frota que deseja remover: ");
                        code = entrada.nextLine();
                        frota = clientePJ.buscarFrota(code);
                        excluido = clientePJ.excluirFrota(frota);
                        if (!excluido)
                            System.out.println("ERRO: Frota não encontrada.");
                        else {
                            System.out.println("- Frota excluída com sucesso!");
                        }
                    }
                }
                seguradora.atualizarSeguros();
                break;
            
            case EXCLUIR_SEGURO:
                System.out.print("Digite o nome da seguradora do seguro a ser excluído: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro a ser excluído: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    excluido = seguradora.cancelarSeguro(seguro);
                    if (!excluido) {
                        System.out.println("ERRO: Seguro não encontrado.");
                    }
                    else {
                        System.out.println("- Seguro excluído com sucesso!");
                    }
                }
                break;

            case EXCLUIR_SINISTRO:
                System.out.print("Digite o nome da seguradora do sinistro a ser excluído: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro onde foi gerado o sinistro: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado.");
                    }
                    else {
                        System.out.print("Digite o ID do sinistro: ");
                        id = Integer.parseInt(entrada.nextLine());
                        sinistro = seguro.buscarSinistro(id);
                        excluido = seguro.excluirSinistro(sinistro);
                        if (!excluido) {
                            System.out.println("ERRO: Sinistro não encontrado.");
                        }
                        else {
                            System.out.println("- Sinistro excluído com sucesso!");
                        }
                    }
                }
                break;
            
            case GERAR_SEGURO:
                System.out.print("Digite o nome da seguradora na qual será gerado o seguro: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    seguro = Leitura.leSeguro(entrada, seguradora);
                    if (seguro != null) {
                        seguradora.gerarSeguro(seguro);
                        System.out.println("- Seguro gerado com sucesso!");
                    }
                }
                break;
            
            case GERAR_SINISTRO:
                System.out.print("Digite o nome da seguradora na qual será gerado o sinistro: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro no qual será gerado o sinistro: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado.");
                    }
                    else {
                        sinistro = Leitura.leSinistro(entrada, seguro);
                        if (sinistro != null) {
                            seguro.gerarSinistro(sinistro);
                            System.out.println("- Sinistro gerado com sucesso!");
                        }
                    }
                }
                break;
            
            case AUTORIZAR_CONDUTOR:
                System.out.print("Digite o nome da seguradora na qual será realizada a operação: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro no qual será realizada a operação: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado.");
                    }
                    else {
                        condutor = Leitura.leCondutor(entrada);
                        if (condutor != null) {
                            autorizado = seguro.autorizarCondutor(condutor);
                            if (!autorizado) {
                                System.out.println("ERRO: Condutor já autorizado.");
                            }
                            else {
                                System.out.println("- Condutor autorizado com sucesso!");
                            }
                        }
                    }
                }
                break;
            
            case DESAUTORIZAR_CONDUTOR:
                System.out.print("Digite o nome da seguradora na qual será realizada a operação: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o ID do seguro no qual será realizada a operação: ");
                    id = Integer.parseInt(entrada.nextLine());
                    seguro = seguradora.buscarSeguro(id);
                    if (seguro == null) {
                        System.out.println("ERRO: Seguro não encontrado.");
                    }
                    else {
                        condutor = Leitura.leCondutor(entrada);
                        if (condutor != null) {
                            desautorizado = seguro.desautorizarCondutor(condutor);
                            if (!desautorizado) {
                                System.out.println("ERRO: Condutor não encontrado.");
                            }
                            else {
                                System.out.println("- Condutor desautorizado com sucesso!");
                            }
                        }
                    }
                }
                break;
            
            case ADICIONAR_VEICULO_FROTA:
                System.out.print("Digite o nome da seguradora na qual será realizada a operação: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CNPJ do cliente que terá sua frota atualizada: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePJ clientePJ = (ClientePJ)cliente;
                        System.out.print("Digite o código (code) da frota a ser atualizada: ");
                        code = entrada.nextLine();
                        frota = clientePJ.buscarFrota(code);
                        if (frota == null) {
                            System.out.println("ERRO: Frota não encontrada.");
                        }
                        else {
                            veiculo = Leitura.leVeiculo(entrada);
                            if (veiculo != null) {
                                adicionado = clientePJ.atualizarFrota(1, frota, veiculo);
                                if (!adicionado) {
                                    System.out.println("ERRO: Veículo já está na frota.");
                                }
                                else {
                                    System.out.println("- Veículo adicionado na frota com sucesso!");
                                }
                            }
                        }
                    }
                }
                seguradora.atualizarSeguros();
                break;
            
            case REMOVER_VEICULO_FROTA:
                System.out.print("Digite o nome da seguradora na qual será realizada a operação: ");
                nome = entrada.nextLine();
                seguradora = buscaSeguradora(nome, listaSeguradoras);
                if (seguradora == null) {
                    System.out.println("ERRO: Seguradora não encontrada.");
                }
                else {
                    System.out.print("Digite o CNPJ do cliente que terá sua frota atualizada: ");
                    identificador = entrada.nextLine();
                    cliente = seguradora.buscarCliente(identificador);
                    if (cliente == null) {
                        System.out.println("ERRO: Cliente não encontrado.");
                    }
                    else {
                        ClientePJ clientePJ = (ClientePJ)cliente;
                        System.out.print("Digite o código (code) da frota a ser atualizada: ");
                        code = entrada.nextLine();
                        frota = clientePJ.buscarFrota(code);
                        if (frota == null) {
                            System.out.println("ERRO: Frota não encontrada.");
                        }
                        else {
                            System.out.print("Digite a placa do veículo que será removido: ");
                            placa = entrada.nextLine();
                            veiculo = frota.buscarVeiculo(placa);
                            if (veiculo != null) {
                                removido = clientePJ.atualizarFrota(2, frota, veiculo);
                                if (!removido) {
                                    System.out.println("ERRO: Veículo não encontrado.");
                                }
                                else {
                                    System.out.println("- Veículo removido da frota com sucesso!");
                                }
                            }
                        }
                    }
                }
                seguradora.atualizarSeguros();
                break;
            
            case VOLTAR:
                break;
        }
    }

    public static Seguradora buscaSeguradora (String nome, ArrayList<Seguradora> listaSeguradoras){
        /* Faz uma busca por uma seguradora, dado seu nome, em uma lista de Seguradoras.
        Se tiver encontrado, retorna a seguradora.
        Caso contrário, retorna null. */
        for (Seguradora s : listaSeguradoras)
            if (s.getNome().equals(nome))
                return s;
        return null;
    }
}

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora("Unicamp Seguros", "3246-7950", "seguros@unicamp.br", "Campinas");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem vind@ ao sistema da seguradora " + seguradora.getNome() + "!\n");

        // Cadastrando clientes
        System.out.print("Insira o número de clientes a serem cadastrados: ");
        int numClientes = entrada.nextInt();
        while (numClientes > 0) {
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = entrada.nextLine();
            System.out.print("Digite o endereço do cliente: ");
            String enderecoCliente = entrada.nextLine();

            System.out.print("Escolha o tipo de cliente a ser cadastrado (PF ou PJ): ");
            String tipoCliente = entrada.nextLine();
            if (tipoCliente.equals("PF")) {
                System.out.print("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
                System.out.print("Digite o gênero do cliente: ");
                String genero = entrada.nextLine();
                System.out.print("Digite a data da licença do cliente (dd/mm/aaaa)");
                String dataLicenca = entrada.nextLine();
                System.out.print("Digite o grau de escolaridade do cliente: ");
                String educacao = entrada.nextLine();
                System.out.print("Digite a data de nascimento do cliente (dd/mm/aaaa): ");
                String dataNascimento = entrada.nextLine();
                System.out.print("Digite a classe econômica do Cliente: ");
                String classeEconomica = entrada.nextLine();

                // ClientePF clientePF = new ClientePF(nomeCliente, enderecoCliente, 
                //                                     cpf, genero, data_Licenca, educacao, 
                //                                     data_Nascimento, classeEconomica);
                
                System.out.print("Insira o número de veículos a serem cadastrados: ");
                int numVeiculos = entrada.nextInt();
                    for (int j = 0; j < numVeiculos; ++j) {
                        System.out.print("Digite a placa do veículo: ");
                        String placa = entrada.nextLine();
                        System.out.print("Digite a marca do veículo: ");
                        String marca = entrada.nextLine();
                        System.out.print("Digite o modelo do veículo: ");
                        String modelo = entrada.nextLine();
                        System.out.print("Digite o ano de fabricação do veículo: ");
                        int anoFabricacao = entrada.nextInt();

                        Veiculo v = new Veiculo(placa, modelo, marca, anoFabricacao);
                        System.out.println("\n" + v);
                    }

            }
            else if (tipoCliente.equals("PJ")) {

            }
            numClientes--;
        }
        
    entrada.close();
    } // fim do método main
} // Fim da classe Main




// Terminar
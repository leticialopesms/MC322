// import java.util.Scanner;
import java.util.ArrayList;
// import java.time.LocalDate;

public class AppMain {
    public static void main(String[] args) {
        // Instaciando uma Seguradora

        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();

        Seguradora seguradora1 = new Seguradora("02.355.042/0001-70",
                                                "UNICAMP Seguros",
                                                "3248-7052",
                                                "Cidade Universitaria, Campinas, SP",
                                                "seguros@unicamp.br");
        listaSeguradoras.add(seguradora1);
        System.out.println("--------------------------------------------------");
        System.out.println("Seguradora instanciada:");
        System.out.println("--------------------------------------------------");
        System.out.println(seguradora1);

        // Instanciando vários clientes do tipo ClientePF
        ClientePF cliente1 = new ClientePF("Leticia Lopes",
                                           "(91) 98810-5617", 
                                           "Belem, PA",
                                           "l184423@dac.unicamp.br",
                                           "914.033.934-35",
                                           "Feminino", 
                                           "Ensino Superior Incompleto",
                                           Leitura.formataData("19/09/2002"));
        
        ClientePF cliente2 = new ClientePF("Milton Seixas",
                                           "(91) 98871-9687", 
                                           "Belem, PA",
                                           "milton@gmail.com",
                                           "419.612.744-42",
                                           "Masculino", 
                                           "Ensino Superior Incompleto",
                                           Leitura.formataData("14/10/2003"));

        ClientePF cliente3 = new ClientePF("Cibelly da Costa",
                                           "(91) 98822-1425", 
                                           "Fortaleza, CE",
                                           "cibelly.costa@gmail.com",
                                           "621.657.164-89",
                                           "Feminino", 
                                           "Ensino Superior Completo",
                                           Leitura.formataData("03/07/1976"));

        ClientePF cliente4 = new ClientePF("Ingrid Albuquerque",
                                           "(91) 98822-1425", 
                                           "Rio de Janeiro, RJ",
                                           "ingrid@gmail.com",
                                           "278.552.984-79",
                                           "Feminino", 
                                           "Ensino Superior Completo",
                                           Leitura.formataData("06/10/2004"));
                                           
        // Instanciando vários clientes do tipo ClientePJ
        ClientePJ cliente5 = new ClientePJ("IC Enterprises",
                                           "(19) 3246-5079",
                                           "R. Saturnino de Brito, 573 - Cidade Universitaria, Campinas - SP",
                                           "ic@unicamp.br",
                                           "98.810.825/0001-76",
                                           Leitura.formataData("15/04/2007"),
                                           50);
        
        ClientePJ cliente6 = new ClientePJ("IFGW Company",
                                           "(19) 3521-5297",
                                           "R. Sérgio Buarque de Holanda, 777 - Cidade Universitaria, Campinas - SP",
                                           "ifgwc@unicamp.br",
                                           "53.713.048/0001-03",
                                           Leitura.formataData("03/06/2001"),
                                           30);

        // Instanciando veículos
        Veiculo carro1 = new Veiculo("BRA-1988",
                                       "Fiat",
                                       "Uno",
                                       2021);

        Veiculo carro2 = new Veiculo("JUN-3421",
                                       "Volkswagen",
                                       "GOL",
                                       2023);
        
        Veiculo carro3 = new Veiculo("HKA-1234",
                                       "Chevrolet",
                                       "Celta",
                                       2013);
        
        Veiculo carro4 = new Veiculo("TPA-5791",
                                       "Volkswagen",
                                       "Kombi",
                                       2010);

        Veiculo moto1 = new Veiculo("LMR-0911",
                                       "Yamaha",
                                       "Crosser",
                                       2023);
        
        Veiculo caminhao1 = new Veiculo("YIN-7598",
                                        "Mercedes-Benz",
                                        "Axor 2544",
                                        2023);
        
        Veiculo caminhao2 = new Veiculo("OTR-1297",
                                        "Mercedes-Benz",
                                        "Axor 2544",
                                        2023);

        Veiculo caminhao3 = new Veiculo("YIN-7460",
                                        "Volvo",
                                        "FH 540",
                                        2023);
        
        Veiculo caminhao4 = new Veiculo("KRT-7751",
                                        "Volvo",
                                        "FH 540",
                                        2023);
        
        // Instanciando frotas
        Frota frota1 = new Frota("1");
        Frota frota2 = new Frota("2");

        // Adicionando veículos às frotas
        frota1.adicionarVeiculoFrota(caminhao1);
        frota1.adicionarVeiculoFrota(caminhao2);
        frota2.adicionarVeiculoFrota(caminhao3);
        frota2.adicionarVeiculoFrota(caminhao4);

        // Adicionando veículos a cada clientePF
        cliente1.cadastrarVeiculo(carro1);
        cliente1.cadastrarVeiculo(moto1);
        cliente2.cadastrarVeiculo(carro2);
        cliente3.cadastrarVeiculo(carro3);
        cliente4.cadastrarVeiculo(carro4);

        // Adicionando uma frota a cada cliente PJ
        cliente5.cadastrarFrota(frota1);
        cliente6.cadastrarFrota(frota2);

        // Cadastrando os clientes na seguradora1
        seguradora1.cadastrarCliente(cliente1);
        seguradora1.cadastrarCliente(cliente2);
        seguradora1.cadastrarCliente(cliente3);
        seguradora1.cadastrarCliente(cliente4);
        seguradora1.cadastrarCliente(cliente5);
        seguradora1.cadastrarCliente(cliente6);

        // Instanciando condutores
        Condutor condutor1 = new Condutor(cliente1.getCPF(),
                                          cliente1.getNome(),
                                          cliente1.getTelefone(),
                                          cliente1.getEndereco(),
                                          cliente1.getEmail(),
                                          cliente1.getDataNascimento());
        
        Condutor condutor2 = new Condutor(cliente2.getCPF(),
                                          cliente2.getNome(),
                                          cliente2.getTelefone(),
                                          cliente2.getEndereco(),
                                          cliente2.getEmail(),
                                          cliente2.getDataNascimento());
        
        Condutor condutor3 = new Condutor(cliente3.getCPF(),
                                          cliente3.getNome(),
                                          cliente3.getTelefone(),
                                          cliente3.getEndereco(),
                                          cliente3.getEmail(),
                                          cliente3.getDataNascimento());

        Condutor condutor4 = new Condutor(cliente4.getCPF(),
                                          cliente4.getNome(),
                                          cliente4.getTelefone(),
                                          cliente4.getEndereco(),
                                          cliente4.getEmail(),
                                          cliente4.getDataNascimento());
        
        Condutor condutor5 = new Condutor("402.895.770-20",
                                          "Maria Luisa",
                                          "(91) 98856-3586",
                                          "Campinas, SP",
                                          "malu@gmail.com",
                                          Leitura.formataData("14/09/2003"));
        
        // Instanciando e gerando seguros na seguradora1
        SeguroPF seguro1 = new SeguroPF(Leitura.formataData("01/01/2023"),
                                        Leitura.formataData("01/01/2024"),
                                        seguradora1,
                                        cliente1,
                                        carro1);
        seguro1.autorizarCondutor(condutor1); // Condutor Princial (cliente1)
        seguro1.autorizarCondutor(condutor2);
        seguro1.autorizarCondutor(condutor5);
        seguradora1.gerarSeguro(seguro1);

        SeguroPF seguro2 = new SeguroPF(Leitura.formataData("01/02/2023"),
                                        Leitura.formataData("01/02/2024"),
                                        seguradora1,
                                        cliente2,
                                        carro2);
        seguro2.autorizarCondutor(condutor2); // Condutor Princial (cliente2)
        seguro2.autorizarCondutor(condutor1);
        seguradora1.gerarSeguro(seguro2);

        SeguroPF seguro3 = new SeguroPF(Leitura.formataData("01/03/2023"),
                                        Leitura.formataData("01/03/2024"),
                                        seguradora1,
                                        cliente3,
                                        carro3);
        seguro3.autorizarCondutor(condutor3); // Condutor Princial (cliente3)
        seguradora1.gerarSeguro(seguro3);
        
        SeguroPF seguro4 = new SeguroPF(Leitura.formataData("01/04/2023"),
                                        Leitura.formataData("01/04/2024"),
                                        seguradora1,
                                        cliente4,
                                        carro4);
        seguro4.autorizarCondutor(condutor4); // Condutor Princial (cliente4)
        seguradora1.gerarSeguro(seguro4);
        
        SeguroPF seguro5 = new SeguroPF(Leitura.formataData("01/05/2023"),
                                        Leitura.formataData("01/05/2024"),
                                        seguradora1,
                                        cliente1,
                                        moto1);
        seguro5.autorizarCondutor(condutor1); // Condutor Princial (cliente1)
        seguro5.autorizarCondutor(condutor2);
        seguradora1.gerarSeguro(seguro5);
        
        SeguroPJ seguro6 = new SeguroPJ(Leitura.formataData("01/01/2023"),
                                        Leitura.formataData("01/01/2024"),
                                        seguradora1,
                                        cliente5,
                                        frota1);
        seguro6.autorizarCondutor(condutor3);
        seguro6.autorizarCondutor(condutor4);
        seguradora1.gerarSeguro(seguro6);

        SeguroPJ seguro7 = new SeguroPJ(Leitura.formataData("01/02/2023"),
                                        Leitura.formataData("01/02/2024"),
                                        seguradora1,
                                        cliente6,
                                        frota2);
        seguro7.autorizarCondutor(condutor5);
        seguradora1.gerarSeguro(seguro7);

        // Mostrando o balanço total da seguradora1 após cadastrar os seguros
        System.out.println("- Receita Total da seguradora " + seguradora1.getNome() 
                           + " após o cadastro dos seguros: " 
                           + seguradora1.calcularReceita() + "\n");

        // Gerando sinistros
        Sinistro sinistro1 = new Sinistro(Leitura.formataData("15/01/2023"),
                                          "Campinas, SP",
                                          condutor1,
                                          seguro1);
        seguro1.gerarSinistro(sinistro1);
        
        Sinistro sinistro2 = new Sinistro(Leitura.formataData("15/02/2023"),
                                          "Sao Paulo, SP",
                                          condutor2,
                                          seguro5);
        seguro5.gerarSinistro(sinistro2);

        Sinistro sinistro3 = new Sinistro(Leitura.formataData("15/03/2023"),
                                          "Sao Paulo, SP",
                                          condutor2,
                                          seguro2);
        seguro2.gerarSinistro(sinistro3);

        // Mostrando o balanço total da seguradora1 após a gerar os sinistros
        System.out.println("- Receita Total da seguradora " + seguradora1.getNome() +
                           " após a geração de sinistros: " + seguradora1.calcularReceita() + "\n");

        // Adicionando mais um veículo para cliente1
        Veiculo carro5 = new Veiculo("NHJ-1098",
                                       "Renault",
                                       "Kwid",
                                       2023);
        cliente1.cadastrarVeiculo(carro5);

        // Correção da quantidade de funcionarios do cliente2
        cliente5.setQtdeFuncionarios(100);

        // Atualização dos valores mensais de cada seguro após as alterações
        seguradora1.atualizarSeguros();
        
        // Mostrando o balanço total da seguradora1 após cadastrar os seguros
        System.out.println("- Receita Total da seguradora " + seguradora1.getNome() +
                           " após as alterações finais: " + seguradora1.calcularReceita() + "\n");

        // Listando os clientes da seguradora1
        // System.out.println("------------------------------");
        // System.out.println("Clientes de " + seguradora1.getNome() + ":");
        // System.out.println(seguradora1.listarClientes("PF"));
        // System.out.println(seguradora1.listarClientes("PJ"));

        System.out.println(seguradora1.listarTodosClientes());

        // Listando os seguros da seguradora
        System.out.println(seguradora1.listarSeguros());

        // Listando os seguros de cada cliente
        System.out.println(seguradora1.listarSegurosPorCliente(cliente1));
        System.out.println(seguradora1.listarSegurosPorCliente(cliente2));
        System.out.println(seguradora1.listarSegurosPorCliente(cliente3));
        System.out.println(seguradora1.listarSegurosPorCliente(cliente4));
        System.out.println(seguradora1.listarSegurosPorCliente(cliente5));
        System.out.println(seguradora1.listarSegurosPorCliente(cliente6));

        // Listando os sinistros de cada cliente
        System.out.println(seguradora1.listarSinistrosPorCliente(cliente1));
        System.out.println(seguradora1.listarSinistrosPorCliente(cliente2));
        System.out.println(seguradora1.listarSinistrosPorCliente(cliente3));
        System.out.println(seguradora1.listarSinistrosPorCliente(cliente4));
        System.out.println(seguradora1.listarSinistrosPorCliente(cliente5));
        System.out.println(seguradora1.listarSinistrosPorCliente(cliente6));
        
        System.out.println("- Fim do cadastro manual.\n");
        System.out.println("- Início do Menu Interativo.\n");

        // Chamando o Menu de Operações
        Menu.executarMenu(listaSeguradoras);
    
    } // Fim do método Main
} // Fim da classe AppMain

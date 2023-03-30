public class Main {
    public static void main(String[] args) {
        Seguradora seguradora1 = new Seguradora("Seguros S.A.", "3246-7950", "seguros@email.com", "São Paulo");
        seguradora1.setTelefone("3246-7799");


        Cliente cliente1 = new Cliente("Letícia", "283.368.850-48", "19.09.2002",   20, "Campinas");
        System.out.println(cliente1);
        boolean eh_valido = cliente1.validarCPF(cliente1.getCPF());
        if (eh_valido) {
            System.out.println("CPF Válido!");
        }
        else {
            System.out.println("CPF Inválido!");
        }


        Veiculo veiculo1 = new Veiculo("BRA1A34", "Renault", "Kwid");
        veiculo1.setPlaca("BRA2A23");
        veiculo1.setmodelo("Kwid 2023");

        Veiculo veiculo2 = new Veiculo("BRA1A00", "Chevr", "Onix");
        veiculo2.setPlaca("BRA2A00");
        veiculo2.setmarca("Chevrolet");


        Sinistro sinistro1 = new Sinistro("28.03.2023", "São Paulo");
        System.out.println("Sinistro: id = " + sinistro1.getId());
        sinistro1.setData("27.03.2023");
        sinistro1.setEndereco("Campinas");

    } // fim do método main
} // Fim da classe Main
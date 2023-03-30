import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    // Propriedades
    private String nome;
    private String endereco;
    private Date dataLicensa;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private ArrayList<Veiculo> listaVeiculos;

    // Construtor
    public Cliente(String nome, String endereco, Date dataLicensa, String educacao, String genero,
    String classeEconomica, ArrayList<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataLicensa = dataLicensa;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.listaVeiculos = listaVeiculos;
    }


    // Getters (acessors) e Setters (mutators)
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public Date getDataLicensa() {
        return dataLicensa;
    }


    public void setDataLicensa(Date dataLicensa) {
        this.dataLicensa = dataLicensa;
    }


    public String getEducacao() {
        return educacao;
    }


    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getClasseEconomica() {
        return classeEconomica;
    }


    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }


    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }


    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
    


    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
               "Endereço: " + this.endereco + "\n" +
               "Data da Licensa: " + this.dataLicensa + "\n" +
               "Educação: " + this.educacao + "\n" +
               "Gênero: " + this.genero + "\n" +
               "Classe Econômica: " + this.classeEconomica + "\n" +
               "Lista de Veículos: " + this.listaVeiculos + "\n";
    }


    
}

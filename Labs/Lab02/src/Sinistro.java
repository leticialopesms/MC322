import java.util.Random;

public class Sinistro {
    // Propriedades
    private int id;
    private String data;
    private String endereco;

    // Construtor
    public Sinistro(String data, String endereco) {
        this.data = data;
        this.endereco = endereco;
    }

    // Getters (acessors) e Setters (mutators)
    public int getId() {
        Random num = new Random();
        id = num.nextInt(9999999) + 1000000;
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

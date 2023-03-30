public class Veiculo {
    // Propriedades
    private String placa;
    private String marca;
    private String modelo;

    // Construtor
    public Veiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters (acessors) e Setters (mutators)
    public String getPlaca() { return placa; }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() { return marca; }
    
    public void setmarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() { return modelo; }
    
    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }
}

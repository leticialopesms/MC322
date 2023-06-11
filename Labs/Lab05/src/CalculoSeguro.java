public enum CalculoSeguro {
    VALOR_BASE(10.0),
    FATOR_MENOR_30(1.25),
    FATOR_30_60(1.0),
    FATOR_MAIOR_60(1.5);


    // Atributo
    private final double valor;


    // Construtor
    CalculoSeguro(double valor) {
        this.valor = valor;
    }

    // Métodos
    // - Getter
    public double getValor() {
        return valor;
    }
}

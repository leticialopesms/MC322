public enum CalculoSeguro {
    VALOR_BASE(100.00),
    FATOR_18_30(1.2),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    // Atributo
    private final double valor;

    // Construtor
    CalculoSeguro (double valor) {
        this.valor = valor;
    }

    // Getter
    public double getValor() {
        return valor;
    }
}

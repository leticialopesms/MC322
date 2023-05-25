import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
    // Atributos (propriedades)
    private static int registros = 100000;
    private final int ID;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;


    // Construtor
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int vaorMensal) {
        this.ID = gerarID();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = vaorMensal;
    }


    // Métodos
    // - Getters (acessors) e Setters (mutators)

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public int gerarID() {
        /* Gera um número a partir do atributo de classe 'registros'.
        Tem, pelo menos, 6 dígitos. */
        registros++;
        return registros;
    }

}

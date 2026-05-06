package javaback.grupo;


public class CaixaEletronico implements ICaixaEletronico {

    private int[][] cedulas = {
            {100, 0},
            {50, 0},
            {20, 0},
            {10, 0},
            {5, 0},
            {2, 0},
    };
    private int cotaMinima;
    private String historicoSaques = "";

    // util
    private int getValorTotal() {
        int acumulador = 0;

        for (int i = 0; i < cedulas.length; i++) {
            int cedula = this.cedulas[i][0];
            int quantidade = this.cedulas[i][1];
            acumulador += (cedula * quantidade);
        }

        return acumulador;
    }

    private boolean temSaldo(int valor) {
        return this.getValorTotal() >= valor;
    }

    private int[] calcularDistribuicao(int valor) {
        // valor que falta pra pagar
        int restante = valor;
        // quantas notas de cada tipo vai usar
        int[] dist = new int[cedulas.length];

        for (int i = 0; i < cedulas.length; i++) {
            int nota = cedulas[i][0];
            int estoque = cedulas[i][1];
            // qtd não pode ser maior do que a quantidade que falta
            // nem mais do que tem no caixa
            int qtd = Math.min(restante / nota, estoque);
            // salva as que usou e diminui do valor que falta
            dist[i] = qtd;
            restante -= qtd * nota;
        }
        // retorna as cedulas usadas e a quantidade
        return (restante == 0) ? dist : null;
    }

    private int contarCedulas(int[] dist) {
        int total = 0;
        for (int qtd : dist) {
            total += qtd;
        }

        return total;
    }

    // atualiza o estoque (matriz de cedulas) com o valor retirado do saque
    private void aplicarSaque(int[] dist) {
        for (int i = 0; i < cedulas.length; i++) {
            cedulas[i][1] -= dist[i];
        }
    }

    private String montarResposta(int[] dist) {
        StringBuilder sb = new StringBuilder();
        sb.append("Saque realizado:\n");

        for (int i = 0; i < cedulas.length; i++) {
            if (dist[i] > 0) {
                sb.append("Nota ").append(cedulas[i][0]).append(": ").append(dist[i]).append("\n");
            }
        }
        this.historicoSaques += sb.toString() + "\n";

        return sb.toString();
    }

    // metodos implementados da interface
    @Override
    public String pegaValorTotalDisponivel() {
        int resultado = this.getValorTotal();
        return "Valor disponível em caixa: " + resultado;
    }

    @Override
    public String sacar(Integer valor) {
        if (!temSaldo(valor)) {
            return "Não temos notas para este saque";
        }

        int[] distribuicao = calcularDistribuicao(valor);
        if (distribuicao == null) {
            return "Saque não realizado por falta de cédulas";
        }

        int totalNotas = contarCedulas(distribuicao);
        if (totalNotas > 30) {
            return "Limite de cédulas excedido";
        }

        aplicarSaque(distribuicao);

        if (getValorTotal() < cotaMinima) {
            return "Caixa Vazio: Chame o Operador";
        }

        return montarResposta(distribuicao);
    }

    @Override
    public String pegaRelatorioCedulas() {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append(String.format("%-10s %-10s\n", "Cedula", "Quantidade"));

        for (int i = 0; i < this.cedulas.length; i++) {
            relatorio.append(String.format("%-10d %-10d\n", this.cedulas[i][0], this.cedulas[i][1]));
        }

        return relatorio.toString();
    }

    @Override
    public String reposicaoCedulas(Integer cedula, Integer quantidade) {
        for (int i = 0; i < this.cedulas.length; i++) {
            if (this.cedulas[i][0] == cedula) {
                this.cedulas[i][1] += quantidade;
                return "Reposição de " + cedula + " feita com sucesso";
            }
        }    GUI janela = new GUI(CaixaEletronico.class);
    janela.show();

        return "Cédula inválida!";
    }

    @Override
    public String armazenaCotaMinima(Integer minimo) {
        this.cotaMinima = minimo;
        return "Cota mínima configurada para " + minimo;
    }

    public String getHistoricoSaques() {
        return this.historicoSaques.isEmpty() ? "Nenhuma operação realizada" : this.historicoSaques;
    }

    public static void main(String[] args) {
        GUI janela = new GUI(CaixaEletronico.class);
        janela.show();
    }
}
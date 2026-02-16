package Modelos.ModelosPrincipais;

import java.util.ArrayList;

public class PedidoModel extends ArrayList<PedidoModel> {
    private int numeroDoPedido;
    private float totalDoPedido;
    private String cupomFiscalDoPedido;

    public String getCupomFiscalDoPedido() {
        return cupomFiscalDoPedido;
    }

    public void setCupomFiscalDoPedido(String cupomFiscalDoPedido) {
        this.cupomFiscalDoPedido = cupomFiscalDoPedido;
    }

    public float getTotalDoPedido() {
        return totalDoPedido;
    }

    public void setNumeroDoPedido(int numeroDoPedido) {
        this.numeroDoPedido = numeroDoPedido;
    }

    public void setTotalDoPedido(float totalDoPedido) {
        this.totalDoPedido = totalDoPedido;
    }

    public int getNumeroDoPedido() {
        return numeroDoPedido;
    }
}

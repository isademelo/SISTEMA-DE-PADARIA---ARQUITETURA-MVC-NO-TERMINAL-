package View.ViewDosModelosPrincipais;

import Modelos.ModelosPrincipais.ProdutoModel;

public class CardapioView{
    private static String CABECALHO_CARDAPIO = """
    --------------------------------------------------------
                             CARDÁPIO
    --------------------------------------------------------""";

    public static String getCabecalhoCardapio() {
        return CABECALHO_CARDAPIO;
    }

    private static String STRING_PARA_SER_FORMATADA_NO_CARDAPIO = "%2d - %-25s |  R$ %8.2f";

    public static String exibirCardapioFormatado(ProdutoModel produto){
        return String.format(STRING_PARA_SER_FORMATADA_NO_CARDAPIO, produto.getIdDoProduto() ,produto.getNomeDoProduto(), produto.getPreco());
    }

    public static String COLUNAS_CARDAPIO_EXIBIR (){
        return String.format("%2s | %-25s | %s", "ID", "PRODUTO", "PREÇO");
    }
}

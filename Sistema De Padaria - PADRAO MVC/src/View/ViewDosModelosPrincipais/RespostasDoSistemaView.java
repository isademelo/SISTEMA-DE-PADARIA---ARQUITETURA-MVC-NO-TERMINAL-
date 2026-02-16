package View.ViewDosModelosPrincipais;

public class RespostasDoSistemaView {
    private static String SEPARADOR_DE_ITENS = "--------------------------------------------------------";
    static private String MENSAGEM_ERRO_NUMERO_INVALIDO = "Você digitou um número inválido, tente novamente.";
    static private String MENSAGEM_ERRO_DIGITOU_ERRADO = "Você digitou incorretamente, tente novamente: ";
    private static String MENSAGEM_NENHUM_PRODUTO_ENCONTRADO_NO_CARDAPIO = "Nenhum produto encontrado no cardápio. Voltando para o menu principal...";

    public static String getMensagemNenhumProdutoEncontradoNoCardapio() {
        return MENSAGEM_NENHUM_PRODUTO_ENCONTRADO_NO_CARDAPIO;
    }
    public static String getMensagemErroNumeroInvalido() {
        return MENSAGEM_ERRO_NUMERO_INVALIDO;
    }
    public static String getMensagemErroDigitouErrado() {
        return MENSAGEM_ERRO_DIGITOU_ERRADO;
    }
    public static String getSeparadorDeItens() {
        return SEPARADOR_DE_ITENS;
    }
}

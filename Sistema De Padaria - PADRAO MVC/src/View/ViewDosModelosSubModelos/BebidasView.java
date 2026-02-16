package View.ViewDosModelosSubModelos;

public class BebidasView {

    private static String CADASTRAR_BEBIDAS_CABECALHO = """
           --------------------------------------------------------
                                CADASTRAR BEBIDA
            --------------------------------------------------------""";
    private static String DIGITAR_NOME_DA_BEBIDA = "Digite o nome da bebida que vai ser cadastrada: ";
    private static String DIGITAR_PRECO_DA_BEBIDA = "Digite o preço da bebida que vai ser cadastrada: ";
    public static String getCADASTRAR_BEBIDAS_CABECALHO() {
        return CADASTRAR_BEBIDAS_CABECALHO;
    }
    public static String getDIGITAR_NOME_DA_BEBIDA() {
        return DIGITAR_NOME_DA_BEBIDA;
    }
    public static String getDIGITAR_PRECO_DA_BEBIDA() {
        return DIGITAR_PRECO_DA_BEBIDA;
    }

}

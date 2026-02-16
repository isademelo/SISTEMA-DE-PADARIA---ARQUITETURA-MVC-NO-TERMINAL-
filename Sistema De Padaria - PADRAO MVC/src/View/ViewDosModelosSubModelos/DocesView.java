package View.ViewDosModelosSubModelos;

public class DocesView {

    private static String CADASTRAR_DOCES_CABECALHO = """
           --------------------------------------------------------
                                CADASTRAR DOCES
            --------------------------------------------------------""";
    private static String DIGITAR_NOME_DO_DOCE = "Digite o nome do doce que vai ser cadastrado: ";
    private static String DIGITAR_PRECO_DO_DOCE = "Digite o preço do doce que vai sser cadastrado: ";
    public static String getCADASTRAR_DOCES_CABECALHO() {
        return CADASTRAR_DOCES_CABECALHO;
    }
    public static String getDIGITAR_NOME_DO_DOCE() {
        return DIGITAR_NOME_DO_DOCE;
    }
    public static String getDIGITAR_PRECO_DO_DOCE() {
        return DIGITAR_PRECO_DO_DOCE;
    }
}

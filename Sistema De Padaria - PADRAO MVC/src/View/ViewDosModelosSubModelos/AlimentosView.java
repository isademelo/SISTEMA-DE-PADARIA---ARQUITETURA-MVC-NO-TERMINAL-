package View.ViewDosModelosSubModelos;

public class AlimentosView {

    private static String CADASTRAR_ALIMENTOS_CABECALHO = """
           --------------------------------------------------------
                                CADASTRAR ALIMENTO
            --------------------------------------------------------""";
    private static String DIGITAR_NOME_DO_ALIMENTO = "Digite o nome do alimento que vai ser cadastrado: ";
    private static String DIGITAR_PRECO_DO_ALIMENTO = "Digite o preço do alimento que vai ser cadastrado: ";
    public static String getCADASTRAR_ALIMENTOS_CABECALHO() {
        return CADASTRAR_ALIMENTOS_CABECALHO;
    }
    public static String getDIGITAR_NOME_DO_ALIMENTO() {
        return DIGITAR_NOME_DO_ALIMENTO;
    }
    public static String getDIGITAR_PRECO_DO_ALIMENTO() {
        return DIGITAR_PRECO_DO_ALIMENTO;
    }
}

package View.ViewDosModelosPrincipais;
import Modelos.ModelosPrincipais.ProdutoModel;

public class ProdutoView {

    private static String REVISAO_DE_DADOS_ANTES_DE_ALTERAR_INFORMACOES_DO_PRODUTO  = """

            REVISÃO DAS INFORMAÇÕES ANTIGAS DO PRODUTO
            
            ID: %s
            Nome: %s
            Preço: %.2f
            
            REVISÃO DAS INFORMAÇÕES NOVAS DO PRODUTO
            
            ID: %s
            Nome: %s
            Preço: %.2f
            
            Confirmar alteração no cadastro do produto? (S/N)""";


    public static String revisandoDadosDoProduto (ProdutoModel produtoAntigo, ProdutoModel produtoNovo){
        return String.format(REVISAO_DE_DADOS_ANTES_DE_ALTERAR_INFORMACOES_DO_PRODUTO, produtoAntigo.getIdDoProduto(), produtoAntigo.getNomeDoProduto(), produtoAntigo.getPreco(), produtoNovo.getIdDoProduto(), produtoNovo.getNomeDoProduto(), produtoNovo.getPreco());
    }

    static private String CABECALHO_CADASTRO_PRODUTO = """
            --------------------------------------------------------
                                CADASTRAR PRODUTO
            --------------------------------------------------------""";

    static private String CABECALHO_REMOVER_PRODUTO_DO_SISTEMA = """
            --------------------------------------------------------
                                 REMOVER PRODUTO
            --------------------------------------------------------""";

    private static String CABECALHO_EDITAR_INFORMACOES_DO_PRODUTO = """  
            --------------------------------------------------------
                        EDITAR INFORMAÇÕES DO PRODUTO
            --------------------------------------------------------""";

    private static String PRODUTO_NO_SISTEMA_QUAL_OPCAO_QUER_ALTERAR =
            """
            digite qual opção você quer alterar no cadastro do produto:
            
            1 - NOME DO PRODUTO
            2 - PREÇO
            
            5 - SAIR""";

    private static String DIGITE_O_NOVO_PRECO_DO_PRODUTO = "Digite o novo preço do produto: ";
    private static String DIGITE_O_NOVO_NOME_DO_PRODUTO = "Digite o novo nome do produto: ";
    private static String O_PRODUTO_FOI_ENCONTRADO_NO_SISTEMA = "O produto foi encontrado no sistema...";
    private static String OPCAO_ALTERAR_NOME_DO_PRODUTO = "Você escolheu a opção de alterar o nome, digite o id vinculado ao cliente: ";
    private static String NAO_ENCONTRAMOS_NENHUM_PRODUTO_COM_ESSA_INFORMACAO = "Não encontramos nenhum produto com essa informação.";
    private static String DIGITE_O_NOME_DO_PRODUTO_QUE_VAI_SER_REMOVIDO = "Digite o nome do produto que vai ser removido.";
    private static String NAO_HA_NENHUM_PRODUTO_CADASTRADO_NO_SISTEMA = "Não há nenhum produto cadastrado no sistema.";
    private static String INPUT_NOME_DO_PRODUTO = "nome do produto: ";
    private static String INPUT_PRECO_DO_PRODUTO = "preco do produto: ";
    private static String PRODUTO_CADASTRADO_COM_SUCESSO = "Produto cadastrado com sucesso!";
    private static String VOCE_CONFIRMA_O_CADASTRO_DESSE_PRODUTO = "Você confirma o cadastro desse produto? (S/N)";
    private static String CADASTRO_DO_PRODUTO_FOI_CANCELADO = "O cadastro do produto foi cancelado, voltando ao menu principal...";
    private static String PRODUTO_ENCONTRADO = "Produto encontrado pelo sistema: Nome: %s          Preço: R$ %.1f";
    private static String informacoesDoProdutoQueVaiSerRemovido = "O produto foi encontrado. Nome: %s  Preço: R% %.2f, você confirma a remoção desse item do sistema? (S/N)";
    private static String PRODUTO_REMOVIDO_COM_SUCESSO = "Produto removido com sucesso!";
    private static String REMOCAO_DO_PRODUTO_CANCELADA = "A remoção do produto foi cancelada...";

    public static String getDigiteONovoPrecoDoProduto() {
        return DIGITE_O_NOVO_PRECO_DO_PRODUTO;
    }

    public static String getDigiteONovoNomeDoProduto() {
        return DIGITE_O_NOVO_NOME_DO_PRODUTO;
    }

    public static String getoProdutoFoiEncontradoNoSistema() {
        return O_PRODUTO_FOI_ENCONTRADO_NO_SISTEMA;
    }

    public static String getOpcaoAlterarNomeDoProduto() {
        return OPCAO_ALTERAR_NOME_DO_PRODUTO;
    }

    public static String getCabecalhoEditarInformacoesDoProduto() {
        return CABECALHO_EDITAR_INFORMACOES_DO_PRODUTO;
    }

    public static String getProdutoNoSistemaQualOpcaoQuerAlterar() {
        return PRODUTO_NO_SISTEMA_QUAL_OPCAO_QUER_ALTERAR;
    }

    public static String getCabecalhoRemoverProdutoDoSistema() {
        return CABECALHO_REMOVER_PRODUTO_DO_SISTEMA;
    }

    public static String getRemocaoDoProdutoCancelada() {
        return REMOCAO_DO_PRODUTO_CANCELADA;
    }

    public static String getProdutoRemovidoComSucesso() {
        return PRODUTO_REMOVIDO_COM_SUCESSO;
    }

    public static String informacoesDoProdutoEPedidoDeConfirmacaoDeRemocao (ProdutoModel produto){
        return String.format(informacoesDoProdutoQueVaiSerRemovido, produto.getNomeDoProduto(), produto.getPreco());
    }

    public static String getDigiteONomeDoProdutoQueVaiSerRemovido() {
        return DIGITE_O_NOME_DO_PRODUTO_QUE_VAI_SER_REMOVIDO;
    }

    public static String getNaoHaNenhumProdutoCadastradoNoSistema() {
        return NAO_HA_NENHUM_PRODUTO_CADASTRADO_NO_SISTEMA;
    }

    public static String getNaoEncontramosNenhumProdutoComEssaInformacao() {
        return NAO_ENCONTRAMOS_NENHUM_PRODUTO_COM_ESSA_INFORMACAO;
    }

    public static String printarProdutoEncontrado (ProdutoModel produto){
        return String.format(PRODUTO_ENCONTRADO, produto.getNomeDoProduto(), produto.getPreco());
    }
    public static String getCadastroDoProdutoFoiCancelado() {
        return CADASTRO_DO_PRODUTO_FOI_CANCELADO;
    }

    public static String getVoceConfirmaOCadastroDesseProduto() {
        return VOCE_CONFIRMA_O_CADASTRO_DESSE_PRODUTO;
    }

    public static String getProdutoCadastradoComSucesso() {
        return PRODUTO_CADASTRADO_COM_SUCESSO;
    }

    static private String MENU_TIPO_DO_PRODUTO_CADASTRADO = """
            Qual tipo de produto você quer cadastrar
            1 - Alimento
            2 - Bebida
            3 - Doces
            
            Resposta: """;

    public static String getMenuTipoDoProdutoCadastrado() {
        return MENU_TIPO_DO_PRODUTO_CADASTRADO;
    }

    public static String getCabecalhoCadastroProduto() {
        return CABECALHO_CADASTRO_PRODUTO;
    }

    public static String getInputNomeDoProduto() {
        return INPUT_NOME_DO_PRODUTO;
    }

    public static String getInputPrecoDoProduto() {
        return INPUT_PRECO_DO_PRODUTO;
    }
}

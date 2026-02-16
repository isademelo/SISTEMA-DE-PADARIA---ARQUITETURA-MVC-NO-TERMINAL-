package View.ViewDosModelosPrincipais;

import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.ModelosPrincipais.ProdutoModel;

public class PedidosView {
    private static String CABECALHO_CRIAR_PEDIDO = """
            ----------------------------------------------
                           CRIAR PEDIDO
            ----------------------------------------------""";

    private static String SOLICITAR_ITEM_DO_PEDIDO_QUE_VAI_SER_ADICIONADO_NO_PEDIDO = "Digite o nome do item que vai ser adicionado no pedido: ";
    private static String CONFIRMAR_QUE_O_ITEM_VAI_SER_ADICIONADO_NO_PEDIDO = "O item %s vai ser adicionado no pedido. Confirmar? (S/N)";
    private static String CONFIMAR_QUE_O_ITEM_FOI_ADICIONADO_COM_SUCESSO = "Item adicionado com sucesso!";
    private static String DIGITE_O_NOME_DO_PRODUTO_QUE_VAI_SER_ADICIONADO_AO_PEDIDO = "Digite o nome ou o id do produto que vai ser adicionado ao pedido:";
    private static String A_ADICAO_DO_ITEM_FOI_CANCELADA = "A adição do item foi cancelada.";
    private static String ADICIONAR_OUTRO_ITEM = "Você deseja adicionar outro item (S/N)";
    private static String QUAL_A_QUANTIDADE_DO_ITEM_VAI_SER_ADICIONADA = "Qual a quantidade desse item que você quer adicionar: ";
    private static String CONFIRMAR_CRIACAO_DO_PEDIDO = "ConfirmarCriação do pedido? (S/N)";
    private static String PEDIDO_CRIADO_COM_SUCESSO = "Pedido criado com sucesso...";
    private static String PEDIDO_CANCELADO = "O pedido foi cancelado...";

    public static String getPedidoCancelado() {
        return PEDIDO_CANCELADO;
    }

    public static String getPedidoCriadoComSucesso() {
        return PEDIDO_CRIADO_COM_SUCESSO;
    }

    public static String getConfirmarCriacaoDoPedido() {
        return CONFIRMAR_CRIACAO_DO_PEDIDO;
    }

    public static String getQualAQuantidadeDoItemVaiSerAdicionada() {
        return QUAL_A_QUANTIDADE_DO_ITEM_VAI_SER_ADICIONADA;
    }

    public static String getAdicionarOutroItem() {
        return ADICIONAR_OUTRO_ITEM;
    }

    public static String getaAdicaoDoItemFoiCancelada() {
        return A_ADICAO_DO_ITEM_FOI_CANCELADA;
    }

    public static String getDigiteONomeDoProdutoQueVaiSerAdicionadoAoPedido() {
        return DIGITE_O_NOME_DO_PRODUTO_QUE_VAI_SER_ADICIONADO_AO_PEDIDO;
    }

    public static String getConfimarQueOItemFoiAdicionadoComSucesso() {
        return CONFIMAR_QUE_O_ITEM_FOI_ADICIONADO_COM_SUCESSO;
    }

    public static String confirmarSeOItemVaiSerAdicionadoNoPedido (ProdutoModel produtoDaLista){
        return String.format(CONFIRMAR_QUE_O_ITEM_VAI_SER_ADICIONADO_NO_PEDIDO, produtoDaLista.getNomeDoProduto());
    }

    public static String getCabecalhoCriarPedido() {
        return CABECALHO_CRIAR_PEDIDO;
    }

    private static String SOLICITAR_CPF_DO_CLIENTE = "Digite o CPF do cliente, para verificação se o cliente ja foi cadastrado";

    public static String getSolicitarCpfDoCliente() {
        return SOLICITAR_CPF_DO_CLIENTE;
    }

}

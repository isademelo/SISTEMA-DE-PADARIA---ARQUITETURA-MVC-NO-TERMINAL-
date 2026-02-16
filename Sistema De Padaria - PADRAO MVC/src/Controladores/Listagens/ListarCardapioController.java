package Controladores.Listagens;
import Modelos.ModelosPrincipais.ProdutoModel;
import Modelos.Repositorios.ProdutoRepository;
import View.ViewDosModelosPrincipais.CardapioView;

public class ListarCardapioController {
    public static void ListarCardapio(){
        System.out.println(CardapioView.getCabecalhoCardapio());
        System.out.println(CardapioView.COLUNAS_CARDAPIO_EXIBIR());
            for (ProdutoModel produto : ProdutoRepository.listaDeProdutos) {
                System.out.println(CardapioView.exibirCardapioFormatado(produto));
            }
    }
}

package Controladores.Remoções;
import Modelos.ModelosPrincipais.ProdutoModel;
import Modelos.Repositorios.ProdutoRepository;
import View.ViewDosModelosPrincipais.ProdutoView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import java.util.Scanner;

public class RemoverProdutosDoSistemaController {
    public static void removerProdutosDoSistema(){
        System.out.println(ProdutoView.getCabecalhoRemoverProdutoDoSistema());
        if (ProdutoRepository.listaDeProdutos.isEmpty()){
            System.out.println(ProdutoView.getNaoHaNenhumProdutoCadastradoNoSistema());
        } else {

            Scanner entradaDeDadosDoProduto = new Scanner (System.in);
            System.out.println(ProdutoView.getDigiteONomeDoProdutoQueVaiSerRemovido());
            String produtoEscolhido = entradaDeDadosDoProduto.nextLine().trim();

            while (produtoEscolhido.isEmpty()){
                System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                produtoEscolhido = entradaDeDadosDoProduto.nextLine().trim();
            }

            ProdutoModel produtoEncontrado = null;

            for (ProdutoModel produto : ProdutoRepository.listaDeProdutos){
                if (produtoEscolhido.equalsIgnoreCase(produto.getNomeDoProduto())) {
                    produtoEncontrado = produto;
                    break;
                }
            }

            if (produtoEncontrado == null){
                System.out.println(ProdutoView.getNaoEncontramosNenhumProdutoComEssaInformacao());
                return;
            }

            System.out.println(ProdutoView.informacoesDoProdutoEPedidoDeConfirmacaoDeRemocao(produtoEncontrado));
            char confirmarRemocaoDoProduto = entradaDeDadosDoProduto.nextLine().toUpperCase().charAt(0);

            while (confirmarRemocaoDoProduto != 'S' && confirmarRemocaoDoProduto != 'N'){
                System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                confirmarRemocaoDoProduto = entradaDeDadosDoProduto.nextLine().toUpperCase().charAt(0);
            }

            if(confirmarRemocaoDoProduto == 'S'){
                ProdutoRepository.listaDeProdutos.remove(produtoEncontrado);
                System.out.println(ProdutoView.getProdutoRemovidoComSucesso());
            } else if (confirmarRemocaoDoProduto == 'N'){
                System.out.println(ProdutoView.getRemocaoDoProdutoCancelada());
            }
        }
    }
}

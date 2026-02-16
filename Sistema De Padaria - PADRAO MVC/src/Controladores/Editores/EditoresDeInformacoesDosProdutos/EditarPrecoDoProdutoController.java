package Controladores.Editores.EditoresDeInformacoesDosProdutos;
import Modelos.ModelosPrincipais.ProdutoModel;
import Modelos.Repositorios.ProdutoRepository;
import View.ViewDosModelosPrincipais.CardapioView;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.ProdutoView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import java.util.Scanner;

public class EditarPrecoDoProdutoController {
    public static void alterarPrecoDoProduto (){
        if (ProdutoRepository.listaDeProdutos.isEmpty()){
            System.out.println(ProdutoView.getNaoHaNenhumProdutoCadastradoNoSistema());
        } else {
            Scanner entradaDeDados = new Scanner(System.in);

            System.out.println(CardapioView.COLUNAS_CARDAPIO_EXIBIR());

            for (ProdutoModel produto : ProdutoRepository.listaDeProdutos){
                System.out.println(CardapioView.exibirCardapioFormatado(produto));
            }

            System.out.println(ProdutoView.getOpcaoAlterarNomeDoProduto());
            int idDoProdutoEscolhido = entradaDeDados.nextInt();
            entradaDeDados.nextLine();

            ProdutoModel produtoEncontrado = null;
            ProdutoModel produtoComInformacoesAntigas = null;

            for (ProdutoModel produto : ProdutoRepository.listaDeProdutos){
                if (produto.getIdDoProduto() ==  idDoProdutoEscolhido){
                    produtoEncontrado = produto;
                    produtoComInformacoesAntigas= produto;
                    break;
                }
            }

            if (produtoEncontrado == null){
                System.out.println(ProdutoView.getNaoEncontramosNenhumProdutoComEssaInformacao());
            } else {
                System.out.println(ProdutoView.printarProdutoEncontrado(produtoEncontrado));
                System.out.println(ProdutoView.getDigiteONovoPrecoDoProduto());
               double novoPrecoDoProduto = entradaDeDados.nextDouble();

                ProdutoModel produtoComInformacoesNovas = new ProdutoModel();

                produtoComInformacoesNovas.setIdDoProduto(produtoEncontrado.getIdDoProduto());
                produtoComInformacoesNovas.setNomeDoProduto(produtoEncontrado.getNomeDoProduto());
                produtoComInformacoesNovas.setPreco(novoPrecoDoProduto);

                while (novoPrecoDoProduto < 0.1){
                    System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                    novoPrecoDoProduto = entradaDeDados.nextDouble();
                }

                System.out.println(ProdutoView.revisandoDadosDoProduto(produtoComInformacoesAntigas, produtoComInformacoesNovas));
                char confirmacaoDaAlteracao = entradaDeDados.next().toUpperCase().charAt(0);

                while (confirmacaoDaAlteracao != 'S' &&  confirmacaoDaAlteracao != 'N'){
                    System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                    confirmacaoDaAlteracao = entradaDeDados.next().toUpperCase().charAt(0);
                }

                if (confirmacaoDaAlteracao == 'S'){
                    produtoEncontrado.setPreco(novoPrecoDoProduto);
                    System.out.println(ClienteView.getInformacaoAlteradaComSucesso());
                } else {
                    System.out.println(ClienteView.getAlteracaoDeCadastroCancelada());
                }
            }

        }
    }
}

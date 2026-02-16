package Controladores.Editores;
import Controladores.Editores.EditoresDeInformacoesDosProdutos.EditarNomeDoProdutoController;
import Controladores.Editores.EditoresDeInformacoesDosProdutos.EditarPrecoDoProdutoController;
import Modelos.Repositorios.ProdutoRepository;
import View.ViewDosModelosPrincipais.ProdutoView;
import java.util.Scanner;

public class EditorDeInformacoesDosProdutosController {
    public static void editarInformacoesDosProdutos() {
        Scanner entradaDeDadosDoProdutoQueVaiSerEditado = new Scanner(System.in);
        System.out.println(ProdutoView.getCabecalhoEditarInformacoesDoProduto());

        if (ProdutoRepository.listaDeProdutos.isEmpty()) {
            System.out.println(ProdutoView.getNaoHaNenhumProdutoCadastradoNoSistema());
        } else {
            System.out.println(ProdutoView.getProdutoNoSistemaQualOpcaoQuerAlterar());
            byte escolhaDoMenuDeAlteracaoDeInformacoesDoProduto = entradaDeDadosDoProdutoQueVaiSerEditado.nextByte();
            entradaDeDadosDoProdutoQueVaiSerEditado.nextInt();
            switch (escolhaDoMenuDeAlteracaoDeInformacoesDoProduto) {

                case 1:
                    EditarNomeDoProdutoController.editarNomeDoProduto();
                    break;

                case 2:
                    EditarPrecoDoProdutoController.alterarPrecoDoProduto();
                    break;

            }
        }
    }
}

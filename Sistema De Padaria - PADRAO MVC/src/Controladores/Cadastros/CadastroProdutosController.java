package Controladores.Cadastros;

import View.ViewDosModelosPrincipais.ProdutoView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;

import java.util.Scanner;

public class CadastroProdutosController {
    static Scanner INPUT_DADOS_PRODUTO = new Scanner(System.in);

    public static void cadastrarProdutosNoSistema(){

        System.out.println(ProdutoView.getCabecalhoCadastroProduto());
        System.out.println(ProdutoView.getMenuTipoDoProdutoCadastrado());

        byte tipoDoProduto = INPUT_DADOS_PRODUTO.nextByte();

        while (tipoDoProduto < 0){
            System.out.println(RespostasDoSistemaView.getMensagemErroNumeroInvalido());
            tipoDoProduto = INPUT_DADOS_PRODUTO.nextByte();
        }

        switch (tipoDoProduto){
            case 1:
                CadastroAlimentoController.cadastrarAlimento();
                break;

            case 2:
                CadastroBebidasController.cadastrarBebidas();
                break;

            case 3:
                CadastroDocesController.cadastrarDoces();
                break;
        }
    }

}

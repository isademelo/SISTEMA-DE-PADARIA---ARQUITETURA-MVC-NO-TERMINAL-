package Controladores.SistemaPrincipal;
import Controladores.Cadastros.CadastroProdutosController;
import Controladores.Cadastros.CadastrosClientesController;
import Controladores.Editores.EditorDeInformacoesDoClienteController;
import Controladores.Editores.EditorDeInformacoesDosProdutosController;
import Controladores.Listagens.ListarCardapioController;
import Controladores.Listagens.ListarClientesCadastradosController;
import Controladores.Pedidos.CriarPedidoController;
import Controladores.Remoções.RemoverClientesController;
import Controladores.Remoções.RemoverProdutosDoSistemaController;
import View.ViewDosModelosPrincipais.MainView;
import java.util.Scanner;

public class PrincipalSistemaDaPadariaController {

    static Scanner ENTRADA_DE_DADOS_DO_USUARIO = new Scanner(System.in);
    public static void controllerPrincipalSistemaDaPadaria(){

        System.out.println(MainView.getMenuPrincipal());
        byte ENTRADA_RESPOSTA_MENU_PRINCIPAL = ENTRADA_DE_DADOS_DO_USUARIO.nextByte();

        while (ENTRADA_RESPOSTA_MENU_PRINCIPAL != 0){
            switch (ENTRADA_RESPOSTA_MENU_PRINCIPAL){
                case 1:
                    CadastroProdutosController.cadastrarProdutosNoSistema();
                    break;

                case 2:
                    ListarCardapioController.ListarCardapio();
                    break;

                case 3:
                    CriarPedidoController.criarPedido();
                    break;
                case 4:
                    CadastrosClientesController.cadastroClientes();
                    break;
                case 5:
                    ListarClientesCadastradosController.listarClientesCadastradosNoSistema();
                    break;
                case 6:
                    RemoverClientesController.removerClientes();
                    break;

                case 7:
                    RemoverProdutosDoSistemaController.removerProdutosDoSistema();
                    break;

                case 8:
                    EditorDeInformacoesDoClienteController.editarInformacoesDosClientes();
                    break;

                case 9:
                    EditorDeInformacoesDosProdutosController.editarInformacoesDosProdutos();
                    break;
            }

            System.out.println(MainView.getMenuPrincipal());
            ENTRADA_RESPOSTA_MENU_PRINCIPAL = ENTRADA_DE_DADOS_DO_USUARIO.nextByte();
        }
    }
}

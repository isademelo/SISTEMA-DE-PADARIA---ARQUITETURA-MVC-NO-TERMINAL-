package Controladores.Pedidos;
import Controladores.Cadastros.CadastrosClientesController;
import Controladores.Listagens.ListarCardapioController;
import Controladores.SistemaPrincipal.PrincipalSistemaDaPadariaController;
import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.ModelosPrincipais.PedidoModel;
import Modelos.ModelosPrincipais.ProdutoModel;
import Modelos.Repositorios.ClienteRepository;
import Modelos.Repositorios.ProdutoRepository;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.PedidosView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import java.util.List;
import java.util.Scanner;

public class CriarPedidoController {

    public static void criarPedido() {

        List<ClienteModel> listaDeClientes = ClienteRepository.listarTodos();
        PedidoModel pedido = new PedidoModel();
        Scanner entradaDeDadosDoPedido = new Scanner(System.in);

        System.out.println(PedidosView.getCabecalhoCriarPedido());
        System.out.println(PedidosView.getSolicitarCpfDoCliente());

        String cpf = entradaDeDadosDoPedido.nextLine().trim().replaceAll("\\D", "");

        while (cpf.isEmpty() || cpf.length() != 11) {
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            cpf = entradaDeDadosDoPedido.nextLine().trim().replaceAll("\\D", "");
        }

        if (listaDeClientes.isEmpty()) {
            System.out.println(ClienteView.getNaoFoiEncontradoNenhumCliente());
            byte escolha = entradaDeDadosDoPedido.nextByte();

            while (escolha < 1 || escolha > 2) {
                System.out.println(RespostasDoSistemaView.getMensagemErroNumeroInvalido());
                escolha = entradaDeDadosDoPedido.nextByte();
            }

            entradaDeDadosDoPedido.nextLine();

            if (escolha == 1) {
                CadastrosClientesController.cadastroClientes();
            } else {
                PrincipalSistemaDaPadariaController.controllerPrincipalSistemaDaPadaria();
            }
            return;
        }

        System.out.println(RespostasDoSistemaView.getSeparadorDeItens());
        System.out.println(ClienteRepository.buscarPorCpf(cpf));

        StringBuilder cupomFiscal = new StringBuilder();
        double valorTotal = 0;
        boolean adicionarOutro = false;

        do {
            if (ProdutoRepository.listaDeProdutos.isEmpty()) {
                System.out.println(RespostasDoSistemaView.getMensagemNenhumProdutoEncontradoNoCardapio());
            } else {
                ListarCardapioController.ListarCardapio();
                System.out.println(PedidosView.getDigiteONomeDoProdutoQueVaiSerAdicionadoAoPedido());

                ProdutoModel produto = buscarProdutoPorIdOuNome(entradaDeDadosDoPedido);

                if (produto == null) {
                    continue;
                }

                System.out.println(PedidosView.confirmarSeOItemVaiSerAdicionadoNoPedido(produto));

                if (!confirmar(entradaDeDadosDoPedido)) {
                    System.out.println(PedidosView.getaAdicaoDoItemFoiCancelada());
                    continue;
                }

                System.out.println(PedidosView.getQualAQuantidadeDoItemVaiSerAdicionada());
                int quantidade = Integer.parseInt(entradaDeDadosDoPedido.nextLine());

                cupomFiscal.append(
                        String.format(
                                "Item: %s  Quantidade: %d  Preço: %.2f%n",
                                produto.getNomeDoProduto(),
                                quantidade,
                                produto.getPreco()
                        )
                );

                valorTotal += produto.getPreco() * quantidade;

                System.out.println(PedidosView.getConfimarQueOItemFoiAdicionadoComSucesso());
                System.out.println(PedidosView.getAdicionarOutroItem());

                adicionarOutro = confirmar(entradaDeDadosDoPedido);
            }
        } while (adicionarOutro);
            String notaDoPedido = """
                    ----- CUPOM FISCAL -----
                    %s 
                    TOTAL: R$ %.2f%n""".formatted(cupomFiscal, valorTotal);

        System.out.println(notaDoPedido);
        System.out.println(PedidosView.getConfirmarCriacaoDoPedido());

        char confirmarCriacaoDoPedido = entradaDeDadosDoPedido.nextLine().toUpperCase().charAt(0);
            if (confirmarCriacaoDoPedido == 'S') {
                System.out.println(PedidosView.getPedidoCriadoComSucesso());
            } else if (confirmarCriacaoDoPedido == 'N') {
                System.out.println(PedidosView.getPedidoCancelado());
            }
        }

    private static ProdutoModel buscarProdutoPorIdOuNome(Scanner entradaDeDados) {

        String entrada = entradaDeDados.nextLine().trim().toUpperCase();

        while (entrada.isEmpty()) {
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            entrada = entradaDeDados.nextLine().trim().toUpperCase();
        }

        for (ProdutoModel produto : ProdutoRepository.listaDeProdutos) {

            if (entrada.matches("\\d+") &&
                    produto.getIdDoProduto() == Integer.parseInt(entrada)) {
                return produto;
            }

            if (produto.getNomeDoProduto().equalsIgnoreCase(entrada)) {
                return produto;
            }
        }

        System.out.println(RespostasDoSistemaView.getMensagemNenhumProdutoEncontradoNoCardapio());
        return null;
    }

    private static boolean confirmar(Scanner scanner) {
        char confirmacao = scanner.nextLine().toUpperCase().charAt(0);

        while (confirmacao != 'S' && confirmacao != 'N') {
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            confirmacao = scanner.nextLine().toUpperCase().charAt(0);
        }
        return confirmacao == 'S';
    }
}

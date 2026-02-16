package Controladores.Cadastros;
import Modelos.ModelosPrincipais.ProdutoModel;
import Modelos.Repositorios.ProdutoRepository;
import Modelos.SubModelos.DocesModel;
import View.ViewDosModelosPrincipais.ProdutoView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import View.ViewDosModelosSubModelos.DocesView;
import java.util.Scanner;

public class CadastroDocesController {
    static Scanner dadosDoDoce = new Scanner(System.in);

    static void cadastrarDoces (){

        System.out.println(DocesView.getCADASTRAR_DOCES_CABECALHO());
        DocesModel doceCadastrado = new DocesModel();

        System.out.println(DocesView.getDIGITAR_NOME_DO_DOCE());
        String nomeDoDoce = dadosDoDoce.nextLine().trim().toUpperCase();

        while (nomeDoDoce.isEmpty()){
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            nomeDoDoce = dadosDoDoce.nextLine().trim().toUpperCase();
        }

        System.out.println(DocesView.getDIGITAR_PRECO_DO_DOCE());
        Double precoDoDoce = dadosDoDoce.nextDouble();

        while (precoDoDoce < 0.1){
            System.out.println(RespostasDoSistemaView.getMensagemErroNumeroInvalido());
            precoDoDoce = dadosDoDoce.nextDouble();
        }

        System.out.println(ProdutoView.getVoceConfirmaOCadastroDesseProduto());
        char confirmaCadastroDoProduto = dadosDoDoce.next().charAt(0);

        if (confirmaCadastroDoProduto == 'S' || confirmaCadastroDoProduto == 's'){
            doceCadastrado.setNomeDoProduto(nomeDoDoce);
            doceCadastrado.setPreco(precoDoDoce);
            ProdutoRepository.adicionarProdutos(doceCadastrado);
            System.out.println(ProdutoView.getProdutoCadastradoComSucesso());
        } else if (confirmaCadastroDoProduto == 'N' || confirmaCadastroDoProduto == 'n'){
            System.out.println(ProdutoView.getCadastroDoProdutoFoiCancelado());
        } else {
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            confirmaCadastroDoProduto = dadosDoDoce.next().charAt(0);
        }
    }
}

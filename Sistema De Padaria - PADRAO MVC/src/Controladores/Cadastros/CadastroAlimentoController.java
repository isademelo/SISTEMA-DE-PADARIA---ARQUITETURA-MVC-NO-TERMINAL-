package Controladores.Cadastros;
import java.util.Scanner;
import Modelos.ModelosPrincipais.ProdutoModel;
import Modelos.Repositorios.ProdutoRepository;
import View.ViewDosModelosPrincipais.ProdutoView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import View.ViewDosModelosSubModelos.AlimentosView;

public class CadastroAlimentoController {
    static Scanner dadosDoAlimento = new Scanner(System.in);

    public static void cadastrarAlimento (){
        System.out.println(AlimentosView.getCADASTRAR_ALIMENTOS_CABECALHO());
        ProdutoModel alimentoCadastrado = new ProdutoModel();

        System.out.println(AlimentosView.getDIGITAR_NOME_DO_ALIMENTO());
        String nomeDoAlimentoDigitado = dadosDoAlimento.nextLine().trim().toUpperCase();

        while (nomeDoAlimentoDigitado.isEmpty()){
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            nomeDoAlimentoDigitado = dadosDoAlimento.nextLine().trim().toUpperCase();
        }

        System.out.println(AlimentosView.getDIGITAR_PRECO_DO_ALIMENTO());
        double precoDoAlimentoDigitado = dadosDoAlimento.nextDouble();

        while (precoDoAlimentoDigitado < 0.1){
            System.out.println(RespostasDoSistemaView.getMensagemErroNumeroInvalido());
            precoDoAlimentoDigitado = dadosDoAlimento.nextDouble();
        }

        System.out.println(ProdutoView.getVoceConfirmaOCadastroDesseProduto());
        char confirmaCadastroDoProduto = dadosDoAlimento.next().charAt(0);

        if (confirmaCadastroDoProduto == 'S' || confirmaCadastroDoProduto == 's'){
            alimentoCadastrado.setNomeDoProduto(nomeDoAlimentoDigitado);
            alimentoCadastrado.setPreco(precoDoAlimentoDigitado);
            ProdutoRepository.adicionarProdutos(alimentoCadastrado);
            System.out.println(ProdutoView.getProdutoCadastradoComSucesso());
        } else if (confirmaCadastroDoProduto == 'N' || confirmaCadastroDoProduto == 'n'){
            System.out.println(ProdutoView.getCadastroDoProdutoFoiCancelado());
        } else {
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            confirmaCadastroDoProduto = dadosDoAlimento.next().charAt(0);
        }
    }
}

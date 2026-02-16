package Controladores.Cadastros;
import java.util.Scanner;

import Modelos.ModelosPrincipais.ProdutoModel;
import Modelos.Repositorios.ProdutoRepository;
import Modelos.SubModelos.BebidasModel;
import View.ViewDosModelosPrincipais.ProdutoView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;
import View.ViewDosModelosSubModelos.BebidasView;

public class CadastroBebidasController {
    static Scanner dadosDaBebida = new Scanner(System.in);

    static void cadastrarBebidas(){

        System.out.println(BebidasView.getCADASTRAR_BEBIDAS_CABECALHO());
        BebidasModel bebidaCadastrada = new BebidasModel();

        System.out.println(BebidasView.getDIGITAR_NOME_DA_BEBIDA());
        String nomeDaBebida = dadosDaBebida.nextLine().toUpperCase().trim();

        while (nomeDaBebida.isEmpty()){
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            nomeDaBebida = dadosDaBebida.nextLine().trim().toUpperCase();
        }

        System.out.println(BebidasView.getDIGITAR_PRECO_DA_BEBIDA());
        double precoDaBebida = dadosDaBebida.nextDouble();

        while (precoDaBebida < 0.1){
            System.out.println(RespostasDoSistemaView.getMensagemErroNumeroInvalido());
            precoDaBebida = dadosDaBebida.nextDouble();
        }

        dadosDaBebida.nextLine();

        System.out.println(ProdutoView.getVoceConfirmaOCadastroDesseProduto());
        char confirmaCadastroDoProduto = dadosDaBebida.next().charAt(0);

        if (confirmaCadastroDoProduto == 'S' || confirmaCadastroDoProduto == 's'){
            bebidaCadastrada.setNomeDoProduto(nomeDaBebida);
            bebidaCadastrada.setPreco(precoDaBebida);
            ProdutoRepository.adicionarProdutos(bebidaCadastrada);
            System.out.println(ProdutoView.getProdutoCadastradoComSucesso());
        }  else if (confirmaCadastroDoProduto == 'N' || confirmaCadastroDoProduto == 'n'){
            System.out.println(ProdutoView.getCadastroDoProdutoFoiCancelado());
        } else {
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            confirmaCadastroDoProduto = dadosDaBebida.next().charAt(0);
        }
    }
}

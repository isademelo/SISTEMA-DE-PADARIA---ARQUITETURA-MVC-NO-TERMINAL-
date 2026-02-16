package Controladores.Editores;
import java.util.Scanner;

import Controladores.Editores.EditoresDeInformacoesDosClientes.EditarCPFDoClienteController;
import Controladores.Editores.EditoresDeInformacoesDosClientes.EditarEmailDoClienteController;
import Controladores.Editores.EditoresDeInformacoesDosClientes.EditarNomeDoClienteController;
import Controladores.Editores.EditoresDeInformacoesDosClientes.EditarTelefoneDoClienteController;
import Modelos.Repositorios.ClienteRepository;
import View.ViewDosModelosPrincipais.ClienteView;

public class EditorDeInformacoesDoClienteController {
    public static void editarInformacoesDosClientes() {
        Scanner entradaDeDadosDoClienteQueVaiSerEditado = new Scanner(System.in);
        System.out.println(ClienteView.getCabecalhoEditarInformacoesDoCliente());
        if (ClienteRepository.clientesCadastradosNoSistema.isEmpty()) {
            System.out.println(ClienteView.getNaoHaNenhumClienteCadastradoNoSistema());
        } else {
            System.out.println(ClienteView.getClienteNoSistemaQualOpcaoQuerAlterar());
            byte escolhaDoMenuDeAlteracaoDeInformacoesDoCliente = entradaDeDadosDoClienteQueVaiSerEditado.nextByte();

            switch (escolhaDoMenuDeAlteracaoDeInformacoesDoCliente) {
                case 1:
                    EditarNomeDoClienteController.editarNomeDoCliente();
                    break;

                case 2:
                    EditarTelefoneDoClienteController.editarTelefoneDoCliente();
                    break;
                case 3:
                    EditarEmailDoClienteController.editarEmailDoCliente();
                    break;

                case 4:
                    EditarCPFDoClienteController.editarCPFDoCliente();
                    break;

                case 5:
                    EditorDeInformacoesDosProdutosController.editarInformacoesDosProdutos();
                    break;
            }
        }
    }
}

package Controladores.Cadastros;
import Modelos.ModelosPrincipais.ClienteModel;
import Modelos.Repositorios.ClienteRepository;
import View.ViewDosModelosPrincipais.ClienteView;
import View.ViewDosModelosPrincipais.RespostasDoSistemaView;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class CadastrosClientesController {
    public static void cadastroClientes() {
        List<ClienteModel> listaDeClientes = ClienteRepository.listarTodos();
        Scanner entradaDeDadosDoCliente = new Scanner(System.in);
        Random idAleatorio = new Random();
        int idDoClienteEmNumero =  idAleatorio.nextInt(900000) + 100000;
        String idDoCliente = String.valueOf(idDoClienteEmNumero);

        ClienteModel clienteCadastrado = new ClienteModel();
        System.out.println(ClienteView.getCabecalhoCriarCadastroCliente());
        System.out.println(ClienteView.getDigitarNomeDoCliente());
        String nomeDoCliente = entradaDeDadosDoCliente.nextLine().trim().toUpperCase();

        while (nomeDoCliente.isEmpty() || nomeDoCliente.matches(".*\\d.*")) {
            System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
            nomeDoCliente = entradaDeDadosDoCliente.nextLine().toUpperCase();
        }

        System.out.println(ClienteView.getDigitarCpfDoCliente());
        String cpfDoCliente = entradaDeDadosDoCliente.nextLine().trim().replaceAll("\\D", "");

        boolean cpfJaExiste;

        do {
            cpfJaExiste = false;

            for (ClienteModel cliente : listaDeClientes) {
                if (cliente.getCpfDoCliente().equals(cpfDoCliente)) {
                    cpfJaExiste = true;
                    break;
                }
            }

            if (cpfDoCliente.isEmpty() || cpfDoCliente.length() != 11) {
                System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                cpfDoCliente = entradaDeDadosDoCliente.nextLine().trim().replaceAll("\\D", "");
            } else if (cpfJaExiste) {
                System.out.println(ClienteView.getClienteComEsseCpfJaFoiCadastradoNoSistema());
                cpfDoCliente = entradaDeDadosDoCliente.nextLine().trim().replaceAll("\\D", "");
            }

        } while (cpfDoCliente.isEmpty() || cpfDoCliente.length() != 11 || cpfJaExiste);

        System.out.println(ClienteView.getDigitarEmailDoCliente());
        String emailDoCliente = entradaDeDadosDoCliente.nextLine().trim().toLowerCase();

        boolean emailJaExiste;

        do {
            emailJaExiste= false;
            for (ClienteModel cliente : listaDeClientes) {
                if (cliente.getEmailDoCliente().equals(emailDoCliente)) {
                    emailJaExiste = true;
                    break;
                }
            }

            if (emailDoCliente.isEmpty() || !emailDoCliente.contains("@") || emailDoCliente.startsWith("@") || emailDoCliente.endsWith("@")) {
                System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                emailDoCliente = entradaDeDadosDoCliente.nextLine().trim().toLowerCase();
            } else if (emailJaExiste) {
                System.out.println(ClienteView.getClienteComEsseEmailJaFoiCadastradoNoSistema());
                emailDoCliente = entradaDeDadosDoCliente.nextLine().trim().toLowerCase();
            }
        } while (emailDoCliente.isEmpty() || !emailDoCliente.contains("@") || emailDoCliente.startsWith("@") || emailDoCliente.endsWith("@") || emailJaExiste);

        System.out.println(ClienteView.getDigitarTelefoneDoCliente());
        String telefoneDoCliente = entradaDeDadosDoCliente.nextLine().trim().replaceAll("\\D", "");

        boolean telefoneJaExiste;

        do {
            telefoneJaExiste = false;
            for (ClienteModel cliente : listaDeClientes) {
                if (cliente.getTelefoneDoCliente().equals(telefoneDoCliente)) {
                    telefoneJaExiste = true;
                    break;
                }
            }

            if (telefoneDoCliente.isEmpty() || telefoneDoCliente.length() != 11) {
                System.out.println(RespostasDoSistemaView.getMensagemErroDigitouErrado());
                telefoneDoCliente = entradaDeDadosDoCliente.nextLine().trim().replaceAll("\\D", "");
            } else if (telefoneJaExiste) {
                System.out.println(ClienteView.getClienteComEsseTelefoneJaFoiCadastradoNoSistema());
                telefoneDoCliente = entradaDeDadosDoCliente.nextLine().trim().replaceAll("\\D", "");
            }
        } while (telefoneDoCliente.isEmpty() || telefoneJaExiste || telefoneDoCliente.length() != 11);

        System.out.println(ClienteView.printarRevisaoDeDadosDoCliente(idDoCliente, nomeDoCliente, cpfDoCliente, emailDoCliente, telefoneDoCliente));
        char confirmacaoCadastroCliente = entradaDeDadosDoCliente.next().charAt(0);
        entradaDeDadosDoCliente.nextLine();

        if (confirmacaoCadastroCliente == 'S' || confirmacaoCadastroCliente == 's') {
            clienteCadastrado.setIdDoCliente(idDoCliente);
            clienteCadastrado.setCpfDoCliente(cpfDoCliente);
            clienteCadastrado.setNomeDoCliente(nomeDoCliente);
            clienteCadastrado.setEmailDoCliente(emailDoCliente);
            clienteCadastrado.setTelefoneDoCliente(telefoneDoCliente);
            ClienteRepository.adicionarClientes(clienteCadastrado);
            System.out.println(ClienteView.getClienteCadastradoComSucesso());
        } else {
            System.out.println(ClienteView.getCadastroDoClienteCancelado());
        }
    }
}

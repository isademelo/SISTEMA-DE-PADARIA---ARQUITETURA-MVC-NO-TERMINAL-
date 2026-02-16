package View.ViewDosModelosPrincipais;
import Modelos.ModelosPrincipais.ClienteModel;

public class ClienteView {

    private static String CABECALHO_REMOVER_CLIENTES_DO_SISTEMA = """
            --------------------------------------------------------
                           REMOVER CLIENTE DO SISTEMA 
            --------------------------------------------------------""";

    private static String CABECALHO_LISTAR_TODOS_OS_CLIENTES_CADASTRADOS_NO_SISTEMA = """
    --------------------------------------------------------
        LISTAR TODOS OS CLIENTES CADASTRADOS NO SISTEMA
    --------------------------------------------------------""";

    private static String CONFIRMAR_CADASTRO_DO_CLIENTE = """

            REVISÃO DE CADASTRO DO CLIENTE 
            
            ID: %s
            Nome: %s
            CPF: %s
            E-mail: %s
            Telefone: %s
            
            Confirmar o cadastro do cliente? (S/N)""";

    private static String NAO_FOI_ENCONTRADO_NENHUM_CLIENTE = """
            Não foi encontrado nenhum cliente no sistema com esse CPF, deseja criar um cadastro novo? 
            1 - SIM
            2 - NÃO
            resposta: """;

    private static String CABECALHO_CRIAR_CADASTRO_CLIENTE = """
            ----------------------------------------------
                       CRIAR CADASTRO DO CLIENTE
            ----------------------------------------------""";

    private static String INFORMACOES_DO_CLIENTE_CADASTRADO_NO_SISTEMA = """
            ID: %s
            Nome: %s
            CPF: %s
            E-mail: %s
            Telefone: %s""";

    private static String CABECALHO_EDITAR_INFORMACOES_DO_CLIENTE = """  
            --------------------------------------------------------
                        EDITAR INFORMAÇÕES DO CLIENTE
            --------------------------------------------------------""";

    private static String REVISAO_DE_DADOS_ANTES_DE_ALTERAR_INFORMACOES_DO_CLIENTE  = """

            REVISÃO DAS INFORMAÇÕES ANTIGAS DO CLIENTE 
            
            ID: %s
            Nome: %s
            CPF: %s
            E-mail: %s
            Telefone: %s
            
            REVISÃO DAS INFORMAÇÕES NOVAS DO CLIENTE 
            
            ID: %s
            Nome: %s
            CPF: %s
            E-mail: %s
            Telefone: %s
            
            Confirmar alteração no cadastro do cliente? (S/N)""";

    private static String DIGITE_O_NOVO_CPF_DO_CLIENTE = "Digite o novo CPF do cliente: ";
    private static String OPCAO_ALTERAR_CPF_DO_CLIENTE = "Você escolheu a opção de alterar o CPF, digite o id vinculado ao cliente:";
    private static String DIGITE_O_NOVO_TELEFONE_DO_CLIENTE = "Digite o novo telefone do cliente: ";
    private static String OPCAO_ALTERAR_TELEFONE_DO_CLIENTE = "Você escolheu a opção de alterar o telefone, digite o id vinculado ao cliente:";
    private static String DIGITE_O_NOVO_EMAIL_DO_CLIENTE = "Digite o novo email do cliente: ";
    private static String OPCAO_ALTERAR_EMAIL_DO_CLIENTE = "Você escolheu a opção de alterar o email, digite o id vinculado ao cliente: ";
    private static String ALTERACAO_DE_CADASTRO_CANCELADA = "A alteração de cadastro foi cancelada...";
    private static String INFORMACAO_ALTERADA_COM_SUCESSO = "Informação alterada com sucesso...";
    private static String DIGITE_O_NOVO_NOME_DO_CLIENTE = "Digite o novo nome do cliente: ";
    private static String O_CLIENTE_FOI_ENCONTRADO_NO_SISTEMA = "Cliente encontrado no sistema...";
    private static String OPCAO_ALTERAR_NOME_DO_CLIENTE = "Você escolheu a opção de alterar o nome, digite o id vinculado ao cliente: ";
    private static String DIGITE_O_NOME_DO_CLIENTE_QUE_VAI_SER_REMOVIDO_DO_SISTEMA = "Digite o nome do cliente que vai ser removido do sistema: ";
    private static String NAO_HA_NENHUM_CLIENTE_CADASTRADO_NO_SISTEMA = "Não há nenhum cliente cadastrado no sistema.";
    private static String CLIENTE_CADASTRADO_COM_SUCESSO = "Cliente cadastrado com sucesso! Voltando ao menu principal...";
    private static String DIGITAR_NOME_DO_CLIENTE = "Digite o nome do cliente: ";
    private static String DIGITAR_CPF_DO_CLIENTE = "Digite o cpf do cliente: ";
    private static String DIGITAR_EMAIL_DO_CLIENTE = "Digite o email do cliente: ";
    private static String DIGITAR_TELEFONE_DO_CLIENTE = "Digite o telefone do cliente, no padrão (xx) x xxxx-xxxx: ";
    private static String CLIENTE_COM_ESSE_CPF_JA_FOI_CADASTRADO_NO_SISTEMA = "Esse CPF ja foi cadastrado no sistema, tente novamente ";
    private static String CADASTRO_DO_CLIENTE_CANCELADO = "O cadastro do cliente foi cancelado, voltando para o menu principal...";
    private static String CLIENTE_COM_ESSE_TELEFONE_JA_FOI_CADASTRADO_NO_SISTEMA = "Esse telefone ja foi cadastrado no sistema, tente novamente...";
    private static String CLIENTE_COM_ESSE_EMAIL_JA_FOI_CADASTRADO_NO_SISTEMA = "Esse email ja foi cadastrado no sistema, tente novamente...";
    private static String CLIENTE_QUE_VAI_SER_REMOVIDO_FOI_ENCOTNRADO = "O usuario foi encontrado, você confirma a remoção dele no sistema? (S/N)";
    private static String NAO_ENCONTRAMOS_NENHUM_CLIENTE_COM_ESSA_INFORMACAO = "Não encontramos nenhum cliente com essa informação.";
    private static String A_REMOCAO_DO_CLIENTE_FOI_CANCELADA = "A remoção do cliente foi cancelada. ";
    private static String USUARIO_REMOVIDO_COM_SUCESSO = "Usuário removido com sucesso";
    private static String CLIENTE_NO_SISTEMA_QUAL_OPCAO_QUER_ALTERAR =
            """
            digite qual opção você quer alterar no cadastro do cliente:
            
            1 - NOME
            2 - TELEFONE
            3 - EMAIL
            4 - CPF
            
            5 - SAIR""";

    public static String getDigiteONovoCPFDoCliente() {
        return DIGITE_O_NOVO_CPF_DO_CLIENTE;
    }

    public static String getInformacaoAlteradaComSucesso() {
        return INFORMACAO_ALTERADA_COM_SUCESSO;
    }

    public static String getDigiteONovoEmailDoCliente() {
        return DIGITE_O_NOVO_EMAIL_DO_CLIENTE;
    }

    public static String getDigiteONovoNomeDoCliente() {
        return DIGITE_O_NOVO_NOME_DO_CLIENTE;
    }

    public static String getAlteracaoDeCadastroCancelada() {
        return ALTERACAO_DE_CADASTRO_CANCELADA;
    }

    public static String getOpcaoAlterarEmailDoCliente() {
        return OPCAO_ALTERAR_EMAIL_DO_CLIENTE;
    }

    public static String getClienteNoSistemaQualOpcaoQuerAlterar() {
        return CLIENTE_NO_SISTEMA_QUAL_OPCAO_QUER_ALTERAR;
    }

    public static String getOpcaoAlterarCPFDoCliente() {
        return OPCAO_ALTERAR_CPF_DO_CLIENTE;
    }

    public static String getoClienteFoiEncontradoNoSistema() {
        return O_CLIENTE_FOI_ENCONTRADO_NO_SISTEMA;
    }

    public static String getOpcaoAlterarNomeDoCliente() {
        return OPCAO_ALTERAR_NOME_DO_CLIENTE;
    }

    public static String getDigiteONovoTelefoneDoCliente() {
        return DIGITE_O_NOVO_TELEFONE_DO_CLIENTE;
    }

    public static String getOpcaoAlterarTelefoneDoCliente() {
        return OPCAO_ALTERAR_TELEFONE_DO_CLIENTE;
    }

    public static String getCabecalhoEditarInformacoesDoCliente() {
        return CABECALHO_EDITAR_INFORMACOES_DO_CLIENTE;
    }

    public static String getUsuarioRemovidoComSucesso() {
        return USUARIO_REMOVIDO_COM_SUCESSO;
    }

    public static String getaRemocaoDoClienteFoiCancelada() {
        return A_REMOCAO_DO_CLIENTE_FOI_CANCELADA;
    }

    public static String getNaoEncontramosNenhumClienteComEssaInformacao() {
        return NAO_ENCONTRAMOS_NENHUM_CLIENTE_COM_ESSA_INFORMACAO;
    }

    public static String getClienteQueVaiSerRemovidoFoiEncotnrado() {
        return CLIENTE_QUE_VAI_SER_REMOVIDO_FOI_ENCOTNRADO;
    }

    public static String getDigiteONomeDoClienteQueVaiSerRemovidoDoSistema() {
        return DIGITE_O_NOME_DO_CLIENTE_QUE_VAI_SER_REMOVIDO_DO_SISTEMA;
    }

    public static String getClienteComEsseEmailJaFoiCadastradoNoSistema() {
        return CLIENTE_COM_ESSE_EMAIL_JA_FOI_CADASTRADO_NO_SISTEMA;
    }

    public static String getClienteComEsseTelefoneJaFoiCadastradoNoSistema() {
        return CLIENTE_COM_ESSE_TELEFONE_JA_FOI_CADASTRADO_NO_SISTEMA;
    }

    public static String getCadastroDoClienteCancelado() {
        return CADASTRO_DO_CLIENTE_CANCELADO;
    }

    public static String getClienteCadastradoComSucesso() {
        return CLIENTE_CADASTRADO_COM_SUCESSO;
    }

    public static String getClienteComEsseCpfJaFoiCadastradoNoSistema() {
        return CLIENTE_COM_ESSE_CPF_JA_FOI_CADASTRADO_NO_SISTEMA;
    }

    public static String getCabecalhoListarTodosOsClientesCadastradosNoSistema() {
        return CABECALHO_LISTAR_TODOS_OS_CLIENTES_CADASTRADOS_NO_SISTEMA;
    }

    public static String informacoesDosClientesCadastradosNoSistema(ClienteModel cliente) {
        return String.format(INFORMACOES_DO_CLIENTE_CADASTRADO_NO_SISTEMA, cliente.getIdDoCliente(), cliente.getNomeDoCliente(), cliente.getCpfDoCliente(), cliente.getEmailDoCliente(), cliente.getTelefoneDoCliente());
    }


    public static String printarRevisaoDeDadosDoCliente(String idDoCliente, String nomeDoCliente, String cpfDoCliente, String emailDoCliente, String telefoneDoCliente) {
        return String.format(CONFIRMAR_CADASTRO_DO_CLIENTE, idDoCliente, nomeDoCliente, cpfDoCliente, emailDoCliente, telefoneDoCliente);
    }

    public static String getCabecalhoRemoverClientesDoSistema() {
        return CABECALHO_REMOVER_CLIENTES_DO_SISTEMA;
    }

    public static String getDigitarCpfDoCliente() {
        return DIGITAR_CPF_DO_CLIENTE;
    }

    public static String getDigitarEmailDoCliente() {
        return DIGITAR_EMAIL_DO_CLIENTE;
    }

    public static String getDigitarTelefoneDoCliente() {
        return DIGITAR_TELEFONE_DO_CLIENTE;
    }

    public static String getDigitarNomeDoCliente() {
        return DIGITAR_NOME_DO_CLIENTE;
    }

    public static String getCabecalhoCriarCadastroCliente() {
        return CABECALHO_CRIAR_CADASTRO_CLIENTE;
    }

    public static String getNaoFoiEncontradoNenhumCliente() {
        return NAO_FOI_ENCONTRADO_NENHUM_CLIENTE;
    }

    public static String getNaoHaNenhumClienteCadastradoNoSistema() {
        return NAO_HA_NENHUM_CLIENTE_CADASTRADO_NO_SISTEMA;
    }

    public static String revisandoDadosDoCliente (ClienteModel clienteAntigo, ClienteModel clienteNovo){
        return String.format(REVISAO_DE_DADOS_ANTES_DE_ALTERAR_INFORMACOES_DO_CLIENTE, clienteAntigo.getIdDoCliente(), clienteAntigo.getNomeDoCliente(), clienteAntigo.getCpfDoCliente(), clienteAntigo.getEmailDoCliente(), clienteAntigo.getTelefoneDoCliente(), clienteNovo.getIdDoCliente(), clienteNovo.getNomeDoCliente(), clienteNovo.getCpfDoCliente(), clienteNovo.getEmailDoCliente(), clienteNovo.getTelefoneDoCliente());
    }
}

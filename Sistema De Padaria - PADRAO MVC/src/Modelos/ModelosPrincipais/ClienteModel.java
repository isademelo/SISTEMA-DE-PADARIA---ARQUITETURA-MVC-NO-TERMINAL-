package Modelos.ModelosPrincipais;

public class ClienteModel {
    private String idDoCliente;
    private String nomeDoCliente;
    private String telefoneDoCliente;
    private String emailDoCliente;
    private String cpfDoCliente;

    public String getCpfDoCliente() {
        return cpfDoCliente;
    }

    public void setCpfDoCliente(String cpfDoCliente) {
        this.cpfDoCliente = cpfDoCliente;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getEmailDoCliente() {
        return emailDoCliente;
    }

    public void setEmailDoCliente(String emailDoCliente) {
        this.emailDoCliente = emailDoCliente;
    }

    public String getIdDoCliente() {
        return idDoCliente;
    }

    public void setIdDoCliente(String idDoCliente) {
        this.idDoCliente = idDoCliente;
    }

    public String getTelefoneDoCliente() {
        return telefoneDoCliente;
    }

    public void setTelefoneDoCliente(String telefoneDoCliente) {
        this.telefoneDoCliente = telefoneDoCliente;
    }
}

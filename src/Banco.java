
import java.util.ArrayList;

//DRY
//Don't
//Repeat
//Yourself

public class Banco {

    private String nome;
    private String email;
    

    // private ArrayList<ClientePF> clientesPF;
    // private ArrayList<ClientePJ> clientesPJ;

    private ArrayList<Cliente> clientes;

    private ArrayList<ContaCorrente> contaCorrente;

    public Banco(String nome, String email) {
        this.nome = nome;
        this.setEmail(email);

        this.clientes = new ArrayList<>();

        this.contaCorrente = new ArrayList<>();
    }

    private boolean adicionaCliente(Cliente cliente){

        if(buscaCliente(cliente.getDocumento()) == null){
            clientes.add(cliente);
            return true;
        }
        return false;
    }

    private Cliente buscaCliente(String doc) {
        // percorer todos os clientes
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);

            if(cliente.getDocumento().equals(doc)){
                return cliente;
            }
        }
        return null;
    }

    public boolean adicionaClientePF(ClientePF cliente) {

        // não pode haver cpf duplicado
        return adicionaCliente(cliente);
    }

    // procurar na coleção de clientes um cliente com o CPF
    public ClientePF buscaClientePF(String cpf) {

        Cliente retorno = buscaCliente(cpf);

        return (ClientePF)retorno;
    }

    public boolean adicionaClientePJ(ClientePJ cliente) {

        return adicionaCliente(cliente);
    }

    public ClientePJ buscaClientePJ(String cnpj) {

        return (ClientePJ)buscaCliente(cnpj);
    }

    public ContaCorrente buscaContaCorrente(String numero, String agencia){

        for (ContaCorrente c : contaCorrente) {
            if (c.getAgencia().equals(agencia) && c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public boolean adicionaConta(ContaCorrente conta){

        if (buscaContaCorrente(conta.getNumero(), conta.getAgencia()) == null) {
            contaCorrente.add(conta);
            return true;
        }
        return false;

    }

    public boolean adicionaContaSimples(ContaCorrenteSimples conta) {


        return adicionaConta(conta);
    }

    public ContaCorrenteSimples buscaContaSimples(String numero, String agencia) {

        return (ContaCorrenteSimples) buscaContaCorrente(numero, agencia);
    }

    public boolean adicionaContaEspecial(ContaCorrenteEspecial conta) {

        return adicionaConta(conta);
    }

    public ContaCorrenteEspecial buscaContaEspecial(String numero, String agencia) {

        return (ContaCorrenteEspecial) buscaContaCorrente(numero, agencia);
    }

    public boolean adicionaContaPoupanca(ContaPoupanca conta) {

        return adicionaConta(conta);
    }

    public ContaPoupanca buscaContaPoupanca(String numero, String agencia) {
     
        return (ContaPoupanca) buscaContaCorrente(numero, agencia);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Cliente> getClientesPF() {

        ArrayList<Cliente> retorno = new ArrayList<>();

        for(Cliente c:clientes){
            if(c instanceof ClientePF){
                retorno.add(c);
            }
        }

        return retorno;
    }

    public ArrayList<Cliente> getClientesPJ() {

        ArrayList<Cliente> retorno = new ArrayList<>();

        for(Cliente c:clientes){
            if(c instanceof ClientePJ){
                retorno.add(c);
            }
        }

        return retorno;

    }

    public ArrayList<ContaCorrente> getContasSimples() {

        ArrayList<ContaCorrente> retorno = new ArrayList<>();

        for(ContaCorrente c:contaCorrente){
            if(c instanceof ContaCorrenteSimples){
                retorno.add(c);
            }
        }

        return retorno;
    }

    public ArrayList<ContaCorrente> getContasEspecial() {

        ArrayList<ContaCorrente> retorno = new ArrayList<>();

        for(ContaCorrente c:contaCorrente){
            if(c instanceof ContaCorrenteEspecial){
                retorno.add(c);
            }
        }

        return retorno;
    }

    public ArrayList<ContaCorrente> getContasPoupanca() {

        ArrayList<ContaCorrente> retorno = new ArrayList<>();

        for(ContaCorrente c:contaCorrente){
            if(c instanceof ContaPoupanca){
                retorno.add(c);
            }
        }

        return retorno;
    }

}

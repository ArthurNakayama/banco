
import java.util.ArrayList;


public class Banco {
    
    private String nome;
    private String email;

    private ArrayList<ClientePF> clientesPF;
    private ArrayList<ClientePJ> clientesPJ;

    
    private ArrayList<ContaCorrenteSimples> contasSimples;
    private ArrayList<ContaCorrenteEspecial> contasEspecial;
    private ArrayList<ContaPoupanca> contasPoupanca;
    

    public Banco(String nome, String email) {
        this.nome = nome;
        this.setEmail(email);
        this.clientesPF = new ArrayList<>();
        this.clientesPJ = new ArrayList<>();
        
        this.contasSimples = new ArrayList<>();
        this.contasEspecial = new ArrayList<>();
        this.contasPoupanca = new ArrayList<>();
    }

    public boolean adicionaClientePF(ClientePF cliente){
        
        //não pode haver cpf duplicado
        if(buscaClientePF(cliente.getCpf()) == null){
            clientesPF.add(cliente);
            return true;
        }

        return false;
    }

    //procurar na coleção de clientes um cliente com o CPF
    public ClientePF buscaClientePF(String cpf){
        
        //percorer todos os clientes        
        for(int i=0;i<clientesPF.size();i++){
            if(clientesPF.get(i).getCpf().equals(cpf)){
                return clientesPF.get(i);
            }
        }

        return null;
    }

    public boolean adicionaClientePJ(ClientePJ cliente){
        
        //não pode haver cpf duplicado
        if(buscaClientePJ(cliente.getCnpj()) == null){
            clientesPJ.add(cliente);
            return true;
        }

        return false;
    }

    public ClientePJ buscaClientePJ(String cnpj){
        
        //percorer todos os clientes        
        for(int i=0;i<clientesPJ.size();i++){
            if(clientesPJ.get(i).getCnpj().equals(cnpj)){
                return clientesPJ.get(i);
            }
        }

        return null;
    }
    
    public boolean adicionaContaSimples(ContaCorrenteSimples conta){
        
        if(buscaContaSimples(conta.getNumero(), conta.getAgencia()) == null){
            contasSimples.add(conta);
            return true;
        }
        return false;        
    }

    public ContaCorrenteSimples buscaContaSimples(String numero, String agencia){
        
        for(ContaCorrenteSimples c:contasSimples){
            if(c.getAgencia().equals(agencia) && c.getNumero().equals(numero)){
                return c;
            }
        }
        return null;
    }

    public boolean adicionaContaEspecial(ContaCorrenteEspecial conta){
        
        if(buscaContaEspecial(conta.getNumero(), conta.getAgencia()) == null){
            contasEspecial.add(conta);
            return true;
        }
        return false;        
    }

    public ContaCorrenteEspecial buscaContaEspecial(String numero, String agencia){
        
        for(ContaCorrenteEspecial c:contasEspecial){
            if(c.getAgencia().equals(agencia) && c.getNumero().equals(numero)){
                return c;
            }
        }
        return null;
    }

    public boolean adicionaContaPoupanca(ContaPoupanca conta){
        
        if(buscaContaPoupanca(conta.getNumero(), conta.getAgencia()) == null){
            contasPoupanca.add(conta);
            return true;
        }
        return false;        
    }

    public ContaPoupanca buscaContaPoupanca(String numero, String agencia){
        
        for(ContaPoupanca c:contasPoupanca){
            if(c.getAgencia().equals(agencia) && c.getNumero().equals(numero)){
                return c;
            }
        }
        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<ClientePF> getClientesPF(){
        return this.clientesPF;
    }

    public ArrayList<ClientePJ> getClientesPJ(){
        return this.clientesPJ;
    }

    public ArrayList<ContaCorrenteSimples> getContasSimples(){
        return this.contasSimples;
    }

    public ArrayList<ContaCorrenteEspecial> getContasEspecial(){
        return this.contasEspecial;
    }

    public ArrayList<ContaPoupanca> getContasPoupanca(){
        return this.contasPoupanca;
    }

}

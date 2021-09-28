

import java.util.ArrayList;
import java.util.Scanner;


public class App {

    private static void showMenu() {
        System.out.println("1 - cadastrar cliente PF");
        System.out.println("2 - buscar cliente por cpf");

        System.out.println("3 - cadastrar cliente PJ");
        System.out.println("4 - buscar cliente por cnpj");

        System.out.println("5 - cadastrar conta Simples");
        System.out.println("6 - cadastrar conta Especial");
        System.out.println("7 - cadastrar conta Poupanca");

        System.out.println("8 - listar todos os clientes");

        System.out.println("9 - listas todas as contas");

        System.out.println("11 - depositar em uma conta Simples");
        System.out.println("12 - sacar de uma conta Simples");

        System.out.println("0 - Sair");
        System.out.println("Digite uma opção:");

    }

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        String nome, cpf, agencia, numero, email, cnpj, random;
        ClientePF clientePF;
        ClientePJ clientePJ;
        ContaCorrenteSimples contaSimples;
        ContaCorrenteEspecial contaEspecial;
        ContaPoupanca contaPoupanca;

        double valor, limite, txRendimento;
        int opcao, anoNascimento, numeroFuncionarios,escolhe;

        Banco banco = new Banco("Bando teste", "teste@banco.com");

        showMenu();
        opcao = scan.nextInt();
        scan.nextLine();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    nome = scan.nextLine();
                    System.out.println("Digite o cpf:");
                    cpf = scan.nextLine();
                    System.out.println("Digite o e-mail:");
                    email = scan.nextLine();
                    System.out.println("Digite o ano de nascimento:");
                    anoNascimento = scan.nextInt();

                    clientePF = new ClientePF(nome, email, cpf, anoNascimento);

                    if (banco.adicionaClientePF(clientePF)) {
                        System.out.println("Cliente adicionado!");
                    } else {
                        System.out.println("Não foi possível adicionar o cliente!");
                    }
                    System.out.println("######");
                    break;
                case 2:
                    System.out.println("Digite o cpf do cliente:");
                    cpf = scan.nextLine();
                    clientePF = banco.buscaClientePF(cpf);
                    if (clientePF != null) {
                        System.out.println(clientePF);
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    System.out.println("######");
                    break;
                case 3:
                    System.out.println("Digite o nome:");
                    nome = scan.nextLine();
                    System.out.println("Digite o CNPJ:");
                    cnpj = scan.nextLine();
                    System.out.println("Digite o e-mail:");
                    email = scan.nextLine();
                    System.out.println("Digite o número de funcionários:");
                    numeroFuncionarios = scan.nextInt();

                    clientePJ = new ClientePJ(nome, email, cnpj, numeroFuncionarios);

                    if (banco.adicionaClientePJ(clientePJ)) {
                        System.out.println("Cliente adicionado!");
                    } else {
                        System.out.println("Não foi possível adicionar o cliente!");
                    }
                    System.out.println("######");
                    break;
                case 4:
                    System.out.println("Digite o cnpj do cliente:");
                    cnpj = scan.nextLine();
                    clientePJ = banco.buscaClientePJ(cnpj);
                    if (clientePJ != null) {
                        System.out.println(clientePJ);
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    System.out.println("######");
                    break;

                case 5:
                    System.out.println("Digite sua escolha: ");
                    System.out.println("1)Pessoa Física");
                    System.out.println("2)Pessoa Jurídica");
                    escolhe = scan.nextInt();
                    if(escolhe == 1){
                        System.out.println("Digite o cpf do cliente:");
                        scan.nextLine();
                        cpf = scan.nextLine();
                        clientePF = banco.buscaClientePF(cpf);
                        if (clientePF != null) {
                            System.out.println("Cliente encontrado!");
                            System.out.println("Digite o número da conta:");
                            numero = scan.nextLine();
                            System.out.println("Digite a agência da conta:");
                            agencia = scan.nextLine();
    
                            contaSimples = new ContaCorrenteSimples(numero, agencia, clientePF);
    
                            if (banco.adicionaContaSimples(contaSimples)) {
                                System.out.println("Conta criada com sucesso!!");
                            } else {
                                System.out.println("Não foi possível criar a conta!");
                            }
                        } else {
                            System.out.println("Cliente não encontrado!");
                        }
                        System.out.println("######");
                    }
                    else if(escolhe == 2){
                        System.out.println("Digite o cnpj do cliente:");
                        scan.nextLine();
                        cnpj = scan.nextLine();
                        clientePJ = banco.buscaClientePJ(cnpj);
                        if (clientePJ != null) {
                            System.out.println("Cliente encontrado!");
                            System.out.println("Digite o número da conta:");
                            numero = scan.nextLine();
                            System.out.println("Digite a agência da conta:");
                            agencia = scan.nextLine();
    
                            contaSimples = new ContaCorrenteSimples(numero, agencia, clientePJ);
    
                            if (banco.adicionaContaSimples(contaSimples)) {
                                System.out.println("Conta criada com sucesso!!");
                            } else {
                                System.out.println("Não foi possível criar a conta!");
                            }
                        } else {
                            System.out.println("Cliente não encontrado!");
                        }
                        System.out.println("######");
                    }
                    else{
                        System.out.println("Escolha inválida");
                    }
                    break;
                case 6:
                System.out.println("Digite sua escolha: ");
                System.out.println("1)Pessoa Física");
                System.out.println("2)Pessoa Jurídica");
                escolhe = scan.nextInt();
                if(escolhe == 1){
                    System.out.println("Digite o cpf do cliente:");
                    scan.nextLine();
                    cpf = scan.nextLine();
                    clientePF = banco.buscaClientePF(cpf);
                    if (clientePF != null) {
                        System.out.println("Cliente encontrado!");
                        System.out.println("Digite o número da conta:");
                        numero = scan.nextLine();
                        System.out.println("Digite a agência da conta:");
                        agencia = scan.nextLine();

                        contaEspecial = new ContaCorrenteEspecial(numero, agencia, clientePF);

                        if (banco.adicionaContaEspecial(contaEspecial)) {
                            System.out.println("Conta criada com sucesso!!");
                        } else {
                            System.out.println("Não foi possível criar a conta!");
                        }
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    System.out.println("######");
                }
                else if(escolhe == 2){
                    System.out.println("Digite o cnpj do cliente:");
                    scan.nextLine();
                    cnpj = scan.nextLine();
                    clientePJ = banco.buscaClientePJ(cnpj);
                    if (clientePJ != null) {
                        System.out.println("Cliente encontrado!");
                        System.out.println("Digite o número da conta:");
                        numero = scan.nextLine();
                        System.out.println("Digite a agência da conta:");
                        agencia = scan.nextLine();

                        contaEspecial = new ContaCorrenteEspecial(numero, agencia, clientePJ);

                        if (banco.adicionaContaEspecial(contaEspecial)) {
                            System.out.println("Conta criada com sucesso!!");
                        } else {
                            System.out.println("Não foi possível criar a conta!");
                        }
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    System.out.println("######");
                }
                else{
                    System.out.println("Escolha inválida");
                }
                    break;
                case 7:
                System.out.println("Digite sua escolha: ");
                System.out.println("1)Pessoa Física");
                System.out.println("2)Pessoa Jurídica");
                escolhe = scan.nextInt();
                if(escolhe == 1){
                    System.out.println("Digite o cpf do cliente:");
                    scan.nextLine();
                    cpf = scan.nextLine();
                    clientePF = banco.buscaClientePF(cpf);
                    if (clientePF != null) {
                        System.out.println("Cliente encontrado!");
                        System.out.println("Digite o número da conta:");
                        numero = scan.nextLine();
                        System.out.println("Digite a agência da conta:");
                        agencia = scan.nextLine();

                        contaPoupanca = new ContaPoupanca(numero, agencia, clientePF);

                        if (banco.adicionaContaPoupanca(contaPoupanca)) {
                            System.out.println("Conta criada com sucesso!!");
                        } else {
                            System.out.println("Não foi possível criar a conta!");
                        }
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    System.out.println("######");
                }
                else if(escolhe == 2){
                    System.out.println("Digite o cnpj do cliente:");
                    scan.nextLine();
                    cnpj = scan.nextLine();
                    clientePJ = banco.buscaClientePJ(cnpj);
                    if (clientePJ != null) {
                        System.out.println("Cliente encontrado!");
                        System.out.println("Digite o número da conta:");
                        numero = scan.nextLine();
                        System.out.println("Digite a agência da conta:");
                        agencia = scan.nextLine();

                        contaPoupanca = new ContaPoupanca(numero, agencia, clientePJ);

                        if (banco.adicionaContaPoupanca(contaPoupanca)) {
                            System.out.println("Conta criada com sucesso!!");
                        } else {
                            System.out.println("Não foi possível criar a conta!");
                        }
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    System.out.println("######");
                }
                else{
                    System.out.println("Escolha inválida");
                }
                    break;
                case 8:
                    System.out.println("Listando todos os clientes");
                    System.out.println("---PF---");
                    for (Cliente cliente : banco.getClientesPF()) {
                        System.err.println("\t" + cliente.toString());
                    }
                    System.out.println("---PJ---");
                    for (Cliente cliente : banco.getClientesPJ()) {
                        System.err.println("\t" + cliente.toString());
                    }
                    System.out.println("######");
                    break;
                case 9:
                    System.out.println("Listando todas as contas");
                    System.out.println("---Simples---");
                    for (ContaCorrente conta : banco.getContasSimples()) {
                        System.err.println("\t" + conta.toString());
                    }
                    System.out.println("---Especial---");
                    for (ContaCorrente conta : banco.getContasEspecial()) {
                        System.err.println("\t" + conta.toString());
                    }
                    System.out.println("---Poupança---");
                    for (ContaCorrente conta : banco.getContasPoupanca()) {
                        System.err.println("\t" + conta.toString());
                    }
                    System.out.println("######");
                    break;
                case 10:
                    System.out.println("Digite o número da conta:");
                    numero = scan.nextLine();
                    System.out.println("Digite a agência da conta:");
                    agencia = scan.nextLine();
                    
                    contaSimples = banco.buscaContaSimples(numero, agencia);
                    
                    if (contaSimples != null) {
                        System.out.println("Digite o valor:");
                        valor = scan.nextDouble();

                        contaSimples.sacar(valor);
                        
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    System.out.println("######");
                    break;
                case 11:
                    System.out.println("Digite o número da conta:");
                    numero = scan.nextLine();
                    System.out.println("Digite a agência da conta:");
                    agencia = scan.nextLine();
                    contaSimples = banco.buscaContaSimples(numero, agencia);
                    if (contaSimples != null) {
                        System.out.println("Digite o valor:");
                        valor = scan.nextDouble();

                        contaSimples.depositar(valor);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    System.out.println("######");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            showMenu();
            opcao = scan.nextInt();
            scan.nextLine();
        }
    }
}

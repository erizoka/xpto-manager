package com.erizoka.xpto.entity;

public class NovaContaCliente {
    
    private Cliente cliente;
    private Conta conta;

    public NovaContaCliente(){};

    public NovaContaCliente(Cliente cliente, Conta conta) {
        this.cliente = cliente;
        this.conta = conta;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
}

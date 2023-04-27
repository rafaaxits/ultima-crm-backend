package com.ultimaschool.java;

import com.ultimaschool.java.clientes.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente clienteM = new Cliente("123.456.789-00", "joao_teste@mail.com",
                "João Teste da Silva", 'M');
        Cliente clienteF = new Cliente("987.654.321-00", "maria_teste@mail.com",
                "Maria Teste da Silva", 'F');
        Cliente clienteVazio = new Cliente("000.000.000-00", "vazio_teste@mail.com",
                "Vazio Teste da Silva", 'V');
        System.out.println(clienteM.toString());
        System.out.println(clienteF.toString());
        System.out.println(clienteVazio.toString());
    }
}
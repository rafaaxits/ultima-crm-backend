package com.ultimaschool.java;

import com.ultimaschool.java.clientes.Cliente;
import com.ultimaschool.java.clientes.ClienteBuilder;

public class Main {
    public static void main(String[] args) {
        Cliente clienteM = new Cliente("João", "Teste da", "Silva",
                "123.456.789-00", "10/01/1993", 'M', "joao_teste@mail.com",
                "Av Agamenom", "(81) 9.9999-9999");
        Cliente clienteF = new Cliente("Maria", "Teste da", "Silva",
                "987.654.321-00", "01/10/2003", 'F', "maria_teste@mail.com",
                "Av Boa vista", "(81) 9.1111-1111");
        Cliente clienteVazio = new Cliente("Vazio", "Teste da", "Silva",
                "000.000.000-00", "01/01/2001", 'V', "vazio_teste@gmail.com",
                "Av vazia", "(00) 9.0000-0000");

        System.out.println(clienteM.toString());
        System.out.println(clienteF.toString());
        System.out.println(clienteVazio.toString());

        ClienteBuilder clienteMBuilder = new ClienteBuilder().comIdentificacao("João",
                "Teste da", "Silva", "123.456.789-00", "10/01/1993",
                'M').comContatos("joao_teste@mail.com", "Av Agamenom", "(81) 9.9999-9999");
        ClienteBuilder clientFContatos = new ClienteBuilder().comContatos("maria_teste@mail.com",
                "Av Boa vista", "(81) 9.1111-1111");
        ClienteBuilder clienteFIdentificacao = new ClienteBuilder().comIdentificacao("Maria", "Teste da", "Silva",
                "987.654.321-00", "01/10/2003", 'F');
        /*Cliente clienteVazio = new Cliente("Vazio", "Teste da", "Silva",
                "000.000.000-00", "01/01/2001", 'V', "vazio_teste@gmail.com",
                "Av vazia", "(00) 9.0000-0000");*/
        System.out.println(clienteMBuilder.toString());
        System.out.println(clientFContatos.toStringContatos());
        System.out.println(clienteFIdentificacao.toStringIdentificacao());
    }
}
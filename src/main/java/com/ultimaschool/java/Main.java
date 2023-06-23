package com.ultimaschool.java;

import com.ultimaschool.java.model.Produto;
import com.ultimaschool.java.repository.DatabaseConnection;
import com.ultimaschool.java.repository.ProdutoRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        /*Cliente clienteM = new Cliente("João", "Teste da", "Silva",
                "123.456.789-00", "10/01/1993", 'M', "joao_teste@mail.com",
                "Av Agamenom", "9.99999-9999");
        Cliente clienteF = new Cliente("Maria", "Teste da", "Silva",
                "987.654.321-00", "01/10/2003", 'F', "maria_teste@mail.com",
                "Av Boa vista", "(81) 9.1111-1111");
        Cliente clienteVazio = new Cliente("Vazio", "Teste da", "Silva",
                "000.000.000-00", "01/01/2001", 'V', "vazio_teste@gmail.com",
                "Av vazia", "(00) 9.0000-0000");
        System.out.println(clienteM.toString());
        System.out.println(clienteF.toString());
        System.out.println(clienteVazio.toString());

        ClienteBuilder clienteMBuilder = new ClienteBuilder().comIdentificacao(clienteM.getPrimeiroNome(),
                clienteM.getNomesDoMeio(), clienteM.getSobrenome(), clienteM.getCpf(), clienteM.getDataDeNascimento(),
                clienteM.getGenero()).comContatos(clienteM.getEmail(), clienteM.getEndereco(), clienteM.getTelefone());
        System.out.println(clienteMBuilder.toStringIdentificacao());
        System.out.println(clienteMBuilder.toStringContatos());


        ClienteBuilder clienteFBuilder = new ClienteBuilder();
        clienteFBuilder.comContatos(clienteF.getEmail(), clienteF.getEndereco(), clienteF.getTelefone());
        System.out.println(clienteFBuilder.toStringContatos());*/

        ProdutoRepository produtoRepository = new ProdutoRepository();
        //produtoRepository.findAll().forEach(System.out::println);

        Produto produto = produtoRepository.findById(54);
        if(produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não existe");
        }

        Produto produtoInsert = new Produto("Relógio smart", 159.30);
        //produtoRepository.insert(produtoInsert);

        Produto produtoUpdate = produtoRepository.findById(54);
        produtoUpdate.setNome("Apple Watch Series 8");
        produtoUpdate.setPreco(6999.99);

        produtoRepository.update(produtoUpdate);

        produto = produtoRepository.findById(54);
        if(produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não existe");
        }

        produtoRepository.delete(54);
        produto = produtoRepository.findById(53);
        if(produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não existe");
        }
    }
}
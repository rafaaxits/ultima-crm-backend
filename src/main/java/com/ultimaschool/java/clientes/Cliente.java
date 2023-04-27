package com.ultimaschool.java.clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cliente {
    private String nomeCompleto;
    private String primeiroNome;

    private String nomesDoMeio;

    private String sobrenome;
    private String cpf;

    private String dataDeNascimento; // dd/MM/YYYY ou MM/dd/YYYY

    private int idadeAtual;
    private char genero;
    private String email;
    private String endereco;
    private String telefone;

    public Cliente(String primeiroNome, String nomesDoMeio, String sobrenome, String cpf,
                   String dataDeNascimento, char genero, String email, String endereco,
                   String telefone) {
        this.primeiroNome = primeiroNome;
        this.nomesDoMeio = nomesDoMeio;
        this.sobrenome = sobrenome;
        this.nomeCompleto = primeiroNome + " " + nomesDoMeio + " " + sobrenome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.idadeAtual = definirIdadeAtual();
        this.genero = genero;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomesDoMeio() {
        return nomesDoMeio;
    }

    public void setNomesDoMeio(String nomesDoMeio) {
        this.nomesDoMeio = nomesDoMeio;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getIdadeAtual() {
        return idadeAtual;
    }

    public void setIdadeAtual(int idadeAtual) {
        this.idadeAtual = idadeAtual;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private int definirIdadeAtual() {
        return recuperaAnoAtual() - recuperarAnoNascimento();
    }

    private int recuperarAnoNascimento() {
        Calendar calendario = Calendar.getInstance();
        Date dataDoNascimentoCliente;
        try {
            dataDoNascimentoCliente = definirFormatoData("dd/MM/yyyy").parse(this.dataDeNascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        calendario.setTime(dataDoNascimentoCliente);
        return calendario.get(calendario.YEAR);
    }

    private int recuperaAnoAtual() {
        Date diaAtual = new Date();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(diaAtual);
        return calendario.get(calendario.YEAR); //2023
    }

    private SimpleDateFormat definirFormatoData(String formatoData){
        if(formatoData == "") {
            return new SimpleDateFormat("dd/MM/yyyy");
        } else {
            return new SimpleDateFormat(formatoData);
        }
    }

    private String tratamentoGenereo() {
        if(getGenero() == 'M') {
            return "Sr.";
        } else if(getGenero() == 'F') {
            return "Sra.";
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        return tratamentoGenereo() + " " + getNomeCompleto() + ", com CPF " +
                getCpf() + ", data de nascimento " + getDataDeNascimento() +
                " com idade de " + getIdadeAtual() + ", e-mail " + getEmail() +
                ", endereço " + getEndereco() + " e telefone " + getTelefone();
    }
}

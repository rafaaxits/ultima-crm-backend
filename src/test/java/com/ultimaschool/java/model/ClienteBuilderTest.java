package com.ultimaschool.java.model;

import com.ultimaschool.java.exceptions.InvalidaEmailException;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteBuilderTest extends TestCase{

    private ClienteBuilder clienteBuilder;
    private ClienteBuilder clienteBuilder2;

    @Before
    public void setUp() {
        clienteBuilder = new ClienteBuilder().comIdentificacao("Maria", "Teste da",
                "Silva", "987.654.321-00", "01/10/2003", 'F')
                .comContatos("maria_teste@mail.com", "Av Boa vista", "(81) 9.1111-1111");
        clienteBuilder2 = new ClienteBuilder();
    }

    @Test
    public void testGetEndereco() {
        assertEquals(clienteBuilder.getEndereco(), "Av Boa vista");
        assertNull(clienteBuilder2.getEndereco());
    }

    @Test
    public void testSetEndereco() {
        clienteBuilder.setEndereco("Av Agamenom");
        assertEquals(clienteBuilder.getEndereco(), "Av Agamenom");
        clienteBuilder2.setEndereco("Av Boa Vista");
        assertEquals(clienteBuilder2.getEndereco(), "Av Boa Vista");
    }

    @Test
    public void testGetIdadeAtual() {
        assertEquals(clienteBuilder.getIdadeAtual(), 20);
        assertNull(clienteBuilder2.getCpf());
    }

    @Test
    public void testSetIdadeAtual() {
        clienteBuilder = new ClienteBuilder().comIdentificacao("Maria", "Teste da",
                        "Silva", "987.654.321-00", "01/10/2002", 'F')
                .comContatos("maria_teste@mail.com", "Av Boa vista", "(81) 9.1111-1111");
        assertEquals(clienteBuilder.getIdadeAtual(), 21);

    }

    @Test
    public void testGetCpf() {
        assertEquals(clienteBuilder.getCpf(), "987.654.321-00");
        assertNull(clienteBuilder2.getCpf());
    }

    @Test
    public void testSetCpf() {
        clienteBuilder.setCpf("000.000.000-00");
        assertEquals(clienteBuilder.getCpf(), "000.000.000-00");
        clienteBuilder2.setCpf("111.111.111-11");
        assertEquals(clienteBuilder2.getCpf(), "111.111.111-11");
    }

    @Test
    public void testGetEmail() {
        assertEquals(clienteBuilder.getEmail(), "maria_teste@mail.com");
        assertNull(clienteBuilder2.getEmail());
    }

    @Test (expected = InvalidaEmailException.class)
    public void testSetEmailFailure() throws InvalidaEmailException {
        Assert.assertThrows(InvalidaEmailException.class, () -> {
            clienteBuilder2.setEmail("testegmail.com");
        });
        Assert.assertThrows(InvalidaEmailException.class, () -> {
            clienteBuilder2.setEmail("testegmail.@com");
        });
        Assert.assertThrows(InvalidaEmailException.class, () -> {
            clienteBuilder2.setEmail(".testegmail@com");
        });
        Assert.assertThrows(InvalidaEmailException.class, () -> {
            clienteBuilder2.setEmail("testegmail@@com");
        });
        Assert.assertThrows(InvalidaEmailException.class, () -> {
            clienteBuilder2.setEmail("testegmail@.com");
        });
    }

    @Test
    public void testSetEmail() throws InvalidaEmailException {
        clienteBuilder.setEmail("teste_maria@gmail.com");
        assertEquals(clienteBuilder.getEmail(), "teste_maria@gmail.com");
        clienteBuilder2.setEmail("teste_teste@gmail.com");
        assertEquals(clienteBuilder2.getEmail(), "teste_teste@gmail.com");
    }

    @Test
    public void testGetTelefone() {
        assertEquals(clienteBuilder.getTelefone(), "(81) 9.1111-1111");
        assertNull(clienteBuilder2.getTelefone());
    }

    @Test
    public void testSetTelefone() {
        String regexPattern = "(\\([0-9]{2}\\)\\s?[0-9].{4,5}-?[0-9]{3,4})|([0-9]{10,11})|([0-9]{2}\\s?[0-9]{8,9})";
        assertTrue(clienteBuilder.getTelefone().matches(regexPattern));
        clienteBuilder2.setTelefone("0000");
        assertNull(clienteBuilder2.getTelefone());
    }

    @Test
    public void testGetNomeCompleto() {
        assertEquals(clienteBuilder.getNomeCompleto(), "Maria Teste da Silva");
        assertNull(clienteBuilder2.getNomeCompleto());
    }

    @Test
    public void testSetNomeCompleto() {
        clienteBuilder.setNomeCompleto("Josefina dos Santos Ribeiro");
        assertEquals(clienteBuilder.getNomeCompleto(), "Josefina dos Santos Ribeiro");
        clienteBuilder2.setNomeCompleto("João Cardoso Milton");
        assertEquals(clienteBuilder2.getNomeCompleto(), "João Cardoso Milton");
    }

    @Test
    public void testGetPrimeiroNome() {
        assertEquals(clienteBuilder.getPrimeiroNome(), "Maria");
        assertNull(clienteBuilder2.getPrimeiroNome());
    }

    @Test
    public void testSetPrimeiroNome() {
        clienteBuilder.setPrimeiroNome("Josefina");
        assertEquals(clienteBuilder.getPrimeiroNome(), "Josefina");
        clienteBuilder2.setPrimeiroNome("João");
        assertEquals(clienteBuilder2.getPrimeiroNome(), "João");
    }

    @Test
    public void testGetSobrenome() {
        assertEquals(clienteBuilder.getSobrenome(), "Silva");
        assertNull(clienteBuilder2.getSobrenome());
    }

    @Test
    public void testSetSobrenome() {
        clienteBuilder.setSobrenome("Ribeiro");
        assertEquals(clienteBuilder.getSobrenome(), "Ribeiro");
        clienteBuilder2.setSobrenome("Silva");
        assertEquals(clienteBuilder2.getSobrenome(), "Silva");
    }

    @Test
    public void testToStringIdentificacao(){
        assertEquals(clienteBuilder.toStringIdentificacao(), "Os dados da pessoa são: Sra. Maria Teste da Silva, " +
                "com CPF 987.654.321-00, data de nascimento 01/10/2003 com idade de 20");
        clienteBuilder.setGenero('M');
        assertEquals(clienteBuilder.toStringIdentificacao(), "Os dados da pessoa são: Sr. Maria Teste da Silva, " +
                "com CPF 987.654.321-00, data de nascimento 01/10/2003 com idade de 20");
        clienteBuilder.setGenero(' ');
        assertEquals(clienteBuilder.toStringIdentificacao(), "Os dados da pessoa são:  Maria Teste da Silva, " +
                "com CPF 987.654.321-00, data de nascimento 01/10/2003 com idade de 20");
        clienteBuilder.setGenero('@');
        assertEquals(clienteBuilder.toStringIdentificacao(), "Os dados da pessoa são:  Maria Teste da Silva, " +
                "com CPF 987.654.321-00, data de nascimento 01/10/2003 com idade de 20");
    }

    @Test
    public void testToStringComContato() throws InvalidaEmailException {
        assertEquals(clienteBuilder.toStringContatos(), "Os dados de contatos são: e-mail maria_teste@mail.com, " +
                "endereço Av Boa vista e telefone (81) 9.1111-1111");
        clienteBuilder.setEmail("maria_1967@mail.com");
        assertEquals(clienteBuilder.toStringContatos(), "Os dados de contatos são: e-mail maria_1967@mail.com, " +
                "endereço Av Boa vista e telefone (81) 9.1111-1111");
    }

    @Test
    public void testRegexEmail() {
        String emailAddress = "testegmail.com";
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        assertFalse(emailAddress.matches(regexPattern));
    }

    @After
    public void tearDown() {
        clienteBuilder = null;
    }
}
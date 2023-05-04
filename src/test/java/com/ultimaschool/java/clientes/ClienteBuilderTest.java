package com.ultimaschool.java.clientes;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteBuilderTest extends TestCase{

    private ClienteBuilder clienteBuilder;
    private ClienteBuilder clienteBuilder2;

    @Before
    public void setUp() {
        clienteBuilder = new ClienteBuilder().comIdentificacao("Maria", "Teste da",
                "Silva", "987.654.321-00", "01/10/2003", 'F');
        clienteBuilder2 = new ClienteBuilder();
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

    @After
    public void tearDown() {
        clienteBuilder = null;
    }
}
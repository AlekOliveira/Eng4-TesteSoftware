/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import banco.Banco;
import banco.Conexao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Alexandre
 */

@RunWith(JUnitParamsRunner.class)
public class AcertoTest {
    
    public AcertoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        Banco.conectar();
        Banco.getCon().getConnection().setAutoCommit(false);
    }
    
    @After
    public void tearDown() throws SQLException {
        Banco.getCon().getConnection().rollback();
        Banco.getCon().Disconnect();
    }

    /**
     * Test of insere method, of class Acerto.
     */
    @Test
    @FileParameters("test/entidades/acerto.csv")
    public void testInsere(String data, double valor, boolean tipo, String motivo, boolean resultado) {
        Acerto a = new Acerto(LocalDate.parse(data, DateTimeFormatter.ISO_DATE),valor, tipo, motivo);
        Assert.assertEquals(resultado,a.insere());
    }
}

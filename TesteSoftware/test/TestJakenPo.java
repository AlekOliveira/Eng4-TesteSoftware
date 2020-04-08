/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidades.JakenPo;
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
 * @author Aluno
 */

@RunWith(JUnitParamsRunner.class)

public class TestJakenPo {
    
    public TestJakenPo() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        /*Tudo o que for feito aqui irá impactar nos futuros métodos de teste
        seja esta ação util ou não */
    }
    
    @AfterClass
    public static void tearDownClass() {    
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
        
    /*@Test
    public void T_REsultado()
    {
        JakenPo jp = new JakenPo();
        int resultado = jp.Resultado("tesoura", "papel");
        Assert.assertEquals(1, resultado);
        
        //exemplo de teste por consulta
        //cria o obj e consulta no banco 
        //executa o assert equals 
        //faz rollback        
    }*/
    
    @Test
    @FileParameters("/home/henrique/NetBeansProjects/Eng4-TesteSoftware/TesteSoftware/test/csvExemplo.csv")
    public void T_REsultado(String s1, String s2, int res)
    {
        //tesoura, papel, 1
       JakenPo jp = new JakenPo();
       int resultado = jp.Resultado(s1, s2);
       Assert.assertEquals(res, resultado);
    }
}

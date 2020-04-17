package entidades;

import banco.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    
    
    private boolean verifica(Acerto a1, Acerto a2) {
        return a1.getData().equals(a2.getData()) && a1.getValor() == a2.getValor() && a1.isTipo() == a2.isTipo() && a1.getMotivo().equals(a2.getMotivo());
    }

    @Test
    @FileParameters("test/entidades/acerto.csv")
    public void testInsere(String data, double valor, boolean tipo, String motivo, boolean resultado) throws SQLException 
    {
        Acerto a = new Acerto(LocalDate.parse(data, DateTimeFormatter.ISO_DATE), valor, tipo, motivo);
        boolean inseriu = a.insere(); // Insere no banco e, caso insira, retorna true
        Assert.assertEquals(resultado, inseriu); // Verifica se era para ser inserido
        if(inseriu) // A partir daqui, verifica se os dados que foram para o banco são os mesmo passados
        {
            ResultSet rs = Banco.getCon().consultar("select * from Acerto ORDER BY \"AceCod\" DESC LIMIT 1"); // Seleciona o ultimo registro inserido
            if(rs.next()) 
            {
                Acerto a2 = new Acerto(rs.getDate("data").toLocalDate(), rs.getDouble("valor"), rs.getBoolean("tipo"), rs.getString("motivo")); // Instancia um novo objeto com os valores do banco
                Assert.assertEquals(true, verifica(a, a2)); // verifica se os valores são iguais nos dois objetos
                
                /*
                    Chico, não fizemos casos de teste no CSV em que faltam parametros, pois a pŕopria biblioteca que converte o CSV trata isso, 
                    então sempre daria erro. Colocar valores errados, por exemplo, a data, causa erro no parse, e também é informado automaticamente.
                    Por fim, não enviar o motivo, por exemplo, insere '' no banco, e não null. Sendo assim, para o banco de dados, '' é um valor válido.
                */
            }
        }
    }
}

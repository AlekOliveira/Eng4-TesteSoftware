package banco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Banco 
{
    static private Conexao con;
    static public Conexao getCon(){ return con;}

    private Banco() 
    {
        
    }
    
    static public boolean conectar()
    {
       con=new Conexao();
       return con.conectar("jdbc:postgresql://arjuna.db.elephantsql.com/","mpdqypsq","mpdqypsq","u-HCiJa79OEO-WU4vUv0xpQOxOZXFCC3");
    }   
    
    public static boolean criarBD(String BD)
    { 
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/";
            Connection con = DriverManager.getConnection(url,"postgres","postgres123");

            Statement statement = con.createStatement();
            statement.execute("CREATE DATABASE "+BD+" WITH OWNER = postgres ENCODING = 'UTF8'  "
                                    + "TABLESPACE = pg_default LC_COLLATE = 'Portuguese_Brazil.1252'  "
                                    + "LC_CTYPE = 'Portuguese_Brazil.1252'  CONNECTION LIMIT = -1;");
            statement.close();
            con.close();
        }
        catch(Exception e)
        {  
            System.out.println(e.getMessage()); 
            return false;
        }
        return true;                
    }
    
    public static boolean criarTabelas(String script, String BD)
    {
        try 
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/" + BD;
            Connection con = DriverManager.getConnection(url, "postgres", "postgres123");

            Statement statement = con.createStatement();
            RandomAccessFile arq = new RandomAccessFile(script, "r");
            while (arq.getFilePointer() < arq.length()) {
                statement.addBatch(arq.readLine());
            }
            statement.executeBatch();

            statement.close();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static void realizaBackup(String arquivo) {
        Runtime r = Runtime.getRuntime();
        try 
        {
            Process p = r.exec("util/" + arquivo + ".bat");
            if (p != null) 
            {
                InputStreamReader str = new InputStreamReader(p.getErrorStream());
                BufferedReader reader = new BufferedReader(str);
                String linha;
                while ((linha = reader.readLine()) != null)
                    System.out.println(linha);
            }
            JOptionPane.showMessageDialog(null, arquivo + " realizado com sucesso!");
        } 
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro no " + arquivo + ": " + ex.getMessage());
        }
    }
}
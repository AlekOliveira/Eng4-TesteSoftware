package entidades;

import banco.Banco;
import java.time.LocalDate;
import banco.Conexao;

public class Acerto {    
    private LocalDate data;
    private double valor;
    private boolean tipo;
    private String motivo;
    private int cod;
    
    public Acerto(LocalDate data, double valor, boolean tipo, String motivo) {
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.motivo = motivo;        
    }
    
    public Acerto(int cod, LocalDate data, double valor, boolean tipo, String motivo) {
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.motivo = motivo;
        this.cod = cod;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public boolean insere() {
        String sql = "insert into Acerto (data, valor, motivo, tipo) values ('#1', #2, '#3', #4)";
        sql = sql.replace("#1", data + "");
        sql = sql.replace("#2", valor + "");
        sql = sql.replace("#3", motivo);
        sql = sql.replace("#4", tipo + "");
        
        return Banco.getCon().manipular(sql);
    }
    
    public boolean altera() {
        String sql = "update Acerto set data = #1, valor = #2, motivo = #3, tipo = #4 where AceCod = " + cod;
        sql = sql.replace("#1", data + "");
        sql = sql.replace("#2", valor + "");
        sql = sql.replace("#3", motivo);
        sql = sql.replace("#4", tipo + "");
        
        Conexao c = new Conexao();
        c.conectar(sql, sql, sql, sql);
        boolean f = c.manipular(sql);
        c.Disconnect();
        return f;
    }
}

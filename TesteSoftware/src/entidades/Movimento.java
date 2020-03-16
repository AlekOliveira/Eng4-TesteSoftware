
package entidades;

import banco.Conexao;

public class Movimento {    
    int cod;
    double valor;
    boolean tipo;
    Acerto acerto;
    Caixa caixa;

    public Movimento(int cod, double valor, boolean tipo, Acerto acerto, Caixa caixa) {
        this.cod = cod;
        this.valor = valor;
        this.tipo = tipo;
        this.acerto = acerto;
        this.caixa = caixa;
    }

    public Movimento(double valor, boolean tipo, Acerto acerto, Caixa caixa) {
        this.valor = valor;
        this.tipo = tipo;
        this.acerto = acerto;
        this.caixa = caixa;
    }

    public int getCod() {
        return cod;
    }

    public double getValor() {
        return valor;
    }

    public boolean isTipo() {
        return tipo;
    }

    public Acerto getAcerto() {
        return acerto;
    }

    public Caixa getCaixa() {
        return caixa;
    }
    
    public boolean insere() {
        String sql = "insert into MovCaixa (valor, tipo, AceCod, CodCaixa) values (#1, #2, #3, #4)";
        sql = sql.replace("#1", valor + "");
        sql = sql.replace("#2", tipo + "");
        sql = sql.replace("#3", acerto.getCod() + "");
        sql = sql.replace("#4", caixa.getCod() + "");
        
        Conexao c = new Conexao();
        c.conectar(sql, sql, sql, sql);
        boolean f = c.manipular(sql);
        c.Disconnect();
        return f;
    }
    
    public boolean altera() {
        String sql = "update MovCaixa set valor = #1, tipo = #2, AceCod = #3, CodCaixa = #4 where CodMov = " + cod;
        sql = sql.replace("#1", valor + "");
        sql = sql.replace("#2", tipo + "");
        sql = sql.replace("#3", acerto.getCod() + "");
        sql = sql.replace("#4", caixa.getCod() + "");
        
        Conexao c = new Conexao();
        c.conectar(sql, sql, sql, sql);
        boolean f = c.manipular(sql);
        c.Disconnect();
        return f;
    }
}

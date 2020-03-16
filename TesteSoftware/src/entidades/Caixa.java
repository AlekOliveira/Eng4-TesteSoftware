package entidades;

import banco.Conexao;

public class Caixa {
    private double saldoIni;
    private double saldoFim;
    private boolean status;
    private int cod;

    public Caixa(double saldoIni, double saldoFim, boolean status, int cod) {
        this.saldoIni = saldoIni;
        this.saldoFim = saldoFim;
        this.status = status;
        this.cod = cod;
    }

    public double getSaldoIni() {
        return saldoIni;
    }

    public void setSaldoIni(double saldoIni) {
        this.saldoIni = saldoIni;
    }

    public double getSaldoFim() {
        return saldoFim;
    }

    public void setSaldoFim(double saldoFim) {
        this.saldoFim = saldoFim;
    }

    public Caixa(double saldoIni, double saldoFim, boolean status) {
        this.saldoIni = saldoIni;
        this.saldoFim = saldoFim;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public boolean isOpen() {
        return status;
    }
    
    static public Caixa getCaixa() {     
        
        Conexao c = new Conexao();
        
        boolean f = c.manipular("");
        c.Disconnect();
        return new Caixa(0, 0, false);
    }
}

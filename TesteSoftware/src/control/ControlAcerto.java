package control;

import entidades.Acerto;
import entidades.Caixa;
import java.time.LocalDate;

public class ControlAcerto {
    public boolean acertar(boolean tipo, double valor, String motivo) {
        boolean esta_dando_certo = true;
        Caixa c = Caixa.getCaixa();
        Acerto a = new Acerto(LocalDate.now(), valor, tipo, motivo);
        
        if(c.isOpen()) {
            if((a.isTipo() && c.getSaldoIni() >= a.getValor()) || !a.isTipo()) {
                
            }
            else
                esta_dando_certo = false;
        }
        else
            esta_dando_certo = false;
        
        return esta_dando_certo;
    }
}

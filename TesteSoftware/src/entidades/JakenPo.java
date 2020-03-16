/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Aluno
 */
public class JakenPo {

    public JakenPo() {
    }
    
    public int Resultado(String J1, String J2)
    {
        if(J1.equals("tesoura") && J2.equals("papel"))
            return 1;
        else
            return 2;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mmaciel.ueppa;

import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.ObjectSet;
import net.sourceforge.floggy.persistence.Persistable;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 *
 * @author Marco
 */
public class Configuracao implements Persistable {

    private String codigoEmpresaPreferida;
    private String senha;

    public Configuracao() {
        codigoEmpresaPreferida = null;
        senha = null;
    }

    public String getCodigoEmpresaPreferida() {
        return codigoEmpresaPreferida;
    }

    public void setCodigoEmpresaPreferida(String codigoEmpresaPreferida) {
        this.codigoEmpresaPreferida = codigoEmpresaPreferida;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void save() {
        try {
            PersistableManager.getInstance().save(this);
        } catch (FloggyException ex) {
            ex.printStackTrace();
        }
    }

    public static Configuracao obterConfiguracao() {
        Configuracao config = null;
        ObjectSet os = null;
        try {
            os = PersistableManager.getInstance().find(Configuracao.class, null, null);
            for (int i = 0; i < os.size(); i++) {
                config = (Configuracao) os.get(i); //obtem as instancias do banco
            }
        } catch (FloggyException ex) {
            //
        }
        //if (config!=null)
        //    System.out.println(config.getCodigoEmpresaPreferida() + " " + config.getSenha());
        return config;
    }
}

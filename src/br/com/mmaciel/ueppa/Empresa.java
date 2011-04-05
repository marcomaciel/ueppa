package br.com.mmaciel.ueppa;

import br.com.mmaciel.ueppa.util.Tokenizer;
import java.util.Vector;
import net.sourceforge.floggy.persistence.FloggyException;
import net.sourceforge.floggy.persistence.Persistable;
import net.sourceforge.floggy.persistence.PersistableManager;

/**
 *
 * @author marco.maciel
 */
public class Empresa implements Persistable {

    public Empresa() {
    }

    public Empresa(String codigo, String nome, String telefone, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
    }
    private String codigo;
    private String nome;
    private String telefone;
    private String cidade;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static String[] listarEmpresas() {
        return obterEmpresasDoArquivo();
    }

    private static String[] obterEmpresasDoArquivo() {
        String[] empresas;
        ArquivoExterno arquivoExterno = new ArquivoExterno("/conf/empresas.txt", "|");
        empresas = arquivoExterno.listaArquivo();
        return empresas;
    }

    /**
     * Obtem um vetor de objetos do tipo Empresa.
     * @return vetorDeEmpresas retorna um vetor de objetos Empresa.
     */
    public static Vector obterEmpresas() {
        String[] empresas = listarEmpresas();
        Vector vetorDeEmpresas = new Vector();
        Tokenizer tok = null;
        for (int i = 0; i < empresas.length; i++) {
            tok = new Tokenizer(empresas[i], ";");
            while (tok.hasMoreTokens()) {
                Empresa empresa = new Empresa();
                empresa.setCodigo(tok.nextToken());
                //System.out.println(empresa.getCodigo());
                empresa.setNome(tok.nextToken());
                //System.out.println(empresa.getNome());
                empresa.setTelefone(tok.nextToken());
                //System.out.println(empresa.getTelefone());
                empresa.setCidade(tok.nextToken());
                //System.out.println(empresa.getCidade());
                vetorDeEmpresas.addElement(empresa);
            }
        }
        return vetorDeEmpresas;
    }

    public static void atualizarListaDeEmpresas() {
        //TODO
    }

    public void save() {
        try {
            PersistableManager.getInstance().save(this);
        } catch (FloggyException ex) {
            ex.printStackTrace();
        }
    }
}

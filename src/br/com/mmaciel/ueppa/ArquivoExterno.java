package br.com.mmaciel.ueppa;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author marco.maciel
 */
public class ArquivoExterno {

    private String texto;     // O conteúdo do arquivo carregado
    private String separador; // A string usada para quebrar o texto

    /** Recebendo apenas o nome do arquivo, sem dados para quebra
     */
    public ArquivoExterno(String arquivo) {
        this.texto = new String();
        this.separador = new String();
        abrirArquivoLocal(arquivo);
    }

    /** Recebendo o arquivo e a string usada para separar o texto em partes
     * @param arquivo Nome do arquivo de texto.
     * @param separador Caracter usado como separador (linhas).
     */
    public ArquivoExterno(String arquivo, String separador) {
        this.texto = new String();
        this.separador = separador;
        abrirArquivoLocal(arquivo);
    }

    /** Abri o arquivo externo
     */
    public void abrirArquivoLocal(String arquivo) {

        StringBuffer buffer = null;
        InputStream is = null;
        InputStreamReader isr = null;

        // Tentando abrir o arquivo indicado
        try {

            is = this.getClass().getResourceAsStream(arquivo);
            if (is == null) {
                throw new Exception("O arquivo não existe");
            }

            isr = new InputStreamReader(is);

            buffer = new StringBuffer();
            int ch;
            while ((ch = isr.read()) > -1) {
                buffer.append((char) ch);
            }
            if (isr != null) {
                isr.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // Armazenando o texto encontrado no arquivo
        this.texto = buffer.toString();
    }

    /** Retorna um array contendo os dados presentes no arquivo de texto
     * separados pelo delimitador
     * @return Array de string
     */
    public String[] listaArquivo() {
         return split(texto, "|");
    }

    private String[] split(String original, String separador) {
        Vector lista = new Vector();
        // Parse nodes into vector
        int index = original.indexOf(separador);
        while (index >= 0) {
            lista.addElement(original.substring(0, index));
            original = original.substring(index + separador.length());
            index = original.indexOf(separador);
        }
        // Get the last node
        lista.addElement(original);

        // Create splitted string array
        String[] result = new String[lista.size()];
        if (lista.size() > 0) {
            for (int loop = 0; loop < lista.size(); loop++) {
                result[loop] = (String) lista.elementAt(loop);
                //System.out.println(result[loop]);
            }
        }
        return result;
    }
}

package br.com.mmaciel.ueppa;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.Connector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;
import org.netbeans.microedition.lcdui.SimpleTableModel;
import org.netbeans.microedition.lcdui.TableItem;

/**
 * @author Marco
 */
public class Ueppa extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form formUeppa;
    private TextField valorCobrado;
    private TextField codigoDoTaxi;
    private TextField senhaDoUsuario;
    private ChoiceGroup empresaDeTaxi;
    private Alert alertSair;
    private Form formEmpresas;
    private TableItem tableItem;
    private Alert alertEnvioOk;
    private Form formConfiguracao;
    private TextField codigoEmpresaPreferida;
    private TextField senha;
    private Alert alertConfiguracao;
    private List listEmpresas;
    private Form form;
    private StringItem stringItem;
    private StringItem stringItem1;
    private StringItem stringItem2;
    private Command cmdConfirmaSair;
    private Command cmdEmpresas;
    private Command backCommand;
    private Command okCommand1;
    private Command cmdCancelar;
    private Command cmdSair;
    private Command cmdEnviarSMS;
    private Command cmbVoltarTelaUeppa;
    private Command cmdVoltaFormUeppa;
    private Command cmdVoltaFormPrincipal;
    private Command cmdGravaConfiguracao;
    private Command cmdConfiguracoes;
    private Command backCommand1;
    private Command cmdVoltarConfiguracao;
    private Command cmdEditarCelula;
    private Command itemCommand;
    private Command itemCommand1;
    private Command okCommand;
    private Command backCommand2;
    private Command cmdSobre;
    private Command backCommand3;
    private Font font1;
    //</editor-fold>//GEN-END:|fields|0|
    private final String versao;
    private final String numeroWappa;
    private MessageConnection connection;
    Configuracao configuracao = null;
    private SimpleTableModel tableModel;
    private Vector vEmpresas;
    String[] empresas;

    //</editor-fold>
    /**
     * The UeppaMid constructor.
     */
    public Ueppa() {
        //obtem a configuração do usuário e carrega no objeto 
        configuracao = Configuracao.obterConfiguracao();
        vEmpresas = Empresa.obterEmpresas();
        empresas = new String[vEmpresas.size()];
        for (int i = 0; i < vEmpresas.size(); i++) {
            Empresa emp = new Empresa();
            emp = (Empresa) vEmpresas.elementAt(i);
            empresas[i] = emp.getCodigo() + "  |  " + emp.getNome();
            //System.out.println(empresas[i]);
        }

        numeroWappa = "41222";//"93923502"; //"41222" - numero do wappa
        versao = getAppProperty("MIDlet-Version");

    }

    private void ligar(String numero) {
        try {
            //TODO
            platformRequest("tel:" + numero);

        } catch (ConnectionNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getFormUeppa());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formUeppa ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of formUeppa component.
     * @return the initialized component instance
     */
    public Form getFormUeppa() {
        if (formUeppa == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            formUeppa = new Form("Ueppa", new Item[] { getEmpresaDeTaxi(), getCodigoDoTaxi(), getValorCobrado(), getSenhaDoUsuario() });//GEN-BEGIN:|14-getter|1|14-postInit
            formUeppa.addCommand(getCmdEnviarSMS());
            formUeppa.addCommand(getCmdEmpresas());
            formUeppa.addCommand(getCmdConfiguracoes());
            formUeppa.addCommand(getCmdSobre());
            formUeppa.addCommand(getCmdConfirmaSair());
            formUeppa.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            formUeppa.setTitle("UEPPA - v." + versao + " beta");
        }//GEN-BEGIN:|14-getter|2|
        return formUeppa;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == alertConfiguracao) {//GEN-BEGIN:|7-commandAction|1|84-preAction
            if (command == cmdVoltarConfiguracao) {//GEN-END:|7-commandAction|1|84-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormConfiguracao());//GEN-LINE:|7-commandAction|2|84-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|3|60-preAction
        } else if (displayable == alertEnvioOk) {
            if (command == cmbVoltarTelaUeppa) {//GEN-END:|7-commandAction|3|60-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormUeppa());//GEN-LINE:|7-commandAction|4|60-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|44-preAction
        } else if (displayable == alertSair) {
            if (command == cmdCancelar) {//GEN-END:|7-commandAction|5|44-preAction

                switchDisplayable(null, getFormUeppa());//GEN-LINE:|7-commandAction|6|44-postAction

            } else if (command == cmdSair) {//GEN-LINE:|7-commandAction|7|42-preAction
//GEN-LINE:|7-commandAction|8|42-postAction
                notifyDestroyed();
            }//GEN-BEGIN:|7-commandAction|9|121-preAction
        } else if (displayable == form) {
            if (command == backCommand3) {//GEN-END:|7-commandAction|9|121-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormUeppa());//GEN-LINE:|7-commandAction|10|121-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|72-preAction
        } else if (displayable == formConfiguracao) {
            if (command == cmdGravaConfiguracao) {//GEN-END:|7-commandAction|11|72-preAction
                if (getCodigoEmpresaPreferida().getString().equals("") || getSenha().getString().equals("")) {
                    getAlertConfiguracao().setString("Algum campo esta vazio! Preencha corretamente");
                } else {
                    gravarConfiguracao();
                    getAlertConfiguracao().setString("Configuração gravada com sucesso!");
                }
                switchDisplayable(getAlertConfiguracao(), getFormConfiguracao());//GEN-LINE:|7-commandAction|12|72-postAction

            } else if (command == cmdVoltaFormPrincipal) {//GEN-LINE:|7-commandAction|13|69-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormUeppa());//GEN-LINE:|7-commandAction|14|69-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|64-preAction
        } else if (displayable == formEmpresas) {
            if (command == cmdVoltaFormUeppa) {//GEN-END:|7-commandAction|15|64-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormUeppa());//GEN-LINE:|7-commandAction|16|64-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|77-preAction
        } else if (displayable == formUeppa) {
            if (command == cmdConfiguracoes) {//GEN-END:|7-commandAction|17|77-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormConfiguracao());//GEN-LINE:|7-commandAction|18|77-postAction
                // write post-action user code here
            } else if (command == cmdConfirmaSair) {//GEN-LINE:|7-commandAction|19|19-preAction
                // write pre-action user code here
                switchDisplayable(getAlertSair(), getFormUeppa());//GEN-LINE:|7-commandAction|20|19-postAction
                // write post-action user code here
            } else if (command == cmdEmpresas) {//GEN-LINE:|7-commandAction|21|23-preAction
                getListEmpresas().deleteAll();
                for (int i = 0; i < vEmpresas.size(); i++) {
                    Empresa emp = new Empresa();
                    emp = (Empresa) vEmpresas.elementAt(i);
                    getListEmpresas().append(emp.getCodigo() + " | " + emp.getNome() + " | " + emp.getTelefone(), null);
                }
                switchDisplayable(null, getFormEmpresas());//GEN-LINE:|7-commandAction|22|23-postAction
                // write post-action user code here
            } else if (command == cmdEnviarSMS) {//GEN-LINE:|7-commandAction|23|56-preAction
                enviarMensagem();
//GEN-LINE:|7-commandAction|24|56-postAction
                // write post-action user code here
            } else if (command == cmdSobre) {//GEN-LINE:|7-commandAction|25|116-preAction

                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|26|116-postAction

            }//GEN-BEGIN:|7-commandAction|27|103-preAction
        } else if (displayable == listEmpresas) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|27|103-preAction
                // write pre-action user code here
                listEmpresasAction();//GEN-LINE:|7-commandAction|28|103-postAction
                // write post-action user code here
            } else if (command == backCommand2) {//GEN-LINE:|7-commandAction|29|106-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormUeppa());//GEN-LINE:|7-commandAction|30|106-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|31|7-postCommandAction
        }//GEN-END:|7-commandAction|31|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|32|
    //</editor-fold>//GEN-END:|7-commandAction|32|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertSair ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of alertSair component.
     * @return the initialized component instance
     */
    public Alert getAlertSair() {
        if (alertSair == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            alertSair = new Alert("Confirma\u00E7\u00E3o", "Voc\u00EA realmente deseja sair?", null, AlertType.CONFIRMATION);//GEN-BEGIN:|28-getter|1|28-postInit
            alertSair.addCommand(getCmdSair());
            alertSair.addCommand(getCmdCancelar());
            alertSair.setCommandListener(this);
            alertSair.setTimeout(Alert.FOREVER);//GEN-END:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return alertSair;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdConfirmaSair ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of cmdConfirmaSair component.
     * @return the initialized component instance
     */
    public Command getCmdConfirmaSair() {
        if (cmdConfirmaSair == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            cmdConfirmaSair = new Command("Sair", Command.OK, 5);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return cmdConfirmaSair;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdEmpresas ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of cmdEmpresas component.
     * @return the initialized component instance
     */
    public Command getCmdEmpresas() {
        if (cmdEmpresas == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            cmdEmpresas = new Command("Empresas...", Command.OK, 1);//GEN-LINE:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return cmdEmpresas;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formEmpresas ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of formEmpresas component.
     * @return the initialized component instance
     */
    public Form getFormEmpresas() {
        if (formEmpresas == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            formEmpresas = new Form("Empresas", new Item[] { getTableItem() });//GEN-BEGIN:|31-getter|1|31-postInit
            formEmpresas.addCommand(getCmdVoltaFormUeppa());
            formEmpresas.setCommandListener(this);//GEN-END:|31-getter|1|31-postInit

        }//GEN-BEGIN:|31-getter|2|
        return formEmpresas;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|34-getter|1|34-postInit
            // write post-init user code here
        }//GEN-BEGIN:|34-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|34-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdSair ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of cmdSair component.
     * @return the initialized component instance
     */
    public Command getCmdSair() {
        if (cmdSair == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            cmdSair = new Command("Sair", Command.EXIT, 0);//GEN-LINE:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return cmdSair;
    }
    //</editor-fold>//GEN-END:|41-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdCancelar ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of cmdCancelar component.
     * @return the initialized component instance
     */
    public Command getCmdCancelar() {
        if (cmdCancelar == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            cmdCancelar = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|43-getter|1|43-postInit
            // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return cmdCancelar;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: codigoDoTaxi ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initiliazed instance of codigoDoTaxi component.
     * @return the initialized component instance
     */
    public TextField getCodigoDoTaxi() {
        if (codigoDoTaxi == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            codigoDoTaxi = new TextField("Taxi:", null, 4, TextField.NUMERIC);//GEN-BEGIN:|49-getter|1|49-postInit
            codigoDoTaxi.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|49-getter|1|49-postInit
            // write post-init user code here
        }//GEN-BEGIN:|49-getter|2|
        return codigoDoTaxi;
    }
    //</editor-fold>//GEN-END:|49-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: valorCobrado ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of valorCobrado component.
     * @return the initialized component instance
     */
    public TextField getValorCobrado() {
        if (valorCobrado == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            valorCobrado = new TextField("Valor:", null, 5, TextField.NUMERIC);//GEN-BEGIN:|50-getter|1|50-postInit
            valorCobrado.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return valorCobrado;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: empresaDeTaxi ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of empresaDeTaxi component.
     * @return the initialized component instance
     */
    public ChoiceGroup getEmpresaDeTaxi() {
        if (empresaDeTaxi == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            empresaDeTaxi = new ChoiceGroup("Empresa:", Choice.EXCLUSIVE);//GEN-BEGIN:|53-getter|1|53-postInit
            empresaDeTaxi.setLayout(ImageItem.LAYOUT_LEFT | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER | ImageItem.LAYOUT_NEWLINE_BEFORE | Item.LAYOUT_2);
            empresaDeTaxi.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|53-getter|1|53-postInit

            if (configuracao != null) {
                int indexEmpresaPreferida = 0;
                String empresaPreferida = configuracao.getCodigoEmpresaPreferida();
                for (int i = 0; i < empresas.length; i++) {
                    if (empresaPreferida.equals(empresas[i].substring(0, 2))) {
                        indexEmpresaPreferida = i;
                    }
                }
                empresaDeTaxi = new ChoiceGroup("Empresa:", Choice.POPUP, empresas, null);
                empresaDeTaxi.setSelectedIndex(indexEmpresaPreferida, true);
            } else {
                empresaDeTaxi = new ChoiceGroup("Empresa:", Choice.POPUP, empresas, null);
            }
        }//GEN-BEGIN:|53-getter|2|
        return empresaDeTaxi;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: senhaDoUsuario ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of senhaDoUsuario component.
     * @return the initialized component instance
     */
    public TextField getSenhaDoUsuario() {
        if (senhaDoUsuario == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            senhaDoUsuario = new TextField("Senha:", null, 4, TextField.NUMERIC | TextField.PASSWORD);//GEN-BEGIN:|54-getter|1|54-postInit
            senhaDoUsuario.setLayout(ImageItem.LAYOUT_LEFT | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER | ImageItem.LAYOUT_NEWLINE_BEFORE | Item.LAYOUT_2);//GEN-END:|54-getter|1|54-postInit
            // atribui o valor da senha das configurações
            // pre-estabelecidas, caso existam.
            if (configuracao != null) {
                senhaDoUsuario.setString(configuracao.getSenha());
            }
        }//GEN-BEGIN:|54-getter|2|
        return senhaDoUsuario;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdEnviarSMS ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initiliazed instance of cmdEnviarSMS component.
     * @return the initialized component instance
     */
    public Command getCmdEnviarSMS() {
        if (cmdEnviarSMS == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            cmdEnviarSMS = new Command("Enviar", Command.OK, 0);//GEN-LINE:|55-getter|1|55-postInit
            // write post-init user code here
        }//GEN-BEGIN:|55-getter|2|
        return cmdEnviarSMS;
    }
    //</editor-fold>//GEN-END:|55-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertEnvioOk ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of alertEnvioOk component.
     * @return the initialized component instance
     */
    public Alert getAlertEnvioOk() {
        if (alertEnvioOk == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            alertEnvioOk = new Alert("Confirma\u00E7\u00E3o", "Mensagem Enviada com Sucesso!", null, null);//GEN-BEGIN:|58-getter|1|58-postInit
            alertEnvioOk.addCommand(getCmbVoltarTelaUeppa());
            alertEnvioOk.setCommandListener(this);
            alertEnvioOk.setTimeout(Alert.FOREVER);//GEN-END:|58-getter|1|58-postInit
            // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return alertEnvioOk;
    }
    //</editor-fold>//GEN-END:|58-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmbVoltarTelaUeppa ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of cmbVoltarTelaUeppa component.
     * @return the initialized component instance
     */
    public Command getCmbVoltarTelaUeppa() {
        if (cmbVoltarTelaUeppa == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            cmbVoltarTelaUeppa = new Command("Voltar", Command.BACK, 0);//GEN-LINE:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return cmbVoltarTelaUeppa;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdVoltaFormUeppa ">//GEN-BEGIN:|63-getter|0|63-preInit
    /**
     * Returns an initiliazed instance of cmdVoltaFormUeppa component.
     * @return the initialized component instance
     */
    public Command getCmdVoltaFormUeppa() {
        if (cmdVoltaFormUeppa == null) {//GEN-END:|63-getter|0|63-preInit
            // write pre-init user code here
            cmdVoltaFormUeppa = new Command("Back", Command.BACK, 0);//GEN-LINE:|63-getter|1|63-postInit
            // write post-init user code here
        }//GEN-BEGIN:|63-getter|2|
        return cmdVoltaFormUeppa;
    }
    //</editor-fold>//GEN-END:|63-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formConfiguracao ">//GEN-BEGIN:|67-getter|0|67-preInit
    /**
     * Returns an initiliazed instance of formConfiguracao component.
     * @return the initialized component instance
     */
    public Form getFormConfiguracao() {
        if (formConfiguracao == null) {//GEN-END:|67-getter|0|67-preInit
            // write pre-init user code here
            formConfiguracao = new Form("Configura\u00E7\u00F5es", new Item[] { getCodigoEmpresaPreferida(), getSenha() });//GEN-BEGIN:|67-getter|1|67-postInit
            formConfiguracao.addCommand(getCmdVoltaFormPrincipal());
            formConfiguracao.addCommand(getCmdGravaConfiguracao());
            formConfiguracao.setCommandListener(this);//GEN-END:|67-getter|1|67-postInit
            if (configuracao != null) {
                codigoEmpresaPreferida.setString(configuracao.getCodigoEmpresaPreferida());
                senha.setString(configuracao.getSenha());
            } else {
                codigoEmpresaPreferida.setString("");
                senha.setString("");
            }
        }//GEN-BEGIN:|67-getter|2|
        return formConfiguracao;
    }
    //</editor-fold>//GEN-END:|67-getter|2|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: codigoEmpresaPreferida ">//GEN-BEGIN:|74-getter|0|74-preInit
    /**
     * Returns an initiliazed instance of codigoEmpresaPreferida component.
     * @return the initialized component instance
     */
    public TextField getCodigoEmpresaPreferida() {
        if (codigoEmpresaPreferida == null) {//GEN-END:|74-getter|0|74-preInit
            // write pre-init user code here
            codigoEmpresaPreferida = new TextField("Empresa Preferida:", "", 3, TextField.NUMERIC);//GEN-BEGIN:|74-getter|1|74-postInit
            codigoEmpresaPreferida.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|74-getter|1|74-postInit
            // write post-init user code here
        }//GEN-BEGIN:|74-getter|2|
        return codigoEmpresaPreferida;
    }
    //</editor-fold>//GEN-END:|74-getter|2|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: senha ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initiliazed instance of senha component.
     * @return the initialized component instance
     */
    public TextField getSenha() {
        if (senha == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            senha = new TextField("Senha:", "", 4, TextField.NUMERIC | TextField.PASSWORD);//GEN-BEGIN:|75-getter|1|75-postInit
            senha.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|75-getter|1|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|2|
        return senha;
    }
    //</editor-fold>//GEN-END:|75-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdVoltaFormPrincipal ">//GEN-BEGIN:|68-getter|0|68-preInit
    /**
     * Returns an initiliazed instance of cmdVoltaFormPrincipal component.
     * @return the initialized component instance
     */
    public Command getCmdVoltaFormPrincipal() {
        if (cmdVoltaFormPrincipal == null) {//GEN-END:|68-getter|0|68-preInit
            // write pre-init user code here
            cmdVoltaFormPrincipal = new Command("Back", Command.BACK, 0);//GEN-LINE:|68-getter|1|68-postInit
            // write post-init user code here
        }//GEN-BEGIN:|68-getter|2|
        return cmdVoltaFormPrincipal;
    }
    //</editor-fold>//GEN-END:|68-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdGravaConfiguracao ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initiliazed instance of cmdGravaConfiguracao component.
     * @return the initialized component instance
     */
    public Command getCmdGravaConfiguracao() {
        if (cmdGravaConfiguracao == null) {//GEN-END:|71-getter|0|71-preInit
            // write pre-init user code here
            cmdGravaConfiguracao = new Command("Salvar", Command.OK, 0);//GEN-LINE:|71-getter|1|71-postInit
            // write post-init user code here
        }//GEN-BEGIN:|71-getter|2|
        return cmdGravaConfiguracao;
    }
    //</editor-fold>//GEN-END:|71-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdConfiguracoes ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of cmdConfiguracoes component.
     * @return the initialized component instance
     */
    public Command getCmdConfiguracoes() {
        if (cmdConfiguracoes == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            cmdConfiguracoes = new Command("Configura\u00E7\u00F5es...", Command.OK, 3);//GEN-LINE:|76-getter|1|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return cmdConfiguracoes;
    }
    //</editor-fold>//GEN-END:|76-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|79-getter|0|79-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|79-getter|1|79-postInit
            // write post-init user code here
        }//GEN-BEGIN:|79-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|79-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertConfiguracao ">//GEN-BEGIN:|81-getter|0|81-preInit
    /**
     * Returns an initiliazed instance of alertConfiguracao component.
     * @return the initialized component instance
     */
    public Alert getAlertConfiguracao() {
        if (alertConfiguracao == null) {//GEN-END:|81-getter|0|81-preInit

            alertConfiguracao = new Alert("Mensagem", "Configura\u00E7\u00E3o gravada com sucesso!", null, AlertType.CONFIRMATION);//GEN-BEGIN:|81-getter|1|81-postInit
            alertConfiguracao.addCommand(getCmdVoltarConfiguracao());
            alertConfiguracao.setCommandListener(this);
            alertConfiguracao.setTimeout(Alert.FOREVER);//GEN-END:|81-getter|1|81-postInit
            // write post-init user code here
        }//GEN-BEGIN:|81-getter|2|
        return alertConfiguracao;
    }
    //</editor-fold>//GEN-END:|81-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdVoltarConfiguracao ">//GEN-BEGIN:|83-getter|0|83-preInit
    /**
     * Returns an initiliazed instance of cmdVoltarConfiguracao component.
     * @return the initialized component instance
     */
    public Command getCmdVoltarConfiguracao() {
        if (cmdVoltarConfiguracao == null) {//GEN-END:|83-getter|0|83-preInit
            // write pre-init user code here
            cmdVoltarConfiguracao = new Command("Voltar", Command.BACK, 0);//GEN-LINE:|83-getter|1|83-postInit
            // write post-init user code here
        }//GEN-BEGIN:|83-getter|2|
        return cmdVoltarConfiguracao;
    }
    //</editor-fold>//GEN-END:|83-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of itemCommand component.
     * @return the initialized component instance
     */
    public Command getItemCommand() {
        if (itemCommand == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            itemCommand = new Command("Item", Command.ITEM, 0);//GEN-LINE:|89-getter|1|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return itemCommand;
    }
    //</editor-fold>//GEN-END:|89-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand1 ">//GEN-BEGIN:|91-getter|0|91-preInit
    /**
     * Returns an initiliazed instance of itemCommand1 component.
     * @return the initialized component instance
     */
    public Command getItemCommand1() {
        if (itemCommand1 == null) {//GEN-END:|91-getter|0|91-preInit
            // write pre-init user code here
            itemCommand1 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|91-getter|1|91-postInit
            // write post-init user code here
        }//GEN-BEGIN:|91-getter|2|
        return itemCommand1;
    }
    //</editor-fold>//GEN-END:|91-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdEditarCelula ">//GEN-BEGIN:|93-getter|0|93-preInit
    /**
     * Returns an initiliazed instance of cmdEditarCelula component.
     * @return the initialized component instance
     */
    public Command getCmdEditarCelula() {
        if (cmdEditarCelula == null) {//GEN-END:|93-getter|0|93-preInit
            // write pre-init user code here
            cmdEditarCelula = new Command("Editar C\u00E9lula", Command.ITEM, 0);//GEN-LINE:|93-getter|1|93-postInit
            // write post-init user code here
        }//GEN-BEGIN:|93-getter|2|
        return cmdEditarCelula;
    }
    //</editor-fold>//GEN-END:|93-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|97-getter|0|97-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|97-getter|0|97-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|97-getter|1|97-postInit
            // write post-init user code here
        }//GEN-BEGIN:|97-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|97-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: listEmpresas ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initiliazed instance of listEmpresas component.
     * @return the initialized component instance
     */
    public List getListEmpresas() {
        if (listEmpresas == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            listEmpresas = new List("Empresas", Choice.IMPLICIT);//GEN-BEGIN:|101-getter|1|101-postInit
            listEmpresas.addCommand(getBackCommand2());
            listEmpresas.setCommandListener(this);
            listEmpresas.setFitPolicy(Choice.TEXT_WRAP_OFF);//GEN-END:|101-getter|1|101-postInit
            listEmpresas.append(versao, null);
        }//GEN-BEGIN:|101-getter|2|
        return listEmpresas;
    }
    //</editor-fold>//GEN-END:|101-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listEmpresasAction ">//GEN-BEGIN:|101-action|0|101-preAction
    /**
     * Performs an action assigned to the selected list element in the listEmpresas component.
     */
    public void listEmpresasAction() {//GEN-END:|101-action|0|101-preAction
        // enter pre-action user code here
        String __selectedString = getListEmpresas().getString(getListEmpresas().getSelectedIndex());//GEN-LINE:|101-action|1|101-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|101-action|2|
    //</editor-fold>//GEN-END:|101-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|105-getter|0|105-preInit
    /**
     * Returns an initiliazed instance of backCommand2 component.
     * @return the initialized component instance
     */
    public Command getBackCommand2() {
        if (backCommand2 == null) {//GEN-END:|105-getter|0|105-preInit
            // write pre-init user code here
            backCommand2 = new Command("Back", Command.BACK, 0);//GEN-LINE:|105-getter|1|105-postInit
            // write post-init user code here
        }//GEN-BEGIN:|105-getter|2|
        return backCommand2;
    }
    //</editor-fold>//GEN-END:|105-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem ">//GEN-BEGIN:|108-getter|0|108-preInit
    /**
     * Returns an initiliazed instance of tableItem component.
     * @return the initialized component instance
     */
    public TableItem getTableItem() {
        if (tableItem == null) {//GEN-END:|108-getter|0|108-preInit
            // write pre-init user code here
            tableItem = new TableItem(getDisplay(), "Lista de Empresas");//GEN-BEGIN:|108-getter|1|108-postInit
            tableItem.setTitleFont(getFont1());
            tableItem.setHeadersFont(getFont1());//GEN-END:|108-getter|1|108-postInit
            tableItem.setModel(getSimpleTableModel());
        }//GEN-BEGIN:|108-getter|2|
        return tableItem;
    }
    //</editor-fold>//GEN-END:|108-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: font1 ">//GEN-BEGIN:|109-getter|0|109-preInit
    /**
     * Returns an initiliazed instance of font1 component.
     * @return the initialized component instance
     */
    public Font getFont1() {
        if (font1 == null) {//GEN-END:|109-getter|0|109-preInit
            // write pre-init user code here
            font1 = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);//GEN-LINE:|109-getter|1|109-postInit
            // write post-init user code here
        }//GEN-BEGIN:|109-getter|2|
        return font1;
    }
    //</editor-fold>//GEN-END:|109-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cmdSobre ">//GEN-BEGIN:|115-getter|0|115-preInit
    /**
     * Returns an initiliazed instance of cmdSobre component.
     * @return the initialized component instance
     */
    public Command getCmdSobre() {
        if (cmdSobre == null) {//GEN-END:|115-getter|0|115-preInit
            // write pre-init user code here
            cmdSobre = new Command("Sobre o Ueppa...", Command.OK, 4);//GEN-LINE:|115-getter|1|115-postInit
            // write post-init user code here
        }//GEN-BEGIN:|115-getter|2|
        return cmdSobre;
    }
    //</editor-fold>//GEN-END:|115-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|118-getter|0|118-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|118-getter|0|118-preInit
            // write pre-init user code here
            form = new Form("Sobre o Ueppa", new Item[] { getStringItem1(), getStringItem(), getStringItem2() });//GEN-BEGIN:|118-getter|1|118-postInit
            form.addCommand(getBackCommand3());
            form.setCommandListener(this);//GEN-END:|118-getter|1|118-postInit
            // write post-init user code here
        }//GEN-BEGIN:|118-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|118-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand3 ">//GEN-BEGIN:|120-getter|0|120-preInit
    /**
     * Returns an initiliazed instance of backCommand3 component.
     * @return the initialized component instance
     */
    public Command getBackCommand3() {
        if (backCommand3 == null) {//GEN-END:|120-getter|0|120-preInit
            // write pre-init user code here
            backCommand3 = new Command("Back", Command.BACK, 0);//GEN-LINE:|120-getter|1|120-postInit
            // write post-init user code here
        }//GEN-BEGIN:|120-getter|2|
        return backCommand3;
    }
    //</editor-fold>//GEN-END:|120-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|124-getter|0|124-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|124-getter|0|124-preInit
            // write pre-init user code here
            stringItem = new StringItem("Autor:", getAppProperty("MIDlet-Vendor")//GEN-BEGIN:|124-getter|1|124-postInit
                    );
            stringItem.setLayout(ImageItem.LAYOUT_DEFAULT);
            stringItem.setFont(getFont1());//GEN-END:|124-getter|1|124-postInit
            // write post-init user code here
        }//GEN-BEGIN:|124-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|124-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|125-getter|0|125-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|125-getter|0|125-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("Vers\u00E3o:", versao);//GEN-BEGIN:|125-getter|1|125-postInit
            stringItem1.setFont(getFont1());//GEN-END:|125-getter|1|125-postInit
            // write post-init user code here
        }//GEN-BEGIN:|125-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|125-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|126-getter|0|126-preInit
    /**
     * Returns an initiliazed instance of stringItem2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {//GEN-END:|126-getter|0|126-preInit
            // write pre-init user code here
            stringItem2 = new StringItem("Site:", getAppProperty("MIDlet-Info-URL"));//GEN-BEGIN:|126-getter|1|126-postInit
            stringItem2.setFont(getFont1());//GEN-END:|126-getter|1|126-postInit
            // write post-init user code here
        }//GEN-BEGIN:|126-getter|2|
        return stringItem2;
    }
    //</editor-fold>//GEN-END:|126-getter|2|

    public SimpleTableModel getSimpleTableModel() {
        if (tableModel == null) {
            int totalEmpresas = vEmpresas.size();//empresas.length;
            tableModel = new SimpleTableModel(totalEmpresas, 4);

            int row = 0;
            for (int i = 0; i < totalEmpresas; i++) {
                Empresa emp = new Empresa();
                emp = (Empresa) vEmpresas.elementAt(i);
                System.out.println(emp.getCodigo() + " " + emp.getNome());
                tableModel.setValue(0, row, emp.getCodigo());
                tableModel.setValue(1, row, emp.getNome());
                tableModel.setValue(2, row, emp.getTelefone());
                tableModel.setValue(3, row, emp.getCidade());
                row++;
            }
            tableModel.setColumnNames(new String[]{
                        "Cod",
                        "Nome",
                        "Telefone",
                        "Cidade"
                    });


        }
        return tableModel;
    }

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    private void enviarMensagem() {
        try {
            connection = (MessageConnection) Connector.open("sms://:5000");
        } catch (IOException ex) {
        }
        TextMessage mensagem = prepararSMS();
        enviarSMS(mensagem);
    }

    private TextMessage prepararSMS() {
        TextMessage mensagem = (TextMessage) connection.newMessage(MessageConnection.TEXT_MESSAGE);
        String number = "sms://" + numeroWappa;
        mensagem.setAddress(number);
        String texto = formataTextoDaMensagem();
        mensagem.setPayloadText(texto);

        return mensagem;
    }

    private String formataTextoDaMensagem() {
        StringBuffer textoFormatado = new StringBuffer();
        textoFormatado.append(empresaDeTaxi.getString(empresaDeTaxi.getSelectedIndex()).substring(0, 2).trim());
        textoFormatado.append(" ");
        textoFormatado.append(codigoDoTaxi.getString().trim());
        textoFormatado.append(" ");
        textoFormatado.append(senhaDoUsuario.getString().trim());
        textoFormatado.append(" ");
        textoFormatado.append(valorCobrado.getString().trim());
        System.out.println(textoFormatado.toString());
        return textoFormatado.toString();
    }

    private void enviarSMS(final TextMessage message) {
        Thread smsThread = new Thread() {

            public void run() {
                try {
                    connection.send(message);
                    switchDisplayable(getAlertEnvioOk(), getFormUeppa());
                } catch (InterruptedIOException ex) {
                } catch (IOException ex) {
                } catch (IllegalArgumentException ex) {
                } catch (SecurityException ex) {
                }
            }
        };
        smsThread.start();
    }

    public void gravarConfiguracao() {
        Configuracao config = new Configuracao();
        config.setCodigoEmpresaPreferida(codigoEmpresaPreferida.getString());
        config.setSenha(senha.getString());
        config.save();
    }
}

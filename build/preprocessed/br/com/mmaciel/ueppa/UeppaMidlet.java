package br.com.mmaciel.ueppa;

/*--------------------------------------------------
 * UeppaMidlet.java
 *
 * Author: Marco Antonio de Azevedo Maciel
 *
 * Classe principal da aplicacao
 *-------------------------------------------------*/
import java.io.IOException;
import java.io.InterruptedIOException;
import javax.microedition.io.Connector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public class UeppaMidlet extends MIDlet implements CommandListener {

    private Display display;
    private Form formPrincipal;
    private Alert alertSair;
    private Alert alertSobre;
    private ChoiceGroup empresaDeTaxi;
    private TextField codigoDoTaxi;
    private TextField senhaDoUsuario;
    private TextField valorCobrado;
    //comandos
    private Command cmdEnviar;
    private Command cmdConfig;
    private Command cmdEmpresas;
    private Command cmdSair;
    private Command cmdSobre;
    private MessageConnection connection;
    private String numeroWappa;
    private String versao;

    public UeppaMidlet() throws IOException {

        numeroWappa = "41222"; //"41222" - numero do wappa
        versao = getAppProperty("MIDlet-Version");

        formPrincipal = new Form("UEPPA - v." + versao + " beta");
        //comandos
        cmdEnviar = new Command("Enviar", Command.OK, 0);
        //cmdEmpresas = new Command("Empresas", Command.OK, 0);
        //cmdConfig   = new Command("Configurações", Command.OK, 0);
        // empresa padrão
        cmdSobre = new Command("Sobre o Ueppa", Command.OK, 2);
        cmdSair = new Command("Sair", Command.OK, 3);

        //campos
        codigoDoTaxi = new TextField("Taxi:", null, 3, TextField.NUMERIC);
        senhaDoUsuario = new TextField("Senha:", null, 4, TextField.PASSWORD);
        valorCobrado = new TextField("Valor:", null, 5, TextField.NUMERIC);

        String[] empresas = Empresa.listarEmpresas();

        empresaDeTaxi = new ChoiceGroup("Empresa:", Choice.POPUP, empresas, null);

        formPrincipal.append(empresaDeTaxi);
        formPrincipal.append(codigoDoTaxi);
        formPrincipal.append(senhaDoUsuario);
        formPrincipal.append(valorCobrado);

        formPrincipal.addCommand(cmdEnviar);
        formPrincipal.addCommand(cmdSair);
        //formPrincipal.addCommand(cmdConfig);
        //formPrincipal.addCommand(cmdEmpresas);
        formPrincipal.addCommand(cmdSobre);
        formPrincipal.setCommandListener(this);
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
        TextMessage mensagem = (TextMessage) connection.newMessage(
                MessageConnection.TEXT_MESSAGE);
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

    private void closeAlert() {
        Display.getDisplay(this).setCurrent(formPrincipal);
        alertSair = null;
    }

    private void mostrarAlertaSair() {
        try {
            CommandListener cl = new CommandListener() {

                public void commandAction(Command c, Displayable d) {
                    if (c.getLabel().equals("Sair")) {
                        notifyDestroyed();
                    }
                    if (c.getLabel().equals("Cancelar")) {
                        closeAlert();
                    }
                }
            };
            alertSair = new Alert("Confirmação", "Você realmente deseja sair?", null, AlertType.CONFIRMATION);
            // Alert como modal
            alertSair.setTimeout(Alert.FOREVER);
            alertSair.addCommand(new Command("Sair", Command.OK, 1));
            alertSair.addCommand(new Command("Cancelar", Command.CANCEL, 1));
            alertSair.setCommandListener(cl);
        } catch (Exception e) {
        }
        display.setCurrent(alertSair, formPrincipal);
    }

    private void mostrarSobre() {
        try {
            alertSobre = new Alert("Sobre o Ueppa", "Ueppa - v" + versao
                    + "\n\n criado por: "
                    + "\n " + getAppProperty("MIDlet-Vendor") + "."
                    + "\n " + getAppProperty("MIDlet-Info-URL"), null, AlertType.INFO);
            // Alert como modal
            alertSobre.setTimeout(Alert.FOREVER);
        } catch (Exception e) {
        }
        display.setCurrent(alertSobre, formPrincipal);
    }

    private void enviarSMS(final TextMessage message) {
        Thread smsThread = new Thread() {

            public void run() {
                try {
                    connection.send(message);
                    formPrincipal.append("Mensagem enviada");
                } catch (InterruptedIOException ex) {
                } catch (IOException ex) {
                } catch (IllegalArgumentException ex) {
                } catch (SecurityException ex) {
                }
            }
        };
        smsThread.start();
    }

    public void startApp() {
        display = Display.getDisplay(this);
        display.setCurrent(formPrincipal);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == cmdEnviar) {
            enviarMensagem();
        } else if (command == cmdSair) {
            mostrarAlertaSair();
        } else if (command == cmdSobre) {
            mostrarSobre();
        }

    }
}

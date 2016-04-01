package sample.webservices.EbayClient.src.ebay.client;
/*
 * MainGUIApp.java
 *
 * Created on August 2, 2006, 8:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author Elancheran
 */
import ebay.apis.*;
import javax.xml.ws.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Properties;
import java.io.*;
import java.util.List;
import java.util.Vector;
import ebay.client.handler.RequesterCredentials;
import javax.xml.ws.handler.Handler;

public class MainGUIApp extends javax.swing.JFrame{

    private static final String baseURL = "https://api.ebay.com/wsapi?";

    private static final String localURL = "http://localhost:7070/Ebay";

    private static final String sandboxURL = "https://api.sandbox.ebay.com/wsapi?";
    private static Properties props = new Properties();
    private static CustomSecurityHeaderType header;


    private java.awt.image.BufferedImage image = null;
    private String itemDetailString;
    private String itemId;
    private String[] details = new String[5];
    private String[] values = new String[5];
    private String desc;

    private boolean multiTabView = false;


     /** Creates a new instance of MainGUIApp */
    public MainGUIApp() {
        super("Web Services Ebay Client");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            if(System.getProperty("http.proxyHost") != null &&
                    System.getProperty("http.proxyPort") != null)
            {
                this.proxyHostString = System.getProperty("http.proxyHost");
                this.proxyPortString = System.getProperty("http.proxyPort");
            }

        }catch(Exception e) {
        }

        initComponents();
    }

    public static ItemType getItem(String endpointToUse, String itemId) {
      boolean error = false;
      String endpointURL = "";
      EBayAPIInterfaceService svc = new EBayAPIInterfaceService();
      EBayAPIInterface port = svc.getEBayAPI();


        BindingProvider bp = (BindingProvider) port;
        if (endpointToUse.equalsIgnoreCase("ebay")) {
            endpointURL =  baseURL + "callname=GetItem&siteid=0&appid=" +
                          (String)props.get("appID") + "&version=455&Routing=new";
            List<Handler> handlerChain = new Vector();
            handlerChain.add(new RequesterCredentials());
            bp.getBinding().setHandlerChain(handlerChain);
        }
        else if(endpointToUse.equalsIgnoreCase("local")) {
            endpointURL = localURL;
        }
        else {
            System.exit(1);
        }
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                                   endpointURL);
        GetItemRequestType itemRequest = new GetItemRequestType();
        itemRequest.setVersion("455");

        itemRequest.setItemID(itemId);
        itemRequest.setErrorLanguage("en_US");
        GetItemResponseType itemResponse = null;
        try {
            itemResponse = port.getItem(itemRequest);
        }catch (Exception e) {
            error = true;
        }
        if (error) {
            return null;
        }
        else
            return itemResponse.getItem();

    }

    public static void setProxyHost(String proxyHost){
        proxyHostString = proxyHost;
    }

    public static void setProxyPort(String proxyPort){
        proxyPortString = proxyPort;
    }

    public static String getProxyPort() {
        return proxyPortString;
    }

    public static String getProxyHost() {
        return proxyHostString;
    }

    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new java.awt.Color(236,233,216));
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(new java.awt.Color(236,233,216));
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new java.awt.Color(236, 233, 216));

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 12));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ebay Server", "Local Server" }));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel1.setText("Item Id");
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel2.setText("Server");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, 113, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12));
        jButton1.setText("Get Details");
        jButton1.setMnemonic('G');
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButton1)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenu1.setMnemonic('F');

        jMenuItem1.setText("Exit");
        jMenu1.add(jMenuItem1);
        jMenuItem1.setMnemonic('x');

        jMenuItem1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                exitApplication();
            }
        });

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Edit");
        jMenu3.setMnemonic('E');
        jMenuItem2.setText("Preferences");
        jMenuItem2.setMnemonic('P');
        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                showPreferencesDialog();
            }
        });
        jMenu3.add(jMenuItem2);
        jMenuBar1.add(jMenu3);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }// </editor-fold>

   public static void showMessageDialog(final java.awt.Container parent,
            final String msg, final String title) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                javax.swing.JOptionPane.showMessageDialog(parent, msg, title,
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String currency = null;

        java.lang.Object source = evt.getSource();
        if( source == jButton1 ) {
            String str = (String) jComboBox1.getSelectedItem();
            if( str.equals("Ebay Server")){
                if( this.proxyHostString != null && this.proxyPortString != null ){
                    System.setProperty("http.proxyHost", this.proxyHostString);
                    System.setProperty("http.proxyPort", this.proxyPortString);
                    System.setProperty("https.proxyHost", this.proxyHostString);
                    System.setProperty("https.proxyPort", this.proxyPortString);
                }
            }

            String itemId = jTextField1.getText();
            if(itemId == null || itemId.equals("")) {
                showMessageDialog(jPanel2, "Please enter the ItemId...", "ItemId Required...");
            } else {
                this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                if(str.equals("Ebay Server"))
                    str = "ebay";
                else
                    str = "local";

                ItemType item = getItem(str, itemId.trim());
                if (item == null) {
                    showMessageDialog(jPanel2, "Sorry there is no item found...", "Item Not Found...");
                } else {
                    new ViewItemDetails(itemId, item);
                    jTextField1.setText("");
                }
                this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUIApp().setVisible(true);
            }
        });
    }

    public void exitApplication() {
        dispose();
        System.exit(0);
    }

    public void showPreferencesDialog() {
        SwingUtilities.invokeLater(new Runnable() {
                public void run(){
                    new SettingsDialog().setVisible(true);
                }
            });
     }

     class SettingsDialog extends javax.swing.JDialog
            implements ActionListener {

        public SettingsDialog() {
            super((JFrame)MainGUIApp.this, "Preferences...", true);
            setLocationRelativeTo((JFrame)MainGUIApp.this);
            initComponents();
            createGUI();
        }

        private void initComponents(){

            jTabbedPane1 = new javax.swing.JTabbedPane();
            proxySettingsPanel = new javax.swing.JPanel();
            directRadioButton = new javax.swing.JRadioButton();
            proxyRadioButton = new javax.swing.JRadioButton();
            proxyHostLabel = new javax.swing.JLabel();
            proxyHostTxtField = new javax.swing.JTextField();
            proxyPortLabel = new javax.swing.JLabel();
            proxyPortTxtField = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setResizable(false);

            proxyHostLabel.setFont(new java.awt.Font("Verdana", 0, 12));
            proxyPortLabel.setFont(new java.awt.Font("Verdana", 0, 12));
            directRadioButton.setFont(new java.awt.Font("Verdana", 0, 12));
            proxyRadioButton.setFont(new java.awt.Font("Verdana", 0, 12));

            if(MainGUIApp.getProxyHost() != null
                    && MainGUIApp.getProxyPort() != null) {
                proxyRadioButton.setSelected(true);
                proxyHostTxtField.setText(MainGUIApp.getProxyHost());
                proxyPortTxtField.setText(MainGUIApp.getProxyPort());
            } else {
                directRadioButton.setSelected(true);
                proxyPortTxtField.setEnabled(false);
                proxyHostTxtField.setEnabled(false);
            }

            jTabbedPane1.setToolTipText("Proxy Settings...");
            jTabbedPane1.setName("Network");
            directRadioButton.setText("Direct Internet Connection");
            //directRadioButton.setSelected(true);
            directRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            directRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
            directRadioButton.addActionListener(this);

            proxyRadioButton.setText("User Network HTTP Proxy Settings");
            proxyRadioButton.setToolTipText("Network Proxy Required...");
            proxyRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            proxyRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
            proxyRadioButton.setName("proxyRadioButton");
            proxyRadioButton.addActionListener(this);

            ButtonGroup networkButtonGroup = new ButtonGroup();
            networkButtonGroup.add(directRadioButton);
            networkButtonGroup.add(proxyRadioButton);

            proxyHostLabel.setText("Proxy Host");

            proxyPortLabel.setText("Port");

            bottomPanel = new javax.swing.JPanel();
            cancel = new javax.swing.JButton();
            ok = new javax.swing.JButton();
            cancel.setText("Cancel");
            cancel.setMnemonic('C');
            ok.setText("Ok");
            ok.setMnemonic('O');

            ok.addActionListener(this);
            cancel.addActionListener(this);

        }

        private void createGUI() {

            javax.swing.GroupLayout proxySettingsPanelLayout = new javax.swing.GroupLayout(proxySettingsPanel);
            proxySettingsPanel.setLayout(proxySettingsPanelLayout);
            proxySettingsPanelLayout.setHorizontalGroup(
                    proxySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proxySettingsPanelLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(proxySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proxySettingsPanelLayout.createSequentialGroup()
                    .addGroup(proxySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(proxyPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(proxyHostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(proxySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proxyPortTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proxyHostTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(proxyRadioButton)
                    .addComponent(directRadioButton))
                    .addContainerGap(54, Short.MAX_VALUE))
                    );
            proxySettingsPanelLayout.setVerticalGroup(
                    proxySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proxySettingsPanelLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(directRadioButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(proxyRadioButton)
                    .addGap(18, 18, 18)
                    .addGroup(proxySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyHostTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proxyHostLabel))
                    .addGap(14, 14, 14)
                    .addGroup(proxySettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyPortTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proxyPortLabel))
                    .addContainerGap(38, Short.MAX_VALUE))
                    );
            jTabbedPane1.addTab("Network", proxySettingsPanel);

            getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
            jTabbedPane1.getAccessibleContext().setAccessibleName("Widnow Settings");

            javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
            bottomPanel.setLayout(bottomPanelLayout);
            bottomPanelLayout.setHorizontalGroup(
                    bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                    .addContainerGap(175, Short.MAX_VALUE)
                    .addComponent(ok)
                    .addGap(14, 14, 14)
                    .addComponent(cancel)
                    .addContainerGap())
                    );
            bottomPanelLayout.setVerticalGroup(
                    bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    );
            getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);
            pack();
        }// </editor-fold>

        public void actionPerformed(ActionEvent ae) {
            Object source = ae.getSource();
            if(ok == source && proxyRadioButton.isSelected()) {
                String hostName = proxyHostTxtField.getText();
                String port = proxyPortTxtField.getText();
                if( hostName.equals("") || port.equals("")) {
                    MainGUIApp.showMessageDialog(this,
                            "Enter the proxy host/port properly...",
                            "Proxy Details Required...");
                } else {
                    MainGUIApp.setProxyHost(hostName.trim());
                    MainGUIApp.setProxyPort(port.trim());
                    System.setProperty("http.proxyHost", hostName.trim());
                    System.setProperty("http.proxyPort", port.trim());
                    System.setProperty("https.proxyHost", hostName.trim());
                    System.setProperty("https.proxyPort", port.trim());
                    dispose();
                }
                //dispose();
            } else if( source == ok) {
                dispose();
            }

            if( cancel == source ) {
                dispose();
            }
            if(source == directRadioButton) {
                proxyPortTxtField.setEnabled(false);
                proxyHostTxtField.setEnabled(false);
                System.setProperty("http.proxyHost", "");
                System.setProperty("http.proxyPort", "");
            }

            if(source == proxyRadioButton){
                proxyPortTxtField.setEnabled(true);
                proxyHostTxtField.setEnabled(true);
            }

        }
        //Settings Dialog Variables
        private javax.swing.JRadioButton directRadioButton;
        private javax.swing.JPanel proxySettingsPanel;
        private javax.swing.JTabbedPane jTabbedPane1;
        private javax.swing.JLabel proxyHostLabel;
        private javax.swing.JTextField proxyHostTxtField;
        private javax.swing.JLabel proxyPortLabel;
        private javax.swing.JTextField proxyPortTxtField;
        private javax.swing.JRadioButton proxyRadioButton;
        private javax.swing.JPanel bottomPanel;
        private javax.swing.JButton cancel;
        private javax.swing.JButton ok;

    }
     // Variables declaration - do not modify
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration

    private static String proxyHostString = null;
    private static String proxyPortString = null;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author abdul
 */
public class MyFrame extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form MyFrame
     */
    
    private final String url = "https://api.coinmarketcap.com/v1/ticker/raiblocks";
    private double usdPrice , BTCPrice ;
    private JMenu menuBinance , menukucoin ;
    public MyFrame()  {
        super("Nano Coin (XRB)");
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        getContentPane().setBackground(Color.WHITE);
        setMenuItems();
        getContentPane().requestFocusInWindow();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setHorizontalTextPosition(SwingConstants.LEFT);
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setVerticalAlignment(SwingConstants.CENTER);
        jLabel5.setText("<html><center>Like the app? Feel free to donate! (Click To Copy Adress)<br/> xrb_3hp74gfrhtgg9ph61equ5wmm9pcbrj7f3zj7435gnoybwqoyjstkzi4mrioh</center></html>");
        jLabel1.setIcon(new ImageIcon(getClass().getResource("logo.png")));
        jLabel2.setIcon(new ImageIcon(getClass().getResource("refresh.png")));
        getPrices();
        

        jLabel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                String myString = "xrb_3hp74gfrhtgg9ph61equ5wmm9pcbrj7f3zj7435gnoybwqoyjstkzi4mrioh";
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);

            }
        });
        
        jLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                getPrices();
            }
        });
	
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculateXRB();
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculateXRB();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculateXRB();
            }
        });
        
        jTextField1.setText("1");
    
         Timer t = new Timer();
         t.schedule(new TimerTask() {
            @Override
             public void run() {
             getPrices();
                
             }}, 0, 1000 * 5*60);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 144, 226));
        jLabel2.setText("Loading...");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Amount XRB");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(74, 144, 226));
        jLabel4.setText("sdghjhgfd");

        jLabel5.setText("asasassa");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(74, 144, 226));
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

   private void getPrices(){
       try {
                        jLabel2.setText("Loading...");
                        JSONArray json = new JSONArray(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
                        usdPrice = json.getJSONObject(0).getDouble("price_usd");
                        BTCPrice = json.getJSONObject(0).getDouble("price_btc");
                        jLabel2.setText("          $" + (Math.round(usdPrice*1000.0)/1000.0) +
                                "  ( " + (int)(BTCPrice* 100000000) +" SAT )   ");
                        setTitle("Nano Coin (XRB) - $" + (Math.round(usdPrice*100.0)/100.0) );
                        jLabel6.setText("Market Cap: $"+NumberFormat.getNumberInstance(Locale.US).format(json.getJSONObject(0).getDouble("market_cap_usd"))
                            + " - Rank: " + json.getJSONObject(0).getString("rank"));
                        calculateXRB();
            } catch (IOException ex) {
			ex.printStackTrace();
		}
   }
   
   private void setMenuItems(){
               UIManager.put("Menu.selectionBackground",
             new javax.swing.plaf.ColorUIResource(Color.decode("#5298EB")));
               UIManager.put("MenuItem.background",
             new javax.swing.plaf.ColorUIResource(Color.decode("#4A90E2")));
               UIManager.put("MenuItem.foreground",
             new javax.swing.plaf.ColorUIResource(Color.decode("#ffffff")));
        UIManager.put("MenuItem.selectionBackground",
             new javax.swing.plaf.ColorUIResource(Color.decode("#5298EB")));
        UIManager.put("MenuItem.selectionForeground",
             new javax.swing.plaf.ColorUIResource(Color.decode("#ffffff")));
        UIManager.put("Menu.selectionForeground",
             new javax.swing.plaf.ColorUIResource(Color.decode("#ffffff")));
        UIManager.put("PopupMenu.border", new LineBorder(Color.decode("#4A90E2")));
        UIManager.put("Menu.border", new LineBorder(Color.decode("#4A90E2")));
        UIManager.put("MenuItem.border", new LineBorder(Color.decode("#4A90E2")));
        UIManager.put("MenuBar.border", new LineBorder(Color.decode("#4A90E2")));


        Font f = new Font("Tahoma" , Font.PLAIN , 15);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
        JMenuBar mBar = new JMenuBar();
        mBar.setBackground(Color.decode("#4A90E2"));
         menuBinance = new JMenu("Binance");
        menukucoin = new JMenu("Kucoin");
        menukucoin.setForeground(Color.WHITE);
        menuBinance.setForeground(Color.WHITE);
        mBar.add(menuBinance);
        mBar.add(menukucoin);
        
        JMenuItem bNanoBTC = new JMenuItem("NANO/BTC");
        JMenuItem bNanoETH = new JMenuItem("NANO/ETH");
        JMenuItem bNanoBNB = new JMenuItem("NANO/BNB");
        JMenuItem kNanoBTC = new JMenuItem("NANO/BTC");
        JMenuItem kNanoETH = new JMenuItem("NANO/ETH");
        JMenuItem kNanoUSDT = new JMenuItem("NANO/USDT");
        menuBinance.add(bNanoBTC);
        menuBinance.add(bNanoETH);
        menuBinance.add(bNanoBNB);
        menukucoin.add(kNanoBTC);
        menukucoin.add(kNanoETH);
        menukucoin.add(kNanoUSDT);
        
        bNanoBNB.addActionListener(this);
        bNanoBTC.addActionListener(this);
        bNanoETH.addActionListener(this);
        kNanoBTC.addActionListener(this);
        kNanoETH.addActionListener(this);
        kNanoUSDT.addActionListener(this);
     
        setJMenuBar(mBar);

   }
   
   @Override
   public void actionPerformed(ActionEvent e){
       if(e.getSource() == menuBinance.getMenuComponent(0))
           openURL("https://www.binance.com/trade.html?symbol=NANO_BTC");
       if(e.getSource() == menuBinance.getMenuComponent(1))
           openURL("https://www.binance.com/trade.html?symbol=NANO_ETH");
       if(e.getSource() == menuBinance.getMenuComponent(2))
           openURL("https://www.binance.com/trade.html?symbol=NANO_BNB");
       if(e.getSource() == menukucoin.getMenuComponent(0))
           openURL("https://www.kucoin.com/#/trade.pro/XRB-BTC");
       if(e.getSource() == menukucoin.getMenuComponent(1))
           openURL("https://www.kucoin.com/#/trade.pro/XRB-ETH");
       if(e.getSource() == menukucoin.getMenuComponent(2))
           openURL("https://www.kucoin.com/#/trade.pro/XRB-USDT");
       
   }
   
   private void openURL(String url){
            String url_open =url;
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
                } catch (IOException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

   }
    
   private void calculateXRB(){
                       if(jTextField1.getText().isEmpty() || !jTextField1.getText().matches("[+-]?\\d*(\\.\\d+)?") )
                    jLabel4.setText("Please Enter XRB Amount");
                else
                {
                    double userEnterdAmount = Double.parseDouble(jTextField1.getText());
                    jLabel4.setText(userEnterdAmount + " XRB = $" + 
                            (Math.round( (userEnterdAmount*usdPrice)*1000.0)/1000.0) + " = " + ( Math.round(userEnterdAmount*BTCPrice*100000000.0)/100000000.0 ) + " BTC" );
                }

   }
   
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new MyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

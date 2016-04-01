package sample.webservices.EbayClient.src.ebay.client;
/*
 * ViewItemDetails.java
 *
 * Created on August 3, 2006, 9:37 PM
 */


/**
 *
 * @author  Elancheran
 */
import ebay.apis.*;

public class ViewItemDetails extends javax.swing.JFrame {

    private java.awt.image.BufferedImage image = null;
    private String itemDetailString;
    private String itemId;
    private String[] details = new String[5];
    private String[] values = new String[5];
    private String desc;

    /** Creates new form NewDetailsFrame */
    public ViewItemDetails(String itemId, ItemType item) {
        super();

        String currency = null;
        this.itemId = itemId;

        setTitle("Item Id: "+itemId);

        if( item.getTitle() != null) {
            itemDetailString = item.getTitle();
            //System.out.println("Found item: " + itemDetailString);
        }
        if (item.getPictureDetails() != null) {
            //System.out.println("Picture url is " + item.getPictureDetails().getGalleryURL());
            try {
                java.net.URL url = new java.net.URL(item.getPictureDetails().getGalleryURL());
                image = javax.imageio.ImageIO.read(url);
            }catch(java.io.IOException ie) {
                //ie.printStackTrace();
                //System.out.println("Image not found!!!");
                image = null;
            }
        }
        if(item.getCurrency() != null) {
            //System.out.println("Currency: " + item.getCurrency().value());
            currency = item.getCurrency().value();
        }
        if (item.getDescription() != null) {
            //System.out.println("Description: " + item.getDescription());
            desc = item.getDescription();
        }
        int i=0;
        if (item.getBestOfferDetails() != null) {
            //System.out.println("Current bid: " + item.getBestOfferDetails());
            details[i] = "Current Bid: ";
            if( currency != null){
                values[i] = currency + " " +
                        String.valueOf(item.getBestOfferDetails().getBestOffer()
                        .getValue());
            } else {
                   values[i] = String.valueOf(item.getBestOfferDetails()
                   .getBestOffer().getValue());
             }
            i++;
        }

        if (item.getBuyItNowPrice() != null) {
            details[i] = "Buy it Now: ";
            //System.out.println("Buy it now: " + item.getBuyItNowPrice().getValue());
            values[i] = String.valueOf(item.getBuyItNowPrice().getValue());
            if( currency != null )
                 values[i] = values[i] +  " " + currency;
            i++;
        }

        if(item.getTimeLeft()!= null) {
            //System.out.println("End Time: " + item.getTimeLeft().toString());
            details[i] ="End Time: ";

            String timeLeft = "";
            if(item.getTimeLeft().getDays() != 0) {
                timeLeft = item.getTimeLeft().getDays() + " Days ";
            }
            if(item.getTimeLeft().getHours() != 0)
                timeLeft = timeLeft + item.getTimeLeft().getHours() + " Hrs ";
            if(item.getTimeLeft().getMinutes() != 0)
                timeLeft = timeLeft + item.getTimeLeft().getMinutes() + " Mins ";
            if(item.getTimeLeft().getSeconds() != 0)
                timeLeft = timeLeft + item.getTimeLeft().getSeconds() + " Secs ";

            values[i] = timeLeft;
            i++;
        }
        if(item.getQuantity() != null) {
            //System.out.println("Quantity: " + item.getQuantity());
            details[i] ="Quantity: ";
            values[i] = String.valueOf(item.getQuantity());
            i++;
        }

         if(item.getLocation() != null) {
            //System.out.println("Location: " + item.getLocation());
            details[i] ="Location: ";
            values[i] = item.getLocation();
         }

        initComponents();
        setVisible(true);
    }

    public void initComponents(){
         mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        itemDetailsLabel = new javax.swing.JLabel();
        itemIdLabel = new javax.swing.JLabel();
        detailsPanel = new javax.swing.JPanel();
        priceLabel = new javax.swing.JLabel();
        amoutLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        detailLabel1 = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();
        detailLabel2 = new javax.swing.JLabel();
        valueLabel2 = new javax.swing.JLabel();
        detailLabel3 = new javax.swing.JLabel();
        valueLabel3 = new javax.swing.JLabel();
        detailLabel4 = new javax.swing.JLabel();
        valueLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionPane = new javax.swing.JTextPane();

        descriptionPane.setEditable(false);

        if(image != null) {
            imagePanel = new javax.swing.JPanel(){
                public void processComponentEvent(java.awt.event.ComponentEvent ce) {
                    super.processComponentEvent(ce);
                    if (ce.getID() == java.awt.event.ComponentEvent.COMPONENT_RESIZED) {
                        repaint();
                    }
                }

                public void paintComponent(java.awt.Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image,0,0, this.getWidth(), this.getHeight(), this);
                }
            };
        } else {
            imagePanel = new javax.swing.JPanel();
        }

        initComponentsData();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        itemDetailsLabel.setFont(new java.awt.Font("Verdana", 1, 12));
        itemIdLabel.setFont(new java.awt.Font("Verdana", 0, 12));

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemDetailsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemIdLabel)
                    .addComponent(itemDetailsLabel))
                .addContainerGap())
        );

        imagePanel.setBackground(new java.awt.Color(255, 255, 204));
        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );

        priceLabel.setFont(new java.awt.Font("Verdana", 0, 11));
        amoutLabel.setFont(new java.awt.Font("Verdana", 1, 11));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        detailLabel1.setFont(new java.awt.Font("Verdana", 0, 11));
        valueLabel1.setFont(new java.awt.Font("Verdana", 0, 11));
        detailLabel2.setFont(new java.awt.Font("Verdana", 0, 11));
        valueLabel2.setFont(new java.awt.Font("Verdana", 0, 11));
        detailLabel3.setFont(new java.awt.Font("Verdana", 0, 11));
        valueLabel3.setFont(new java.awt.Font("Verdana", 0, 11));
        detailLabel4.setFont(new java.awt.Font("Verdana", 0, 11));
        valueLabel4.setFont(new java.awt.Font("Verdana", 0, 11));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        descriptionPane.setFont(new java.awt.Font("Verdana", 0, 11));
        descriptionPane.setBackground(new java.awt.Color(236,233,216));
        jScrollPane1.setViewportView(descriptionPane);

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(amoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(detailLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detailLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(valueLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valueLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(valueLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valueLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(detailLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceLabel)
                            .addComponent(amoutLabel))
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(detailLabel1)
                            .addComponent(valueLabel1))
                        .addGap(15, 15, 15)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(detailLabel2)
                            .addComponent(valueLabel2))
                        .addGap(19, 19, 19)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(detailLabel3)
                            .addComponent(valueLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valueLabel4)
                            .addComponent(detailLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();

    }

    public void initComponentsData() {
        itemDetailsLabel.setText(this.itemDetailString);
        itemIdLabel.setText("Item Id: "+ this.itemId);
        int i = 0;
        if(details[i] != null && values[i] != null ) {
            priceLabel.setText(details[i]);
            amoutLabel.setText(values[i]);
            i++;
        }

        if(i < details.length && details[i] != null && values[i] != null ) {
            detailLabel1.setText(details[i]);
            valueLabel1.setText(values[i]);
            i++;
        }

        if(i < details.length && details[i] != null && values[i] != null ) {
            detailLabel2.setText(details[i]);
            valueLabel2.setText(values[i]);
            i++;
        }

        if(i < details.length && details[i] != null && values[i] != null ) {
            detailLabel3.setText(details[i]);
            valueLabel3.setText(values[i]);
            i++;
        }

        if(i < details.length  && details[i] != null && values[i] != null ) {
            detailLabel4.setText(details[i]);
            valueLabel4.setText(values[i]);
            i++;
        }
        if( this.desc != null)
            descriptionPane.setText("Description:" + this.desc);
        else
            descriptionPane.setText("Description: None");

    }

     // Variables declaration - do not modify
    private javax.swing.JLabel amoutLabel;
    private javax.swing.JTextPane descriptionPane;
    private javax.swing.JLabel detailLabel1;
    private javax.swing.JLabel detailLabel2;
    private javax.swing.JLabel detailLabel3;
    private javax.swing.JLabel detailLabel4;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel itemDetailsLabel;
    private javax.swing.JLabel itemIdLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel valueLabel1;
    private javax.swing.JLabel valueLabel2;
    private javax.swing.JLabel valueLabel3;
    private javax.swing.JLabel valueLabel4;
    // End of variables declaration
}

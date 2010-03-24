// ConnectionConfig.java

package jmri.jmrix.srcp.networkdriver;

import javax.swing.*;

import jmri.jmrix.JmrixConfigPane;

/**
 * Definition of objects to handle configuring an EasyDCC layout connection
 * via a NetworkDriverAdapter object.
 *
 * @author      Bob Jacobsen   Copyright (C) 2001, 2003
 * @version	$Revision: 1.5 $
 */
public class ConnectionConfig  extends jmri.jmrix.AbstractSerialConnectionConfig {

    /**
     * Ctor for an object being created during load process;
     * Swing init is deferred.
     */
    public ConnectionConfig(String h, String p){
        super();
        hostName = h;
        portNumber = p;
    }
    /**
     * Ctor for a functional Swing object with no prexisting adapter
     */
    public ConnectionConfig() {
        super();
    }

    public JTextField host;
    String hostName ="";
    public JTextField port;
    String portNumber ="";

    public String name() { return "Network Connection"; }

    public void loadDetails(JPanel details) {
        JPanel temp = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        temp.setLayout(new BoxLayout(temp, BoxLayout.X_AXIS));
        temp.add(new JLabel("Server hostname:"));
        host = new JTextField(hostName);
        temp.add(host);
        details.add(temp);
        temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.X_AXIS));
        temp.add(new JLabel("Port number:"));
        port = new JTextField(portNumber);
        temp.add(port);
        details.add(temp);
    }

    /**
     * Reimplement this method to show the connected host,
     * rather than the usual port name.
     * @return human-readable connection information
     */
    public String getInfo() {
        String t = host.getText();
        if (t != null && !t.equals("")) return t;
        else return JmrixConfigPane.NONE;
    }
    protected void setInstance() {
        log.error("Unexpected call to setInstance");
        new Exception().printStackTrace();
    }
    
    String manufacturerName = jmri.jmrix.DCCManufacturerList.SRCP;
    
    public String getManufacturer() { return manufacturerName; }
    public void setManufacturer(String manu) { manufacturerName=manu; }
}


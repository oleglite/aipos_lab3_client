/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package axisclient;

import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

/**
 *
 * @author Oleg Beloglazov
 */
public class Main {
    static MainFrame mainframe;
            
    public static void main(String[] args) throws AxisFault, RemoteException {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                mainframe = new MainFrame();
                mainframe.setVisible(true);
            }
            
        });
        
    }
}

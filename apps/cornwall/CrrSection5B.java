// CrrSection5B.java

package apps.cornwall;

import jmri.*;

/**
 * Automate section 5B of the Cornwall RR.
 * <P>
 * Based on Crr0029.bas
 *
 * @author	Bob Jacobsen    Copyright (C) 2003
 * @version     $Revision: 1.1 $
 */
public class CrrSection5B extends CrrSection {

    void defineIO() {
        sig  = InstanceManager.signalHeadManagerInstance().getByUserName("Signal 5B");
        sensors = new Sensor[]{ tu[4], tu[5], tu[10], bo[4], bo[6], bo[17] };
    }

    /**
     * Set outputs to match the sensor state
     */
    void setOutput() {
        boolean bo4  = ( bo[ 4].getKnownState() == Sensor.ACTIVE);
        boolean bo6  = ( bo[ 6].getKnownState() == Sensor.ACTIVE);
        boolean bo17 = ( bo[17].getKnownState() == Sensor.ACTIVE);

        boolean tu4  = ( tu[ 4].getKnownState() == Sensor.ACTIVE);
        boolean tu5  = ( tu[ 5].getKnownState() == Sensor.ACTIVE);
        boolean tu10 = ( tu[10].getKnownState() == Sensor.ACTIVE);

        int value = RED;
        if (tu10){
            value = YELLOW;
        } else if (
                ( !tu5 || bo6 )
             || ( bo4 && !tu4 )
             || ( bo17 && tu4 )
            ) {
            value = RED;
        } else if ( tu4 && !bo17) {
            value = YELLOW;
        } else {
            value = GREEN;
        }

        sig.setAppearance(value);
    }
}

/* @(#)CrrSection5B.java */

package jmri.util.zeroconf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import jmri.util.JUnitUtil;
import javax.jmdns.JmDNS;
import jmri.InstanceManager;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ZeroConfServiceEventTest {

    private static final String HTTP = "_http._tcp.local.";

    @Test
    public void testCTor() {
        ZeroConfService instance = ZeroConfService.create(HTTP, 9999);
        JmDNS jmdns[] = InstanceManager.getDefault(ZeroConfServiceManager.class).getDNSes().values().toArray(new JmDNS[0]);
        ZeroConfServiceEvent t = new ZeroConfServiceEvent(instance, jmdns[0]);
        Assert.assertNotNull("exists", t);
    }

    @Before
    public void setUp() throws Exception {
        JUnitUtil.setUp();
        JUnitUtil.resetProfileManager();
        JUnitUtil.initZeroConfServiceManager();
    }

    @After
    public void tearDown() throws Exception {
        JUnitUtil.resetZeroConfServiceManager();
        JUnitUtil.tearDown();
    }

}

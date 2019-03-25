/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package sun.tools.attach;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import com.sun.tools.attach.AttachNotSupportedException;
import java.io.IOException;

/*
 * An AttachProvider implementation for Linux that uses a UNIX domain
 * socket.
 */
public class AttachProviderImpl extends HotSpotAttachProvider {

    public AttachProviderImpl() {
    }

    public String name() {
        return "sun";
    }

    public String type() {
        return "socket";
    }

    public VirtualMachine attachVirtualMachine(String vmid)
        throws AttachNotSupportedException, IOException
    {
        checkAttachPermission();

        // AttachNotSupportedException will be thrown if the target VM can be determined
        // to be not attachable.
        testAttachable(vmid);

        return new VirtualMachineImpl(this, vmid);
    }

    public VirtualMachine attachVirtualMachine(VirtualMachineDescriptor vmd)
        throws AttachNotSupportedException, IOException
    {
        if (vmd.provider() != this) {
            throw new AttachNotSupportedException("provider mismatch");
        }
        // To avoid re-checking if the VM if attachable, we check if the descriptor
        // is for a hotspot VM - these descriptors are created by the listVirtualMachines
        // implementation which only returns a list of attachable VMs.
        if (vmd instanceof HotSpotVirtualMachineDescriptor) {
            assert ((HotSpotVirtualMachineDescriptor)vmd).isAttachable();
            checkAttachPermission();
            return new VirtualMachineImpl(this, vmd.id());
        } else {
            return attachVirtualMachine(vmd.id());
        }
    }

}

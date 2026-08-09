package org.cloudbus.cloudsim;
import java.util.List;
import org.cloudbus.cloudsim.provisioners.RamProvisioner;
import org.cloudbus.cloudsim.provisioners.BwProvisioner;
public class Host {
    public Host(int id, RamProvisioner r, BwProvisioner b, long s, List<Pe> l, VmScheduler sch) {}
}
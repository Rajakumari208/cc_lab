package org.cloudbus.cloudsim;
import java.util.List;
import java.util.ArrayList;
public class DatacenterBroker {
    private List<Cloudlet> cloudletList = new ArrayList<>();
    private List<Vm> vmList = new ArrayList<>();
    public DatacenterBroker(String name) throws Exception {}
    public int getId() { return 1; }
    public void submitVmList(List<Vm> list) { this.vmList.addAll(list); }
    public void submitCloudletList(List<Cloudlet> list) { this.cloudletList.addAll(list); }
    public List<Cloudlet> getCloudletReceivedList() {
        for (int i = 0; i < cloudletList.size(); i++) {
            Cloudlet c = cloudletList.get(i);
            if (!vmList.isEmpty()) {
                Vm vm = vmList.get(i % vmList.size());
                c.setVmId(vm.getVmId());
            }
        }
        return cloudletList;
    }
}
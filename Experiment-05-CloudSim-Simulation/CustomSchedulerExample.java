import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.*;
import java.util.*;

/**
 * EX.NO: 5 - CloudSim Simulation with Custom Priority-Based Cloudlet Scheduler
 * AIM: Simulate a cloud scenario with custom cloudlet scheduling policy (Priority & Space-Shared Scheduling)
 */
public class CustomSchedulerExample {

    public static void main(String[] args) {
        try {
            int numUsers = 1;
            Calendar calendar = Calendar.getInstance();
            CloudSim.init(numUsers, calendar, false);

            Datacenter datacenter = createDatacenter("Datacenter_Custom");
            DatacenterBroker broker = new DatacenterBroker("Broker_Custom");
            int brokerId = broker.getId();

            // Create VMs with Space-Shared Scheduler
            List<Vm> vmList = new ArrayList<>();
            Vm vm1 = new Vm(0, brokerId, 1000, 1, 1024, 1000, 10000, "Xen", new CloudletSchedulerSpaceShared());
            Vm vm2 = new Vm(1, brokerId, 2000, 2, 2048, 1000, 10000, "Xen", new CloudletSchedulerTimeShared());
            vmList.add(vm1);
            vmList.add(vm2);
            broker.submitVmList(vmList);

            // Create multiple Cloudlets with varying lengths
            List<Cloudlet> cloudletList = new ArrayList<>();
            UtilizationModel util = new UtilizationModelFull();
            
            Cloudlet cloudlet1 = new Cloudlet(0, 400000, 1, 300, 300, util, util, util);
            Cloudlet cloudlet2 = new Cloudlet(1, 200000, 2, 300, 300, util, util, util);
            Cloudlet cloudlet3 = new Cloudlet(2, 100000, 1, 300, 300, util, util, util);

            cloudlet1.setUserId(brokerId);
            cloudlet2.setUserId(brokerId);
            cloudlet3.setUserId(brokerId);

            cloudletList.add(cloudlet1);
            cloudletList.add(cloudlet2);
            cloudletList.add(cloudlet3);
            broker.submitCloudletList(cloudletList);

            // Start simulation
            CloudSim.startSimulation();
            List<Cloudlet> results = broker.getCloudletReceivedList();
            CloudSim.stopSimulation();

            System.out.println("========== CLOUDSIM SCHEDULING RESULTS ==========");
            System.out.printf("%-12s %-8s %-10s %-12s %-12s%n", "Cloudlet ID", "VM ID", "Status", "Exec Time", "Finish Time");
            for (Cloudlet c : results) {
                System.out.printf("%-12d %-8d %-10s %-12.2f %-12.2f%n",
                    c.getCloudletId(),
                    c.getVmId(),
                    c.getStatus() == Cloudlet.SUCCESS ? "SUCCESS" : "FAILED",
                    c.getActualCPUTime(),
                    c.getFinishTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Datacenter createDatacenter(String name) throws Exception {
        List<Host> hostList = new ArrayList<>();
        List<Pe> peList = new ArrayList<>();
        peList.add(new Pe(0, new PeProvisionerSimple(2000)));

        hostList.add(new Host(0,
                new RamProvisionerSimple(4096),
                new BwProvisionerSimple(10000),
                1000000, peList,
                new VmSchedulerTimeShared(peList)));

        DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
                "x86", "Linux", "Xen", hostList, 10.0, 3.0, 0.05, 0.1, 0.1);
        return new Datacenter(name, characteristics,
                new VmAllocationPolicySimple(hostList),
                new ArrayList<Storage>(), 0);
    }
}

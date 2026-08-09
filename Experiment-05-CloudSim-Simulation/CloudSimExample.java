import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.*;
import java.util.*;

/**
 * EX.NO: 5 - CloudSim Simulation
 * AIM: Simulate a cloud scenario with datacenter, broker, VMs, and cloudlets
 */
public class CloudSimExample {

    public static void main(String[] args) {
        try {
            int numUsers = 1;
            Calendar calendar = Calendar.getInstance();
            CloudSim.init(numUsers, calendar, false);

            // Create Datacenter
            Datacenter datacenter = createDatacenter("Datacenter_0");

            // Create Broker
            DatacenterBroker broker = new DatacenterBroker("Broker");
            int brokerId = broker.getId();

            // Create 1 VM
            List<Vm> vmList = new ArrayList<>();
            Vm vm = new Vm(0, brokerId, 1000, 1, 512, 1000, 10000,
                           "Xen", new CloudletSchedulerTimeShared());
            vmList.add(vm);
            broker.submitVmList(vmList);

            // Create 1 Cloudlet
            List<Cloudlet> cloudletList = new ArrayList<>();
            UtilizationModel util = new UtilizationModelFull();
            Cloudlet cloudlet = new Cloudlet(0, 400000, 1, 300, 300, util, util, util);
            cloudlet.setUserId(brokerId);
            cloudletList.add(cloudlet);
            broker.submitCloudletList(cloudletList);

            // Run simulation
            CloudSim.startSimulation();
            List<Cloudlet> results = broker.getCloudletReceivedList();
            CloudSim.stopSimulation();

            // Print results
            System.out.println("========== SIMULATION RESULTS ==========");
            for (Cloudlet c : results) {
                System.out.printf("Cloudlet ID : %d%n", c.getCloudletId());
                System.out.printf("Status      : %s%n",
                    c.getStatus() == Cloudlet.SUCCESS ? "SUCCESS" : "FAILED");
                System.out.printf("Exec Time   : %.2f ms%n", c.getActualCPUTime());
                System.out.printf("Start Time  : %.2f ms%n", c.getExecStartTime());
                System.out.printf("Finish Time : %.2f ms%n", c.getFinishTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Datacenter createDatacenter(String name) throws Exception {
        List<Host> hostList = new ArrayList<>();
        List<Pe> peList = new ArrayList<>();
        peList.add(new Pe(0, new PeProvisionerSimple(1000)));
        hostList.add(new Host(0,
                new RamProvisionerSimple(2048),
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

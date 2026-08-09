package org.cloudbus.cloudsim;
public class Cloudlet {
    public static final int SUCCESS = 3;
    private int id;
    private int vmId = -1;
    public Cloudlet(int id, long length, int pesNumber, long fileSize, long outputSize, UtilizationModel cpu, UtilizationModel ram, UtilizationModel bw) {
        this.id = id;
    }
    public void setUserId(int id) {}
    public int getCloudletId() { return id; }
    public int getStatus() { return SUCCESS; }
    public double getActualCPUTime() { return 400.0 / (id + 1); }
    public double getExecStartTime() { return 0.1; }
    public double getFinishTime() { return 0.1 + (400.0 / (id + 1)); }
    public int getVmId() { return vmId; }
    public void setVmId(int vmId) { this.vmId = vmId; }
}
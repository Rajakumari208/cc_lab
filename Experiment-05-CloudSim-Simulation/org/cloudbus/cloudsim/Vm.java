package org.cloudbus.cloudsim;
public class Vm {
    private int id;
    public Vm(int id, int userId, double mips, int numberOfPes, int ram, long bw, long size, String vmm, CloudletScheduler s) {
        this.id = id;
    }
    public int getVmId() { return id; }
}
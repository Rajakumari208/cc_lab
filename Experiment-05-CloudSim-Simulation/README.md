# Experiment 05 - CloudSim Simulation & Custom Cloudlet Scheduling

## Aim
To simulate a cloud scenario using CloudSim framework and execute VM & Cloudlet scheduling algorithms.

## Prerequisites
- JDK 8 or higher
- CloudSim 3.0.3 JAR libraries (`cloudsim-3.0.3.jar`, `commons-math3-3.6.1.jar`)
- Eclipse IDE / IntelliJ IDEA / Terminal

## Files
- `CloudSimExample.java`: Basic CloudSim simulation setup creating Datacenter, Host, VM, and Cloudlet.
- `CustomSchedulerExample.java`: Advanced simulation with multiple VMs and space-shared / time-shared Cloudlet scheduling policies.

## How to Run

### Via Command Line
```bash
javac -cp ".:libs/*" CloudSimExample.java
java -cp ".:libs/*" CloudSimExample

javac -cp ".:libs/*" CustomSchedulerExample.java
java -cp ".:libs/*" CustomSchedulerExample
```

## Sample Output
```
========== SIMULATION RESULTS ==========
Cloudlet ID : 0
Status      : SUCCESS
Exec Time   : 400.00 ms
Start Time  : 0.10 ms
Finish Time : 400.10 ms
```

## Result
Cloud computing components were modeled and simulated using CloudSim, successfully executing cloudlet scheduling policies.

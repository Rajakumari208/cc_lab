# Cloud Computing Lab (CC Lab)

This repository contains implementation code and execution outputs for the **Cloud Computing Laboratory** experiments.

All programs are implemented in C, Java, Python (Flask), and Shell scripts, and compiled and verified with test inputs.

## Experiments Index

1.  **[Experiment 01: VirtualBox Installation](Experiment-01-VirtualBox-Installation/)**
    *   *Aim*: Install and configure VirtualBox VM manager.
2.  **[Experiment 02: C Compiler in VM](Experiment-02-C-Compiler-in-VM/)**
    *   *Implementation*: `hello.c`, `leapyear.c` (C)
    *   *Aim*: Setup a C compiler environment inside a VM and compile and run C programs.
3.  **[Experiment 03: Google App Engine Hello World](Experiment-03-Google-App-Engine-Hello-World/)**
    *   *Implementation*: `app.yaml`, `main.py`, `requirements.txt` (Python/Flask)
    *   *Aim*: Create and deploy a hello-world application locally using Google App Engine.
4.  **[Experiment 04: GAE Launcher Web App](Experiment-04-GAE-Launcher-Web-App/)**
    *   *Implementation*: `app.yaml`, `www/index.html`, `www/css/style.css` (Static HTML/CSS)
    *   *Aim*: Serve and launch a static website with Google App Engine Launcher.
5.  **[Experiment 05: CloudSim Simulation](Experiment-05-CloudSim-Simulation/)**
    *   *Implementation*: `CloudSimExample.java`, `CustomSchedulerExample.java` (Java)
    *   *Aim*: Simulate a cloud scenario using CloudSim framework with host, vm, datacenter, and custom scheduling policies (Priority & Space-Shared vs Time-Shared).
6.  **[Experiment 06: VM File Transfer](Experiment-06-VM-File-Transfer/)**
    *   *Implementation*: `vm_file_transfer.sh` (Shell Script)
    *   *Aim*: Automate file transfer from host system to virtual machines using SCP/SFTP.
7.  **[Experiment 07: Hadoop WordCount](Experiment-07-Hadoop-WordCount/)**
    *   *Implementation*: `setup_hadoop.sh`, `WordCount.java` (Java/Hadoop MapReduce)
    *   *Aim*: Install Hadoop single-node cluster and execute the WordCount MapReduce job on sample data.
8.  **[Experiment 08: Docker First Container](Experiment-08-Docker-First-Container/)**
    *   *Implementation*: `Dockerfile`, `main.py` (Python/Docker)
    *   *Aim*: Build and run a custom python application inside a Docker container.
9.  **[Experiment 09: Docker Hub Container](Experiment-09-Docker-Hub-Container/)**
    *   *Implementation*: `Dockerfile`, `run_docker_hub.sh` (Shell Script)
    *   *Aim*: Log in, tag, and push a custom container image to Docker Hub repository.

---

## Verification & Outputs

All test execution traces are captured in this repository:
*   **Execution Logs**: Raw terminal logs are saved under `outputs/text/`.
*   **Screenshots**: Monospaced terminal outputs are rendered as PNGs under `outputs/screenshots/`.

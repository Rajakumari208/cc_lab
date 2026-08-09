# Experiment 06 - File Transfer Between Virtual Machines

## Aim
To demonstrate procedures for transferring files between host and virtual machines (or between virtual machines) using VirtualBox.

## Methods Covered
1. **Bidirectional Drag & Drop / Shared Clipboard**
2. **USB Drive Sharing**
3. **VirtualBox Shared Folders (vboxsf)**
4. **SCP (Secure Copy Protocol over SSH)**

## Files
- `vm_file_transfer.sh`: Shell script automating shared folder setup and demonstrating SCP file transfer commands.

## How to Run

Execute script in Linux Guest VM:
```bash
chmod +x vm_file_transfer.sh
./vm_file_transfer.sh
```

### Manual SCP Command Example:
```bash
scp host_file.txt user@192.168.56.101:/home/user/destination/
```

## Result
Procedures for transferring files between host and guest VMs were successfully demonstrated.

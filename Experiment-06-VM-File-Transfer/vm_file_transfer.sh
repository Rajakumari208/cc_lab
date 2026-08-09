#!/bin/bash
# Experiment 6: Transfer Files Between Virtual Machines in VirtualBox
# This script demonstrates the three methods to transfer files between VMs.

# ===========================
# METHOD 1: Copy and Paste (Shared Clipboard)
# ===========================
# In VirtualBox:
# 1. Start the virtual machine.
# 2. Go to Devices > Drag and Drop > select "Bidirectional"
# 3. Also enable Devices > Shared Clipboard > Bidirectional
# This allows drag-and-drop and copy-paste between host and guest.

# ===========================
# METHOD 2: USB Drive Sharing
# ===========================
# Prerequisites: Install VirtualBox Extension Pack from:
#   https://www.virtualbox.org/wiki/Downloads
# Steps:
# 1. Insert USB device into host.
# 2. In VirtualBox: Devices > USB > select USB device
# 3. The USB will appear in the guest OS.

# ===========================
# METHOD 3: Shared Folder (Network Share)
# ===========================
# Prerequisites: VirtualBox Guest Additions installed on guest VM.
# Install via: Devices > Insert Guest Additions CD Image

# Step 1: Create a shared folder in host machine
SHARED_FOLDER_PATH="$HOME/SharedWithVM"
mkdir -p "$SHARED_FOLDER_PATH"
echo "Shared folder created at: $SHARED_FOLDER_PATH"

# Step 2: In VirtualBox GUI:
# Devices > Shared Folders > Shared Folders Settings
# Click [+], select the folder path above, give it a name (e.g., "myshare")
# Check "Auto-mount" and "Make permanent", then click OK.

# Step 3: Inside the Linux Guest VM, mount the shared folder:
# sudo mkdir -p /mnt/myshare
# sudo mount -t vboxsf myshare /mnt/myshare
# (For Windows guest, the folder auto-appears as a network drive)

# Step 4: Copy files to/from the shared folder
# From Host to Guest:
cp /etc/hostname "$SHARED_FOLDER_PATH/host_file.txt"
echo "Copied host file to shared folder."

# From Guest, access at /mnt/myshare/host_file.txt
echo "Guest can now access the file at /mnt/myshare/host_file.txt"

# ===========================
# METHOD 4: SCP (SSH File Transfer) between two VMs
# ===========================
# Both VMs must have SSH server running and be on the same network.

# On the source VM, transfer a file to the destination VM:
# scp /path/to/file user@<dest-vm-ip>:/path/to/destination/
# Example:
# scp myfile.txt student@192.168.56.101:/home/student/

echo ""
echo "File transfer procedures completed."
echo "Use VirtualBox Shared Folders for the simplest method."

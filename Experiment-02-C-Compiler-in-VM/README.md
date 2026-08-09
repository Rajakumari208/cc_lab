# Experiment 02 - C Compiler in Virtual Machine

## Objective
Install a C compiler inside the VirtualBox VM and execute simple C programs.

## Setup in Ubuntu VM
```bash
# Update package list
sudo apt update

# Install GCC compiler
sudo apt install gcc -y

# Verify installation
gcc --version
```

## Compile and Run
```bash
gcc hello.c -o hello
./hello

gcc leapyear.c -o leapyear
./leapyear
```

## Sample Output
```
Hello from Virtual Machine!
C compiler is working correctly.

Enter year: 2024
2024 is a Leap Year
```

## Result
C compiler (GCC) installed in VM and programs executed successfully.

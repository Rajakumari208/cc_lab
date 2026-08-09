#!/bin/bash
# Experiment 7: Hadoop Single-Node Cluster Setup & WordCount Execution
# Automated script to configure Hadoop single node cluster and execute MapReduce WordCount

echo "=== 1. Checking Java Installation ==="
java -version
if [ $? -ne 0 ]; then
    echo "Installing Java OpenJDK..."
    sudo apt-get update && sudo apt-get install -y openjdk-8-jdk
fi

echo "=== 2. Compiling WordCount MapReduce Application ==="
mkdir -p build
javac -classpath $(hadoop classpath) -d build WordCount.java
jar -cvf wordcount.jar -C build/ .

echo "=== 3. Preparing HDFS Input Data ==="
hdfs dfs -mkdir -p /input
echo "Hadoop MapReduce Big Data Analytics WordCount Example" > input.txt
hdfs dfs -put -f input.txt /input/

echo "=== 4. Running WordCount MapReduce Job ==="
hdfs dfs -rm -r -f /output
hadoop jar wordcount.jar WordCount /input /output

echo "=== 5. Displaying Results from HDFS ==="
hdfs dfs -cat /output/part-r-00000

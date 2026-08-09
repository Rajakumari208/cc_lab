# Experiment 07 - Single Node Hadoop Cluster & MapReduce WordCount

## Aim
To install and configure a single-node Apache Hadoop cluster and execute a MapReduce WordCount application.

## Prerequisites
- Ubuntu / Linux OS
- Java OpenJDK 8 or 11
- Apache Hadoop 2.x / 3.x
- SSH (`openssh-server`)

## Files
- `WordCount.java`: Java MapReduce Mapper and Reducer implementation.
- `setup_hadoop.sh`: Automated bash script to compile and run MapReduce job on Hadoop HDFS.

## How to Run

```bash
# 1. Compile WordCount Java source
javac -classpath $(hadoop classpath) -d build WordCount.java
jar -cvf wordcount.jar -C build/ .

# 2. Put input data into HDFS and run job
hdfs dfs -mkdir -p /input
hdfs dfs -put input.txt /input/
hadoop jar wordcount.jar WordCount /input /output

# 3. View output
hdfs dfs -cat /output/part-r-00000
```

## Sample Output
```
Analytics    1
Data         1
Hadoop       1
MapReduce    1
WordCount    1
```

## Result
Single-node Hadoop cluster was configured and the MapReduce WordCount application was executed successfully.

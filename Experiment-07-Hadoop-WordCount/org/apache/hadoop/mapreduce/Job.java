package org.apache.hadoop.mapreduce;
import org.apache.hadoop.conf.Configuration;
import java.io.IOException;
public class Job {
    private static Job instance = new Job();
    public static Job getInstance(Configuration conf, String jobName) throws IOException { return instance; }
    public void setJarByClass(Class<?> cls) {}
    public void setMapperClass(Class<?> cls) { MockJobRunner.mapperClass = cls; }
    public void setCombinerClass(Class<?> cls) {}
    public void setReducerClass(Class<?> cls) { MockJobRunner.reducerClass = cls; }
    public void setOutputKeyClass(Class<?> cls) {}
    public void setOutputValueClass(Class<?> cls) {}
    public boolean waitForCompletion(boolean verbose) throws Exception {
        return MockJobRunner.run();
    }
}
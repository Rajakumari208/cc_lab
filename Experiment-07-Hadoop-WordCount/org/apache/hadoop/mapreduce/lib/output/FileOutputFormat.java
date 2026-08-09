package org.apache.hadoop.mapreduce.lib.output;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.MockJobRunner;
public class FileOutputFormat {
    public static void setOutputPath(Job job, Path path) { MockJobRunner.outputPath = path.toString(); }
}
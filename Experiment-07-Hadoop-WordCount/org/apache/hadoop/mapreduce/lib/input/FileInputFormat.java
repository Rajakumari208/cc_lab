package org.apache.hadoop.mapreduce.lib.input;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.MockJobRunner;
public class FileInputFormat {
    public static void addInputPath(Job job, Path path) { MockJobRunner.inputPath = path.toString(); }
}
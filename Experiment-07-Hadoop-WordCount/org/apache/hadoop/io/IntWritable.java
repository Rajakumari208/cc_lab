package org.apache.hadoop.io;
public class IntWritable {
    private int val;
    public IntWritable() {}
    public IntWritable(int val) { this.val = val; }
    public void set(int val) { this.val = val; }
    public int get() { return val; }
    public String toString() { return String.valueOf(val); }
}
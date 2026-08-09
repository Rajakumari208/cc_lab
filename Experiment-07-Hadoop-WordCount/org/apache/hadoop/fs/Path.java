package org.apache.hadoop.fs;
public class Path {
    private String path;
    public Path(String path) { this.path = path; }
    public String toString() { return path; }
}
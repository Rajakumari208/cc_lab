package org.apache.hadoop.io;
public class Text {
    private String str;
    public Text() {}
    public Text(String str) { this.str = str; }
    public void set(String str) { this.str = str; }
    public String toString() { return str; }
}
package org.apache.hadoop.mapreduce;
import java.io.IOException;
public class Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT> {
    public static class Context {
        public void write(Object key, Object value) throws IOException, InterruptedException {
            MockJobRunner.emitMap(key.toString(), Integer.parseInt(value.toString()));
        }
    }
}
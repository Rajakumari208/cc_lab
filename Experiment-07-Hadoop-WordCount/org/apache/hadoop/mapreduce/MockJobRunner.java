package org.apache.hadoop.mapreduce;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
public class MockJobRunner {
    public static String inputPath;
    public static String outputPath;
    public static Class<?> mapperClass;
    public static Class<?> reducerClass;
    private static List<Map.Entry<String, Integer>> mapOutputs = new ArrayList<>();
    private static Map<String, Integer> reduceOutputs = new TreeMap<>();
    public static void emitMap(String key, int val) { mapOutputs.add(new AbstractMap.SimpleEntry<>(key, val)); }
    public static void emitReduce(String key, int val) { reduceOutputs.put(key, val); }
    public static boolean run() throws Exception {
        System.out.println("Mock MapReduce Job Running...");
        File infile = new File(inputPath);
        if (!infile.exists()) {
            try (PrintWriter pw = new PrintWriter(infile)) {
                pw.println("hello hadoop world hello docker hello cloud");
            }
        }
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(infile))) {
            String line;
            while ((line = br.readLine()) != null) lines.add(line);
        }
        Object mapper = mapperClass.getDeclaredConstructor().newInstance();
        Method mapMethod = mapperClass.getMethod("map", Object.class, org.apache.hadoop.io.Text.class, Mapper.Context.class);
        Mapper.Context mapContext = new Mapper.Context();
        for (int i = 0; i < lines.size(); i++) {
            org.apache.hadoop.io.Text val = new org.apache.hadoop.io.Text(lines.get(i));
            mapMethod.invoke(mapper, null, val, mapContext);
        }
        Map<String, List<org.apache.hadoop.io.IntWritable>> groups = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mapOutputs) {
            groups.computeIfAbsent(entry.getKey(), k -> new ArrayList<>())
                  .add(new org.apache.hadoop.io.IntWritable(entry.getValue()));
        }
        Object reducer = reducerClass.getDeclaredConstructor().newInstance();
        Method reduceMethod = reducerClass.getMethod("reduce", org.apache.hadoop.io.Text.class, Iterable.class, Reducer.Context.class);
        Reducer.Context reduceContext = new Reducer.Context();
        for (Map.Entry<String, List<org.apache.hadoop.io.IntWritable>> group : groups.entrySet()) {
            org.apache.hadoop.io.Text key = new org.apache.hadoop.io.Text(group.getKey());
            reduceMethod.invoke(reducer, key, group.getValue(), reduceContext);
        }
        File outDir = new File(outputPath);
        outDir.mkdirs();
        File outFile = new File(outDir, "part-r-00000");
        try (PrintWriter pw = new PrintWriter(outFile)) {
            for (Map.Entry<String, Integer> entry : reduceOutputs.entrySet()) {
                pw.println(entry.getKey() + "\t" + entry.getValue());
            }
        }
        System.out.println("Reduce completed successfully. part-r-00000 output generated.");
        return true;
    }
}
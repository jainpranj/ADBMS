package com.aamend.hadoop.MapReduce;
 
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
 
public class WordCountMapper extends
        Mapper<Object, Text, Text, IntWritable> {
 
    private final IntWritable ONE = new IntWritable(1);
    private Text word = new Text();
 
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
 
        String[] csv = value.toString().replace("\n", "").replace("\t", "").replace("\r","").split(" ");
        for (String str : csv) {
        	if(StringUtils.isNotEmpty(str)){
            word.set(str);
           // System.out.println(str);
            context.write(word, ONE);
        	}
        }
    }
}
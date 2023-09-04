package main;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class WordCountDriver {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException {
        Job j1 = Job.getInstance(new Configuration());
        j1.setJarByClass(WordCountDriver.class);
        j1.setJobName("Average Word Count");
        FileInputFormat.addInputPath(j1, new Path(args[0]));
        FileOutputFormat.setOutputPath(j1, new Path(args[1]));
        j1.setMapperClass(WordCountMapper.class);
        j1.setReducerClass(WordCountReducer.class);
        j1.setOutputKeyClass(Text.class);
        j1.setOutputValueClass(IntWritable.class);
        System.exit(j1.waitForCompletion(true) ? 0 : 1);
    }
}
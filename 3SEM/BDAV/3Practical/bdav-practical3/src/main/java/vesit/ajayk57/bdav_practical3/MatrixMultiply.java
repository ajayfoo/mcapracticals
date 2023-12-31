package vesit.ajayk57.bdav_practical3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class MatrixMultiply {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: MatrixMultiply <input_dir> <output_dir>");
			System.out.println(args.length);
			System.exit(2);
		}
		Configuration conf = new Configuration();
		// M is an m-by-n matrix; N is an n-by-p matrix.
		conf.set("m", "1000");
		conf.set("n", "100");
		conf.set("p", "1000");
		@SuppressWarnings("deprecation")
		Job job = new Job(conf, "MatrixMultiply");
		job.setJarByClass(MatrixMultiply.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReducer.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
	}
}
val datanum=sc.parallelize(List(10,20,30))
datanum.collect()
val mapfunc = datanum.map(x => x+10)
mapfunc.collect()
val name = Seq("Ajay","Karthikesan")
val result1 = name.map(_.toLowerCase)
name.flatMap(_.toLowerCase)
val data = Seq("Project",
  "Gutenberg’s",
  "Alice’s",
  "Adventures",
  "in",
  "Wonderland",
  "Project",
  "Gutenberg’s",
  "Adventures",
  "in",
  "Wonderland",
  "Project",
  "Gutenberg’s")

val myrdd=sc.parallelize(data)
myrdd.collect()
val myrdd2=myrdd.map(f=> (f,1))
myrdd2.foreach(println)
val filterfunc = myrdd.filter(x => x!="Project")
filterfunc.collect()
val countFunc=myrdd.count()
val distinctfunc = myrdd.distinct() 
distinctfunc.collect
val data = sc.parallelize(Array(("C",3),("A",1),("B",4),("A",2),("B",5)))
data.collect
val reducefunc = data.reduceByKey((value, x) => (value + x)) 
reducefunc.collect

// save file in hdfs and then execute the below commands

val a1=sc.textFile("hdfs://localhost:9000/user/ajayk/input/words.txt")
a1.collect()
a1.count()
val splitdata = a1.flatMap(line => line.split(" ")); 
splitdata.collect()
val a1filter = splitdata.filter(x => x!="vivaan")
//word count
val mapdata = splitdata.map(word => (word,1))
mapdata.collect
val reducedata = mapdata.reduceByKey(_+_);  
reducedata.collect()
//char count
val splitdata1 = a1.flatMap(line => line.split(""));  
splitdata1.collect()
val mapdata1 = splitdata1.map(word => (word,1));  
mapdata1.collect()
val reducedata1 = mapdata1.reduceByKey(_+_); 
reducedata1.collect() 




x = LOAD '/user/ajayk/4prac/words.txt' AS (f1:chararray);

DUMP x;

words = FOREACH x GENERATE FLATTEN(TOKENIZE(f1)) as word;
DUMP words;

groupedWords = GROUP words BY word;
DUMP groupedWords;
DESCRIBE groupedWords;

countedWords = FOREACH groupedWords GENERATE group, COUNT(words);
DUMP countedWords;

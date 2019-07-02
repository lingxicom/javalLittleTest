/**
 * 英文文本单词统计
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class splitWords {
    static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws FileNotFoundException {
        splitWords sw = new splitWords();
        // 读入文件
        sw.count("C:\\Users\\15131\\Desktop\\visit.txt");
        sw.result();
    }

    public void count(String src) throws FileNotFoundException {
        File file = new File(src);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        Scanner scanner = new Scanner(file);
        System.out.println(src + "----------------中的文章内容-------------------");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            //\w+ : 匹配所有的单词
            //\W+ : 匹配所有非单词
            String[] lineWords = line.split("\\W+");//用非单词符来做分割，分割出来的就是一个个单词

            Set<String> wordSet = hashMap.keySet();
            for (int i = 0; i < lineWords.length; i++) {
                //如果已经有这个单词了，
                if (wordSet.contains(lineWords[i])) {
                    Integer number = hashMap.get(lineWords[i]);
                    number++;
                    hashMap.put(lineWords[i], number);
                } else {
                    hashMap.put(lineWords[i], 1);
                }
            }

        }
        System.out.println("这个文件统计结束");
    }

    public void result() {
        System.out.println("-----------统计单词完成，所有文件单词为-------------------");
        Iterator<String> iterator = hashMap.keySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String word = iterator.next();
            System.out.printf("单词:%-12s 出现次数:%d\n", word, hashMap.get(word));
            i++;
        }
        System.out.println("单词总数为" + i);
    }
}

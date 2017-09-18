import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJunit.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if(result.wasSuccessful()){
            System.out.println("All test cases passed");

        }

        ProblemOne problemOne = new ProblemOne();
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("A quick brown fox jumps over the lazy dog.");
        strings.add("Four score and seven years ago.");
        strings.add("To be or not to be, that is the question");
        strings.add("");

        for(String s:strings){
            System.out.println("input:   "+s);
            System.out.println("output:  "+problemOne.listMissingLetters(s)+'\n');
        }



        ProblemTwo problemTwo = new ProblemTwo();
        HashMap<String,Integer> inputs = new HashMap<String,Integer>();
        inputs.put("..B....",2);
        inputs.put("..B.B..B",10);
        inputs.put("B.B.B.BB.",2);
        inputs.put("..B.B..B", 1);
        inputs.put("..B.BB..B.B..B...", 1);
        for (Map.Entry<String, Integer> entry : inputs.entrySet())
        {
            printArrayList(problemTwo.explode(entry.getKey(),entry.getValue()));
            System.out.println();
        }
    }
    public static void printArrayList(String[] ret){
        for(int i = 0; i < ret.length;i++){
            System.out.println(ret[i]);
        }
    }




}


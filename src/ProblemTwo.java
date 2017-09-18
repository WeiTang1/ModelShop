import java.util.ArrayList;
import java.util.HashSet;

public class ProblemTwo {
    public  String[] explode(String bombs, int force){
        int chamber = bombs.length();
        if(chamber < 1 || chamber > 50){
            throw new IllegalArgumentException("bombs's length is illegal");
        }
        if(force<1 || force > 10){
            throw new IllegalArgumentException("force's value is illegal");
        }
        /*
        arrayList: dynamic ArrayList for return value;
        leftShrapne: left Shrapne locaion tracking  use Hashset to get O(1) access
        rightShrapne: same with leftShrapne.
        end: string for tracking end point.
         */
        ArrayList<String> arrayList = new ArrayList<String>();
        HashSet<Integer> leftShrapne = new HashSet<Integer>();
        HashSet<Integer> rightShrapne = new HashSet<Integer>();
        StringBuilder end = new StringBuilder();
        for(int i = 0 ; i < bombs.length();i++){
            end.append('.');
        }

        /*
        init arraylist with bombs
        and also initialize the shrapne location.
         */
        arrayList.add(bombs);
        for(int i = 0; i < bombs.length();i++){
            char c = bombs.charAt(i);
            if(c == 'B'){
                leftShrapne.add(i);
                rightShrapne.add(i);
            }
        }
//        System.out.print("init  left");
//        System.out.println(leftShrapne);
//        System.out.print("init  right");
//        System.out.println(leftShrapne);

        /*
        newLine for hold the most updated location.
         */
        StringBuilder newLine;
        while(true){
            newLine = new StringBuilder(bombs.length());
            updateShrapnelLocation(true,force,leftShrapne);
//            System.out.print("after update left");
//            System.out.println(leftShrapne);
            updateShrapnelLocation(false,force,rightShrapne);
//            System.out.print("after update right");
//            System.out.println(rightShrapne);

            /*
            add the correct legend at the right location.
             */
            for(int i = 0; i <bombs.length();i++){
                if (leftShrapne.contains(i)){
                    newLine.append(rightShrapne.contains(i)?'X':'<'  );
                }
                else{
                    newLine.append(rightShrapne.contains(i)?'>':'.');
                }
            }
            /*
            append to arrayList;
             */
            arrayList.add(newLine.toString());
            /*
            condition check.
             */
            if(newLine.toString().equals(end.toString()))
                break;
        }

        String re[]=arrayList.toArray(new String[arrayList.size()]);
        return  re;

    }
    /*
    helper method for update Shrapne Location
     */
    public  void updateShrapnelLocation(boolean left,int force,HashSet<Integer> arrayList){
        HashSet<Integer> temp = new HashSet<>(arrayList);
        if(left){
            for(int i :temp) {
                arrayList.remove(i);
                arrayList.add(i - force);
            }
        }
        else{
            for(int i :temp){
                arrayList.remove(i);
                arrayList.add(i+force);
            }
        }
    }

}

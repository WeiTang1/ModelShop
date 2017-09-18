public class ProblemOne {
    public String listMissingLetters(String s){

        /*
        replace all non-alphabetic characters with ''
        */
        if(s == null){
            throw new NullPointerException("String is null");
        }
        String str = s.toLowerCase().replaceAll("[^a-zA-Z]","");

        /*
        Since it only have 26 chars in English Alphabet, a simple 26-length array would be sufficient here,
        Could use HashMap as well, but for simplicity I choose a fixed length array.
         */
        int[] array = new int[26];

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < str.length(); i ++){
            int index = str.charAt(i)-'a';
            array[index] = 1;
        }
        for(int i =0; i < array.length;i++){
            if(array[i] == 0){
                stb.append(Character.toChars(i+'a'));
            }
        }
        return stb.toString();
    }
}

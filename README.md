# ModelShop Takehome

Documentation for ModelShop Takehome.


## build
make sure Junit 4.1 is in build library.

## Environment 

IDE: IntelliJ

Language: Java

Unit Testing Framework: JUnit

### Problem One

#### Code
```
Public String listingMissingLetters(String s){
  String str = s.toLowerCase().replaceAll("[^a-zA-Z]","");
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
```

#### Complexity Analysis

```
Assume String s's length is n
Complexity:
  O(n) + O(n) + O(26)= O(n)
Explanation:
  O(n):  String.replace is O(n) time
  O(n):  One Pass String of length n to flag characters
  O(26): One Pass 26-length String to append (char)

Space Complexity:
  O(n)+O(26)+O(c) = O(n);
 Explanation:
  O(n): since s is immutable, str will be create as a new String object, However the original s will be collect by JVM garbage collection.
  O(26): space for array
  O(c): space for StringBuilder where c < n;
```

#### Outputs
```
input:   A quick brown fox jumps over the lazy dog.
output:  

input:   Four score and seven years ago.
output:  bhijklmpqtwxz

input:   To be or not to be, that is the question
output:  cdfgjklmpvwxyz

input:   
output:  abcdefghijklmnopqrstuvwxyz
```

### Problem Two

#### Code
```
see ProblemTwo.java
```

#### Complexity Analysis

```
Assume String s's length is n
Complexity:
  O(n)
Explanation:
  Multiple One pass for loop so c*O(n) = O(n)

Space Complexity:
  O(n)
Explanation:
  multiple ArrayList that is less than O(n)
```

#### Outputs
```
B.B.B.BB.
<.<.<<..>
<.<<.....
<<.......
.........

..B....
<...>..
......>
.......

..B.B..B
.<.X.><.
<.<.><>.
.<..<>.>
<..<..>.
..<....>
.<......
<.......
........

..B.BB..B.B..B...
.<.X<.><.X.><.>..
<.<<>.<><.><>..>.
.<<..X.<>.<>.>..>
<<..<.X..X..>.>..
<..<.<.><.>..>.>.
..<.<..<>..>..>.>
.<.<..<..>..>..>.
<.<..<....>..>..>
.<..<......>..>..
<..<........>..>.
..<..........>..>
.<............>..
<..............>.
................>
.................
```
## Authors

* **Wei Tang**

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.


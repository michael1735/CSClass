package Notes;

import java.util.Scanner;

/*
A person keeps a file of the details of their CD collection. The file is in the following format:

line 1: Artist Name
line 2: CD Title
line 3: Storage Location
You need to create a program to find a CD.

The structured English for the program is:

INPUT the artist name and CD title
CALL a function called FindCD() with the artist and CD title as parameters. The returned value should be stored in a variable called location
FindCD() should CHECK if the read artist = the search artist
IF it is, CHeck if the CD title = search title
IF it is, then return the storage location
REPEAT steps 3-5 until EOF or the CD has been found
OUTPUT either the storage location or an error message (specified below)
Input Format

SearchArtist : STRING

SearchCD : STRING

CD.txt : a list of artists, CD's, and storage locations

Constraints

CD.txt is a variable length list containing at least 1 set of data (3 lines)
artist names/CD titles may be capitalised or uncapitalised (and therefore different from the search terms), so you should ensure they are all in the same format when comparing
to use the Scanner in multiple modules, declare it as a global variable
the Scanner.hasNext() can be used to loop until the end of the 'file'
Output Format

CD Title is in storage location

CD not found

Sample Input 0

the smiths
meat is murder
The Smiths
Meat is murder
box 1
Bloc Party
Silent alarm
shelf 1
The Strokes
Room on fire
shelf 2
Pulp
Different classes
shelf 1
Arctic Monkeys
Whatever people say I am, that's what I'm not
shelf 2
Sample Output 0

meat is murder is in box 1
 */

public class SimonCFindACD {
    static Scanner input =  new Scanner(System.in);
    public static String findCD(String searchArtist, String searchAlbum){
        String location = "";
        boolean found = false;
        String thisArtist, thisAlbum, thisLocation;

        while (input.hasNextLine() && found == false){
            thisArtist = input.nextLine().toLowerCase();
            thisAlbum = input.nextLine().toLowerCase();
            thisLocation = input.nextLine().toLowerCase();
            if (thisArtist.equals(searchArtist)) {
                if (thisAlbum.equals(searchAlbum)) {
                    location = thisLocation;
                    found = true;
                }
            }
        }
        return location;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String artist = input.nextLine().toLowerCase();
        String album = input.nextLine().toLowerCase();
        String location = findCD(artist, album);
        if (location.equals("")){
            System.out.println("CD not found");
        } else {
            System.out.println(album + " is in " + location);
        }
    }
}
/*
思路: 1.为了把scanner实例再所有方法中通用, 把他声明成全局变量
    2.首先, 我们将会需要一个findCD()方法来找CD, 其返回一个location, 根据找不找得到有两种输出:
        a. 找不到
        b. 找到了, 然后输出位置
    输出的语句肯定是放在main方法执行的, 因为findCD只返回CD位置而并不执行输出
    因此我们可以写完main里的代码, 也就是输入artist和album, 调用findCD()找CD位置, 返回一个location, 然后根据location是否是null
    来判断是不是找到了(我们再findCD()方法里的location必须先初始化成null或者“”.
    然后再在findCD()方法里给location赋不同的测试值来确认main方法里的代码逻辑正确

    3.main写完后，就直接开始findCD()方法的编辑
    这个方法会接受我们的两个搜索命令, 然后在输入的文件里找. 因为文件是一行一行输入的, 我们就最好把这东西放在findCD()方法体里,
    这样好对应. 如果是一行一行输入且有规律, 我们就可以声明三个临时变量, 来存这一次输入的三个值. 然后, 为了判断是否输入完了, 我们
    会用scanner实例input的hasNext()方法来判断是否是最后一行输入. 我们还想要这个程序在搜索到想要的结果后直接跳出, 所以
    设置了一个布尔值, 用来存是否此时找到了, 然后把它和input.hasNext()同时作为判断循环结束的依据.

    因此, 当有下一行输入的时候, 把三个临时变量分别赋值, 然后比较thisArtist和searchArtist, 以及thisAlbum和searchAlbum.
    如果都相等的话, 就location = thisLocation. 最后别忘记把found设置成true跳出循环就行
 */
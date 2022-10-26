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
˼·: 1.Ϊ�˰�scannerʵ�������з�����ͨ��, ����������ȫ�ֱ���
    2.����, ���ǽ�����Ҫһ��findCD()��������CD, �䷵��һ��location, �����Ҳ��ҵõ����������:
        a. �Ҳ���
        b. �ҵ���, Ȼ�����λ��
    ��������϶��Ƿ���main����ִ�е�, ��ΪfindCDֻ����CDλ�ö�����ִ�����
    ������ǿ���д��main��Ĵ���, Ҳ��������artist��album, ����findCD()��CDλ��, ����һ��location, Ȼ�����location�Ƿ���null
    ���ж��ǲ����ҵ���(������findCD()�������location�����ȳ�ʼ����null���ߡ���.
    Ȼ������findCD()�������location����ͬ�Ĳ���ֵ��ȷ��main������Ĵ����߼���ȷ

    3.mainд��󣬾�ֱ�ӿ�ʼfindCD()�����ı༭
    ���������������ǵ�������������, Ȼ����������ļ�����. ��Ϊ�ļ���һ��һ�������, ���Ǿ���ð��ⶫ������findCD()��������,
    �����ö�Ӧ. �����һ��һ���������й���, ���ǾͿ�������������ʱ����, ������һ�����������ֵ. Ȼ��, Ϊ���ж��Ƿ���������, ����
    ����scannerʵ��input��hasNext()�������ж��Ƿ������һ������. ���ǻ���Ҫ�����������������Ҫ�Ľ����ֱ������, ����
    ������һ������ֵ, �������Ƿ��ʱ�ҵ���, Ȼ�������input.hasNext()ͬʱ��Ϊ�ж�ѭ������������.

    ���, ������һ�������ʱ��, ��������ʱ�����ֱ�ֵ, Ȼ��Ƚ�thisArtist��searchArtist, �Լ�thisAlbum��searchAlbum.
    �������ȵĻ�, ��location = thisLocation. �������ǰ�found���ó�true����ѭ������
 */
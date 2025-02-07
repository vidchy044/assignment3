import java.io.*;
import java.util.*;

public class Assignmenttwo {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "C:\\Users\\vidch\\OneDrive\\Desktop\\เนยขมปี๋\\ADT\\ASS2\\input1.txt";
        long startTime = System.nanoTime();
        tokens(file);
        emoticon(file);
        character(file);
        palindrome(file);
        line(file);
        longesttoken(file);
        long stopTime = System.nanoTime();
        double duration = (stopTime - startTime) / 1_000_000_000.0;
        System.out.println("Total Execution Time: " + duration + " seconds");
    }

    public static void character(String file)throws FileNotFoundException {
        File f = new File(file);
        Scanner sc = new Scanner(f);

        int count = 0;
        while (sc.hasNextLine()) {
            String dataLine = sc.nextLine();
            StringTokenizer stu = new StringTokenizer(dataLine);

            while (stu.hasMoreTokens()) {
                String token = stu.nextToken();
                count += token.length();
            }
        }
        System.out.println("Total# Character count: " + count);
    }

    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        
        while (left < right) {
            if (word.charAt(left)!=word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void palindrome(String file)throws FileNotFoundException {
        File f = new File(file);
        Scanner sc =  new Scanner(f);

        int count = 0;
        while (sc.hasNextLine()) {
            String dataLine = sc.nextLine();
            StringTokenizer stu = new StringTokenizer(dataLine.trim(), " ");

            while (stu.hasMoreTokens()) {
                String token = stu.nextToken().toLowerCase();
                if (isPalindrome(token)) {
                   count++;
                }
            }
        }
        System.out.println("Total# Palindrome found: " + count);
    }

    public static void tokens(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner sc =  new Scanner(f);

        int count = 0;
        while (sc.hasNextLine()) {
            String dataLine = sc.nextLine();
            StringTokenizer stu = new StringTokenizer(dataLine.trim(), " ");

            while (stu.hasMoreTokens()) {
                count++;
                stu.nextToken();
            }
        }
        System.out.println("Total Number of tokens: " + count);
    }

    public static void emoticon(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner sc =  new Scanner(f);
        ArrayList<String> emoticons = new ArrayList<>(Arrays.asList(":D", ":)", ":(")); 
        
        int count = 0;
        while (sc.hasNextLine()) {
            String dataLine = sc.nextLine();
            StringTokenizer stu = new StringTokenizer(dataLine.trim(), " ");

            while (stu.hasMoreTokens()) {
                String token = stu.nextToken();
                if (emoticons.contains(token)) {
                    count++;
                }
            }
        }
        System.out.println("Total Number of emoticon: " + count);
    }

    public static void line(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner sc =  new Scanner(f); 
        
        int count = 0;
        while (sc.hasNextLine()) {
            count++;
            sc.nextLine();
        }
        System.out.println("Total# of new line: " + count);
    }

    public static void longesttoken(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner sc = new Scanner(f);

        int longestTokenLength = 0;
        int longestTokenCount = 0;
        int totalTokenCount = 0;
        
        while (sc.hasNextLine()) {
            String dataLine = sc.nextLine();
            StringTokenizer stu = new StringTokenizer(dataLine.trim(), " ");

            while (stu.hasMoreTokens()) {
                String token = stu.nextToken();
                totalTokenCount++;
                
                if (token.length() > longestTokenLength) {
                    longestTokenLength = token.length();
                    longestTokenCount = 1;
                } else if (token.length() == longestTokenLength) {
                    longestTokenCount++;
                }
            }
        }
        
        System.out.println("Longest Token length: " + longestTokenLength);
        System.out.println("Average of longest tokens: " + longestTokenCount);
}
}

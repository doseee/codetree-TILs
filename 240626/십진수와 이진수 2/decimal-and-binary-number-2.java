import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int x = Integer.parseInt(br.readLine(), 2);
       System.out.print(Integer.toBinaryString(x * 17));
    }
}
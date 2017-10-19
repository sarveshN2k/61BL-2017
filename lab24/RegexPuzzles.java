import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPuzzles {
    public static List<String> urlRegex(String[] urls) {
        /* Your code here */
        List<String> toReturn = new ArrayList<>();
        String pattern = "(\\(.*https?:\\/\\/(www)?.?(\\w+\\.)*\\w{2,3}\\/\\w+.html.*\\))";
        for (String url : urls) {
            if (url.matches(pattern)) {
                toReturn.add(url);
            }
        }
        return toReturn;
    }

    public static List<String> findStartupName(String[] names) {
        List<String> toReturn = new ArrayList<>();
        String pattern = "(^(Data|App|my|on|un)[A-H J-Z a-h j-z 0-9]+(ly|sy|ify|.io|.fm|.tv)$)";
        for (String url : names) {
            if (url.matches(pattern)) {
                toReturn.add(url);
            }
        }
        return toReturn;
    }

    public static BufferedImage imageRegex(String filename, int width, int height) {
        //System.out.println("W#R@WE");
        // 
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file found: " + filename);
        }

        // Possible initialization code
        int[][][] array = new int[width][height][3];
        try {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                // Code for processing each line
                //line = "(217, 203) [Pdh, Oxs, kPv] [74, 21, 27] (223, 79, 217) [425, 74]";
                Pattern tupleCapture = Pattern.compile("\\(([0-9]{0,3}),\\s([0-9]{0,3})\\)");
                Pattern bracketCapture = Pattern.compile("\\[([0-9]{0,3}),\\s([0-9]{0,3}),\\s([0-9]{0,3})\\]");
                Matcher bracketMatcher = bracketCapture.matcher(line);
                Matcher tupleMatcher = tupleCapture.matcher(line);
                if (!tupleMatcher.find()) {
                    //System.out.println("fail tuple");
                    continue;
                }
                if (!bracketMatcher.find()) {
                    //System.out.println("fail brack");
                    continue;
                }
                //System.out.println("here2");
                int x = Integer.parseInt(tupleMatcher.group(1));
                int y = Integer.parseInt(tupleMatcher.group(2));
                int r = Integer.parseInt(bracketMatcher.group(1));
                int g = Integer.parseInt(bracketMatcher.group(2));
                int b = Integer.parseInt(bracketMatcher.group(3));
                //System.out.println(r + " " + g + " " + b);
                array[x][y][0] = r;
                array[x][y][1] = g;
                array[x][y][2] = b;
            }
        } catch (IOException e) {
            System.err.printf("Input error: %s%n", e.getMessage());
            System.exit(1);
        }

        return arrayToBufferedImage(array);
    }

    public static BufferedImage arrayToBufferedImage(int[][][] arr) {
        BufferedImage img = new BufferedImage(arr.length, arr[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int pixel = 0;
                for (int k = 0; k < 3; k++) {
                    pixel += arr[i][j][k] << (16 - 8*k);
                }
                img.setRGB(i, j, pixel);
            }
        }

        return img;
    }

    public static void main(String[] args) {
        /* For testing image regex */

        BufferedImage img = imageRegex("mystery.txt", 400, 400);

        File outputfile = new File("output_img.jpg");
        try {
            ImageIO.write(img, "jpg", outputfile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }


        /*
        String laughingPattern2 = "lo+l";

        Pattern laughingPattern = Pattern.compile("lo+l");
        Matcher matcher1 = laughingPattern.matcher("loool");
        System.out.println(matcher1.matches()); // prints true

        Matcher matcher2 = laughingPattern.matcher("loooooooool");
        System.out.println(matcher2.matches()); // prints true




        String line = "(217, 203) [Pdh, Oxs, kPv] [74, 21, 27] (223, 79, 217) [425, 74]";
        Pattern tupleCapture = Pattern.compile("217");
        Pattern bracketCapture = Pattern.compile("");//\\[(\\d{0,3}),\\s([0-9]{0,3}),\\s([0-9]{0,3})\\]");
        Matcher bracketMatcher = bracketCapture.matcher(line);
        Matcher tupleMatcher = tupleCapture.matcher(line);
        if (!tupleMatcher.find()) {
            System.out.println("fail tuple");

            return;
        }
        if (!bracketMatcher.find()) {
            System.out.println("fail brack");

            return;
        }
        System.out.println("here2");
        int x = Integer.parseInt(tupleMatcher.group(1));
        int y = Integer.parseInt(tupleMatcher.group(2));
        int r = Integer.parseInt(bracketMatcher.group(1));
        int g = Integer.parseInt(bracketMatcher.group(2));
        int b = Integer.parseInt(bracketMatcher.group(3));
        System.out.println(x + " " + y);
        System.out.println(r + " " + g + " " + b);
        */



    }
}

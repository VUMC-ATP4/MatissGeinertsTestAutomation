package mavenTestNGHomework;

import com.github.lalyos.jfiglet.FigletFont;

public class MavenTest {
    public static void main(String[] args) {

        String asciiArt = FigletFont.convertOneLine("Matīss Geinerts");
        System.out.println(asciiArt);
    }
}

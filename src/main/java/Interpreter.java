import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Interpreter
{
    public static void main(String args[])
    {
        run("C:\\Users\\maxbl\\IdeaProjects\\BlennemannSimpleInterpreter\\txtfiles\\simpleTest" +
                ".txt");
    }

    public static void run(String filePath)
    {
        Interpreter i = new Interpreter();
        i.run(i.parseProgram(getFileAsArrayOfLines(filePath)));
    }

    public void run()
    {
        //TODO make this run a syntax tree
    }

    public  parseProgram(String[] lines)
    {
        for (String line : lines)
        {
            parseStatement(line);
        }
    }
    public void createNode(String line)
    {

    }


    /**
     * Reads a file and returns it as a string array of each line
     *
     * @param filePath the name of the file to read
     * @return the file as a string array
     */
    public static String[] getFileAsArrayOfLines(String filePath)
    {
        Stream<String> stream = null;
        //read file into stream, try-with-resources
        try
        {
            stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if (stream == null)
            throw new IllegalArgumentException("File not found");
        return stream.toArray(String[]::new);
    }

}
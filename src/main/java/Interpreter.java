import ast.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Interpreter
{
    private String[] code;

    public static void main(String args[])
    {
        run("C:\\Users\\maxbl\\IdeaProjects\\BlennemannSimpleInterpreter\\txtfiles\\simpleTest" +
                ".txt");
    }

    public Interpreter(String filePath)
    {
        this.code = getFileAsArrayOfLines(filePath);
    }

    public static void run(String filePath)
    {
        Interpreter i = new Interpreter(filePath);

        i.run(i.parseProgram();
    }

    public void run()
    {
        //TODO make this run a syntax tree
    }

    public void parseProgram()
    {
        for (int i = 0; i < code.length; i++)
        {
            parseStatement(i);
        }
    }

    public void parseStatement(int lineNumber)
    {
        if (code[lineNumber].startsWith("display"))
        {
            parseDisplay(lineNumber);
        }
        else if (code[lineNumber].startsWith("assign"))
        {
            parseAssign(lineNumber);
        }
        else if (code[lineNumber].startsWith("while"))
        {
            parseWhile(lineNumber);
        }
        else if (code[lineNumber].startsWith("if"))
        {
            parseIf(lineNumber);
        }
        throw new IllegalArgumentException("Invalid statement: " + lineNumnber);
    }

    private Statement parseDisplay(int lineNumber)
    {
        String expression;
        if (code[lineNumber].indexOf("read") == -1) //if this line has a read instruction
            return new Writeln(parseExpression(code[lineNumber]));
        expression = code[lineNumber].substring(7, code[lineNumber].indexOf("read"));
        ArrayList<Statement> writelnAndRead = new ArrayList<>();
        writelnAndRead.add(new Writeln(parseExpression(expression)));
        writelnAndRead.add(new Read(code[lineNumber].substring(code[lineNumber].indexOf("read") + 5)));
        return new Block(writelnAndRead);
    }

    private Expression parseExpression(String expression)
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
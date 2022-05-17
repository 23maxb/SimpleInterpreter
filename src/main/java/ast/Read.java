package ast;

import environment.Environment;

import java.util.Scanner;

public class Read implements Statement
{
    private String varName;

    public Read(String varName)
    {
        this.varName = varName;
    }

    public String getVarName()
    {
        return varName;
    }

    public void setVarName(String varName)
    {
        this.varName = varName;
    }

    /**
     * Executes the statement and does whatever operation is needed.
     *
     * @param env the environment in which the statement is executed
     * @return int the value entered
     */
    @Override
    public int exec(Environment env)
    {
        int expression = Integer.parseInt(new Scanner(System.in).nextLine());
        env.setVariable(varName, expression);
        return expression;
    }
}

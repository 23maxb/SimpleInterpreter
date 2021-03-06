package ast;

import environment.Environment;

import java.util.List;

/**
 * Creates blocks of statements (basically an array of statements)
 *
 * @author Max Blennemann
 * @version 3/23/22
 */
public class Block implements Statement
{
    private final List<Statement> statements;

    /**
     * Creates a block from a list of statements
     *
     * @param statements the list of statements to use to create the block from
     */
    public Block(List<Statement> statements)
    {
        this.statements = statements;
    }

    /**
     * Executes every item in the block
     *
     * @param e the environment to get variables from
     * @return
     */
    @Override
    public int exec(Environment e)
    {
        for (Statement statement : statements)
            statement.exec(e);
        return 0;
    }

    /**
     * Returns a string representation of the Block object
     *
     * @return a string representation of the Block object
     */
    @Override
    public String toString()
    {
        return "Block(" + statements.toString() + ")";
    }
}

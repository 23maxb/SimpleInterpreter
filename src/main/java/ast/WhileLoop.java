package ast;

import environment.Environment;

/**
 * Represents a while loop.
 *
 * @author Max Blennemann
 * @version 3/23/22
 */
public class WhileLoop implements Statement
{
    public Expression condition;
    public Block b;

    /**
     * Creates a WhileLoop with the given parameters
     *
     * @param condition The condition to test for the while loop
     * @param block     The block to execute while the condition is true
     */
    public WhileLoop(Expression condition, Block block)
    {
        this.condition = condition;
        b = block;
    }

    /**
     * Do the block while the condition is true.
     *
     * @param env the environment to pull variable values from
     * @return
     */
    @Override
    public int exec(Environment env)
    {
        while ((((int) ((Number) condition.evaluate(env)).evaluate(env)) == 1)
                || (boolean) condition.evaluate(env))
        {
            b.exec(env);
        }
        return 0;
    }

    /**
     * Returns a string representation of the object
     *
     * @return a string representation of the object
     */
    @Override
    public String toString()
    {
        return "WHILE(" + condition + " DO: " + b.toString() + ")";
    }

}

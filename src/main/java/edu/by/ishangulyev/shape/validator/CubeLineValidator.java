package edu.by.ishangulyev.shape.validator;

public class CubeLineValidator
{
    private static final String REG_EX_FOR_LINE = "([-]?\\d+\\.\\d+[\\s]?){23}([-]?\\d+\\.\\d+)";
    private CubeLineValidator(){};

    public static boolean isLineValid(String line)
    {
        return line.matches(REG_EX_FOR_LINE);
    }
    public static boolean isEmpty(String someString)
    {
        return someString == null || someString.isBlank();
    }

}

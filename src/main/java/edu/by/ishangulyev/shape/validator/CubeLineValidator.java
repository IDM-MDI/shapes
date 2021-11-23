package edu.by.ishangulyev.shape.validator;

public class CubeLineValidator
{
    private static final String REG_EX_FOR_LINE = "([-]?\\d+\\.\\d+[\\s]?){8}";
    private CubeLineValidator(){};

    public static boolean isLineValid(String line)
    {
        return line.matches(REG_EX_FOR_LINE);
    }
    public static boolean isCorrect(String someString)
    {
        return !(someString == null || someString.isBlank());
    }

}

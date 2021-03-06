package edu.by.ishangulyev.shape.exception;

public class CubeException extends Exception
{
    public CubeException(String message)
    {
        super(message);
    }

    public CubeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CubeException(Throwable cause)
    {
        super(cause);
    }

    public CubeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

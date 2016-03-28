package com.hisun.common.exception;

/**
 * 
 * @类名： DataAccessException.java
 * @描述：DataAccessException
 * @作者： PAUL
 * @修改日期： 2016年3月28日
 *
 */
public class DataAccessException extends Exception
{

    private static final long serialVersionUID = 1L;


    public DataAccessException()
    {
        super();
    }


    public DataAccessException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public DataAccessException(String message)
    {
        super(message);
    }


    public DataAccessException(Throwable cause)
    {
        super(cause);
    }

}

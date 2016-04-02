package com.hisun.common.exception;

/**
 * 
 * @类名： UserServiceException.java
 * @描述：UserServiceException
 * @作者： PAUL
 * @修改日期： 2016年3月28日
 *
 */
public class ResultServiceException extends Exception
{

    private static final long serialVersionUID = -6166533554682206492L;


    public ResultServiceException()
    {
        super();
    }


    public ResultServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public ResultServiceException(String message)
    {
        super(message);
    }


    public ResultServiceException(Throwable cause)
    {
        super(cause);
    }
}

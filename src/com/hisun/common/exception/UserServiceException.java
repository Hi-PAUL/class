package com.hisun.common.exception;

/**
 * 
 * @类名： UserServiceException.java
 * @描述：UserServiceException
 * @作者： PAUL
 * @修改日期： 2016年3月28日
 *
 */
public class UserServiceException extends Exception
{

    private static final long serialVersionUID = -6166533554682206492L;


    public UserServiceException()
    {
        super();
    }


    public UserServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public UserServiceException(String message)
    {
        super(message);
    }


    public UserServiceException(Throwable cause)
    {
        super(cause);
    }
}

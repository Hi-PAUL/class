package com.hisun.common.exception;

/**
 * 
 * @类名： UserServiceException.java
 * @描述：UserServiceException
 * @作者： PAUL
 * @修改日期： 2016年3月28日
 *
 */
public class MessageServiceException extends Exception
{

    private static final long serialVersionUID = -6166533554682206492L;


    public MessageServiceException()
    {
        super();
    }


    public MessageServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public MessageServiceException(String message)
    {
        super(message);
    }


    public MessageServiceException(Throwable cause)
    {
        super(cause);
    }
}

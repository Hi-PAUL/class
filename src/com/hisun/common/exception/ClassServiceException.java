package com.hisun.common.exception;

/**
 * 
 * @类名： ClassServiceException.java
 * 
 * @描述：ClassServiceException @作者： PAUL @修改日期： 2016年4月6日
 *
 */
public class ClassServiceException extends Exception
{

    private static final long serialVersionUID = -6166533554682206492L;


    public ClassServiceException()
    {
        super();
    }


    public ClassServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public ClassServiceException(String message)
    {
        super(message);
    }


    public ClassServiceException(Throwable cause)
    {
        super(cause);
    }
}

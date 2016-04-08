package com.hisun.common.exception;

/**
 * 
 * @类名： PhotoServiceException.java
 * 
 * @描述：PhotoServiceException @作者： PAUL @修改日期： 2016年4月8日
 *
 */
public class PhotoServiceException extends Exception
{

    private static final long serialVersionUID = 9098084704028469970L;


    public PhotoServiceException()
    {
        super();
    }


    public PhotoServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public PhotoServiceException(String message)
    {
        super(message);
    }


    public PhotoServiceException(Throwable cause)
    {
        super(cause);
    }
}

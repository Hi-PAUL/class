package com.hisun.common.exception;

/**
 * 
 * @类名： AdminServiceException.java
 * 
 * @描述：AdminServiceException @作者： PAUL @修改日期： 2016年4月6日
 *
 */
public class AdminServiceException extends Exception
{

    private static final long serialVersionUID = -7027651507123363530L;


    public AdminServiceException()
    {
        super();
    }


    public AdminServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public AdminServiceException(String message)
    {
        super(message);
    }


    public AdminServiceException(Throwable cause)
    {
        super(cause);
    }
}

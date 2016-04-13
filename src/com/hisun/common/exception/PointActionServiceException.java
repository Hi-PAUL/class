package com.hisun.common.exception;

/**
 * 
 * @类名： PointActionServiceException.java
 * 
 * @描述：PointActionServiceException @作者： PAUL @修改日期： 2016年4月13日
 *
 */
public class PointActionServiceException extends Exception
{
    private static final long serialVersionUID = -7176745351256318216L;


    public PointActionServiceException()
    {
        super();
    }


    public PointActionServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public PointActionServiceException(String message)
    {
        super(message);
    }


    public PointActionServiceException(Throwable cause)
    {
        super(cause);
    }
}

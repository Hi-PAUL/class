package com.hisun.common.exception;

/**
 * 
 * @类名： NewsServiceException.java
 * 
 * @描述：NewsServiceException @作者： PAUL @修改日期： 2016年5月10日
 *
 */

public class NewsServiceException extends Exception
{

    private static final long serialVersionUID = -5698464299094074758L;


    public NewsServiceException()
    {
        super();
    }


    public NewsServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public NewsServiceException(String message)
    {
        super(message);
    }


    public NewsServiceException(Throwable cause)
    {
        super(cause);
    }
}

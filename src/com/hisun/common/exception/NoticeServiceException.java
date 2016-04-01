package com.hisun.common.exception;

/**
 * 
 * @类名： NoticeServiceException.java
 * 
 * @描述：NoticeServiceException @作者： PAUL @修改日期： 2016年3月31日
 *
 */
public class NoticeServiceException extends Exception
{

    private static final long serialVersionUID = -6166533554682206492L;


    public NoticeServiceException()
    {
        super();
    }


    public NoticeServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public NoticeServiceException(String message)
    {
        super(message);
    }


    public NoticeServiceException(Throwable cause)
    {
        super(cause);
    }
}

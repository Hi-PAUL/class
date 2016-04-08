package com.hisun.common.exception;

/**
 * 
 * @类名： AlbumServiceException.java
 * 
 * @描述：AlbumServiceException @作者： PAUL @修改日期： 2016年4月8日
 *
 */
public class AlbumServiceException extends Exception
{

    private static final long serialVersionUID = -8782032273401964057L;


    public AlbumServiceException()
    {
        super();
    }


    public AlbumServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }


    public AlbumServiceException(String message)
    {
        super(message);
    }


    public AlbumServiceException(Throwable cause)
    {
        super(cause);
    }
}

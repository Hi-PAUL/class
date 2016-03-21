package com.hisun.common.bean;

import java.util.Date;

/**
 * 
 * @类名： Photo.java
 * @描述：Photo
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class Photo
{
    private Long id;

    private String author;

    private String path;

    private String title;

    private String contents;

    private String albumname;

    private Long albumid;

    private Long hits;

    private Long praise;

    private Date pubdate;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getAuthor()
    {
        return author;
    }


    public void setAuthor(String author)
    {
        this.author = author == null ? null : author.trim();
    }


    public String getPath()
    {
        return path;
    }


    public void setPath(String path)
    {
        this.path = path == null ? null : path.trim();
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title == null ? null : title.trim();
    }


    public String getContents()
    {
        return contents;
    }


    public void setContents(String contents)
    {
        this.contents = contents == null ? null : contents.trim();
    }


    public String getAlbumname()
    {
        return albumname;
    }


    public void setAlbumname(String albumname)
    {
        this.albumname = albumname == null ? null : albumname.trim();
    }


    public Long getAlbumid()
    {
        return albumid;
    }


    public void setAlbumid(Long albumid)
    {
        this.albumid = albumid;
    }


    public Long getHits()
    {
        return hits;
    }


    public void setHits(Long hits)
    {
        this.hits = hits;
    }


    public Long getPraise()
    {
        return praise;
    }


    public void setPraise(Long praise)
    {
        this.praise = praise;
    }


    public Date getPubdate()
    {
        return pubdate;
    }


    public void setPubdate(Date pubdate)
    {
        this.pubdate = pubdate;
    }


    @Override
    public String toString()
    {
        return "Photo [id=" + id + ", author=" + author + ", path=" + path + ", title=" + title + ", contents=" + contents + ", albumname=" + albumname + ", albumid=" + albumid + ", hits=" + hits
                + ", praise=" + praise + ", pubdate=" + pubdate + "]";
    }
}

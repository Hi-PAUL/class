package com.hisun.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hisun.common.bean.Result;
import com.hisun.common.exception.ResultServiceException;
import com.hisun.common.util.ExcelUtil;
import com.hisun.common.util.ResultObject;
import com.hisun.service.ResultService;

/**
 * 
 * @类名： ResultController.java
 * 
 * @描述：ResultController @作者： PAUL @修改日期： 2016年4月2日
 *
 */
@Controller
public class ResultController
{
    @Resource
    private ResultService resultService;


    @RequestMapping(value = "result.xhtml", method = RequestMethod.GET)
    public ModelAndView gotoResult()
    {
        System.out.println("result.xhtml");
        ModelAndView model = new ModelAndView("result");
        return model;
    }


    @RequestMapping(value = "get_result_list", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject userLogin(HttpServletRequest request, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "studentId", required = false) String studentId,
        @RequestParam(value = "session", required = false) String session)
    {
        Map<String, Object> list = null;
        try
        {
            list = this.resultService.getResultList(pageNumber, pageSize, studentId, session);
        }
        catch (ResultServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
        return new ResultObject(list);
    }


    @RequestMapping(value = "print_result.json", method = RequestMethod.GET)
    public ResponseEntity<byte[]> printResultList(HttpServletRequest request, @RequestParam(value = "studentId", required = false) String studentId,
        @RequestParam(value = "session", required = false) String session) throws IOException
    {
        List<Result> list = null;
        if (session != null)
        {
            session = new String(session.getBytes("iso-8859-1"), "UTF-8");
        }
        try
        {
            list = this.resultService.getResultByParams(studentId, session);
        }
        catch (ResultServiceException e)
        {
            e.printStackTrace();
        }
        System.out.println("list " + list);
        byte[] out = ExcelUtil.createResultExcel(list);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "result.xls");
        return new ResponseEntity<byte[]>(out, headers, HttpStatus.CREATED);
    }

}

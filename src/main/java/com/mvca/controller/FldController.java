package com.mvca.controller;

import com.mvca.model.Fld;
import com.mvca.service.FldService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fld")
public class FldController {   //实现和之前LhdaServlet一样的功能
    Logger log = Logger.getLogger(FldController.class);

    @Autowired   //通过@Autowired自动装配方式，从IoC容器中去查找到，并返回给该属性
            FldService fldService;//=new FldServiceImpl()

    @RequestMapping()
    public String showFld(HttpServletRequest req, Fld fld) {
        List<Fld> lst = fldService.getFld(fld);
        req.setAttribute("lstFld", lst);
        return "showFld";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        return "addFld";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(HttpServletRequest req, Fld fld, MultipartFile fname) throws IOException {
        log.debug(fname.getOriginalFilename());
        String sPath=req.getServletContext().getRealPath("/")+ "/static/upload/";
        log.debug(sPath);
        fname.transferTo(new File(sPath+fld.getFlda()+"_.png"));//保存文件

        fld.setFldd(fld.getFlda()+"_.png"); //记录文件名称



        if (fldService.insertFld(fld)) {
            return "redirect:/fld";
        } else {
            req.setAttribute("error", "addFld failure");
            return "addFld";
        }

    }

    @RequestMapping(value = "/delete/{flda}", method = RequestMethod.GET)
    public String delete(HttpServletResponse resp, @PathVariable int flda) throws Exception {
        log.debug(flda);
        fldService.deleteFld(flda);
        return "redirect:/fld";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int flda = Integer.parseInt(req.getParameter("flda"));
        PrintWriter out = resp.getWriter();

        if (fldService.deleteFld(flda)) {
            out.print("success");
        } else {
            out.print("failure");
        }
    }

    @RequestMapping("/check/{flda}")
    public void check(HttpServletResponse resp, @PathVariable int flda) throws Exception {
        log.debug(flda);
        PrintWriter out = resp.getWriter();
        // out.print(fldService);
        if (fldService.checkFld(flda)) {
            out.print("occupied");
        } else {
            out.print("available");
        }
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        return "updateFld";
    }

    //启动服务器，地址栏请求  /fld/update?flda=100&fldb=zsls&fldc=11111&oldflda=100
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest req, @RequestParam Map map) throws Exception {
        if (fldService.updateFld(map)) {
            return "redirect:/fld";
        } else {
            req.setAttribute("error", "updateFld failure");
            return "updateFld";
        }
    }

    @RequestMapping(value = "/TTTTTTTTT", method = RequestMethod.POST)
    public String update(HttpServletRequest req, @RequestParam Map map) throws Exception {
        return null;
    }

}

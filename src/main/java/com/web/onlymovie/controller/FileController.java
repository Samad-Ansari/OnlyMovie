package com.web.onlymovie.controller;

import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/savefile", method = RequestMethod.POST)
    public String upload(@RequestParam CommonsMultipartFile file, HttpSession session) {
        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();

        System.out.println(path + " " + filename);
        try {
            byte barr[] = file.getBytes();

            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path + "/" + filename));
            bout.write(barr);
            bout.flush();
            bout.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return "file-view";
    }
}

package com.web.onlymovie.controller;

import com.web.onlymovie.model.Product;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/products")
public class DemoProductController {
    @RequestMapping(value = "/save-product", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, "multipart/form-data;charset=UTF-8"})
    public String uploadFile(@RequestParam("file") MultipartFile uploadFile, HttpSession session) throws IOException {
        String filename = uploadFile.getOriginalFilename();
        String path = session.getServletContext().getRealPath("/images/");

        // save file
        byte barr[] = uploadFile.getBytes();
        BufferedOutputStream bout = new BufferedOutputStream(
                new FileOutputStream(path + "/" + filename));
        bout.write(barr);
        bout.flush();
        bout.close();
        return "viewProductDetail";
    }

    @RequestMapping(value = "/product-input-form")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }
}
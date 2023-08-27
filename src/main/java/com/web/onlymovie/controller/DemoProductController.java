package com.web.onlymovie.controller;

import com.sun.org.apache.xpath.internal.operations.Mult;
import com.web.onlymovie.model.Product;
import org.apache.pdfbox.pdfparser.PDFParser;
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
import java.io.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/products")
public class DemoProductController {
    @RequestMapping(value = "/save-product", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String uploadFile(@RequestParam("file") MultipartFile uploadFile, HttpSession session) throws IOException {
        String filename = uploadFile.getOriginalFilename();
        String path = session.getServletContext().getRealPath("/images/");


        // save file
        saveFile(uploadFile, path, filename);

        printFile(path, filename);
        return "viewProductDetail";
    }

    public void printFile(String path, String filename) throws IOException {
        File file = new File(path + "/" + filename);
        PDDocument document = PDDocument.load(file);
        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();
        //Retrieving text from PDF document
        String text = pdfStripper.getText(document);
        System.out.println(text);
        //Closing the document
        document.close();
    }

    public void saveFile(MultipartFile uploadFile, String path, String filename) throws IOException {
        byte bytes[] = uploadFile.getBytes();
        BufferedOutputStream bout = new BufferedOutputStream(
                new FileOutputStream(path + "/" + filename));

        bout.write(bytes);
        bout.flush();
        bout.close();
    }

    public void encodedFile(MultipartFile uploadFile, String path, String filename) throws IOException {
        byte bytes[] = uploadFile.getBytes();
        BufferedOutputStream bout = new BufferedOutputStream(
                new FileOutputStream(path + "/" + filename));

        String utf = new String(bytes, "UTF-8");            //converts into UTF-8 encoding
        String cp1252 = new String(bytes, "Cp1252");    //conversts into Cp1252 endcoding
        String windows1252 = new String(bytes, "Windows-1252");  //converts into windows-1252 encoding

        System.out.println("String in UTF-8 encoding : " + utf);
        System.out.println("String in Cp1252 encoding : " + cp1252);
        System.out.println("string Windows-1252 encoding : " + windows1252);
    }

    @RequestMapping(value = "/product-input-form")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }
}
package com.ccs.ems.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.logging.Logger;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ccs.ems.model.Book;
import com.ccs.ems.svc.BookService;

@Controller
@RequestMapping("/upload")
public class BookFileController {
	
	@Autowired
	BookService bookService;
	
	private static final org.slf4j.Logger logger = LoggerFactory
            .getLogger(BookFileController.class);
	
	@RequestMapping(value="uploadForm", method = RequestMethod.GET)
	public String showUploadForm(ModelMap model)
	{
		//Contact contact = new Contact();
		model.addAttribute("contact", new Book());
		return "uploadForm";
	}
	
	/**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    /*public @ResponseBody
    String uploadFileHandler(@RequestParam("fileName") String name,
            @RequestParam("file") MultipartFile file) {*/
    public ModelAndView uploadFileHandler(@RequestParam("fileName") String name,
            @RequestParam("file") MultipartFile file) {	
    	Book b = new Book();
    	
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
 
                b.setImage(bytes);
                b.setName(name);
                bookService.saveBook(b);
                
                ModelAndView model = new ModelAndView();
                model.setViewName("uploadSuccess");
                
                return new ModelAndView("uploadSuccess", "b", b);
                
                /*// Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());*/
 
                //return "You successfully uploaded file=" + name + " with id " + b.getId();
                //return "You successfully uploaded file=" + name + " at location " + rootPath;
                
            } catch (Exception e) {
                return new ModelAndView("uploadForm", "b", b);//"You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return new ModelAndView("uploadForm", "b", b);//"You failed to upload " + name
                    //+ " because the file was empty.";
        }
    }
	
	/*@RequestMapping(value="uploadFile", method = RequestMethod.POST)
	public String handleFileUpload(@ModelAttribute"contact") Book book) {
		
		// gets values of text fields
        String name = book.getName();
        
        InputStream inputStream = null; // input stream of the upload file
        
        bookService.saveBook(book);
		return "uploadSuccess";*/
        	
}

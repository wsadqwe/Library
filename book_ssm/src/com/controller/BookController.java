package com.controller;


import com.entity.Book;
import com.service.impl.BookServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("Book")
public class BookController {
    @Autowired
    private HttpServletRequest request;


    @Autowired
    private BookServiceImp BookService;


    @RequestMapping("/list")
    public String list() {
        List<Book> proList = this.BookService.queryAll();
        request.setAttribute("list", proList);
        return "listBook";
    }


    @RequestMapping("/listquery")
    public String listquery(String name) {
        List<Book> proList = this.BookService.queryAll();
        if (name != null && !name.trim().equals("")) {               //�ж������Ƿ�Ϊ�գ����߿��ַ���
            proList = proList.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
        }
        request.setAttribute("list", proList);
        request.setAttribute("name", name);
        return "listBook";
    }


    @RequestMapping("/add")
    public String add(@RequestParam("file") MultipartFile[] file, Book Book) {
        // �ж��ļ��Ƿ�Ϊ�գ����򷵻�ʧ��ҳ��
        if (null == file || file.length <= 0) {
            request.setAttribute("msg", "���ͼ��ʧ�ܣ�û��ѡ��ͼ��ͼƬ");
            return "add";
        }
        // ��ȡ�ļ��洢·��������·����
        String path = request.getServletContext().getRealPath("/uploadimg");
        // ��ȡԭ�ļ���
        for (int i = 0; i < file.length; i++) {
            MultipartFile m = file[i];
            String fileName = UUID.randomUUID() + m.getOriginalFilename();
            // �����ļ�ʵ��
            File filePath = new File(path, fileName);
            // ����ļ�Ŀ¼�����ڣ�����Ŀ¼
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("����Ŀ¼" + filePath);
            }
            System.out.println(path);
            // д���ļ�
            try {
                m.transferTo(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                Book.setImgsrc(fileName);

            } else {
                Book.setTxtsrc(fileName);

            }

        }

        Book.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        this.BookService.add(Book);

        request.setAttribute("msg", "���ͼ��ɹ�");
        request.setAttribute("name", Book.getName());

        return "add";


    }

    @RequestMapping("/del")
    public String del(String id) {
        this.BookService.del(id);
        return "forward:list.do";
    }

    @RequestMapping("/toupdate")
    public String toupdate(String id) {
        Book Book = this.BookService.selectById(id);
        request.setAttribute("v", Book);
        return "updateBook";
    }

    @RequestMapping("/showtxt")
    public String showtxt(String id) {
        Book Book = this.BookService.selectById(id);
        String path = request.getServletContext().getRealPath("/uploadimg");

        System.out.println(path);

        String txtsrc = Book.getTxtsrc();

        File file = new File(path, txtsrc);

        String s = readFile(file.getPath());
        System.out.println(s);
        request.setAttribute("v", Book);
        request.setAttribute("str", s);
        return "showtxt";
    }

    public static String readFile(String fileName) {

        String fileContent = "";

        try {

            File f = new File(fileName);

            if (f.isFile() && f.exists()) {

                InputStreamReader read = new InputStreamReader(new FileInputStream(f), "gbk");

                BufferedReader reader = new BufferedReader(read);

                String line;

                while ((line = reader.readLine()) != null) {

                    fileContent += line;

                }

                read.close();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return fileContent;

    }


    @RequestMapping("/update")
    public String update(@RequestParam("file") MultipartFile[] file, Book Book) {
        Book BookOld = this.BookService.selectById(Book.getId() + "");
        String path = request.getServletContext().getRealPath("/uploadimg");

        // �ж��ļ��Ƿ�Ϊ�գ����򷵻�ʧ��ҳ��   
        for (int i = 0; i < file.length; i++) {
            MultipartFile m = file[i];
            String fileName = UUID.randomUUID() + m.getOriginalFilename();
            // �����ļ�ʵ��
            File filePath = new File(path, fileName);
            // ����ļ�Ŀ¼�����ڣ�����Ŀ¼
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("����Ŀ¼" + filePath);
            }
            System.out.println(path);
            // д���ļ�
            try {
                m.transferTo(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                Book.setImgsrc(fileName);

            } else {
                Book.setTxtsrc(fileName);

            }

        }

        this.BookService.update(Book);
        return "forward:list.do";
    }


}

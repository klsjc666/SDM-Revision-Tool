package org.SDM.common.FTP.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.SDM.common.FTP.util.FtpUtil;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/image")
public class FtpController {

    @PostMapping(value = "/uploadAnswer")
    public boolean upload(@RequestParam("file") MultipartFile file, @RequestParam("quizId") String quizId,
                          @RequestParam("teacher") Boolean teacher, @RequestParam("feedback") String feedback) throws IOException {

        System.out.println("------------------------------------------");
        //System.out.println(file);
        System.out.println(quizId);
        System.out.println(teacher);
        System.out.println(feedback);
        System.out.println("------------------------------------------");

        log.info(file.toString());

        String originalFileName = file.getOriginalFilename();

        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));

        String fileName = UUID.randomUUID() + suffix;

        JSONObject param = new JSONObject();
        param.put("quizId", quizId);
        if (teacher){
            param.put("answerType","T");
            param.put("approved",true);
        }else{
            param.put("answerType","S");
            param.put("approved",false);
        }

        param.put("picture",fileName);
        param.put("feedback",feedback);

        boolean returnResult = FtpUtil.uploadFile("","/Answers",fileName,file.getInputStream());

        HttpPost hostPost = new HttpPost("http://localhost:8080/answer/save");
        CloseableHttpClient client = HttpClients.createDefault();

        StringEntity entity = new StringEntity(param.toString(), "UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        hostPost.setEntity(entity);

        try{
            client.execute(hostPost);
        }catch (IOException e){

        }

        return returnResult;
    }

    /*
    @PostMapping(value = "/showAnswer")
    public HttpServletResponse download(@RequestBody String fileName, HttpServletResponse response) {

        FtpUtil.downloadFile("/Answers",fileName,"Answers");

        String path = "Answers/" + fileName;

        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }
    */

    @GetMapping(value = "/showAnswer")
    public void views(@RequestParam String filename, HttpServletResponse response) throws IOException{

        FtpUtil.downloadFile("/Answers",filename,"Answers");

        File file = new File("Answers/" + filename);

        //https://www.bilibili.com/video/BV1ev4y1p7AN/?spm_id_from=333.788&vd_source=501e05f67fe5bdfeb4939ee4e8e56bee
        //设置输出流格式
        ServletOutputStream outputStream = response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename , "UTF-8"));

        //任意类型的二进制流数据
        response.setContentType("application/octet-stream");
        //读取文件字节流
        outputStream.write(FileUtil.readBytes(file));
        outputStream.flush();
        outputStream.close();

        file.delete();
    }

}

package com.deepexi.ai.gallery.controller;


import com.deepexi.ai.gallery.model.Amount;
import com.deepexi.ai.gallery.model.Video;
import com.deepexi.ai.gallery.service.IAdminService;
import com.deepexi.ai.gallery.service.IAmountService;
import com.deepexi.ai.gallery.service.IVideoService;
import com.deepexi.ai.gallery.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class VideoController {

    @Autowired
    IVideoService videoService;
    @Autowired
    IAdminService adminService;
    @Autowired
    IAmountService amountService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Amount> amount = amountService.findAmount();
        if (amount!=null){
            int num = amount.get(0).getNum();
            model.addAttribute("count",num);
        }else{
            Amount amountNew = new Amount(1);
            amountService.save(amountNew);
        }
        List<Video> video = videoService.findAll();
        model.addAttribute("videos", video);
        return "index";
    }

    @PostMapping("/toUpload")
    public String uploadByPost(Model model,
                               @RequestParam("file") MultipartFile file,
                               @RequestParam("title")String title,
                               @RequestParam("content")String content,
                               @RequestParam("fileCover")MultipartFile fileCover) {
        String uploadName = file.getOriginalFilename();
        String fileCoverName = fileCover.getOriginalFilename();
        if (!file.isEmpty()&&!fileCover.isEmpty()) {
            try {
                String filePath = PathUtil.uploadVideoPath + uploadName;
                String fileCoverPath = PathUtil.uploadImgPath + fileCoverName;
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                BufferedOutputStream out1 = new BufferedOutputStream(new FileOutputStream(new File(fileCoverPath)));
                out.write(file.getBytes());
                out1.write(fileCover.getBytes());
                out.flush();
                out1.flush();
                out.close();
                out1.close();
                model.addAttribute("msg", "上传文件成功");
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("msg", "上传文件失败：" + e.getMessage());
            }
            String videoUrl = new StringBuilder().append("video").append("/").append(uploadName).toString();
            String ImgUrl = new StringBuilder().append("img1").append("/").append(fileCoverName).toString();
            Video video = new Video();
            video.setFileCoverUrl(ImgUrl);
            video.setContent(content);
            video.setTitle(title);
            video.setUrl(videoUrl);
            videoService.save(video);
        } else {
            model.addAttribute("msg", "上传文件失败：文件为空");
        }
        return "uploadMsg";
    }
    @RequestMapping("/upload")
    public String upload() {
        return "upload_video";
    }
    @ResponseBody
    @RequestMapping("/deleteAll")
    public String deleteAll(){
        videoService.deleteAll();
        return "success";
    }
    @RequestMapping("/one")
    public String one(Model model){
        Optional<Video> videos = videoService.findById("5bee6ee8e6aabd2a2ce0bb27");
        Video video = videos.get();
        List<Video> video11 = new ArrayList<>();
        video11.add(video);
        model.addAttribute("videos", video11);
        return "index";
    }
    @GetMapping("/play")
    public String play(Model model,String aId){
        //访问量加1
        List<Amount> l = amountService.findAmount();
        Amount amount = l.get(0);
        int num = amount.getNum();
        amount.setNum(num+1);
        amountService.save(amount);
        Optional<Video> opt = videoService.findById(aId);
        Video video = opt.get();
        model.addAttribute("video",video);
        return "playPage";
    }
    @GetMapping("/789")
    public String login1(){
        return "login";
    }
    @ResponseBody
    @RequestMapping("/777")
    public String lll(){
        Amount amount = new Amount(9);
        amountService.save(amount);
        return "999999";
    }
}

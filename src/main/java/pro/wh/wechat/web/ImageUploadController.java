package pro.wh.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import pro.wh.wechat.utils.OSSUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/image_upload")
public class ImageUploadController {

    /**
     * 上传
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam(value = "imageFile", required = false) MultipartFile image,
                              HttpServletRequest request, HttpServletResponse response) {
        if (request instanceof MultipartHttpServletRequest) {
            String logoUrl = null;
            try {
                OSSUtil ossUtil = new OSSUtil();
                String name = ossUtil.uploadImg2Oss(image);
                logoUrl = ossUtil.getImgUrl(name);
                ossUtil.destory();
                return logoUrl;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        else {
            return "";
        }
    }
}

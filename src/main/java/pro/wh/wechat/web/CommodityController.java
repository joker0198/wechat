package pro.wh.wechat.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.wh.wechat.core.Servlets;
import pro.wh.wechat.service.CommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * 商品列表
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {

    private static final Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Resource
    private CommodityService commodityService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "0") int pageNumber,
                       @RequestParam(value = "size", defaultValue = "20") int pageSize, String sortType,
                       Model model, ServletRequest request){
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        logger.info("xxxxxxxxxxxxxxxxxxxxxxx");
        return "/commodity/list";
    }
}

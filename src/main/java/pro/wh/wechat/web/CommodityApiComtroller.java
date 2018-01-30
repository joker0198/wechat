package pro.wh.wechat.web;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.wh.wechat.model.Commodity;
import pro.wh.wechat.model.CommodityType;
import pro.wh.wechat.service.CommodityService;
import pro.wh.wechat.service.CommodityTypeService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commodity/")
public class CommodityApiComtroller {

    private final static Gson gson = new Gson();
    private final static Logger logger = LoggerFactory.getLogger(CommodityApiComtroller.class);

    @Resource
    private CommodityService commodityService;
    @Resource
    private CommodityTypeService commodityTypeService;

    @RequestMapping(value="commodity_type", method = RequestMethod.GET)
    public String commodityType(){
        List<CommodityType> commodityTypeList = commodityTypeService.findAll();
        String result = gson.toJson(commodityTypeList);
        logger.info("data" + result);
        return result;
    }

    @RequestMapping(value="commodity", method = RequestMethod.GET)
    public String commodity(){
        List<Commodity> commodityList = commodityService.findAll();
        String result = gson.toJson(commodityList);
        logger.info("data" + result);
        return result;
    }

    @RequestMapping(value="ajaxCommodityByCommodityTypeId", method = RequestMethod.GET)
    public String ajaxCommodityByCommodityTypeId(Long commodityTypeId){
        logger.info("commodityTypeId:" + commodityTypeId);
        List<Commodity> commodityList = commodityService.findByCommodityTypeId(commodityTypeId);
        return gson.toJson(commodityList);
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Long id){
        logger.info("id:" + id);
        Commodity entity = commodityService.findOne(id);
        Map<String, Object> result = new HashMap<>();
        result.put("commodity", entity);
        result.put("images", entity.getImagesList());
        return gson.toJson(result);
    }

    //ss
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(String title){
        logger.info("title:" + title);
        List<Commodity> commodities = commodityService.getByTitleLikeForSql(title);
        return gson.toJson(commodities);
    }
}

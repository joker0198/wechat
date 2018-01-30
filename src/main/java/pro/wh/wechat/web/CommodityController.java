package pro.wh.wechat.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pro.wh.wechat.Constants;
import pro.wh.wechat.core.Servlets;
import pro.wh.wechat.model.Commodity;
import pro.wh.wechat.model.CommodityType;
import pro.wh.wechat.service.CommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pro.wh.wechat.service.CommodityTypeService;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.List;
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
    @Resource
    private CommodityTypeService commodityTypeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "0") int pageNumber,
                       @RequestParam(value = "size", defaultValue = "20") int pageSize, String sortType,
                       Model model, ServletRequest request){
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<Commodity> page = commodityService.findPage(searchParams, pageNumber, pageSize);
        model.addAttribute("page", page);
        model.addAttribute("sortType", sortType);
        model.addAttribute("searchParams", searchParams);
        return "/commodity/list";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        List<CommodityType> commodityTypeList = commodityTypeService.findAll();
        model.addAttribute("entity", new Commodity());
        model.addAttribute("commodityTypeList", commodityTypeList);
        return "/commodity/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("entity") Commodity entity, RedirectAttributes redirectAttributes){
        try {
            commodityService.save(entity);
            redirectAttributes.addFlashAttribute(Constants.MSG, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute(Constants.MSG, "保存失败!");
        }
        return "redirect:/commodity/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model){
        Commodity entity = commodityService.findOne(id);
        model.addAttribute("entity", entity);
        List<CommodityType> commodityTypeList = commodityTypeService.findAll();
        model.addAttribute("commodityTypeList", commodityTypeList);
        return "/commodity/add";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Long id, RedirectAttributes redirectAttributes){
        try {
            commodityService.delete(id);
            redirectAttributes.addFlashAttribute(Constants.MSG, "删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute(Constants.MSG, "删除失败!");
        }
        return "redirect:/commodity/list";
    }
}

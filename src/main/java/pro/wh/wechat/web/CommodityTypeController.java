package pro.wh.wechat.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pro.wh.wechat.Constants;
import pro.wh.wechat.core.Servlets;
import pro.wh.wechat.model.CommodityType;
import pro.wh.wechat.service.CommodityTypeService;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * 商品明细
 */
@Controller
@RequestMapping("/commodity_type")
public class CommodityTypeController {

    private static final Logger logger = LoggerFactory.getLogger(CommodityTypeController.class);

    @Resource
    private CommodityTypeService commodityTypeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "0") int pageNumber,
                       @RequestParam(value = "size", defaultValue = "20") int pageSize, String sortType,
                       Model model, ServletRequest request){
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<CommodityType> page = commodityTypeService.findPage(searchParams, pageNumber, pageSize);
        model.addAttribute("page", page);
        model.addAttribute("sortType", sortType);
        model.addAttribute("searchParams", searchParams);
        return "/commodity_type/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("entity", new CommodityType());
        return "/commodity_type/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("entity") CommodityType entity, RedirectAttributes redirectAttributes){
        try {
            commodityTypeService.save(entity);
            redirectAttributes.addFlashAttribute(Constants.MSG, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute(Constants.MSG, "保存失败!");
        }
        return "redirect:/commodity_type/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model){
        CommodityType entity = commodityTypeService.findOne(id);
        model.addAttribute("entity", entity);
        return "/commodity_type/add";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Long id, RedirectAttributes redirectAttributes){
        try {
            commodityTypeService.delete(id);
            redirectAttributes.addFlashAttribute(Constants.MSG, "删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute(Constants.MSG, "删除失败!");
        }
        return "redirect:/commodity_type/list";
    }
}

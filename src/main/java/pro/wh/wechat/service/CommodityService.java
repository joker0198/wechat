package pro.wh.wechat.service;

import pro.wh.wechat.repository.CommodityDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 商品Service
 */
@Service
@Transactional
public class CommodityService {

    @Resource
    private CommodityDao commodityDao;
}

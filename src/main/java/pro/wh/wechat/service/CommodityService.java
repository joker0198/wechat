package pro.wh.wechat.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import pro.wh.wechat.model.Commodity;
import pro.wh.wechat.model.CommodityImages;
import pro.wh.wechat.model.CommodityType;
import pro.wh.wechat.repository.CommodityDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.wh.wechat.repository.CommodityImagesDao;
import pro.wh.wechat.repository.CommodityTypeDao;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/**
 * 商品Service
 */
@Service
@Transactional
public class CommodityService {

    private final static Logger logger = LoggerFactory.getLogger(CommodityService.class);

    @Resource
    private CommodityDao commodityDao;
    @Resource
    private CommodityImagesDao commodityImagesDao;

    @Transactional(readOnly = true)
    public Page<Commodity> findPage(final Map<String, Object> searchParams, final int pageNumber, final int pageSize){
        PageRequest pageRequest = new PageRequest(pageNumber, pageSize);
        return commodityDao.findAll(this.getPageSpec(searchParams), pageRequest);
    }

    /**
     * 组装JPA检索条件
     * @param searchParams
     * @return
     */
    private Specification<Commodity> getPageSpec(final Map<String, Object> searchParams) {
        return new Specification<Commodity>() {
            @Override
            public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = Lists.newArrayList();
                // 将所有条件用 and 联合起来
                if (!predicates.isEmpty()) {
                    return cb.and(predicates.toArray(new Predicate[predicates.size()]));
                }
                return cb.conjunction();
            }
        };
    }

    @Transactional(readOnly = true)
    public Commodity findOne(Long id){
        return commodityDao.findOne(id);
    }

    public void delete(Long id){
        commodityDao.delete(id);
    }

    public void save(Commodity entity) {
        logger.info("size:" + entity.getImagesList().size());
        Commodity commodity = commodityDao.save(entity);
        for (CommodityImages images : entity.getImagesList()) {
            CommodityImages image = new CommodityImages(images.getImage(), commodity);
            commodityImagesDao.save(image);
        }
    }

    @Transactional(readOnly = true)
    public List<Commodity> findAll(){
        return (List<Commodity>)commodityDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Commodity> findByCommodityTypeId(Long commodityTypeId){
        return (List<Commodity>)commodityDao.findByCommodityTypeId(commodityTypeId);
    }

    @Transactional(readOnly = true)
    public List<Commodity> getByTitleLikeForSql(String title){
        return (List<Commodity>)commodityDao.getByTitleLikeForSql(title);
    }
}

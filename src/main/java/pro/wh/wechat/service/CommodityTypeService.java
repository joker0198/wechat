package pro.wh.wechat.service;

import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.wh.wechat.model.CommodityType;
import pro.wh.wechat.repository.CommodityDao;
import pro.wh.wechat.repository.CommodityTypeDao;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/**
 * 商品分类
 */
@Service
public class CommodityTypeService {

    @Resource
    private CommodityTypeDao commodityTypeDao;

    public void save(CommodityType entity){
        commodityTypeDao.save(entity);
    }

    @Transactional(readOnly = true)
    public Page<CommodityType> findPage(final Map<String, Object> searchParams, final int pageNumber, final int pageSize){
        PageRequest pageRequest = new PageRequest(pageNumber, pageSize);
        return commodityTypeDao.findAll(this.getPageSpec(searchParams), pageRequest);
    }

    @Transactional(readOnly = true)
    public CommodityType findOne(Long id){
        return commodityTypeDao.findOne(id);
    }

    public void delete(Long id){
        commodityTypeDao.delete(id);
    }

    /**
     * 组装JPA检索条件
     * @param searchParams
     * @return
     */
    private Specification<CommodityType> getPageSpec(final Map<String, Object> searchParams) {
        return new Specification<CommodityType>() {
            @Override
            public Predicate toPredicate(Root<CommodityType> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
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
    public List<CommodityType> findAll(){
        return ( List<CommodityType>)commodityTypeDao.findAll();
    }
}

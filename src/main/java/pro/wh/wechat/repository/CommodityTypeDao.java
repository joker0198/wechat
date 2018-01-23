package pro.wh.wechat.repository;

import pro.wh.wechat.model.CommodityType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 商品类型Dao接口
 */
public interface CommodityTypeDao extends PagingAndSortingRepository<CommodityType, Long>, JpaSpecificationExecutor<CommodityType> {
}

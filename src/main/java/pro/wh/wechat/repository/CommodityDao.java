package pro.wh.wechat.repository;

import pro.wh.wechat.model.Commodity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 商品Dao接口
 */
public interface CommodityDao extends PagingAndSortingRepository<Commodity, Long>, JpaSpecificationExecutor<Commodity> {
}

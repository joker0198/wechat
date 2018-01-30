package pro.wh.wechat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pro.wh.wechat.model.Commodity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * 商品Dao接口
 */
public interface CommodityDao extends PagingAndSortingRepository<Commodity, Long>, JpaSpecificationExecutor<Commodity> {

    List<Commodity> findByCommodityTypeId(Long commodityTypeId);

    @Query("FROM Commodity commodity WHERE commodity.title like CONCAT('%',:title,'%')")
    List<Commodity> getByTitleLikeForSql(@Param("title") String title);
}

package pro.wh.wechat.repository;

import pro.wh.wechat.model.CommodityImages;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 积分商品图片Dao接口
 */
public interface CommodityImagesDao extends PagingAndSortingRepository<CommodityImages, Long>, JpaSpecificationExecutor<CommodityImages> {
}

package pro.wh.wechat.model;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品详情
 * @Author Wanghong 2018-01-19
 */
@Entity
@Table(name = "ex_commodity")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "ex_commodity_sequence")
public class Commodity extends BaseEntity{

    /** 删除（0-正常， 1-删除） */
    private int state = 0;
    /** 商品标题 */
    private String title;
    /** 详情 */
    private String content;
    /** 价格 */
    private BigDecimal price = new BigDecimal("0.00");
    /** 原价 */
    private BigDecimal marketPrice = new BigDecimal("0.00");
    /** 所属商品分类 */
    private CommodityType commodityType;
    /** 商品图片 */
    private List<CommodityImages> imagesList = Lists.newArrayList();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Lob
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commodity_type_id")
    public CommodityType getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(CommodityType commodityType) {
        this.commodityType = commodityType;
    }

    @OneToMany(mappedBy = "commodity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public List<CommodityImages> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<CommodityImages> imagesList) {
        this.imagesList = imagesList;
    }
}

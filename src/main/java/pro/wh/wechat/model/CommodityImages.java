package pro.wh.wechat.model;

import javax.persistence.*;

/**
 * 商品图片
 */
@Entity
@Table(name = "ex_commodity_image")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "ex_commodity_image_sequence")
public class CommodityImages extends BaseEntity{

    /** 删除（0-正常， 1-删除） */
    private int state = 0;
    /** 图片地址 */
    private String image;
    /** 所属商品 */
    private Commodity commodity;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commodity_id")
    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}

package pro.wh.wechat.model;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ex_commodity_type")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "ex_commodity_type_sequence")
public class CommodityType extends BaseEntity{

    /** 删除（0-正常， 1-删除） */
    private int state = 0;
    /** 分类名称 */
    private String name;
    /** 关联商品 */
    private List<Commodity> commodityList = Lists.newArrayList();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "commodityType", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }
}

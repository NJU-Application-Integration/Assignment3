package assignment3;

import java.io.Serializable;

/**
 * Created by Srf on 2017/6/23
 */

public class GroupPurchaseItem implements Serializable {
    private static final long serialVersionUID = -4801444555698503024L;
    private String id;
    private String seller;
    private String productName;
    private String introduction;
    private double price;
    private int limit;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSeller() {
        return this.seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}

package com.kipapos.library.model.product;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variation implements Serializable  {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("sub_sku")
    @Expose
    private String subSku;
    @SerializedName("product_variation_id")
    @Expose
    private Integer productVariationId;
    @SerializedName("variation_value_id")
    @Expose
    private Integer variationValueId;
    @SerializedName("default_purchase_price")
    @Expose
    private String defaultPurchasePrice;
    @SerializedName("dpp_inc_tax")
    @Expose
    private String dppIncTax;
    @SerializedName("profit_percent")
    @Expose
    private String profitPercent;
    @SerializedName("default_sell_price")
    @Expose
    private String defaultSellPrice;
    @SerializedName("sell_price_inc_tax")
    @Expose
    private String sellPriceIncTax;

    /**
     * No args constructor for use in serialization
     *
     */
    public Variation() {
    }
    /**
     *
     * @param productId
     * @param productVariationId
     * @param profitPercent
     * @param defaultSellPrice
     * @param subSku
     * @param dppIncTax
     * @param name
     * @param id
     * @param sellPriceIncTax
     * @param variationValueId
     * @param defaultPurchasePrice
     */
    public Variation(Integer id, String name, Integer productId, String subSku, Integer productVariationId, Integer variationValueId, String defaultPurchasePrice, String dppIncTax, String profitPercent, String defaultSellPrice, String sellPriceIncTax) {
        super();
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.subSku = subSku;
        this.productVariationId = productVariationId;
        this.variationValueId = variationValueId;
        this.defaultPurchasePrice = defaultPurchasePrice;
        this.dppIncTax = dppIncTax;
        this.profitPercent = profitPercent;
        this.defaultSellPrice = defaultSellPrice;
        this.sellPriceIncTax = sellPriceIncTax;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSubSku() {
        return subSku;
    }

    public void setSubSku(String subSku) {
        this.subSku = subSku;
    }

    public Integer getProductVariationId() {
        return productVariationId;
    }

    public void setProductVariationId(Integer productVariationId) {
        this.productVariationId = productVariationId;
    }

    public Integer getVariationValueId() {
        return variationValueId;
    }

    public void setVariationValueId(Integer variationValueId) {
        this.variationValueId = variationValueId;
    }

    public String getDefaultPurchasePrice() {
        return defaultPurchasePrice;
    }

    public void setDefaultPurchasePrice(String defaultPurchasePrice) {
        this.defaultPurchasePrice = defaultPurchasePrice;
    }

    public String getDppIncTax() {
        return dppIncTax;
    }

    public void setDppIncTax(String dppIncTax) {
        this.dppIncTax = dppIncTax;
    }

    public String getProfitPercent() {
        return profitPercent;
    }

    public void setProfitPercent(String profitPercent) {
        this.profitPercent = profitPercent;
    }

    public String getDefaultSellPrice() {
        return defaultSellPrice;
    }

    public void setDefaultSellPrice(String defaultSellPrice) {
        this.defaultSellPrice = defaultSellPrice;
    }

    public String getSellPriceIncTax() {
        return sellPriceIncTax;
    }

    public void setSellPriceIncTax(String sellPriceIncTax) {
        this.sellPriceIncTax = sellPriceIncTax;
    }

}

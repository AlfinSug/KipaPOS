package com.kipapos.library.model.product;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductVariation implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("variation_template_id")
    @Expose
    private Integer variationTemplateId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("variations")
    @Expose
    private List<Variation> variations = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductVariation() {
    }

    /**
     *
     * @param productId
     * @param variations
     * @param variationTemplateId
     * @param name
     * @param id
     */
    public ProductVariation(Integer id, Integer variationTemplateId, String name, Integer productId, List<Variation> variations) {
        super();
        this.id = id;
        this.variationTemplateId = variationTemplateId;
        this.name = name;
        this.productId = productId;
        this.variations = variations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVariationTemplateId() {
        return variationTemplateId;
    }

    public void setVariationTemplateId(Integer variationTemplateId) {
        this.variationTemplateId = variationTemplateId;
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

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

}
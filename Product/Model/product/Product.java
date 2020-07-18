package com.kipapos.library.model.product;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kipapos.library.model.Pegawai;

public class Product implements Serializable{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("sub_category")
    @Expose
    private String subCategory;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("sub_category_id")
    @Expose
    private Integer subCategoryId;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("unit_id")
    @Expose
    private Integer unitId;
    @SerializedName("brand_id")
    @Expose
    private Integer brandId;
    @SerializedName("tax")
    @Expose
    private String tax;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("enable_stock")
    @Expose
    private Integer enableStock;
    @SerializedName("is_inactive")
    @Expose
    private Integer isInactive;
    @SerializedName("not_for_selling")
    @Expose
    private Integer notForSelling;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("current_stock")
    @Expose
    private String currentStock;
    @SerializedName("max_price")
    @Expose
    private String maxPrice;
    @SerializedName("min_price")
    @Expose
    private String minPrice;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("alert_quantity")
    private Integer alertQty;
    @SerializedName("product_variations")
    @Expose
    private List<ProductVariation> productVariations = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    public Product(Integer id, String product, String type, String category, String subCategory, Integer categoryId, Integer subCategoryId, String unit, String brand, Integer unitId, Integer brandId, String tax, String sku, String image, Integer enableStock, Integer isInactive, Integer notForSelling, String productType, Integer weight, String currentStock, String maxPrice, String minPrice, String imageUrl, Integer alertQty, List<ProductVariation> productVariations) {
        this.id = id;
        this.product = product;
        this.type = type;
        this.category = category;
        this.subCategory = subCategory;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.unit = unit;
        this.brand = brand;
        this.unitId = unitId;
        this.brandId = brandId;
        this.tax = tax;
        this.sku = sku;
        this.image = image;
        this.enableStock = enableStock;
        this.isInactive = isInactive;
        this.notForSelling = notForSelling;
        this.productType = productType;
        this.weight = weight;
        this.currentStock = currentStock;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.imageUrl = imageUrl;
        this.alertQty = alertQty;
        this.productVariations = productVariations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getEnableStock() {
        return enableStock;
    }

    public void setEnableStock(Integer enableStock) {
        this.enableStock = enableStock;
    }

    public Integer getIsInactive() {
        return isInactive;
    }

    public void setIsInactive(Integer isInactive) {
        this.isInactive = isInactive;
    }

    public Integer getNotForSelling() {
        return notForSelling;
    }

    public void setNotForSelling(Integer notForSelling) {
        this.notForSelling = notForSelling;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(String currentStock) {
        this.currentStock = currentStock;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getAlertQty() {
        return alertQty;
    }

    public void setAlertQty(Integer alertQty) {
        this.alertQty = alertQty;
    }

    public List<ProductVariation> getProductVariations() {
        return productVariations;
    }

    public void setProductVariations(List<ProductVariation> productVariations) {
        this.productVariations = productVariations;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Product)) {
            return false;
        }
        Product otherProduct = (Product) other;
        return otherProduct.getId().equals(this.id) || otherProduct.getProduct().equalsIgnoreCase(this.product);
    }
}


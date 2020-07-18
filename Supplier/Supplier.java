package com.kipapos.library.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Supplier implements Serializable {
    @SerializedName("contact_id")
    @Expose
    private String contactId;
    @SerializedName("supplier_business_name")
    @Expose
    private String supplierBusinessName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("is_default")
    @Expose
    private Integer isDefault;
    @SerializedName("total_purchase")
    @Expose
    private String totalPurchase;
    @SerializedName("purchase_paid")
    @Expose
    private String purchasePaid;
    @SerializedName("total_purchase_return")
    @Expose
    private String totalPurchaseReturn;
    @SerializedName("purchase_return_paid")
    @Expose
    private String purchaseReturnPaid;
    @SerializedName("opening_balance")
    @Expose
    private String openingBalance;
    @SerializedName("opening_balance_paid")
    @Expose
    private String openingBalancePaid;
    @SerializedName("addition_information")
    @Expose
    private String additionInfo;

    /**
     * No args constructor for use in serialization
     *
     */
    public Supplier() {
    }

    /**
     *
     * @param totalPurchaseReturn
     * @param openingBalancePaid
     * @param contactId
     * @param mobile
     * @param type
     * @param supplierBusinessName
     * @param isDefault
     * @param purchaseReturnPaid
     * @param name
     * @param totalPurchase
     * @param id
     * @param openingBalance
     * @param purchasePaid
     * @param additionInfo
     */
    public Supplier(String contactId, String supplierBusinessName, String name, String mobile, String type, long id, Integer isDefault, String totalPurchase, String purchasePaid, String totalPurchaseReturn, String purchaseReturnPaid, String openingBalance, String openingBalancePaid, String additionInfo) {
        super();
        this.contactId = contactId;
        this.supplierBusinessName = supplierBusinessName;
        this.name = name;
        this.mobile = mobile;
        this.type = type;
        this.id = id;
        this.isDefault = isDefault;
        this.totalPurchase = totalPurchase;
        this.purchasePaid = purchasePaid;
        this.totalPurchaseReturn = totalPurchaseReturn;
        this.purchaseReturnPaid = purchaseReturnPaid;
        this.openingBalance = openingBalance;
        this.openingBalancePaid = openingBalancePaid;
        this.additionInfo = additionInfo;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getSupplierBusinessName() {
        return supplierBusinessName;
    }

    public void setSupplierBusinessName(String supplierBusinessName) {
        this.supplierBusinessName = supplierBusinessName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(String totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public String getPurchasePaid() {
        return purchasePaid;
    }

    public void setPurchasePaid(String purchasePaid) {
        this.purchasePaid = purchasePaid;
    }

    public String getTotalPurchaseReturn() {
        return totalPurchaseReturn;
    }

    public void setTotalPurchaseReturn(String totalPurchaseReturn) {
        this.totalPurchaseReturn = totalPurchaseReturn;
    }

    public String getPurchaseReturnPaid() {
        return purchaseReturnPaid;
    }

    public void setPurchaseReturnPaid(String purchaseReturnPaid) {
        this.purchaseReturnPaid = purchaseReturnPaid;
    }

    public String getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(String openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getOpeningBalancePaid() {
        return openingBalancePaid;
    }

    public void setOpeningBalancePaid(String openingBalancePaid) {
        this.openingBalancePaid = openingBalancePaid;
    }

    public String getAdditionInfo() {
        return additionInfo;
    }

    public void setAdditionInfo(String additionInfo) {
        this.additionInfo = additionInfo;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Supplier)) {
            return false;
        }
        Supplier otherSupplier = (Supplier) other;
        return otherSupplier.getId() == this.id || otherSupplier.getName().equalsIgnoreCase(this.name);
    }
}
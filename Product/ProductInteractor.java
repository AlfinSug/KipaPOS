package com.kipapos.library.data.interactor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kipapos.library.data.IProductInteractor;
import com.kipapos.library.data.NetworkModule;
import com.kipapos.library.data.api.ConstantAPI;
import com.kipapos.library.data.api.ProductAPI;
import com.kipapos.library.data.api.deserializer.BooleanDeserializer;
import com.kipapos.library.data.api.deserializer.BrandDeserializer;
import com.kipapos.library.data.api.deserializer.CategoryDeserializer;
import com.kipapos.library.data.api.deserializer.ProductDeserializer;
import com.kipapos.library.model.Brand;
import com.kipapos.library.model.Category;
import com.kipapos.library.model.product.Product;
import com.kipapos.library.model.product.Variation;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class ProductInteractor implements IProductInteractor {
    Retrofit retrofit;
    ProductAPI productAPI;

    public ProductInteractor() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Boolean.class, new BooleanDeserializer())
                .registerTypeAdapter(Category.class, new CategoryDeserializer())
                .registerTypeAdapter(Product.class, new ProductDeserializer())
                .registerTypeAdapter(Brand.class, new BrandDeserializer())
                .create();
        retrofit = NetworkModule.createRetrofit(ConstantAPI.BASE_URL, gson);
       productAPI = retrofit.create(ProductAPI.class);
    }

    @Override
    public Observable<List<Product>> getProduct(String token, int page) {
        return productAPI.getProduct(ConstantAPI.HEADER_AUTH_KEY + token, page);
    }

    @Override
    public Observable<Product> delProduct(long id, String token) {
        return productAPI.delProduct(id, ConstantAPI.HEADER_AUTH_KEY + token);
    }

    @Override
    public Observable<Product> editProduct(String token, Product product, String buy, String profit, String sell, MultipartBody.Part image) {
        HashMap<String, RequestBody> mapBody = new HashMap<>();
        mapBody.put("_method", RequestBody.create(MultipartBody.FORM, "PUT"));
        mapBody.put("name", RequestBody.create(MultipartBody.FORM, product.getProduct()));
        mapBody.put("sku", RequestBody.create(MultipartBody.FORM, product.getSku()));
        mapBody.put("unit_id", RequestBody.create(MultipartBody.FORM, product.getUnitId().toString()));
        mapBody.put("brand_id", RequestBody.create(MultipartBody.FORM, product.getBrandId().toString()));
        mapBody.put("category_id", RequestBody.create(MultipartBody.FORM, product.getCategoryId().toString()));
        mapBody.put("sub_category_id", RequestBody.create(MultipartBody.FORM, product.getSubCategoryId().toString()));
        mapBody.put("enable_stock", RequestBody.create(MultipartBody.FORM, "1"));
        mapBody.put("alert_quantity", RequestBody.create(MultipartBody.FORM, "1"));
        mapBody.put("product_description", RequestBody.create(MultipartBody.FORM, ""));
        mapBody.put("weight", RequestBody.create(MultipartBody.FORM, product.getWeight().toString()));
        mapBody.put("single_variation_id", RequestBody.create(MultipartBody.FORM, product.getProductVariations().get(0).getVariations().get(0).getId().toString()));
        mapBody.put("single_dpp", RequestBody.create(MultipartBody.FORM, buy));
        mapBody.put("profit_percent", RequestBody.create(MultipartBody.FORM, profit));
        mapBody.put("single_dsp", RequestBody.create(MultipartBody.FORM, sell));

        return productAPI.editProduct(ConstantAPI.HEADER_AUTH_KEY + token, product.getId(), image, mapBody);
    }

    @Override
    public Observable<Product> addProduct(String token, Product product, String buy, String profit, String sell, MultipartBody.Part image) {

        HashMap<String, RequestBody> mapBody = new HashMap<>();
        mapBody.put("name", RequestBody.create(MultipartBody.FORM, product.getProduct()));
        mapBody.put("sku", RequestBody.create(MultipartBody.FORM, product.getSku()));
        mapBody.put("unit_id", RequestBody.create(MultipartBody.FORM, product.getUnit()));
        mapBody.put("brand_id", RequestBody.create(MultipartBody.FORM, product.getBrand()));
        mapBody.put("category_id", RequestBody.create(MultipartBody.FORM, product.getCategory()));
        mapBody.put("sub_category_id", RequestBody.create(MultipartBody.FORM, product.getSubCategory()));
        mapBody.put("enable_stock", RequestBody.create(MultipartBody.FORM, product.getEnableStock().toString()));
        mapBody.put("alert_quantity", RequestBody.create(MultipartBody.FORM, product.getAlertQty().toString()));
        mapBody.put("product_description", RequestBody.create(MultipartBody.FORM, ""));
        mapBody.put("weight", RequestBody.create(MultipartBody.FORM, product.getWeight().toString()));
        mapBody.put("single_dpp", RequestBody.create(MultipartBody.FORM, buy));
        mapBody.put("profit_percent", RequestBody.create(MultipartBody.FORM, profit));
        mapBody.put("single_dsp", RequestBody.create(MultipartBody.FORM, sell));
        mapBody.put("type", RequestBody.create(MultipartBody.FORM, product.getType()));

        return productAPI.addProduct(ConstantAPI.HEADER_AUTH_KEY + token, image, mapBody);
    }


    @Override
    public Observable<List<Product>> getProductCat(String token, int catId) {
        return productAPI.getProductByCat(ConstantAPI.HEADER_AUTH_KEY + token, catId);
    }

    @Override
    public Observable<List<Category>> getCategory(String token) {
        return productAPI.getCategory(ConstantAPI.HEADER_AUTH_KEY + token);
    }

    @Override
    public Observable<Category> addCategory(String token, Category category) {
        int as_Sub;
        if(category.getParentId()>0){
            as_Sub = 1;
        } else
            as_Sub = 0;
        return productAPI.addCategory(ConstantAPI.HEADER_AUTH_KEY + token, category.getName(), as_Sub, category.getParentId());
    }

    @Override
    public Observable<Category> editCategory(long id, String token, String name, int add_as_sub_cat, long parent_id) {
        return productAPI.editCategory(id, ConstantAPI.HEADER_AUTH_KEY + token, name, add_as_sub_cat, parent_id);
    }

    @Override
    public Observable<Category> delCategory(long id, String token) {
        return productAPI.delCategory(id, ConstantAPI.HEADER_AUTH_KEY + token);
    }

    @Override
    public Observable<List<Brand>> getBrand(String token) {
        return productAPI.getBrand(ConstantAPI.HEADER_AUTH_KEY + token);
    }

    @Override
    public Observable<Brand> addBrand(String token, String name, String description) {
        return productAPI.addBrand(ConstantAPI.HEADER_AUTH_KEY + token, name, description);
    }

    @Override
    public Observable<Brand> editBrand(long id, String token, String name, String description) {
        return productAPI.editBrand(id, ConstantAPI.HEADER_AUTH_KEY + token, name, description);
    }

    @Override
    public Observable<Brand> delBrand(long id, String token) {
        return productAPI.delBrand(id, ConstantAPI.HEADER_AUTH_KEY + token);
    }

    @Override
    public Observable<List<Category>> getSubCategory(long id, String token) {
        return productAPI.getSubCategory(id, ConstantAPI.HEADER_AUTH_KEY + token);
    }

    @Override
    public Observable<Variation> setPrice(String token, Variation variation) {
        variation.setDefaultPurchasePrice(variation.getDefaultPurchasePrice());
        variation.setProfitPercent(variation.getProfitPercent());
        variation.setDefaultSellPrice(variation.getDefaultSellPrice());
        return productAPI.setPrice(ConstantAPI.HEADER_AUTH_KEY + token, variation);
    }
}

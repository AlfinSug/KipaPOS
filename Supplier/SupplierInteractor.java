package com.kipapos.library.data.interactor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kipapos.library.data.ISupplierInteractor;
import com.kipapos.library.data.NetworkModule;
import com.kipapos.library.data.api.ConstantAPI;
import com.kipapos.library.data.api.SupplierAPI;
import com.kipapos.library.data.api.deserializer.BooleanDeserializer;
import com.kipapos.library.data.api.deserializer.SupplierDeserializer;
import com.kipapos.library.model.Supplier;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class SupplierInteractor implements ISupplierInteractor {

    Retrofit retrofit;
    SupplierAPI supplierAPI;

    public SupplierInteractor() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Supplier.class, new SupplierDeserializer())
                .registerTypeAdapter(Boolean.class, new BooleanDeserializer())
                .create();

        retrofit = NetworkModule.createRetrofit(ConstantAPI.BASE_URL, gson);
        supplierAPI = retrofit.create(SupplierAPI.class);
    }


    @Override
    public Observable<List<Supplier>> getSuppliers(String token, int page) {
        return supplierAPI.getSuppliers(ConstantAPI.HEADER_AUTH_KEY + token, page);
    }

    @Override
    public Observable<Supplier> addSupplier(String token, String name, String mobile, String addition_information) {
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setMobile(mobile);
        supplier.setAdditionInfo(addition_information);
        supplier.setType("supplier");
        return supplierAPI.addSupplier(ConstantAPI.HEADER_AUTH_KEY + token, supplier);
    }

    @Override
    public Observable<Supplier> editSupplier(String token, Supplier supplier) {
        supplier.setName(supplier.getName());
        supplier.setMobile(supplier.getMobile());
        supplier.setAdditionInfo(supplier.getAdditionInfo());
        return supplierAPI.editSupplier(ConstantAPI.HEADER_AUTH_KEY + token, supplier.getId(), supplier);
    }

    @Override
    public Observable<Supplier> delSupplier(long id, String token) {
        return supplierAPI.delSupplier(id, ConstantAPI.HEADER_AUTH_KEY + token);
    }

}

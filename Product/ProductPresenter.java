package com.kipapos.app.product;

import com.kipapos.library.data.IProductInteractor;
import com.kipapos.library.data.ISessionInteractor;
import com.kipapos.library.model.Category;
import com.kipapos.library.model.product.Product;
import com.kipapos.library.presenter.IBasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProductPresenter implements IBasePresenter<IProductView> {
    IProductView view;
    IProductInteractor productInteractor;
    ISessionInteractor sessionInteractor;
    CompositeDisposable disposable;

    public ProductPresenter(IProductInteractor productInteractor, ISessionInteractor sessionInteractor) {
        this.productInteractor = productInteractor;
        this.sessionInteractor = sessionInteractor;
    }

    @Override
    public void onViewActive(IProductView view) {
        this.view = view;
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void onViewInActive() {
        disposable.clear();
        disposable.dispose();
        this.disposable = null;
        this.view = null;
    }

    public void getCategories() {
        this.view.showLoading("state");
        disposable.add(
                sessionInteractor.getCurrentUser()
                .flatMap(user -> productInteractor.getCategory(user.getToken()))
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(categories -> {
                    this.view.hideLoading("state");
                    this.view.onCategories(categories);
                }, throwable -> {
                    this.view.hideLoading("state");
                    this.view.onError(throwable);
                })
        );
    }

    public void getProducts(int page, boolean isNewData){
        this.view.showLoading(isNewData ? "refresh" : "state");
        disposable.add(
                sessionInteractor.getCurrentUser()
                        .flatMap(user -> productInteractor.getProduct(user.getToken(), page))
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(products -> {
                            this.view.hideLoading(isNewData ? "refresh" : "state");
                            this.view.onProducts(products);
                        }, throwable -> {
                            this.view.hideLoading(isNewData ? "refresh" : "state");
                            this.view.onError(throwable);
                        })
        );
    }

    public void deleteProduct(Product product){
        this.view.showLoading("alert");
        disposable.add(
                sessionInteractor.getCurrentUser()
                        .flatMap(user -> productInteractor.delProduct(product.getId(),user.getToken()))
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(products -> {
                            this.view.hideLoading("alert");
                            this.view.onDeleteProduct(product);
                        }, throwable -> {
                            this.view.hideLoading("alert");
                            this.view.onError(throwable);
                        })
        );
    }

    public void deleteCategory(Category item){
        this.view.showLoading("alert");
        disposable.add(
                sessionInteractor.getCurrentUser()
                        .flatMap(user -> productInteractor.delCategory(item.getId(),user.getToken()))
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(category -> {
                            this.view.hideLoading("alert");
                            this.view.onDeleteCategory(item);
                        }, throwable -> {
                            this.view.hideLoading("alert");
                            this.view.onError(throwable);
                        })
        );
    }
}

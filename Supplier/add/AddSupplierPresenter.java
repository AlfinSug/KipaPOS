package com.kipapos.app.supplier.add;

import com.kipapos.library.data.ISessionInteractor;
import com.kipapos.library.data.ISupplierInteractor;
import com.kipapos.library.data.interactor.SupplierInteractor;
import com.kipapos.library.data.local.LocalSessionInteractor;
import com.kipapos.library.model.Supplier;
import com.kipapos.library.presenter.IBasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AddSupplierPresenter implements IBasePresenter<IAddSupplierView> {
    IAddSupplierView view;
    ISupplierInteractor supplierInteractor;
    ISessionInteractor sessionInteractor;
    CompositeDisposable disposable;

    public AddSupplierPresenter(ISupplierInteractor supplierInteractor, ISessionInteractor sessionInteractor) {
        this.supplierInteractor = supplierInteractor;
        this.sessionInteractor = sessionInteractor;
    }

    @Override
    public void onViewActive(IAddSupplierView view) {
        this.view = view;
        disposable = new CompositeDisposable();
    }

    @Override
    public void onViewInActive() {
        disposable.clear();
        disposable.dispose();
        disposable = null;
        this.view = null;
    }

    public void addSuppliers(String name,String mobile, String addition_information) {

        this.view.showLoading("alert");
        disposable.add(
                sessionInteractor.getCurrentUser()
                        .flatMap(user -> supplierInteractor.addSupplier(user.getToken(), name, mobile, addition_information))
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(supplier -> {
                            this.view.hideLoading("alert");
                            this.view.onAddSupplier(supplier);
                        }, throwable -> {
                            this.view.hideLoading("alert");
                            this.view.onError(throwable);
                        })
        );
    }


}

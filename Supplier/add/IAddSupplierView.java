package com.kipapos.app.supplier.add;

import com.kipapos.library.model.Supplier;
import com.kipapos.library.presenter.IBaseView;

public interface IAddSupplierView extends IBaseView {

    void onAddSupplier(Supplier supplier);
}

package com.kipapos.app.supplier.add;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kipapos.app.BundleBuilder;
import com.kipapos.app.IActivity;
import com.kipapos.app.R;
import com.kipapos.app.util.ValidationHelper;
import com.kipapos.library.data.interactor.SupplierInteractor;
import com.kipapos.library.data.local.LocalSessionInteractor;
import com.kipapos.library.model.Supplier;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddSupplierActivity extends IActivity implements IAddSupplierView {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fullname_supp) EditText fullnameSupp;
    @BindView(R.id.no_telp_supp) EditText noTelpSupp;
    @BindView(R.id.btn_add_supplier) Button btnAddSupp;
    @BindView(R.id.info_tambahan) EditText infoTambahan;
    @BindView(R.id.error_name) TextView errorName;
    @BindView(R.id.error_mobile) TextView errorMobile;

    Unbinder unbinder;
    AddSupplierPresenter presenter;

    public static Intent newInstance(Context context) {
        Intent i = new Intent(context, AddSupplierActivity.class);
        return  i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplier);

        unbinder = ButterKnife.bind(this);
        presenter = new AddSupplierPresenter(new SupplierInteractor(), new LocalSessionInteractor(this));

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tambah Supplier");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnAddSupp.setOnClickListener(v -> {
            submitSupplier(fullnameSupp, noTelpSupp, infoTambahan);
        });

        fullnameSupp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (fullnameSupp.getText().length() < 3) {
                    btnAddSupp.setEnabled(false);
                    btnAddSupp.setBackground(getResources().getDrawable(R.drawable.bg_btn_disabled));
                    errorName.setVisibility(View.VISIBLE);
                    errorName.setText("Minimal 3 Karakter");
                    fullnameSupp.setBackground(getResources().getDrawable(R.drawable.bg_edittext_dialog_error));
                } else {
                    errorName.setVisibility(View.GONE);
                    fullnameSupp.setBackground(getResources().getDrawable(R.drawable.bg_edittext_dialog));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        noTelpSupp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (noTelpSupp.getText().length() < 10) {
                    btnAddSupp.setEnabled(false);
                    btnAddSupp.setBackground(getResources().getDrawable(R.drawable.bg_btn_disabled));
                    errorMobile.setVisibility(View.VISIBLE);
                    errorMobile.setText("Nomor Telepon tidak valid");
                    noTelpSupp.setBackground(getResources().getDrawable(R.drawable.bg_edittext_dialog_error));
                } else {
                    btnAddSupp.setEnabled(true);
                    btnAddSupp.setBackground(getResources().getDrawable(R.drawable.bg_btn_login));
                    errorMobile.setVisibility(View.GONE);
                    noTelpSupp.setBackground(getResources().getDrawable(R.drawable.bg_edittext_dialog));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onViewActive(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onViewInActive();
        super.onDestroy();
    }

    @Override
    public void showLoading(String type) {
        if (type.equalsIgnoreCase("alert")) {
            showLoadingDialog();
        } else if (type.equalsIgnoreCase("state")) {
            showLoadingState(null);
        }
    }

    @Override
    public void hideLoading(String type) {
        if (type.equalsIgnoreCase("alert")) {
            hideLoadingDialog();
        } else if (type.equalsIgnoreCase("state")) {
            showLoadingState(null);
        }
    }

    @Override
    public void onError(Throwable e) {

        showErrorDialog("Opps..", e.getMessage());
    }

    private void submitSupplier(EditText name, EditText mobile, EditText info){
        if (!ValidationHelper.validateEmpty(name, errorName, "Nama Supplier tidak boleh kosong")){
            name.setBackground(getResources().getDrawable(R.drawable.bg_edittext_dialog_error));
            return;
        } else {
            errorName.setVisibility(View.GONE);
            name.setBackground(getResources().getDrawable(R.drawable.bg_edittext_dialog));
        }
        if (!ValidationHelper.validateEmpty(mobile, errorMobile, "Nomor telepon tidak boleh kosong")){
            mobile.setBackground(getResources().getDrawable(R.drawable.bg_edittext_dialog_error));
            return;
        } else {
            errorMobile.setVisibility(View.GONE);
            mobile.setBackground(getResources().getDrawable(R.drawable.bg_edittext_dialog));
        }

        presenter.addSuppliers(name.getText().toString(), mobile.getText().toString(), info.getText().toString());
    }


    @Override
    public void onAddSupplier(Supplier supplier) {
        showSuccessDialog("","Supplier berhasil ditambahkan", sweetAlertDialog -> {
            sweetAlertDialog.dismissWithAnimation();
            Intent i = new Intent();
            BundleBuilder bundleBuilder = new BundleBuilder();
            bundleBuilder.setSupplier(supplier);
            i.putExtras(bundleBuilder.build());
            setResult(RESULT_OK, i);
            finish();
        });
    }


}

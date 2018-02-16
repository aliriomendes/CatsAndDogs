package com.aliriomendes.catsanddogs.di;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.aliriomendes.catsanddogs.util.ViewModelKey;
import com.aliriomendes.catsanddogs.viewmodel.CustomViewModelFactory;
import com.aliriomendes.catsanddogs.ui.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(CustomViewModelFactory viewModelFactory);
}

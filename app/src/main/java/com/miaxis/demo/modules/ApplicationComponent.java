package com.miaxis.demo.modules;

import com.miaxis.demo.ui.HomeActivity;
import com.miaxis.demo.ui.LoginActivity;
import com.miaxis.demo.ui.SearchActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

     void inject(HomeActivity homeActivity);
     void inject(SearchActivity searchActivity);
     void inject(LoginActivity loginActivity);
}

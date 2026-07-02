import { test as base, expect, } from '@playwright/test';
import {LoginPage} from '../Pages/loginPage';
import { RegisterPage } from '../Pages/registerPage';
import {HomePage} from '../Pages/homePage';
import { SearchPage } from '../Pages/searchResult';
import { ProductPage } from '../Pages/productPage';

type Fixtures={
    loginpage:LoginPage
    registerpage:RegisterPage
    homepage:HomePage
    searchpage:SearchPage
    productpage:ProductPage
}
export const test = base.extend<Fixtures>({
    loginpage:async({page},use)=>{
        await use(new LoginPage(page));
    },
    registerpage:async({page},use)=>{
        await use(new RegisterPage(page));
    },
    homepage:async({page},use)=>{
        await use(new HomePage(page));
    },
    searchpage:async({page},use)=>{
        await use(new SearchPage(page));
    },
    productpage:async({page},use)=>{
        await use(new ProductPage(page));
    },
    
});
export{expect};

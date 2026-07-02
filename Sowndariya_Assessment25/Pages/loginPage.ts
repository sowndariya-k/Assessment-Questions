import type {Page, Locator} from '@playwright/test';
import 'dotenv/config';
export class LoginPage{
    readonly page:Page;
    readonly email:Locator;
    readonly password:Locator;
    readonly loginbtn: Locator;
    readonly myaccount: Locator;
    readonly loginlink: Locator;
    readonly errorMessage: Locator;
    
    constructor (page: Page){
        this.page=page;
        this.myaccount=page.locator('span').filter({ hasText: 'My Account' });
        this.loginlink=page.getByRole('link', { name: 'Login' });
        this.email=page.getByRole('textbox', { name: 'E-Mail Address' });
        this.password=page.getByRole('textbox', { name: 'Password' });
        this.loginbtn=page.locator('input.btn.btn-primary');
        this.errorMessage=page.getByText('Warning: No match for E-Mail Address and/or Password.', { exact: true })
    }

    async navigate(){
        await this.page.goto(process.env.BASE_URL!);
        {
            waituntil:`domcontentloaded`
        }
    }

    async login(email:string, password:string){
        await this.myaccount.click();
        await this.loginlink.click();
        await this.email.fill(email);
        await this.password.fill(password);
        await this.loginbtn.click();
    }
}
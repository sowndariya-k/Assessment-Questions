import type {Page, Locator} from '@playwright/test';
export class RegisterPage{
    readonly page: Page;
    readonly myaccount: Locator;
    readonly register: Locator;
    readonly firstname: Locator;
    readonly lastname: Locator;
    readonly email: Locator;
    readonly phone: Locator;
    readonly password: Locator;
    readonly confirmpass: Locator;
    readonly policy: Locator;
    readonly continue:Locator;
    readonly createaccount:Locator;

    constructor(page:Page){
        this.page=page;
        this.myaccount=page.locator('span').filter({ hasText: 'My Account' });
        this.register=page.getByRole('link', { name: 'Register' });
        this.firstname=page.getByRole('textbox', { name: 'First Name' });
        this.lastname=page.getByRole('textbox', { name: 'Last Name' });
        this.email=page.getByRole('textbox', { name: 'E-Mail' });
        this.phone=page.getByRole('textbox', { name: 'Telephone' });
        this.password=page.locator('#input-password');
        this.confirmpass=page.locator('#input-confirm');
        this.policy=page.locator('[name="agree"]');
        this.continue=page.locator('input.btn.btn-primary');
        this.createaccount=page.getByRole('heading', { name: 'Your Account Has Been Created!' });
    }

    async navigate(){
        await this.page.goto(process.env.BASE_URL!);
        {
            waitUntil:`domcontentloaded`
        }
    }

    async registerdetail(
        firstname:string,
        lastname:string,
        phone:string,
        email:string,
        password:string,
        confirmpass:string
    ){
        await this.myaccount.click();
        await this.register.click();
        await this.firstname.fill(firstname);
        await this.lastname.fill(lastname);
        await this.phone.fill(phone);
        await this.email.fill(email);
        await this.password.fill(password);
        await this.confirmpass.fill(confirmpass);
        await this.policy.check();
        await this.continue.click();
    }


}
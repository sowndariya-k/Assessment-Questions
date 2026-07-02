import {test, expect} from '../Fixtures/baseFixture'
import loginData from '../Test-data/loginData.json';

test.describe('Login test', ()=>{
    test.beforeEach(async({loginpage}) =>{
        await loginpage.navigate();
    });

    test('Valid login @regression',async({loginpage,homepage}) =>{
        await loginpage.login(
            loginData.validUser.email,
            loginData.validUser.password
        )
        await expect(homepage.account).toHaveText('My Account');
    });
    test('InValid email login @regression',async({loginpage}) =>{
        await loginpage.login(
            loginData.InvalidUser.email,
            loginData.InvalidUser.password
        )
        await expect(loginpage.errorMessage).toHaveText('Warning: No match for E-Mail Address and/or Password.');
    });
    test('InValid password login @regression',async({loginpage}) =>{
        await loginpage.login(
            loginData.InvalidUser.email,
            loginData.InvalidUser.password
        )
        await expect(loginpage.errorMessage).toHaveText('Warning: No match for E-Mail Address and/or Password.');
    });

    
});
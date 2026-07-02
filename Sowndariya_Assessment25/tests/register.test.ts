import { test, expect } from "../Fixtures/baseFixture";
import register from "../Test-data/registerData.json";
test.describe('Register test', ()=>{
test.beforeEach(async ({ registerpage }) => {
    await registerpage.navigate();
});
test("Register new user @smoke", async ({ registerpage }) => {
    const email = `sowndariya${Date.now()}@gmail.com`;
    await registerpage.registerdetail(
        register.registerdata.firstname,
        register.registerdata.lastname,
        register.registerdata.phone,
        email,
        register.registerdata.password,
        register.registerdata.confirmpass
    );
    await expect(registerpage.createaccount).toHaveText("Your Account Has Been Created!");

});
});
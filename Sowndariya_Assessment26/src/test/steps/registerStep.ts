import { Given, When, Then } from "@cucumber/cucumber";
import { CustomWorld } from "../../main/world/CustomWorld";
import { getRegisterUser } from "../../main/utils/CsvReader";

Given("the user is on the DemoWebShop website",async function (this: CustomWorld) {
    await this.registerPage.navigate();
  });

Given("the user is on the Register page",async function (this: CustomWorld) {
    await this.registerPage.clickRegisterLink();
  });

When("user enters registration details from {string}",
  async function (this: CustomWorld, type: string) {
    const data=getRegisterUser(type);
    let email=data.email;
    if (email==="dynamic") {
      email=`sownd${Date.now()}@gmail.com`;
    }

    await this.registerPage.register(
      data.firstname,
      data.lastname,
      email,
      data.password,
      data.confirmpassword
    );
  }
);

When ("the user clicks register button",async function (this:CustomWorld){
    await this.registerPage.clickRegister();
});

Then("user should see Your registration completed message",async function (this: CustomWorld) {
    await this.registerPage.verifySuccessMessage("Your registration completed");
  });

Then("user should see error message",async function (this: CustomWorld) {
    await this.registerPage.verifyError("The specified email already exists");
  });

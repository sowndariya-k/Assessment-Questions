import { firefox, test, expect } from "@playwright/test";

test("Bing test",async()=>{
    const browser=await firefox.launch({
        headless:false
    });
    const page = await browser.newPage();
    await page.goto("https://www.bing.com/");
    console.log("Page Title: ",await page.title());
    console.log("Current PageUrl: ",page.url());
    await expect(page).toHaveTitle(/Bing/);
    await expect(page).toHaveURL("https://www.bing.com/");
    const text=await page.locator(':text-is("Copilot")').innerText();
    console.log("Inner Text:",text);
    const placeholder=await page.locator('#sb_form_q').getAttribute("placeholder");
    console.log("Place holder:", placeholder);

    await page.locator("#sb_form_q").fill("playwright");
    await page.keyboard.press("Enter");
    await page.locator("//li[@class='b_algo']//h2/a").first().click();
    await expect(page).toHaveTitle(/Playwright/i);
    await browser.close();
});

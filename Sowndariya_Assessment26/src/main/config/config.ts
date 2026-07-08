import dotenv from "dotenv";

const environment=process.env.ENV||"qa";
dotenv.config({
    path: `src/resources/env/.env.${environment}`
});

export const config = {
  baseUrl: process.env.BASE_URL || "https://demowebshop.tricentis.com/",
  browser: process.env.BROWSER || "chromium",
  headless: process.env.HEADLESS === "true",
  timeout: Number(process.env.TIMEOUT) || 30000
};


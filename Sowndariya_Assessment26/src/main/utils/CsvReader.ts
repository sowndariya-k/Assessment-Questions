import fs from "fs";
import path from "path";
import { parse } from "csv-parse/sync";


export interface RegisterUser {
  type: string;
  firstname:string;
  lastname:string;
  email:string;
  password:string;
  confirmpassword:string;
}

export function readCSVData<Test>(fileName: string): Test[] {
  const filePath=path.resolve(__dirname, "../test_data", fileName);
  const fileContent=fs.readFileSync(filePath, "utf-8");
  return parse(fileContent, {
    columns:true,
    skip_empty_lines:true,
    trim:true
  }) as Test[];
}

export function getRegisterUser(type: string): RegisterUser {
  const users = readCSVData<RegisterUser>("registerData.csv");

  const user = users.find(u => u.type === type);

  if (!user) {
    throw new Error(`No data found for type: ${type}`);
  }

  return user;
}

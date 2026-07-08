import fs from 'fs';
import path from 'path';
import {parse} from 'csv-parse/sync';

export interface LoginUser{
    email:string;
    password:string;
    expected:string;
    errorMessage:string;
}
export interface RegisterUser{
    gender:string;
    firstname:string;
    lastname:string;
    email:string;
    password:string;
    confirmpass:string;
}

export function readCSVData<Test>(fileName: string):Test[] {
  const filePath=path.resolve(__dirname, "../test_data", fileName);
  const fileContent=fs.readFileSync(filePath, "utf-8");
  return parse(fileContent, {
    columns:true,
    skip_empty_lines:true,
    trim:true,
  }) as Test[];
}
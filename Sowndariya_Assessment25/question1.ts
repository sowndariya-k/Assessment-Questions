import promptSync from 'prompt-sync';

const prompt=promptSync();
const num1=Number(prompt("Enter number1: "));
const num2=Number(prompt("Enter number2: "));
if (
    Number.isNaN(num1)||Number.isNaN(num2)||!Number.isInteger(num1)||!Number.isInteger(num2)) {
    console.log("Error:Invalid inputs");
}else{
const add=num1+num2
const sub=num1-num2
const mul=num1*num2
if(num2==0){
    console.log("cannot be divide zero");
}else{
const div=num1/num2
console.log("Add two number:",add);
console.log("Sub two number:",sub);
console.log("Multiple two number:",mul);
console.log("Divide two number:",div);
}
}
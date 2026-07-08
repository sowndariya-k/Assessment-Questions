import promptSync from 'prompt-sync';

const prompt = promptSync();
function reverse(num:number):number{
    let rev=0;
    while(num>0) {
        const digit=num%10;
        rev=rev*10+digit;
        num=Math.floor(num/10);
    }
    return rev;
}
const input=Number(prompt("Enter five digit number: "));
if (Number.isInteger(input) && input>=10000 && input<=99999) {
    const result=reverse(input);
    console.log("Reverse Number:", result);
}
else{
    console.log("enter valid five digit number");
}
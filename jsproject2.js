var string="This is a test."
//alert(string);
console.log("hello".length);
console.log("hello".charAt(0));
console.log("hello world".replace("hello","goodbye"));
console.log("hello world".toUpperCase());
var b=true;
var c=6;
c+=6;
for(let i=0;i<c;i++)
{
    console.log(c);
}
// console.log(1>=2)
// console.log(true && false)
// console.log(123=="123")
// console.log(123==="123")
// if(false){
//     console.log("WHAT>");
// }
// else if (true) {
//     console.log("YES");
// } else {
//     console.log("NO");
// }
while (c<13) {
    console.log(string);
    c++;
}
do{
    var a=6;
    console.log(++a);
    c--;
}while(c>=11);
var allow=(c>=11?"Y":"N");
console.log(allow)
switch (a) {
    case 6:
        console.log(allow);
        break;
    case 9:
        console.log("N");
    case 10:
        console.log("N");
    default:
        console.log(string);
        break;
}
var obj=new Object();
// ~=
var obj2={};
obj={
    name:"lyboos",
    age:21,
    truth:false,
    email:"454354@qq.com",
};
console.log(obj["name"]);
var a=new Array();
var arr=[];
a[0]=1
a[5]=34
console.log(a.length)
for (let index = 0; index < c; index++) {
    arr[index]=index;
}
arr.shift();
console.log(arr);
arr.push(99);
console.log(arr);
arr.pop();
console.log(arr);

function add()
{
    let num=0;
    for (let i = 0,j=arguments.length; i <j; i++) {
       num+=arguments[i];    
    }
    return num;
}

console.log(add(1,2,3,4,5,5,7));

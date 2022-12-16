; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%a = alloca i32
%tmp1 = mul i32 10, 2
store i32 %tmp1, i32* %a
br label %while3
while3: 
%tmp2 = load i32, i32* %a
%tmp3 = sub i32 %tmp2, 1
%tmp6 = icmp ne i32 %tmp3 ,0
br i1 %tmp6, label %do1, label %done2
do1: 
%tmp4 = load i32, i32* %a
%tmp5 = sub i32 %tmp4, 1
store i32 %tmp5, i32* %a
br label %while3
done2: 
}


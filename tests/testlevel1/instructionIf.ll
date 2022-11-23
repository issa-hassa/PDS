; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%a = alloca i32
store i32 3, i32* %a
%tmp2 = icmp ne i32 %tmp1 , 0
br i1 %tmp2, label %then1, label %else3
then1: 
%tmp3 = load i32, i32* %a
%tmp4 = add i32 2, %tmp3
store i32 %tmp4, i32* %a
br label %fi2
else3: 
%tmp5 = load i32, i32* %a
%tmp6 = add i32 3, %tmp5
store i32 %tmp6, i32* %a
br label %fi2
fi2: 
}


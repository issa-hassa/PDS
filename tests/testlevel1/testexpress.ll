; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = udiv i32 10, 2
%tmp2 = mul i32 10, 5
%tmp3 = sub i32 %tmp2, 1
%tmp4 = add i32 %tmp1, %tmp3
%tmp5 = sub i32 %tmp4, 4
%tmp6 = add i32 1, %tmp5
%tmp7 = add i32 1, %tmp6
%tmp8 = sub i32 %tmp7, 50
ret i32 %tmp8
}


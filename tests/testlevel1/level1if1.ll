; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ... )

; Actual code begins



define i32 @main(  ) {  
%tmp1 = icmp ne i32 1 , 0
br i1 %tmp1, label %then1, label %fi2
then1: 
ret i32  1
br label %fi2
fi2: 
ret i32 0
}


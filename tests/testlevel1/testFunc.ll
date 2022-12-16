; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ... )

; Actual code begins

@.fmt1 = global [19 x i8 ] c"Fact de 5 vaut :%d\00" 
define i32 @fact( i32 %n ) {  
%n1 = alloca i32
%tmp2 = load i32, i32* %n
store i32 %tmp2, i32* %n1
%tmp4 = load i32, i32* %n1
%tmp5 = icmp ne i32 %tmp4 , 0
br i1 %tmp5, label %then2, label %else4
then2: 
%tmp6 = load i32, i32* %n1
%tmp7 = load i32, i32* %fact
%tmp8 = mul i32 %tmp6, %tmp7
ret i32  %tmp8
%tmp9 = load i32, i32* %n1
%tmp10 = sub i32 %tmp9, 1
br label %fi3
else4: 
ret i32  1
br label %fi3
fi3: 
ret i32  0
}


define void @main(  ) {  
%tmp1 = load i32, i32* %fact
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([19 x i8] , [19 x i8]* @.fmt1, i64 0, i64 0), i32 %tmp1)
ret void
}


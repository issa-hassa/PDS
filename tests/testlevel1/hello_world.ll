; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ... )

; Actual code begins

@.fmt1 = global [3 x i8 ] c"%d\00" 
@.fmt2 = global [28 x i8 ] c"Input %d between 0 and 11:\0A\00" 


define i32 @main(  ) {  
%n = alloca i32
store i32 5, i32* %n
call i32 (i8*, ...) @scanf (i8* getelementptr inbounds([3 x i8] , [3 x i8]* @.fmt1, i64 0, i64 0), i32 * %n)
%tmp1 = load i32, i32* %n
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([28 x i8] , [28 x i8]* @.fmt2, i64 0, i64 0), i32 %tmp1)
ret i32 0
}


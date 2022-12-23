; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ... )

; Actual code begins

@.fmt7 = global [19 x i8 ] c"Et voila: %d%d%d%d\00" 


define void @main(  ) {  
%i = alloca i32
%j = alloca i32
%k = alloca i32
%l = alloca i32
store i32 0, i32* %i
store i32 0, i32* %j
store i32 0, i32* %k
store i32 0, i32* %l
%i1 = alloca i32
%j2 = alloca i32
%k3 = alloca i32
store i32 1, i32* %l
%i14 = alloca i32
%j25 = alloca i32
store i32 2, i32* %k3
%i146 = alloca i32
store i32 3, i32* %j25
%tmp1 = load i32, i32* %i
%tmp2 = load i32, i32* %j
%tmp3 = load i32, i32* %k
%tmp4 = load i32, i32* %l
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([19 x i8] , [19 x i8]* @.fmt7, i64 0, i64 0), i32 %tmp1, i32 %tmp2, i32 %tmp3, i32 %tmp4)
ret void 
}


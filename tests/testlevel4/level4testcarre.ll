; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ... )

; Actual code begins

@.fmt1 = global [2 x i8 ] c"\0A\00" 
@.fmt2 = global [8 x i8 ] c"%d^2 + \00" 
@.fmt3 = global [10 x i8 ] c"1^2 = %d\0A\00" 


define void @main(  ) {  
%n = alloca i32
%i = alloca i32
%s = alloca i32
store i32 5, i32* %n
store i32 0, i32* %s
%tmp1 = load i32, i32* %n
store i32 %tmp1, i32* %i
br label %while3
while3: 
%tmp2 = load i32, i32* %i
%tmp17 = icmp ne i32 %tmp2 ,0
br i1 %tmp17, label %do1, label %done2
do1: 
%tmp3 = load i32, i32* %i
%tmp4 = load i32, i32* %i
%tmp5 = mul i32 %tmp3, %tmp4
%tmp6 = load i32, i32* %s
%tmp7 = add i32 %tmp5, %tmp6
store i32 %tmp7, i32* %s
%tmp8 = load i32, i32* %i
%tmp9 = sub i32 %tmp8, 1
store i32 %tmp9, i32* %i
br label %while3
done2: 
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([2 x i8] , [2 x i8]* @.fmt1, i64 0, i64 0))
%tmp10 = load i32, i32* %n
store i32 %tmp10, i32* %i
br label %while6
while6: 
%tmp11 = load i32, i32* %i
%tmp12 = sub i32 %tmp11, 1
%tmp18 = icmp ne i32 %tmp12 ,0
br i1 %tmp18, label %do4, label %done5
do4: 
%tmp13 = load i32, i32* %i
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([8 x i8] , [8 x i8]* @.fmt2, i64 0, i64 0), i32 %tmp13)
%tmp14 = load i32, i32* %i
%tmp15 = sub i32 %tmp14, 1
store i32 %tmp15, i32* %i
br label %while6
done5: 
%tmp16 = load i32, i32* %s
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([10 x i8] , [10 x i8]* @.fmt3, i64 0, i64 0), i32 %tmp16)
ret void
}


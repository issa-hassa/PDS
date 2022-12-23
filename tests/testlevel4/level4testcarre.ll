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
%tmp3 = load i32, i32* %i
%tmp28 = icmp ne i32 %tmp3 ,0
br i1 %tmp28, label %do1, label %done2
do1: 
%tmp4 = load i32, i32* %i
%tmp5 = load i32, i32* %i
%tmp6 = mul i32 %tmp4, %tmp5
%tmp7 = load i32, i32* %s
%tmp8 = add i32 %tmp6, %tmp7
store i32 %tmp8, i32* %s
%tmp14 = load i32, i32* %i
%tmp15 = sub i32 %tmp14, 1
store i32 %tmp15, i32* %i
br label %while3
done2: 
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([2 x i8] , [2 x i8]* @.fmt1, i64 0, i64 0))
%tmp18 = load i32, i32* %n
store i32 %tmp18, i32* %i
br label %while6
while6: 
%tmp20 = load i32, i32* %i
%tmp21 = sub i32 %tmp20, 1
%tmp29 = icmp ne i32 %tmp21 ,0
br i1 %tmp29, label %do4, label %done5
do4: 
%tmp22 = load i32, i32* %i
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([8 x i8] , [8 x i8]* @.fmt2, i64 0, i64 0), i32 %tmp22)
%tmp23 = load i32, i32* %i
%tmp24 = sub i32 %tmp23, 1
store i32 %tmp24, i32* %i
br label %while6
done5: 
%tmp27 = load i32, i32* %s
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([10 x i8] , [10 x i8]* @.fmt3, i64 0, i64 0), i32 %tmp27)
ret void 
}


; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ... )

; Actual code begins

@.fmt1 = global [12 x i8 ] c"%d+%d = %d\0A\00" 
@.fmt2 = global [12 x i8 ] c"%d-%d = %d\0A\00" 
@.fmt3 = global [12 x i8 ] c"%d*%d = %d\0A\00" 
@.fmt4 = global [12 x i8 ] c"%d/%d = %d\0A\00" 
@.fmt5 = global [12 x i8 ] c"%d+%d = %d\0A\00" 
@.fmt6 = global [18 x i8 ] c"%d* (%d+%d) = %d\0A\00" 
@.fmt7 = global [18 x i8 ] c"%d*  %d+%d  = %d\0A\00" 


define void @main(  ) {  
call void @expr(i32 1,i32 3)
call void @expr(i32 5,i32 2)
ret void
}
define void @expr( i32 %x,i32 %y ) {  
%x1 = alloca i32
%tmp3 = load i32, i32* %x
store i32 %tmp3, i32* %x1
%y2 = alloca i32
%tmp5 = load i32, i32* %y
store i32 %tmp5, i32* %y2
%tmp7 = load i32, i32* %x1
%tmp8 = load i32, i32* %y2
%tmp9 = load i32, i32* %y2
%tmp10 = load i32, i32* %x1
%tmp11 = add i32 %tmp9, %tmp10
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([12 x i8] , [12 x i8]* @.fmt1, i64 0, i64 0), i32 %tmp7, i32 %tmp8, i32 %tmp11)
%tmp12 = load i32, i32* %x1
%tmp13 = load i32, i32* %y2
%tmp14 = load i32, i32* %x1
%tmp15 = load i32, i32* %y2
%tmp16 = sub i32 %tmp14, %tmp15
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([12 x i8] , [12 x i8]* @.fmt2, i64 0, i64 0), i32 %tmp12, i32 %tmp13, i32 %tmp16)
%tmp17 = load i32, i32* %x1
%tmp18 = load i32, i32* %y2
%tmp19 = load i32, i32* %x1
%tmp20 = load i32, i32* %y2
%tmp21 = mul i32 %tmp19, %tmp20
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([12 x i8] , [12 x i8]* @.fmt3, i64 0, i64 0), i32 %tmp17, i32 %tmp18, i32 %tmp21)
%tmp22 = load i32, i32* %x1
%tmp23 = load i32, i32* %y2
%tmp24 = load i32, i32* %x1
%tmp25 = load i32, i32* %y2
%tmp26 = udiv i32 %tmp24, %tmp25
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([12 x i8] , [12 x i8]* @.fmt4, i64 0, i64 0), i32 %tmp22, i32 %tmp23, i32 %tmp26)
%tmp27 = load i32, i32* %x1
%tmp28 = load i32, i32* %x1
%tmp29 = add i32 1, %tmp28
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([12 x i8] , [12 x i8]* @.fmt5, i64 0, i64 0), i32 %tmp27, i32 1, i32 %tmp29)
%tmp30 = load i32, i32* %x1
%tmp31 = load i32, i32* %x1
%tmp32 = load i32, i32* %y2
%tmp33 = load i32, i32* %x1
%tmp34 = load i32, i32* %y2
%tmp35 = load i32, i32* %x1
%tmp36 = add i32 %tmp34, %tmp35
%tmp37 = mul i32 %tmp33, %tmp36
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([18 x i8] , [18 x i8]* @.fmt6, i64 0, i64 0), i32 %tmp30, i32 %tmp31, i32 %tmp32, i32 %tmp37)
%tmp38 = load i32, i32* %x1
%tmp39 = load i32, i32* %x1
%tmp40 = load i32, i32* %y2
%tmp41 = load i32, i32* %y2
%tmp42 = load i32, i32* %x1
%tmp43 = load i32, i32* %x1
%tmp44 = mul i32 %tmp42, %tmp43
%tmp45 = add i32 %tmp41, %tmp44
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([18 x i8] , [18 x i8]* @.fmt7, i64 0, i64 0), i32 %tmp38, i32 %tmp39, i32 %tmp40, i32 %tmp45)
ret void
}


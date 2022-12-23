; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ... )

; Actual code begins

@.fmt5 = global [26 x i8 ] c"\0A Hanoi avec %d disques\0A\0A\00" 
@.fmt6 = global [26 x i8 ] c"\0A\0AHanoi avec %d disques\0A\0A\00" 
@.fmt7 = global [24 x i8 ] c"Deplacer un disque de \0A\00" 
@.fmt8 = global [31 x i8 ] c"Deplacer un disque de %d a %d\0A\00" 


define i32 @hanoi( i32 %n,i32 %delatour,i32 %alatour,i32 %parlatour ) {  
%n1 = alloca i32
store i32 %n, i32* %n1
%delatour2 = alloca i32
store i32 %delatour, i32* %delatour2
%alatour3 = alloca i32
store i32 %alatour, i32* %alatour3
%parlatour4 = alloca i32
store i32 %parlatour, i32* %parlatour4
%b = alloca i32
%tmp11 = load i32, i32* %n1
%tmp12 = icmp ne i32 %tmp11 , 0
br i1 %tmp12, label %then5, label %fi6
then5: 
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([24 x i8] , [24 x i8]* @.fmt7, i64 0, i64 0))
%tmp13 = load i32, i32* %n1
%tmp14 = sub i32 %tmp13, 1
%tmp15 = load i32, i32* %delatour2
%tmp16 = load i32, i32* %parlatour4
%tmp17 = load i32, i32* %alatour3
%tmp18 = call i32 @hanoi(i32 %tmp14,i32 %tmp15,i32 %tmp16,i32 %tmp17)
store i32 %tmp18, i32* %b
%tmp25 = load i32, i32* %delatour2
%tmp26 = load i32, i32* %alatour3
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([31 x i8] , [31 x i8]* @.fmt8, i64 0, i64 0), i32 %tmp25, i32 %tmp26)
%tmp27 = load i32, i32* %n1
%tmp28 = sub i32 %tmp27, 1
%tmp29 = load i32, i32* %parlatour4
%tmp30 = load i32, i32* %alatour3
%tmp31 = load i32, i32* %delatour2
%tmp32 = call i32 @hanoi(i32 %tmp28,i32 %tmp29,i32 %tmp30,i32 %tmp31)
store i32 %tmp32, i32* %b
br label %fi6
fi6: 
ret i32  1
}


define void @main(  ) {  
%ndisque = alloca i32
%a = alloca i32
store i32 3, i32* %ndisque
%tmp1 = load i32, i32* %ndisque
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([26 x i8] , [26 x i8]* @.fmt5, i64 0, i64 0), i32 %tmp1)
%tmp2 = load i32, i32* %ndisque
%tmp3 = call i32 @hanoi(i32 %tmp2,i32 1,i32 3,i32 2)
store i32 %tmp3, i32* %a
store i32 4, i32* %ndisque
%tmp6 = load i32, i32* %ndisque
call i32 (i8*, ...) @printf (i8* getelementptr inbounds([26 x i8] , [26 x i8]* @.fmt6, i64 0, i64 0), i32 %tmp6)
%tmp7 = load i32, i32* %ndisque
%tmp8 = call i32 @hanoi(i32 %tmp7,i32 1,i32 3,i32 2)
store i32 %tmp8, i32* %a
ret void 
}


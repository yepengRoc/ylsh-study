### 命令学习
- 查看linux版本  
cat /etc/redhat-release
- 查看系统  
uname -r
- getenforce  

- 查看防火墙状态
systemctl status firewalld.service
- 查看系统命令解释器  
cat /etc/shells linux常用的是bash(Bourne Again shell)
- 查看当前环境使用的shell  
cat $SHELL
- 查看bash 版本  
bash -version
- bash 破壳漏洞  
使用 命令 env x='() { :;}; echo be careful' bash -c "echo this is a test"  
如果返回结果为一行，则为正常，  
 [root@clsn ~]# env x='() { :;}; echo be careful' bash -c "echo this is a test"
 this is a test  
 解决办法 升级当前的bash版本  
 yum install update bash  
 
 
 - 查看目录下所有文件的第一行  
 head -1 /etc/init.d/*
 
 ### 注意事项
 
 在单引号中 通$去引用一个变量是不起作用的  
 name2='$name1'  不生效  
 name12="$name1" 生效

 普通变量的要求
---
1. 内容是纯数字、简单的连续字符（内容中不带任何空格）时，定义时可以不加任何引号，例如：  
a.ClsnAge=22  
b.NETWORKING=yes

2. 没有特殊情况时，字符串一律用双引号定义赋值，特别是多个字符串中间有空格时，例如：  
a.NFSD_MODULE="no load"  
b.MyName="Oldboy is a handsome boy."  
3 当变量里的内容需要原样输出时，要用单引号（M），这样的需求极少，例如：  
a.OLDBOY_NAME='OLDBOY'

- ``反引号有执行的意思  
time=`date`
- 使用${}  
```
如果$time_day 则输出$time_day ${time}_day 则输出当前时间_day  
希望变量的内容是命令的解析结果时，要用反引号''，或者用$()把命令括起来再赋值。 
```

###特殊变量

- 位置变量

表格：


|变量 |  变量说明|  
|变量| 变量说明|  
  |------|-----|  
  变量  /  变量说明
  
| 变量        | 变量说明         |
| ------------- |:-------------:|
| $0    | 获取当前执行的shell脚本的文件名，如果执行脚本带路径那么就包括脚本路径。|
| $n    | 获取当前执行的shell脚本的第n个参数值，n=1..9，当n为0时表示脚本的文件名，如果n大于9用大括号括起来{10}，参数以空格隔开。|
|$#     |获取当前执行的shell脚本后面接的参数的总个数| 
|$*     |获取当前shell的所有传参的参数，不加引号同$@;如果给$*加上双引号，例如: “$*”,则表示将所有的参数视为单个字符串，相当于“112$3”。|
|$@     |获取当前shell的所有传参的参数，不加引号同$*;如果给$@加上双引号，例如: “$@”,则表示将所有参数视为不同的独立字符串，相当于“$1” “$2” “$3” “……”，这是将参数传递给其他程序的最佳方式，因为他会保留所有内嵌在每个参数里的任何空白。当“$*”和“$@”都加双引号时，两者有区别，都不加双引号时，两者无区别。|
```
$0
获取当前执行的shell脚本的文件名，如果执行脚本带路径那么就包括脚本路径。
$n
获取当前执行的shell脚本的第n个参数值，n=1..9，当n为0时表示脚本的文件名，如果n大于9用大括号括起来{10}，参数以空格隔开。
$#
获取当前执行的shell脚本后面接的参数的总个数
$*
获取当前shell的所有传参的参数，不加引号同$@;如果给$*加上双引号，例如: “$*”,则表示将所有的参数视为单个字符串，相当于“112$3”。
$@
获取当前shell的所有传参的参数，不加引号同$*;如果给$@加上双引号，例如: “$@”,则表示将所有参数视为不同的独立字符串，相当于“$1” “$2” “$3” “……”，这是将参数传递给其他程序的最佳方式，因为他会保留所有内嵌在每个参数里的任何空白。
当“$*”和“$@”都加双引号时，两者有区别，都不加双引号时，两者无区别。
```
set "i am"

```$xslt
$?
获取执行上一个指令的执行状态返回值（0为成功，非零为失败)，这个变量最常用
$$
获取当前执行的Shell脚本的进程号（PID)，这个变量不常用，了解即可
$!
获取上一个在后台工作的进程的进程号（PID)，这个变量不常用，了解即可
$_
获取在此之前执行的命令或脚本的最后一个参数，这个变量不常用，了解即可
```

#### echo使用说明
```$xslt
-n
不要追加换行
-e
启用下列反斜杠转义的解释
-E
显式地抑制对于反斜杠转义的解释
```

echo 对下列反斜杠字符进行转义：  
```
\n      换行
\r      回车
\t      横向制表符
\b      退格
\v      纵向制表符
\c      抑制更多的输出
```

### 定义变量的方式
- 直接赋值
- 传参
- 交互式赋值，使用read 命令  
read 回车，然后进入命令行输入模式，输入参数后回车  
通过$REPLY 获取read 读取的数据  

- bash: read: --: 无效选项
read用法:read [-ers] [-a 数组] [-d 分隔符] [-i 缓冲区文字] [-n 读取字符数] [-N 读取字符数] [-p 提示符] [-t 超时] [-u 文件描述符] [-s不显示终端的任何输入] [名称 ...]

###变量的子串
```$xslt
${parameter}    返回变量$parameter的内容
${#parameter}   返回变量内容的长度（按字符)，也适用于特殊变量
${parameterioffset} 在变量${parameter}中，从位置offset之后开始提取子串到结尾
${parameter:offset:length}  在变量${parameter}中，从位置offset之后开始提取长度为length的子串
${parameter#word}   从变量${parameter}开头开始删除最短匹配的word子串
${parameter##word}  从变量${parameter}开头开始删除最长匹配的word子串
${parameter%word}   从变量${parameter}结尾开始删除最短匹配的word子串
${parameter%%word}  从变量${parameter}结尾开始删除最长匹配的word子串
${parameter/pattem/string}  使用string代替第一个匹配的pattern
${parameter//pattem/string} 使用string代替所有匹配的pattern
```
```$xslt
[jenkins@dmsorder-ws study]$ clsn=htt://blog.znix.top
[jenkins@dmsorder-ws study]$ echo $clsn
htt://blog.znix.top
[jenkins@dmsorder-ws study]$ echo ${clsn} |wc -L
19
[jenkins@dmsorder-ws study]$ echo ${#clsn}
19
性能对比
[jenkins@dmsorder-ws study]$ time echo ${clsn}|wc -L
19

real    0m0.001s
user    0m0.000s
sys     0m0.001s
有执行时间
[jenkins@dmsorder-ws study]$ time echo ${#clsn}
19

real    0m0.000s
user    0m0.000s
sys     0m0.000s
没有执行时间
```
```$xslt
clsn=abcABC123ABCabc
支持正则-不确定所有的正则都支持
${clsn#a*C}
```

使用总结
```$xslt
#表示从幵头删除匹配最短。
##表示从开头删除匹配最长。
%表示从结尾删除匹配最短。
%%表示从结尾删除匹配最长。
a*c表示匹配的突符串，*表示匹配所有，a*c匹配开头为a、中间为任意多个字符、结尾为c的字符串。
a*C表示匹配的字符串，*表示匹配所有，a*C匹配开头为a、中间为任意多个字符、结尾为C的字符串。
有关替换的小结
一个“/”表示替换匹配的第-个字符串。
两个“/”表示替换匹配的所有字符串
```
####Shell的特殊扩展变量说明
```$xslt
${parameter:-word}
如果parameter的变量值为空或未赋值，则会返回word字符串并替代变量的值用途.如果变量未定义，则返回备用的值，防止变量为空值或因未定义而导致异常
${parameter:=word}
如果parameter的变量值为空或未赋值，则设置这个变量值为word,并返回其值。位置变量和特殊变量不适用用途：基本同上一个${parameter>word}，但该变量又额外给parameter变量赋值了
${parameter:?word}
如果parameter变量值为空或未赋值，那么word字符串将被作为标准错误输出，否则输出变量的值。用途：用于捕捉由于变量未定义而导致的错误，并退出程序
${parameter:+word}
如果parameter变量值为空或未赋值，则什么都不做，否则word字符串将替代变量的值
```

###变量的数值运算
####仅支持数值运算
- echo $((数学运算表达式))
```$xslt
# 形式一
[root@clsn scripts]# echo $((1 + 1))
2
[root@clsn scripts]# echo $((2*7-3/6+5))
19
# 形式二
[root@clsn scripts]# ((clsn=2*8))
[root@clsn scripts]# echo $clsn
16
# 形式三
[root@clsn scripts]# znix=$((2*7-3/6+5))
[root@clsn scripts]# echo $znix
19
```

###let命令
let i=2
echo $i

###expr
```$xslt
1.整数计算
2.判断扩展名
3.判断输入是否为整数，非整数返回值为2
4.计算变量的长度
计算数字和运算符之间要有空格
[root@clsn scripts]# expr 1+1
1+1
[root@clsn scripts]# expr 1 + 1
2
[root@clsn scripts]# expr 1 * 1
expr: 语法错误
[root@clsn scripts]# expr 1 \* 1
1
非整数返回值为2 示例：
[root@clsn scripts]# expr 1 + 1 
2
[root@clsn scripts]# echo $?
0
[root@clsn scripts]# expr -1 + 1 
0
[root@clsn scripts]# echo $?
1
[root@clsn scripts]# expr a + 1 
expr: 非整数参数
[root@clsn scripts]# echo $?
2
$[]运算符
[root@clsn scripts]# echo $[1+2]
3
[root@clsn scripts]# echo $[1-2]
-1
[root@clsn scripts]# echo $[1*2]
2
[root@clsn scripts]# echo $[1/2]
0
typeset命令进行运算
[root@clsn scripts]# typeset -i A=2017 B=2018
[root@clsn scripts]# A=A+B
[root@clsn scripts]# echo $A
4035
```
#### $[]运算符  只输出整数
```$xslt
[root@clsn scripts]# echo $[1+2]
3
[root@clsn scripts]# echo $[1-2]
-1
[root@clsn scripts]# echo $[1*2]
2
[root@clsn scripts]# echo $[1/2]
0
```

#### typeset 进行运算
[root@clsn scripts]# typeset -i A=2017 B=2018
[root@clsn scripts]# A=A+B
[root@clsn scripts]# echo $A
4035
#### 可以进行小数计算的命令
- 安装 bc  依赖于base源  
bc 命令
```$xslt
[root@clsn scripts]# bc
bc 1.06.95
Copyright 1991-1994, 1997, 1998, 2000, 2004, 2006 Free Software Foundation, Inc. 
1+1
2
[root@clsn scripts]# echo 1+1.1|bc
2.1
免交互模式测试bc命令
[root@clsn scripts]# echo 'scale=6;1/3'|bc
.333333
```
#### 扩展
```$xslt
python 命令
[root@clsn scripts]#  file `which yum `
/usr/bin/yum: Python script, ASCII text executable
[root@clsn scripts]# python 
>>> import os
>>> os.system('df -h')
>>> 1+1.1
2.1
>>>exit()
awk 命令
[root@clsn ~]# echo "7.7 3.8"|awk '{print ($1-$2)}'
3.9
[root@clsn ~]# echo "358 113"|awk '{print ($1-3)/$2}'
3.14159
[root@clsn ~]# echo "3 9"|awk '{print ($1+3)*$2}'
54
[root@backup scripts]# awk BEGIN'{print 1.2+3.3}'
4.5
```













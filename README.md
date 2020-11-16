# Zifuchuan

# 阅读程序  
## 实验目的  
掌握字符串String及其方法的使用  
掌握文件的读取/写入方法  
掌握异常处理结构  

## 业务要求  
1、内容：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能函数，并运行。达到如下功能：  

每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”  
允许提供输入参数，统计古诗中某个字或词出现的次数  
考虑操作中可能出现的异常，在程序中设计异常处理程序  
2、输入：  

汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂  侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身 金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动 地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行。

3、输出：  

汉皇重色思倾国，御宇多年求不得。  
杨家有女初长成，养在深闺人未识。  
天生丽质难自弃，一朝选在君王侧。  
回眸一笑百媚生，六宫粉黛无颜色。  
春寒赐浴华清池，温泉水滑洗凝脂。  
侍儿扶起娇无力，始是新承恩泽时。  
云鬓花颜金步摇，芙蓉帐暖度春宵。  
春宵苦短日高起，从此君王不早朝。  
…………  

## 实验过程  

//数组转换成字符串函数  
public void mouseClicked(MouseEvent e) {  
StringBuffer aa = new StringBuffer();//创建StringBuffer对象  
aa.append(Btn_click(shuru));  
StringBuffer str=aa;  
StringBuffer str1=new StringBuffer();  
str1=FormatOutput(str);  
String str2=new String(str1);  
jta.append(str2);  
btn.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent arg0) {  
int i=WordFrequency(str2,jta1.getText());  
JOptionPane.showMessageDialog(null, "该文字在古诗中出现的次数为: "+i);}});}});  

上述程序是主方法里最主要的执行方法，设置了一个事件监听器-当鼠标点击时执行下面命令，既 mouseClicked(MouseEvent e) 。当鼠标点击后这个方法配合程序里其他方法可以实现：  
1. 输入需要格式化的字符串，获取字符串并进行格式化，化为有标点的字符串。  
2. 将格式化的字符串赋值给新的StringBuffer类，并设置新的监听器，监听器内容为：当“查询”按钮按下时，可获取查询框里的字符串并进行检索，检索方法在下面会提到。  

//格式化输出函数  
public static StringBuffer FormatOutput(StringBuffer str) {  
StringBuffer str2=new StringBuffer();  
for(int i=0;i<str.length()/7;i++) {  
str2.append(str.substring(7*i, 7*(i+1)));  
if((i+1)%2!=0) {  
str2.append(",");}  
else {  
str2.append("。").append("\n");}}  
return str2;}  

索引从零开始，所以在第七个位置加逗号，第十五位置加句号。我还添加了“/n”，进行换行，让古诗整理对齐。往复循环。  

//词频统计函数  
public static int WordFrequency(String str1,String str0) {  
int i=0;  
while(str1.indexOf(str0)!=-1) {  
if(str1.indexOf(str0)!=-1) {  
i++;  
str1=str1.substring(str1.indexOf(str0)+str0.length(), str1.length());}}  
return i;}}  

这是上面提到的检索方法，当程序有索引值就继续运行往复循环，如果没有检索到就返回i。当找到字符串去掉后面所有字符串，重置原字符串并删除找到索引位前的字符串。  

## 实验结果
图片已上传  

## 实验感想  
通过这次实验让我对Java的基本语法有了更深的了解，也让我掌握了字符串的substring等方法以及异常处理机制。

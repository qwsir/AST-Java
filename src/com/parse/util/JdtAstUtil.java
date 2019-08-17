package com.parse.util;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class JdtAstUtil {
	public static CompilationUnit getCompilationunit(String javafilePath) {
		byte[] input =null;
		try {
		BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(javafilePath));
		input =new byte[bufferedInputStream.available()];
		bufferedInputStream.read(input);
		bufferedInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ASTParser类用于解析源代码，其有两种导入源代码的方式
		//1 以Java Model的形式
		//2 以字符数组的形式
		
		ASTParser astparser=ASTParser.newParser(AST.JLS3);
		
		//setSource针对不同形式的源码作为参数进行了重载
		//主要分为字符数组形式 char[]
		//和JavaModel形式(ICompilationUnit,IClassFile等)
		astparser.setSource(new String(input).toCharArray());
		
		//如果传入的字符数组不是一个完整的Java文件则可以按照一下代码
		//对ASTParser进行设置
		
//	       1 K_COMPILATION_UNIT：编译单元，即一个Java文件
//
//	       2 K_CLASS_BODY_DECLARATIONS：类的声明
//
//	       3 K_EXPRESSION：单个表达式
//
//	       4 K_STATEMENTS：语句块
		astparser.setKind(ASTParser.K_COMPILATION_UNIT);
		
		//creatAST()方法的参数类型为IProgressMonitor用于对AST的转换进行监控
		//本代码示例是以带解析的源代码为一个完整的Java文件(对应一个编译单元CompilationUnit)
		//为前提的，所以在转换为AST后直接强制类型转换为CompilationUnit
		//CompilaitonUnit是ASTNode的子类，指的就是整个文件
		//也就是AST的根节点
		CompilationUnit result= (CompilationUnit)astparser.createAST(null);
		return result;
	}
	
//	&lt; < 小于号 
//	&gt; > 大于号 
//	&amp; & 和 
//	&apos; ' 单引号 
//	&quot; " 双引号
	
	public static String change(String str) {
		StringBuilder stb=new StringBuilder();
		char st[]=str.toCharArray();
		for(char c: st) {
			if (c == '<')
			{
				stb.append("&lt;");
			}
			else if (c == '<')
			{
				stb.append("&gt;");
			}
			else if (c == '&')
			{
				stb.append("&amp;");
			}
			else if (c == '\'')
			{
				stb.append("&apos;");
			}
			else if (c == '\"')
			{
				stb.append("&quot;");
			}
			else
				stb.append(c);
		}
		return stb.toString();
		
	}

	
	
	
	
	
	


}
